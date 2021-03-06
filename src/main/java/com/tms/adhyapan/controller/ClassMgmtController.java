package com.tms.adhyapan.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
import com.tms.adhyapan.dao.entity.StudentClass;
import com.tms.adhyapan.dao.repository.ClassRepository;
import com.tms.adhyapan.dao.repository.StudentClassRepository;
import com.tms.adhyapan.dao.repository.StudentRepository;
import com.tms.adhyapan.util.CommonUtils;
import com.tms.adhyapan.vo.DateRangeVO;

@Controller
public class ClassMgmtController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ClassRepository classRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentClassRepository studentClassRepository;

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
	
	@RequestMapping(value = "/populateActiveClasses")
	public String populateActiveClasses(Model model, @RequestParam(value = "pageFragment") String pageFragment,
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
			@RequestParam(value = "pageFragment") String pageFragment, @RequestParam(value = "standardId") Long standardId, @RequestParam(value = "classId") Long classId) {
		List<Student> availableStudentList = studentRepository.getAvailableStudentsToAssignByClassId(standardId, classId);
		model.addAttribute("availableStudentList", availableStudentList);
		return pageFragment;
	}

	@RequestMapping(value = "/getAssignedStudentsToClass")
	public String getAssignedStudentsToClass(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "classId") Long classId) {
		List<Student> assignedStudentList = studentRepository.getAssignedStudentsByClassId(classId);
		model.addAttribute("assignedStudentList", assignedStudentList);
		return pageFragment;
	}
	
	@ResponseBody
	@RequestMapping(value = "/assignStudentsToClass")
	public List<StudentClass> assignStudentsToClass(@RequestBody List<StudentClass> studentClassList) {
		List<StudentClass> savedStudentClassList = studentClassRepository.saveAll(studentClassList);
		return savedStudentClassList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/removeStudentsFromClass")
	@Transactional
	public Integer removeStudentsFromClass(@RequestParam(value = "classId") Long classId,
			@RequestParam(value = "studentList[]", required = false) List<Long> studentList) {
		Date endDate = CommonUtils.getCurrentSystemDate();
		Integer updateCount = studentClassRepository.removeStudentsFromClass(endDate, classId, studentList);
		return updateCount;
	}
	
	@RequestMapping(value = "/populateClassMonthByClassId")
	public String populateClassMonthByClassId(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "classId") Long classId) {
		DateRangeVO startEndDate = classRepository.getStartEndDateByClassId(classId);
		List<String> monthList = CommonUtils.getMonthList(startEndDate.getStartDate(), startEndDate.getEndDate());
		model.addAttribute("monthList", monthList);
		return pageFragment;
	}
	
	@RequestMapping(value = "/populateClassMonthByTeacherId")
	public String populateClassMonthByTeacherId(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "teacherId") Long teacherId) {
		DateRangeVO startEndDate = classRepository.getStartEndDateByTeacherId(teacherId);
		List<String> monthList = CommonUtils.getMonthList(startEndDate.getStartDate(), startEndDate.getEndDate());
		model.addAttribute("monthList", monthList);
		return pageFragment;
	}
	
	@RequestMapping(value = "/populateClassMonthByStandardId")
	public String populateClassMonthByStandardId(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "standardId") Long standardId) {
		DateRangeVO startEndDate = classRepository.getStartEndDateByStandardId(standardId);
		List<String> monthList = CommonUtils.getMonthList(startEndDate.getStartDate(), startEndDate.getEndDate());
		model.addAttribute("monthList", monthList);
		return pageFragment;
	}
	
	@RequestMapping(value = "/populateClassMonthByStudentId")
	public String populateClassMonthByStudentId(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "studentId") Long studentId) {
		DateRangeVO startEndDate = studentClassRepository.getStartEndDateByStudentId(studentId);
		List<String> monthList = CommonUtils.getMonthList(startEndDate.getStartDate(), startEndDate.getEndDate());
		model.addAttribute("monthList", monthList);
		return pageFragment;
	}
	
	@RequestMapping(value = "/populateClassMonthByStudentIdAndClassId")
	public String populateClassMonthByStudentIdAndClassId(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "studentId") Long studentId,
			@RequestParam(value = "classId") Long classId) {
		DateRangeVO startEndDate = studentClassRepository.getStartEndDateByStudentIdAndClassId(studentId, classId);
		List<String> monthList = CommonUtils.getMonthList(startEndDate.getStartDate(), startEndDate.getEndDate());
		model.addAttribute("monthList", monthList);
		return pageFragment;
	}
	
	@RequestMapping(value = "/populateAssignedClassesOfStudent")
	public String populateAssignedClassesOfStudent(Model model, @RequestParam(value = "pageFragment") String pageFragment,
			@RequestParam(value = "studentId") Long studentId) {
		List<Clazz> classList = classRepository.getAssignedClassesByStudentId(studentId);
		model.addAttribute("classList", classList);
		return pageFragment;
	}
}
