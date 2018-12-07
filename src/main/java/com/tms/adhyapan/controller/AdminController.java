package com.tms.adhyapan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.entity.School;
import com.tms.adhyapan.dao.entity.Subject;
import com.tms.adhyapan.dao.repository.SchoolRepository;
import com.tms.adhyapan.dao.repository.SubjectRepository;

@Controller
public class AdminController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	
	@RequestMapping(value = "/manageSubject")
	public ModelAndView manageSubject(HttpServletRequest request) {
		LOGGER.info("Inside manageSubject");
		ModelAndView mv = new ModelAndView("manage-subject");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveSubject")
	public Subject saveSubject(@RequestBody Subject subject) {
		Subject savedSubject = subjectRepository.save(subject);
		return savedSubject;
	}
	
	@RequestMapping(value = "/populateAllSubjects")
	public String populateAllSubjects(Model model) {
		List<Subject> subjectList = subjectRepository.findAll();
		model.addAttribute("subjectList", subjectList);
		return "manage-subject :: frag-all-subjects";
	}
	
	@RequestMapping(value = "/manageSchool")
	public ModelAndView manageSchool(HttpServletRequest request) {
		LOGGER.info("Inside manageSchool");
		ModelAndView mv = new ModelAndView("manage-school");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveSchool")
	public School saveSchool(@RequestBody School school) {
		School savedSchool = schoolRepository.save(school);
		return savedSchool;
	}
	
	@RequestMapping(value = "/populateAllSchools")
	public String populateAllSchools(Model model) {
		List<School> schoolList = schoolRepository.findAll();
		model.addAttribute("schoolList", schoolList);
		return "manage-school :: frag-all-schools";
	}
}
