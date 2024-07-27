package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	public List<Student> listAll();
	
	public void save(Student std);
	
	public Student getid(long id);
	
	public Student get(long id);
	
	public void delete(long id);

}
