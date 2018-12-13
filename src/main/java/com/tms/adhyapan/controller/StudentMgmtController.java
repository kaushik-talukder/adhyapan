package com.tms.adhyapan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.entity.Student;
import com.tms.adhyapan.dao.repository.StudentRepository;
import com.tms.adhyapan.util.CommonConstants;
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
	
	@RequestMapping(value = "/getStudentList")
	public String getStudentList(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "searchCategory") String searchCategory,
			@RequestParam(value = "searchKey") String searchKey) {
		List<Student> studentList = null;
		switch (searchCategory) {
		case CommonConstants.SEARCH_CATEGORY_BY_FIRST_NAME:
			studentList = studentRepository.findByFirstNameStartingWithOrderByFirstName(searchKey);
			break;
		case CommonConstants.SEARCH_CATEGORY_BY_LAST_NAME:
			studentList = studentRepository.findByLastNameStartingWithOrderByLastName(searchKey);
			break;
		case CommonConstants.SEARCH_CATEGORY_BY_STUDENT_CODE:
			studentList = studentRepository.findByStudentCodeContainingOrderByStudentCode(searchKey);
			break;
		case CommonConstants.SEARCH_CATEGORY_BY_STANDARD:
			studentList = studentRepository.findByStandardIdOrderByFirstName(Long.valueOf(searchKey));
			break;
		case CommonConstants.SEARCH_CATEGORY_BY_SCHOOL:
			studentList = studentRepository.findBySchoolIdOrderByFirstName(Long.valueOf(searchKey));
			break;			
		default:
			studentList = new ArrayList<>();
			break;
		}
		model.addAttribute("studentList", studentList);
		return pageFragment;
	}
	
	@RequestMapping(value = "/populateStudents")
	public String populateStudents(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "standardId") Long standardId,
			@RequestParam(value = "classId") Long classId) {
		List<Student> studentList = null;
		
		if(Objects.nonNull(standardId) && Objects.nonNull(classId)) {
			
		} else if(Objects.nonNull(standardId)) {
			
		} else if(Objects.nonNull(classId)) {
			studentList = studentRepository.getStudentsByClassId(classId);
		}
		model.addAttribute("studentList", studentList);
		return pageFragment;
		
	}
}
