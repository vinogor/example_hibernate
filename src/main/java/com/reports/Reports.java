package com.reports;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Reports {

    // можно проще написать
    /*
    public List<ExamReport> getExamResults(String firstName, String lastName, Session session) {
        //language=HQL
        String query = "" +
                " select new com.reports.ExamReport(s.name, st.lastname, e.grade) " +
                " from Exam e, Subject s, Student st " +
                " where e.student.id = st.id and e.subject.id = s.id " +
                " and st.firstname = :firstname and st.lastname = :lastname";
        Query hibQuery = session.createQuery(query);
        hibQuery.setParameter("firstname", firstName);
        hibQuery.setParameter("lastname", lastName);

        return hibQuery.getResultList();

    }
     */

    // запрос короче так как прописаны всякие аннотации у классов - они заменяют связи между таблицами в HQL запросе
    public List<ExamReport> getExamResults(String firstName, String lastName, Session session) {
        //language=HQL
        String query = "" +
                " select new com.reports.ExamReport(e.student.firstname, e.student.lastname, e.grade) " +
                " from Exam e " +
                " where e.student.firstname = :firstname and e.student.lastname = :lastname";

        // в запросе через ":" вставляется параметр
        Query hibQuery = session.createQuery(query);
        hibQuery.setParameter("firstname", firstName);
        hibQuery.setParameter("lastname", lastName);

        return hibQuery.getResultList();

    }
}
