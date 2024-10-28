package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import utils.ConnectionFactory;

public class ProdutoDAO {
    
    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO PRODUTO (descricao, quantidade, preco, detalhes,imagem) VALUES (?,?,?,?,?)";
        
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getDetalhe());
            ps.setString(5, produto.getUrl_imagem());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto inserido com sucesso!");
            } else {
                System.out.println("Nenhuma linha foi inserida.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String descricao = rs.getString("descricao");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");
                String detalhe = rs.getString("detalhes");
                String urlImagem = rs.getString("imagem");

                Produto produto = new Produto(idProduto, descricao, quantidade, preco, detalhe, urlImagem);
                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return produtos;
    }
    
    public void removerProduto(int idProduto) {
        String sql = "DELETE FROM PRODUTO WHERE idProduto = ?";
        
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Nenhuma linha foi removida.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE PRODUTO SET descricao = ?, quantidade = ?, preco = ?, detalhes = ?, imagem = ? WHERE idProduto = ?";
        
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getDetalhe());
            ps.setString(5, produto.getUrl_imagem());
            
            ps.setInt(6, produto.getIdProduto());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }    
    }
    
    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM PRODUTO WHERE idProduto = ?";
        
        Produto produto = null;
        try (Connection conn = new ConnectionFactory().getConnection(); 
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto = new Produto(
                    rs.getInt("idProduto"),
                    rs.getString("descricao"),
                    rs.getInt("quantidade"),
                    rs.getDouble("preco"),
                    rs.getString("detalhes"),
                    rs.getString("imagem")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto;
    }
    
    public List<Produto> buscarPorDescricao(String descricao) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO WHERE descricao LIKE ?";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + descricao + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setDetalhe(rs.getString("detalhes"));
                produto.setUrl_imagem(rs.getString("imagem"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}