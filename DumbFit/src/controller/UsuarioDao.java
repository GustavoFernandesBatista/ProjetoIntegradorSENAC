/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Enter;

public class UsuarioDao extends ConectarDao {
    private PreparedStatement ps;
    public UsuarioDao() {
        super();
    }

public void incluir(Usuario obj) {
          sql = "INSERT INTO USUARIOS VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, obj.getCpf());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getTelefone());
            ps.setString(4, obj.getEmail());
            ps.setString(5, obj.getIdNivel());
            ps.setString ( 6, obj.getSenha());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir usuário!" + err.getMessage());
        }
    }
        public void excluir ( String cpf ) {
       
        sql = "DELETE FROM USUARIOS WHERE CPF = '" + cpf + "'";
        try { 
            ps = mycon.prepareStatement (sql); 
            ps.execute();
            ps.close();
        JOptionPane.showMessageDialog (null,"Registro Excluido com Sucesso!");
        } catch (SQLException err) {
        JOptionPane.showMessageDialog (null, "Erro ao Excluir usuário!" +
        err.getMessage());
        }
        }
        
                public ResultSet buscar ( Usuario obj ) {
     
        sql = "SELECT * FROM USUARIOS WHERE CPF = ?";
        try { ps = mycon.prepareStatement(sql); 
         ps.setString(1, obj.getCpf());
        return ps.executeQuery();
        } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" +
        err.getMessage());
        return null;
        }}
        


public ResultSet validarLogin (String login, String senha)   {
    
    sql = "SELECT * , if(idnivel = 1, 'Gerente', 'Operador') as nivel "
            + "FROM USUARIOS WHERE ucase(email) = ucase('"+login+"') "
            + "and senha = ucase('"+ senha +"')";
   
    try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null; 
        }
}

public ResultSet obterUsuarios ()   {
    
    sql = "SELECT * FROM `USUARIOS`";
   
    try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null; 
        }
}

public ResultSet obterEntradas ()   {
    
    sql = "SELECT * FROM `ENTRADAS`";
   
    try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null; 
        }
}

        public void alterar (Usuario obj) {
        sql = "UPDATE USUARIOS SET nome = ?, email = ?, telefone = ?, idnivel = ?"
        + ", senha = ? WHERE cpf = ?";
        try {
        ps = mycon.prepareStatement(sql);
        ps.setString(1, obj.getNome());
        ps.setString(2, obj.getEmail());
        ps.setString(3, obj.getTelefone());
        ps.setString(4, obj.getIdNivel());
        ps.setString ( 5, obj.getSenha());
        ps.setString(6, obj.getCpf());
        ps.execute();
        ps.close();
        JOptionPane.showMessageDialog(null,"Registro Alterado com Sucesso!");
        } catch (SQLException err) {
        JOptionPane.showMessageDialog(null,
        "Erro ao Alterar usuário!" + err.getMessage());}}
}

