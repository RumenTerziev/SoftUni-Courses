package bg.softuni.bookshop.services.impl;

import bg.softuni.bookshop.domain.entities.Category;
import bg.softuni.bookshop.repositories.CategoryRepository;
import bg.softuni.bookshop.services.CategoryService;
import bg.softuni.bookshop.utils.io.read.Reader;
import bg.softuni.bookshop.utils.io.read.ReaderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static bg.softuni.bookshop.domain.constants.FilePaths.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedAllCategories() throws IOException {

        if (isDataSeeded()) {
            return;
        }

        Reader reader = ReaderManager.getFileReader(CATEGORIES_FILE_PATH);

        String line = reader.readLine();

        while (line != null) {

            if (!line.trim().equals("")) {
                Category category = new Category();
                category.setName(line);
                this.categoryRepository.save(category);
            }

            line = reader.readLine();
        }
    }


    @Override
    public Category getRandomCategory() {

        long count = this.categoryRepository.count();

        if (count > 0) {
            long randomId = ThreadLocalRandom.current().nextLong(1, count) + 1L;
            return this.categoryRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException("No categories found!");
    }

    @Override
    public Set<Category> getRandomCategories() {


        long count = this.categoryRepository.count();

        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < count / 2; i++) {

            Category category = getRandomCategory();

            Category searchedCategory =
                    categories.stream()
                            .filter(c -> Objects.equals(c.getId(), category.id)).findFirst()
                            .orElse(null);

            if (searchedCategory == null) {
                categories.add(category);
            }
        }

        return categories;
    }

    @Override
    public boolean isDataSeeded() {
        return this.categoryRepository.count() > 0;
    }
}
