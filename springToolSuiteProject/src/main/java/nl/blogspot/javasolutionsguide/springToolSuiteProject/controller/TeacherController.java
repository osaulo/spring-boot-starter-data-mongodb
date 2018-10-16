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

import nl.blogspot.javasolutionsguide.springToolSuiteProject.service.TeacherService;
import nl.blogspot.javasolutionsguide.springToolSuiteProject.vo.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid Teacher teacherEntry) {
		service.create(teacherEntry);
    }
	
	@RequestMapping(value = "/find/{idTeacher}", method = RequestMethod.GET)
    public Teacher findByID(@PathVariable Long idTeacher) {
        return service.findByID(idTeacher);
    }
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Teacher> list() {
        return service.list();
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public Teacher update(@RequestBody @Valid Teacher teacherEntry) {
		return service.update(teacherEntry);
    }
	
	@RequestMapping(value = "/delete/{idTeacher}", method = RequestMethod.GET)
    public void delete(@PathVariable Long idTeacher) {
		service.delete(idTeacher);
    }
}