package com.Murakami.My_First_App.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConexao() {
        String url = "jdbc:mysql://127.0.0.1:3306/javadatabase?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "javauser";
        String password = "senha123";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conectado ao MySQL!");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Erro ao conectar ao MySQL: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
