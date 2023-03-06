package magicGame.repositories;

import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static magicGame.common.ExceptionMessages.INVALID_MAGIC_REPOSITORY;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return Collections.unmodifiableCollection(data);
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(INVALID_MAGIC_REPOSITORY);
        }
        data.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return data.remove(magic);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream().filter(magic -> magic.getName().equals(name)).findFirst().orElse(null);
    }
}
