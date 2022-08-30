package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gl.entity.Teacher;

public class SecondLevelCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Teacher teacher=session.get(Teacher.class,1);
		System.out.println(teacher);
		session.close();
		System.out.println("testing second level cache...");
		Session session1=factory.getCurrentSession();
		session1.beginTransaction();
		Teacher teacher1=session1.get(Teacher.class,1);
		System.out.println(teacher);
		session1.close();
		factory.close();
	}

}
