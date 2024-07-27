package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("Student")
public class StudentController {

	@Autowired
	private StudentService service;

	private StudentRepository studentRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student std) {
		service.save(std);
		return "{\"status\":\"success\"}";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Student> listStudents() {
		List<Student> liststudent = service.listAll();
		return liststudent;
	}


	@RequestMapping(value = "/get/{id}")
	public Student getStudentPage(@PathVariable(name = "id") int id) {
		Student stdd = service.getid(id);
		return stdd;
	}


	@PostMapping(value = "/edit/{id}")
	public String updateStudent(@PathVariable("id") long id,  Student student)
	{
		student.setId(id);
		service.save(student);
		return "{\"status\":\"success\"}";

	}

	@RequestMapping("/delete/{id}")
	public String deletestudent(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "{\"status\":\"success\"}";
	}
	/*
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">

	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	
	*/






}

