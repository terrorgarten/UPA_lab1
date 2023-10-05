package cz.vut.fit.rychly.objectbox.books;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Entity;
import io.objectbox.relation.ToMany;

import java.util.Iterator;

@Entity
public class Course {

    @Id
    public long id;

    public String code;

    public String name;

    public int year;

    @Backlink
    ToMany<Student> students;
    @Backlink
    ToMany<Exam> exams;

    public Course(){}

    public Course(long id){
        this.id = id;
    }

    public Course(String code, String name, int year){
        this.code = code;
        this.name = name;
        this.year = year;
    }


    public int getStudentCount(){
        return this.students.size();
    }

    // mapping manipulation
    public void addStudent(Student student){
        this.students.add(student);
    }

    public void addExam(Exam exam){
        this.exams.add(exam);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void removeExam(Exam exam){
        this.exams.remove(exam);
    }

    public Iterator<Student> getStudents() {
        return students.iterator();
    }

    public Iterator<Exam> getExams() {
        return exams.iterator();
    }

    // getters setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Course: %s (ID %d)", getName(), getId());
    }
}
