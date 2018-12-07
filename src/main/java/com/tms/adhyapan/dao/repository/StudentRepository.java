package com.tms.adhyapan.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.adhyapan.dao.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
