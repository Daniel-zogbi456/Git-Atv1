
package dao;
 import beans.Produto;
 import classe.Conexao;
 import java.sql.Connection;
 import java.sql.PreparedStatement;

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
}
