package com;

import com.entity.Exam;
import com.entity.Student;
import com.entity.Subject;
import com.reports.ExamReport;
import com.reports.Reports;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class ExampleHibernate {

    // получаем объект конфигурации который читает файл  hibernate.cfg.xml
    // по хорошему надо это вынести в отдельный синглетон, чтобы объект был только один
    SessionFactory sessionFactory =
            new Configuration()
                    .configure()
                    .buildSessionFactory();

    // получаем текущую сессию
    private Session session = sessionFactory.openSession();

    void start() {

        // поработаем с базой данных
        // через транзакцию
        Transaction transaction = session.beginTransaction(); // старт транзакции из сессии

/*
       // добавляем студента

        Student student = new Student();
        student.setFirstname("John");
        student.setLastname("Snow");
        student.setAge(35);

        session.save(student);
*/

//        Subject subject = new Subject();
//        subject.setName("Math");
      //  session.save(subject);

//        Exam exam = new Exam();
//        exam.setStudent(session.get(Student.class, 1));
//        exam.setGrade(5);
//        exam.setSubject(session.get(Subject.class, 1));
//        session.save(exam);

        // получаем объект из БД
        // Student student = session.get(Student.class, 5); // указываем путь к классу объекта и номер ID
        // можно через .load() но если такого id  нет, то будет эксепшн

        // изменим значение поля объекта
        // student.setAge(66666666); // hiber обновит значение и в БД тоже !!! (сделает UPDATE)
        // System.out.println("student = " + student);


        // создадим HQL запрос
        /*
        System.out.println("запускаем HQL запрос: ");
        Query query = session.createQuery("from Student"); // тут пишем не названия таблиц, а названия КЛАССОВ !!!
        List<Student> students = query.getResultList();
        */

        // сгенерим отчёт - сводная таблица
        Reports reports = new Reports();
        List<ExamReport> results = reports.getExamResults("John", "Snow", session);
        System.out.println(results);

        transaction.commit(); // чтобы транзакция завершилась и всё запислаось в БД

        // запишем в БД через метод с аннотацией
        //  ( не надо отдельно открывать/коммитить/закрывать транзакцию)
        //     doTransaction();

        // закрываем сессию и сешнфактори
        session.close();
        sessionFactory.close();
    }

    @Transactional
    void doTransaction() {
        Student student = new Student();
        student.setFirstname("King");
        student.setLastname("of Night");
        student.setAge(666);
        session.save(student);
    }
}