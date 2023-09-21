/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author IFSul
 */
public class JDBC {

    /**
     * @param args the command line arguments
     */
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
 System.out.println("_______-------______--------____ ejercicio2: mostrar todo_____---------_______-----______-----");
 for(EstadoCidade x :lista ){
 System.out.println(x.toString());
 }
  System.out.println("_______-------______--------____ ejercicio2: mostrar todo_____---------_______-----______-----");

    }
    
}
