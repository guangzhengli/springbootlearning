package com.ligz.mybatisplus;

import com.ligz.mybatisplus.system.entity.Student;
import com.ligz.mybatisplus.system.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//author:ligz


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
	@Autowired
	private StudentServiceImpl service;

	@Test
	public void addStudent(){
		Student student = new Student();
		student.setName("ligz");
		student.setClassName("math");
		student.setTeatherName("zz");
		service.save(student);
	}

}
