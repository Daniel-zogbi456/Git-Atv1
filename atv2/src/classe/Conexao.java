/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
     public Connection getConexao() {
            
                    try {
                        Connection conn = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/ leilao ", 
                                "root", 
                                "ds66647892**"
                        );
                        return conn;
            
                    } catch (Exception e) {
                        System.out.println("Erro ao conectar: " + e.getMessage());
                        return null;
                    }
            
                }
    
}
