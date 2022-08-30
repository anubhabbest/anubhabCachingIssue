package com.gl.entity;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="teacher")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	private String name;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="teacher_tdetails",
				joinColumns=@JoinColumn(name="teacher_id"),
				inverseJoinColumns=@JoinColumn(name="tdetails_id")
			)
	private List<TeacherDetails> td;
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", td=" + td + "]";
	}
	public Teacher(String name) {
		this.name = name;
	}
	public Teacher() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public TeacherDetails getTd() {
//		return td;
//	}
//	public void setTd(TeacherDetails td) {
//		this.td = td;
//	}
	public List<TeacherDetails> getTd() {
		return td;
	}
	public void setTd(List<TeacherDetails> td) {
		this.td = td;
	}
	
	
}
