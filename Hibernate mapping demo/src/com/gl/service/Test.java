package com.gl.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gl.entity.Teacher;
import com.gl.entity.TeacherDetails;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting test class.. ");
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Teacher teacher=new Teacher("Anubhab");
		Teacher teacher1=new Teacher("Arunava");
		TeacherDetails td=new TeacherDetails("guitar");
		TeacherDetails td1=new TeacherDetails("swimming");
		List<TeacherDetails> list=new ArrayList<>();
		List<Teacher> list1=new ArrayList<>();
		list.add(td);
		list.add(td1);
		list1.add(teacher);
		list1.add(teacher1);
		td.setTeacher(list1);
		td1.setTeacher(list1);
		teacher.setTd(list);
		teacher1.setTd(list);
		
		Session session=factory.getCurrentSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			
			session.save(teacher);
			session.save(teacher);
			Teacher t1=session.get(Teacher.class, 1);
			tx.commit();
			
			System.out.println("details saved successfully");
			for(TeacherDetails t:t1.getTd())
			System.out.println(t1.getName()+" hobby is "+t.getHobby());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
