/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author gustavofernandes
 */
import model.Enter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class EnterUserDao extends ConectarDao {
    private PreparedStatement ps;
    public EnterUserDao() {
        super();
    }

public void incluir(Enter obj) {
          sql = "INSERT INTO ENTRADAS VALUES (?, ?, ?, ?)";
        try {
            ps = mycon.prepareStatement(sql);
            ps.setString(1, obj.getCpf());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getEntradaUsu());
            ps.setString(4, obj.getSaidaUsu());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Entrada/Saida incluída com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir ccc!" + err.getMessage());
        }
    }



public ResultSet obterUsuarios ()   {
    
    sql = "SELECT * FROM `ENTRADAS`";
   
    try {
            ps = mycon.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null; 
        }
}


}

