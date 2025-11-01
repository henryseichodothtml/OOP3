package com.Murakami.My_First_App.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public Connection getConexao() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/javadatabase?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String usuario = "javauser";
            String senha = "senha123";
            System.out.println("✅ Conectado ao MySQL!");
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar ao MySQL: " + e.getMessage());
            return null;
        }
    }
}