package bg.softuni.bookshop.services;

import bg.softuni.bookshop.domain.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedAllCategories() throws IOException;

    Category getRandomCategory();

    Set<Category> getRandomCategories();

    boolean isDataSeeded();
}
