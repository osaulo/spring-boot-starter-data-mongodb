package nl.blogspot.javasolutionsguide.springToolSuiteProject.vo;

import java.util.Date;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.entity.TeacherEntity;

public class Teacher {
	
	private String id;
	
	private String name;
	
	private String subject;
	
	private Date hour;
	
	public Teacher(String id, String name, String subject, Date hour) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.hour = hour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TeacherEntity format() {
		return new TeacherEntity(this.id, this.name, this.subject, this.hour);
	}
}
