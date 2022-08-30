package com.gl.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher_details")
public class TeacherDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String hobby;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="teacher_tdetails",
	joinColumns=@JoinColumn(name="tdetails_id"),
	inverseJoinColumns=@JoinColumn(name="teacher_id")
)
	//@JoinColumn(name="teacher_id")
	private List<Teacher> teacher;
	
	
//	public Teacher getTeacher() {
//		return teacher;
//	}
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
	
	public TeacherDetails(String hobby) {
		
		this.hobby = hobby;
	}
	public List<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}
	public TeacherDetails() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "TeacherDetails [id=" + id + ", hobby=" + hobby + "]";
	}
	
	
	
}
