package cloud.cholewa.jpa;

public interface BookDao {

    void save(Book book);

    Book getById(Long id);

    void cleanUp();
}
