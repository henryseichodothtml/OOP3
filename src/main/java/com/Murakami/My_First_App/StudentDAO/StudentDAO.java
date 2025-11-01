package com.Murakami.My_First_App.StudentDAO;

import com.Murakami.My_First_App.Conexao.Conexao;
import com.Murakami.My_First_App.Student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection con;

    public StudentDAO() {
        this.con = new Conexao().getConexao();
    }

    public List<Student> listarTodos() {
        List<Student> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setIdade(rs.getInt("idade"));
                lista.add(s);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar estudantes: " + e.getMessage());
        }
        return lista;
    }

    public boolean adicionar(Student s) {
        try {
            String sql = "INSERT INTO students (nome, idade) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getNome());
            stmt.setInt(2, s.getIdade());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar estudante: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(int id) {
        try {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao remover estudante: " + e.getMessage());
            return false;
        }
    }
}