package nl.blogspot.javasolutionsguide.springToolSuiteProject.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nl.blogspot.javasolutionsguide.springToolSuiteProject.service.StudentService;
import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid Student studentEntry) {
		service.create(studentEntry);
    }
	
	@RequestMapping(value = "/find/{idStudent}", method = RequestMethod.GET)
    public Student findByID(@PathVariable Long idStudent) {
        return service.findByID(idStudent);
    }
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Student> list() {
        return service.list();
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public Student update(@RequestBody @Valid Student studentEntry) {
		return service.update(studentEntry);
    }
	
	@RequestMapping(value = "/delete/{idStudent}", method = RequestMethod.GET)
    public void delete(@PathVariable Long idStudent) {
		service.delete(idStudent);
    }
}