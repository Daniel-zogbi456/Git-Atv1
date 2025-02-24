
package dao;
 import beans.Produto;
 import classe.Conexao;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Conexao conexao;
                private Connection conn;
            
                public ProdutoDAO() {
                    this.conexao = new Conexao();
                    this.conn = this.conexao.getConexao();
                }
            
                public void inserir(Produto produto) {
                    String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                            + "(?, ?, ?)";
                    try {
                        PreparedStatement stmt = this.conn.prepareStatement(sql);
                        stmt.setString(1, produto.getNome());
                        stmt.setString(2, produto.getPreco());
                        stmt.setString(3, produto.getStatus());
                        stmt.execute();
            
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir produto: " + e.getMessage());
                    }
                }
                
                public List<Produto> getProduto() {
                String sql = "SELECT * FROM produtos";
                
                try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();            
                    
                    List<Produto> listaProdutos = new ArrayList<>();
                    
                    while (rs.next()) { 
                        Produto produto = new Produto();
                        
                        produto.setId(rs.getInt("id"));
                        produto.setNome(rs.getString("nome"));
                        produto.setPreco(rs.getString("valor"));
                        produto.setStatus(rs.getString("status"));
                        
                        listaProdutos.add(produto);    
                    }
                    return listaProdutos;
                    
                    
                } catch (Exception e) {
                    return null;
                }
            }
                
                
                
                
                
                
                
}
