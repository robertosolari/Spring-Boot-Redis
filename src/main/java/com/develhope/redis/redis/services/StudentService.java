package com.develhope.redis.redis.services;

import com.develhope.redis.redis.converter.StudentConverter;
import com.develhope.redis.redis.dtos.StudentDTO;
import com.develhope.redis.redis.entities.Student;
import com.develhope.redis.redis.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return student != null ? StudentConverter.entityToDTO(student) : null;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentConverter::entityToDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = StudentConverter.dtoToEntity(dto);
        student = studentRepository.save(student);
        return StudentConverter.entityToDTO(student);
    }

    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }
}
