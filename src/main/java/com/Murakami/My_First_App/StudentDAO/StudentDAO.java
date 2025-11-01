package com.Murakami.My_First_App.StudentDAO;

import com.Murakami.My_First_App.Conexao.Conexao;
import com.Murakami.My_First_App.Student.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO {

    public List<Student> listarTodos() {
        List<Student> lista = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = new Conexao().getConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentid(rs.getInt("id"));
                s.setStudentname(rs.getString("nome"));
                s.setStudentcpf(rs.getString("CPF"));
                lista.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void inserir(Student s) {
        String sql = "INSERT INTO students (nome, email) VALUES (?, ?)";
        try (Connection con = new Conexao().getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getStudentname());
            ps.setString(2, s.getStudentcpf());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}