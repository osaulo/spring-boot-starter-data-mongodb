package nl.blogspot.javasolutionsguide.springToolSuiteProject.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Teacher;

@Document(collection = "teachers")
public class TeacherEntity {
	
	@Id
    public String id;
	
	public String name;
	
	public String subject;
	
	public Date hour;
	
	public TeacherEntity() {}
	
	public TeacherEntity(String id, String name, String subject, Date hour) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.hour = hour;
	}

	@Override
    public String toString() {
		return String.format(
                "Teacher[id=%s, name=%s, subject=%s, hour=%s]", id, name, subject, new SimpleDateFormat("HH:mm:ss").format(hour));
	}
	
	public Teacher format() {
		return new Teacher(this.id, this.name, this.subject, this.hour);
	}

}
