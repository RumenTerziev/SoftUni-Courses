package bg.softuni.hospital.repositories;


public interface Repository<E> {

    void save(E entity);

    void remove(E entity);

    void closeConnection();
}
