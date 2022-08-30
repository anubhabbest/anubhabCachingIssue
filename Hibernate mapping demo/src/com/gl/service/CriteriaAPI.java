package com.gl.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.gl.entity.Teacher;

public class CriteriaAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		Criteria c=session.createCriteria(Teacher.class);
		//List<Teacher> teachers=c.list();
		c.add(Restrictions.like("name","Anu%"));
		List<Teacher> teachers=c.list();
		for(Teacher t:teachers)
			System.out.println(t);
	}

}
