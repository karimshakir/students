package com.jpa1.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/students")
public class MainController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewStudent(@RequestParam String name, @RequestParam Integer grade){
        Student s = new Student();
        s.setName(name);
        s.setGrade(grade);
        studentRepository.save(s);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
