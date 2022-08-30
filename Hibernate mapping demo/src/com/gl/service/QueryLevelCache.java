package com.gl.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.gl.entity.Teacher;



public class QueryLevelCache {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Query q1=session.createQuery("from Teacher");
		q1.setCacheable(true);
		q1.setCacheRegion("teacher");
		System.out.println(q1.list());
		session.close();
		System.out.println("testing query level cache...");
		Session session1=factory.getCurrentSession();
		session1.beginTransaction();
		Query q2=session.createQuery("from Teacher");
		q2.setCacheable(true);
		System.out.println(q2.list());
		session1.close();
		factory.close();

	}

}
