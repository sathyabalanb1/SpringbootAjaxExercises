package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	private StudentRepository repo;

	public List<Student> listAll() {
		return repo.findAll();
	}

	public void save(Student std) {
		repo.save(std);
	}

	public Student getid(long id) {
		return repo.findById(id).get();
	}

	public Student get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}


