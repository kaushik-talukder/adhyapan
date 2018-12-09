package com.tms.adhyapan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.entity.Student;
import com.tms.adhyapan.dao.repository.StudentRepository;
import com.tms.adhyapan.util.CommonUtils;

@Controller
public class StudentMgmtController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value = "/registerStudentLandingPage")
	public ModelAndView registerStudentLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside registerStudentLandingPage");
		ModelAndView mv = new ModelAndView("register-student");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerStudent")
	public Student registerStudent(@RequestBody Student student) {
		Student registeredStudent = studentRepository.save(student);
		return registeredStudent;
	}
	
	@RequestMapping(value = "/viewStudentLandingPage")
	public ModelAndView viewStudentLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside viewStudentLandingPage");
		ModelAndView mv = new ModelAndView("view-student");
		List<String> alphabetList = CommonUtils.getAlphabetList();
		mv.addObject("alphabetList", alphabetList);
		return mv;
	}
}
