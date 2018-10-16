package nl.blogspot.javasolutionsguide.springToolSuiteProject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.domain.repository.StudentRepositoryCustom;
import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Student;

@Service
public class StudentService {
	
	private final StudentRepositoryCustom studentRepository;
	
	@Inject
    public StudentService(StudentRepositoryCustom studentRepository) {
        this.studentRepository = studentRepository;
    }

	public void create(Student studentEntry) {
		studentRepository.create(studentEntry);
	}

	public Student update(Student studentEntry) {
		return studentRepository.update(studentEntry);
	}

	public void delete(Long idStudent) {
		studentRepository.delete(idStudent);
	}

	public Student findByID(Long idStudent) {
		return studentRepository.findByID(idStudent);
	}

	public List<Student> list() {
		return studentRepository.list();
	}

}
