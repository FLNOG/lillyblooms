package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import utils.ConnectionFactory;

public class ClienteDAO {

	public void cadastrarCliente(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE (Nome, Email, Telefone) VALUES (?,?,?)";
		
		PreparedStatement ps = null;
        Connection conn = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cliente inserido com sucesso!");
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
	
	public List<Cliente> listarClientes() {
		
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nome = rs.getString("Nome");
                String email = rs.getString("email");
                String contato = rs.getString("Telefone");
                

                Cliente cliente = new Cliente(idCliente, nome, email, contato);
                clientes.add(cliente);
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
        return clientes;
    }
	
	public void removerCliente(int idProduto) {
        String sql = "DELETE FROM CLIENTE WHERE IdCliente = ?";
        
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idProduto);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("CLiente removido com sucesso!");
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
	
	public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET Nome = ?, CpfCnpj = ?, Nascimento = ?, Telefone = ?, Senha = ?, Email = ? WHERE idCliente = ?";
        
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getNascimento());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getSenha());
            ps.setString(6, cliente.getEmail());
            
            ps.setInt(7, cliente.getIdCliente());
            
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
	
	public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM CLIENTE WHERE IdCliente = ?";
        
        Cliente cliente = null;
        try (Connection conn = new ConnectionFactory().getConnection(); 
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("IdCliente"),
                    rs.getString("Nome"),
                    rs.getString("CpfCnpj"),
                    rs.getString("Nascimento"),
                    rs.getString("Email"),
                    rs.getString("Telefone"),
                    rs.getString("Senha")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public List<Cliente> buscarPorNome(String nome) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM CLIENTE WHERE nome LIKE ?";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCLiente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNascimento(rs.getString("nascimento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}