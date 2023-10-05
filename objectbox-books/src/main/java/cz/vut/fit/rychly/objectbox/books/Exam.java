package cz.vut.fit.rychly.objectbox.books;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

import java.util.Date;

@Entity
public class Exam {
    @Id
    long id;

    public String name;

    Date date;

    int capacity;

    boolean published;

    ToOne<Course> course;

    @Backlink
    ToMany<Student> students;

    public Exam(){}

    public Exam(long id){
        this.id = id;
    }

    public Exam(String name, Date date, int capacity, Course course) throws ExamException {
        this.name = name;
        this.date = date;
        this.setCourse(course);
        if(capacity < course.getStudentCount()){
            this.capacity = course.getStudentCount();
        } else {
            throw new ExamException(String.format(
                    "Cannot set capacity lower than the number of students enrolled in the course which is %d.",
                    course.getStudentCount()));
        }
    }

    public void addStudent(Student student) throws ExamException {
        boolean available = this.capacity <= this.students.size();
        if(available) {
            throw new ExamException(String.format(
                    "Cannot enroll more students than the capacity which is %d.", capacity));
        }
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCourse(Course course){
        this.course.setTarget(course);
    }

    public Course getCourse(){
        return this.course.getTarget();
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return this.date;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
