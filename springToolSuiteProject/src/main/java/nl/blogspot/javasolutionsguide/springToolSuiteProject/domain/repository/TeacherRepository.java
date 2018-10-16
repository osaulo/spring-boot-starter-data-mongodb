package nl.blogspot.javasolutionsguide.springToolSuiteProject.domain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.entity.TeacherEntity;

public interface TeacherRepository extends MongoRepository<TeacherEntity, Long> {

	public Optional<TeacherEntity> findById(String idStudent);
	
	//Supports native JSON query string
//    @Query("{'class':'0'}")
	public Optional<TeacherEntity> findByName(String name);
	
}
