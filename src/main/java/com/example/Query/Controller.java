package com.example.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	StudentDAO studentDAO;
	
	@RequestMapping("save")
	public String save(@RequestBody Student student) {
		studentDAO.save(student);
		return "Saved Successfully";
	}
	@RequestMapping("get/{id}")
	public Student getById(@PathVariable int id) {
		return studentDAO.getById(id);
	}
	
	@RequestMapping("delete/{id}")
	public int deleteById(@PathVariable int id) {
		studentDAO.deleteById(id);
		return 1;
		
	}
	
	@RequestMapping("update")
	String update(@RequestBody Student student) {
		try {
			studentDAO.update(student);
			return "updated";
		} catch (Exception e) {
			return "Id Not found";
		}
	}
}
