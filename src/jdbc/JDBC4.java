/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author IFSul
 */
public class JDBC4 {
     public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
     Connection conexao = DriverManager.getConnection( "jdbc:mysql://localhost/estados_cidades", "root", "");
     ArrayList<EstadoCidade> lista = new ArrayList<>();  
     
 String sql = "SELECT * FROM `cidade`";
 PreparedStatement stmt = conexao.prepareStatement(sql);
 ResultSet rs = stmt.executeQuery();
 while (rs.next()) {
     int id = rs.getInt("id");
 String nome =  rs.getString("nome");
 String estado = rs.getString("estado");
 
 lista.add(new EstadoCidade(id,nome,estado));
 
 
 }
 rs.close();
 stmt.close();
 conexao.close();

         String resp = JOptionPane.showInputDialog(null, "What's your name?");
         char resposta = resp.charAt(0);
 System.out.println("_______-------______--------____ ejercicio4:  cidades con letra 'A' no inicio_____---------_______-----______-----");
  for(EstadoCidade x :lista ){
      char letra = x.getNome().charAt(0);
      if(letra == resposta){
 System.out.println(x.toString());}
 }
  System.out.println("_______-------______--------____ ejercicio4: cidades con letra 'A' no inicio_____---------_______-----______-----");
    }
    
}
