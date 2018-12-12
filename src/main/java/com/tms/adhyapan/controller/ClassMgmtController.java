package com.tms.adhyapan.controller;

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

import com.tms.adhyapan.dao.entity.Clazz;
import com.tms.adhyapan.dao.entity.Student;
import com.tms.adhyapan.dao.repository.ClassRepository;
import com.tms.adhyapan.dao.repository.StudentRepository;

@Controller
public class ClassMgmtController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ClassRepository classRepository;
	@Autowired
	private StudentRepository studentRepository;

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
	public String populateAllClasses(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "standardId", required = false) Long standardId,
			@RequestParam(value = "subjectId", required = false) Long subjectId,
			@RequestParam(value = "teacherId", required = false) Long teacherId) {
		List<Clazz> classList = null;
		if(Objects.nonNull(subjectId) && Objects.nonNull(teacherId) && Objects.nonNull(standardId)) {
			classList = classRepository.findByStandardIdAndSubjectIdAndTeacherId(standardId, subjectId, teacherId);
		} else if(Objects.nonNull(subjectId) && Objects.nonNull(teacherId)) {
			classList = classRepository.findBySubjectIdAndTeacherId(subjectId, teacherId);
		} else if(Objects.nonNull(teacherId) && Objects.nonNull(standardId)) {
			classList = classRepository.findByStandardIdAndTeacherId(standardId, teacherId);
		} else if(Objects.nonNull(subjectId) && Objects.nonNull(standardId)) {
			classList = classRepository.findByStandardIdAndSubjectId(standardId, subjectId);
		} else if(Objects.nonNull(subjectId)) {
			classList = classRepository.findBySubjectId(subjectId);
		} else if(Objects.nonNull(teacherId)) {
			classList = classRepository.findByTeacherId(teacherId);
		} else if(Objects.nonNull(standardId)) {
			classList = classRepository.findByStandardId(standardId);
		} else {
			classList = classRepository.findAll();
		}
		model.addAttribute("classList", classList);
		return pageFragment;
	}

	@RequestMapping(value = "/assignStudentLandingPage")
	public ModelAndView assignStudentLandingPage() {
		ModelAndView mv = new ModelAndView("assign-student-class");
		return mv;
	}

	@RequestMapping(value = "/getAvailableStudentsToAssignClass")
	public String getAvailableStudentsToAssignClass(Model model,
			@RequestParam(value = "pageFragment") String pageFragment, @RequestParam(value = "classId") Long classId) {
		List<Student> availableStudentList = studentRepository.findAll();
		model.addAttribute("availableStudentList", availableStudentList);
		return pageFragment;
	}

	@RequestMapping(value = "/getAssignedStudentsToClass")
	public String getAssignedStudentsToClass(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "classId") Long classId) {
		List<Student> assignedStudentList = studentRepository.findAll();
		model.addAttribute("assignedStudentList", assignedStudentList);
		return pageFragment;
	}
}
