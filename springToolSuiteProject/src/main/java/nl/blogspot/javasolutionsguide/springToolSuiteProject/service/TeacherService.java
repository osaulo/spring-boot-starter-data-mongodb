package nl.blogspot.javasolutionsguide.springToolSuiteProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.domain.repository.TeacherRepository;
import nl.blogspot.javasolutionsguide.springToolSuiteProject.entity.TeacherEntity;
import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Teacher;

@Service
public class TeacherService {
	
	private final TeacherRepository teacherRepository;
	
	@Inject
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

	public void create(Teacher teacherEntry) {
		teacherRepository.insert(teacherEntry.format());
	}

	public Teacher update(Teacher teacherEntry) {
		return teacherRepository.save(teacherEntry.format()).format();
	}

	public void delete(Long idTeacher) {
		teacherRepository.deleteById(idTeacher);
	}

	public Teacher findByID(Long idTeacher) {
		Teacher retorno = null;
		Optional<TeacherEntity> findById = teacherRepository.findById(String.valueOf(idTeacher));
		if (findById.isPresent())
			retorno = findById.get().format();
		return retorno;
	}

	public List<Teacher> list() {
		Supplier<List<Teacher>> supplier = ArrayList::new;
		List<TeacherEntity> findAll = teacherRepository.findAll();
		
		List<Teacher> retorno = findAll
        .stream()
        .map(teacher -> new Teacher(teacher.id, teacher.name, teacher.subject, teacher.hour))
		.collect(Collectors.toCollection(supplier));
		
		return retorno;
	}

}
