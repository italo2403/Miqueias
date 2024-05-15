package br.com.armazem.dal;

import java.sql.*;
/*
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;*/

public class ModuloConexao {
    //Método responsável pela conexão com o Banco de Dados

    public static Connection conector() {

        java.sql.Connection conexao = null;
        //a linha abaixo chama o driver que importei para a biblioteca
        //Em algumas máquinas deve ser usado a conexão com cj.
         //  String driver = "com.mysql.cj.jdbc.Driver";
             String driver = "com.mysql.jdbc.Driver";

        //armazendando informações do Banco de Dados
        String url = "jdbc:mysql://localhost:3306/armazem";
        String user = "root";
        String password = "";
        //Estabelecendo Conexão com o Banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // a linha abaixo serve para esclarecer o erro que aparecer.
            System.out.println(e);
            return null;
        }
    }

}
