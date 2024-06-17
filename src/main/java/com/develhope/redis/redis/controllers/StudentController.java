package com.develhope.redis.redis.controllers;

import com.develhope.redis.redis.converter.StudentConverter;
import com.develhope.redis.redis.dtos.StudentDTO;
import com.develhope.redis.redis.entities.Student;
import com.develhope.redis.redis.services.StudentService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private StudentService studentService;

    @Cacheable(value = "students", key = "#id")
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        LOG.info("Getting student with ID {}.", id);
        return studentService.getStudentById(id);
    }

    @GetMapping("/cache/clear")
    @CacheEvict(value = "students", allEntries = true)
    public void clearCache() {

    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @PostMapping("/import")
    public String importStudents() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("C:\\Users\\rober\\PycharmProjects\\scripts\\students_2.json");
            List<Student> students = objectMapper.readValue(file, new TypeReference<List<Student>>() {});
            studentService.saveAll(students);
            return "Students imported successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while importing students!";
        }
    }
}
