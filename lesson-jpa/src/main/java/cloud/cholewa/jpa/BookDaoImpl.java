package cloud.cholewa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public BookDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myUnit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Book book) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(book);
        entityTransaction.commit();
    }

    @Override
    public Book getById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
