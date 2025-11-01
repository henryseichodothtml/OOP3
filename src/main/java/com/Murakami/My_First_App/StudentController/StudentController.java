package com.Murakami.My_First_App.StudentController;

import com.Murakami.My_First_App.Student.Student;
import com.Murakami.My_First_App.StudentDAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentDAO dao;

    @GetMapping
    public List<Student> getAll() {
        return dao.listarTodos();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        dao.inserir(student);
    }
}

