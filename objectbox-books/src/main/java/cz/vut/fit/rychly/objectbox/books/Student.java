package cz.vut.fit.rychly.objectbox.books;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;


@Entity
public class Student {

    @Id
    long id;

    int studentId;
    String name;

    ToMany<Course> courses;
    ToMany<Exam> exams;

    public Student(){}

    public Student(long id) {
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Student: %s (ID %d)", getName(), getId());
    }
}