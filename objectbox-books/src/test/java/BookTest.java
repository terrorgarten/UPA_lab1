//import io.objectbox.Box;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class BookTest extends AbstractObjectBoxTest {
//
//    @Test
//    public void testPutAndGetAuthor() {
//        Box<Author> authorBox = store.boxFor(Author.class);
//        Author author = new Author();
//        author.setFirstName("John");
//        author.setLastName("Smith");
//        long id = authorBox.put(author);
//
//        Author authorFromBox = authorBox.get(id);
//        assertEquals("Smith", authorFromBox.getLastName());
//    }
//
//    @Test
//    public void testPutAndGetBook() {
//        Box<Book> bookBox = store.boxFor(Book.class);
//        Book book = new Book();
//        book.setTitle("John's Bible");
//        long id = bookBox.put(book);
//
//        Book bookFromBox = bookBox.get(id);
//        assertEquals("John's Bible", bookFromBox.getTitle());
//    }
//
//    @Test
//    public void testPutAndQueryBook() {
//        Box<Book> bookBox = store.boxFor(Book.class);
//        Book book = new Book();
//        book.setTitle("John's Bible");
//        long id = bookBox.put(book);
//
//        List<Book> booksFromBox = bookBox.query().contains(Book_.title, "Bible").build().find();
//        assertEquals(1, booksFromBox.size());
//        assertEquals("John's Bible", booksFromBox.iterator().next().getTitle());
//    }
//
//    @Test
//    public void testBooksAndAuthors() {
//        Box<Author> authorBox = store.boxFor(Author.class);
//        Author author = new Author();
//        author.setFirstName("John");
//        author.setLastName("Smith");
//        long authorId = authorBox.put(author);
//
//        Box<Book> bookBox = store.boxFor(Book.class);
//        Book book = new Book();
//        book.setTitle("John's Bible");
//        book.setAuthor(author);
//        long bookId = bookBox.put(book);
//
//        Book bookFromBox = bookBox.get(bookId);
//        assertEquals("John's Bible", bookFromBox.getTitle());
//        assertEquals(authorId, bookFromBox.getAuthor().getId());
//
//        Author authorFromBox = authorBox.get(authorId);
//        assertEquals("Smith", authorFromBox.getLastName());
//        assertEquals(1, authorFromBox.getBooks().size());
//        assertEquals(bookId, authorFromBox.getBooks().iterator().next().getId());
//    }
//}
