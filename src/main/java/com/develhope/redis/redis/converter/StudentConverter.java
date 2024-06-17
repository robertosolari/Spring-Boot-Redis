package com.develhope.redis.redis.converter;

import com.develhope.redis.redis.dtos.StudentDTO;
import com.develhope.redis.redis.entities.Student;

public class StudentConverter {

    public static StudentDTO entityToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }

    public static Student dtoToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return student;
    }
}
