package cloud.cholewa.jpa;

public class Main {

    public static void main(String[] args) {

        Book book = Book.builder()
                .isbn("123456789")
                .title("Wall Street Wolf")
                .author("Jordan Belfort")
                .build();

        BookDao bookDao = new BookDaoImpl();
        bookDao.save(book);
        System.out.println("Book saved !");
        bookDao.cleanUp();
    }
}
