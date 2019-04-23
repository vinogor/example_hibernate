package com.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id  // поле идентификатор (первичный ключ)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //  значение поля генерируется автоматом
    // IDENTITY - для MySQL, для других БД возможно придётся подругому настраивать
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @Embedded // Когда хочется чтобы внутренние поля класса - были такими же столбцами текущей таблицы
    // чтобы заработало надо и над классом StudentAddress поставить @Embeddable
    private StudentAddress studentAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    // mappedBy =  по какому полю в классе Exam делать маппинг (имя поля!)
    private Set<Exam> exams;


    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", studentAddress=" + studentAddress +
                '}';
    }
}
