package com.Murakami.My_First_App.StudentController;

import com.Murakami.My_First_App.Student.Student;
import com.Murakami.My_First_App.StudentDAO.StudentDAO;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private StudentDAO dao = new StudentDAO();

    @GetMapping
    public List<Student> getAll() {
        return dao.listarTodos();
    }

    @PostMapping
    public String add(@RequestBody Student s) {
        return dao.adicionar(s) ? "✅ Estudante adicionado" : "❌ Erro ao adicionar";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return dao.remover(id) ? "🗑️ Estudante removido" : "❌ Erro ao remover";
    }
}