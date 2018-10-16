package nl.blogspot.javasolutionsguide.springToolSuiteProject.domain.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Student;
import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Teacher;

@Repository
public class StudentRepositoryCustom {
	
	MongoClient mongoClient = new MongoClient("localhost", 27017);
	DB database = mongoClient.getDB("school");
	DBCollection collection = database.getCollection("students");
	
	public void create(Student studentEntry) {
		collection.insert(studentEntry.format());
	}

	public Student update(Student studentEntry) {
		BasicDBObject query = new BasicDBObject();
		query.put("_id", studentEntry.getId());
		
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("name", studentEntry.getName());
		
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);
		
		collection.update(query, updateObject);
		return studentEntry;
	}

	public void delete(Long idStudent) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", idStudent);
		 
		collection.remove(searchQuery);
	}

	public Student findByID(Long idStudent) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", String.valueOf(idStudent));
		DBObject object = collection.findOne(searchQuery);
		
		return this.getStudent((String) object.get("name"), (List) object.get("teachers"));
	}

	public List<Student> list() {
		List<Student> retorno = new ArrayList<Student>();
		DBCursor cursor = collection.find();
		
		while (cursor.hasNext()) {
			DBObject next = cursor.next();
			Object object = next.get("teachers");
			Student student = null;
			if (!object.toString().contains("name")) {
				student = this.getStudent((String) next.get("name"), (List) object);
			}
		    
		    retorno.add(student);
		}
		return retorno;
	}
	
	private Student getStudent(String name, List<Double> teachers) {
		List<Teacher> list = new ArrayList<Teacher>();
		
		for (Double teacherID : teachers) {
			list.add(new Teacher(String.valueOf(teacherID), null, null, null));
		}
		
		Student retorno = new Student(name, list);
		
		return retorno;
	}

}
