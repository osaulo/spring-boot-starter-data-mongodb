package nl.blogspot.javasolutionsguide.springToolSuiteProject.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Teacher;

//@Document(collection = "students")
public class StudentEntity {
	
	@Id
    public String id;
	
	public String name;
	
	public List<Teacher> listTeacher;
	
	public StudentEntity() {}
	
	@Override
    public String toString() {
		return String.format(
                "Student[id=%s, name=%s]", id, name);
	}

}
