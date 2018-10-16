package nl.blogspot.javasolutionsguide.springToolSuiteProject.vo;

import java.util.List;

import com.mongodb.BasicDBObject;

public class Student {
	
	private String id;
	
	private String name;
	
	private List<Teacher> listTeacher;
	
	public Student(String name, List<Teacher> listTeacher) {
		super();
		this.name = name;
		this.listTeacher = listTeacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getListTeacher() {
		return listTeacher;
	}
	
	public String getTeachers() {
		String retorno = "";
		
		for (Teacher teacher : listTeacher) {
			retorno+=teacher.getId() + ",";
		}
		
		return retorno.substring(0, retorno.length() - 1);
	}

	public void setListTeacher(List<Teacher> listTeacher) {
		this.listTeacher = listTeacher;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BasicDBObject format() {
		BasicDBObject document = new BasicDBObject();
		document.put("name", this.name);
		document.put("teachers", "["
				+ this.getTeachers()
				+ "]");
		
		return document;
	}
}
