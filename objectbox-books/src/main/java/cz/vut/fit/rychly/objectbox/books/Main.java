package cz.vut.fit.rychly.objectbox.books;

import io.objectbox.Box;
import io.objectbox.BoxStore;


public class Main {
    public static void main(String[] args) {
        final BoxStore store = MyObjectBox.builder().name("courses").build();

        final Box<Student> studentBox = store.boxFor(Student.class);
        final Box<Course> courseBox = store.boxFor(Course.class);
        final Box<Exam> examBox = store.boxFor(Exam.class);

        // create some objects
        final Student janLazy = new Student(111, "Jan Lazy");
        studentBox.put(janLazy);


//        final String title = args.length > 0 ? String.join(" ", args) : "No text given";
//        bookBox.put(new Book(title));
//
//        System.out.println(bookBox.count() + " books in ObjectBox database:");
//        for (Book book : bookBox.getAll()) {
//            System.out.println(book);
//        }
//        store.close();
    }
}
