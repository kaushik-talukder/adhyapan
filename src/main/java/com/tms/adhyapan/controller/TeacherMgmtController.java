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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tms.adhyapan.dao.entity.Teacher;
import com.tms.adhyapan.dao.repository.TeacherRepository;

@Controller
public class TeacherMgmtController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@RequestMapping(value = "/registerTeacherLandingPage")
	public ModelAndView registerTeacherLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside registerTeacher");
		ModelAndView mv = new ModelAndView("register-teacher");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerTeacher")
	public Teacher registerTeacher(@RequestBody Teacher teacher) {
		Teacher registeredTeacher = teacherRepository.save(teacher);
		return registeredTeacher;
	}
	
	@RequestMapping(value = "/viewTeacherLandingPage")
	public ModelAndView viewTeacherLandingPage() {
		ModelAndView mv = new ModelAndView("view-teacher");
		return mv;
	}
	
	@RequestMapping(value = "/populateAllTeachers")
	public String populateAllTeachers(Model model, @RequestParam(value = "pageFragment") String pageFragment) {
		List<Teacher> teacherList = teacherRepository.findAll();
		model.addAttribute("teacherList", teacherList);
		return pageFragment;
	}
}
