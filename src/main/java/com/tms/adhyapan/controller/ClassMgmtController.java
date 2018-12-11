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

import com.tms.adhyapan.dao.entity.Clazz;
import com.tms.adhyapan.dao.repository.ClassRepository;

@Controller
public class ClassMgmtController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClassRepository classRepository;
	
	@RequestMapping(value = "/createClassLandingPage")
	public ModelAndView createClassLandingPage(HttpServletRequest request) {
		LOGGER.info("Inside createClassLandingPage");
		ModelAndView mv = new ModelAndView("create-class");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/createClass")
	public Clazz createClass(@RequestBody Clazz clazz) {
		Clazz createdClass = classRepository.save(clazz);
		return createdClass;
	}
	
	@RequestMapping(value = "/viewClassLandingPage")
	public ModelAndView viewClassLandingPage() {
		ModelAndView mv = new ModelAndView("view-class");
		return mv;
	}
	
	@RequestMapping(value = "/populateAllClasses")
	public String populateAllClasses(Model model, @RequestParam(value = "pageFragment") String pageFragment) {
		List<Clazz> classList = classRepository.findAll();
		model.addAttribute("classList", classList);
		return pageFragment;
	}
}
