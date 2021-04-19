package com.example.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {

	SessionFactory SessionFactory;

	public StudentDAO() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory = cfg.buildSessionFactory();
	}

	public int save(Student student) {
		try {
			Session session = SessionFactory.openSession();
			session.save(student);
			session.close();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public Student getById(int id) {

		Session session = SessionFactory.openSession();
		Student student = session.get(Student.class, id);
		session.close();
		return student;
	}

	public void deleteById(int id) {
		Session session = SessionFactory.openSession();
		session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		session.getTransaction().commit();
		SessionFactory.close();
		session.close();

	}

	public void update(Student student) {

		Session session = SessionFactory.openSession();
		session.beginTransaction();
		Student obj = session.get(Student.class, student.id);
		obj.setMarks(student.marks);
		obj.setName(student.name);
		session.getTransaction().commit();
		SessionFactory.close();
		session.close();
	}
}
