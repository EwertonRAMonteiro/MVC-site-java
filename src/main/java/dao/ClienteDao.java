package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO cliente VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, cliente.getCpf());
	            preparedStatement.setString(2, cliente.getNomeCompleto());
	            preparedStatement.setString(3, cliente.getRua());
	            preparedStatement.setString(4, cliente.getBairro());
	            preparedStatement.setString(5, cliente.getCep());
	            preparedStatement.setString(6, cliente.getCidade());
	            preparedStatement.setString(7, cliente.getEstado());
	            preparedStatement.setString(8, cliente.getEmail());
	            preparedStatement.setString(9, cliente.getNumero());

	            preparedStatement.executeUpdate();
	            
	            System.out.println("[LOG] Cliente inserido com sucesso.");
	            

	        } catch (SQLException e) {
	            System.out.printf("[ERROR] Cliente não foi inserido. Message:\n%s", e.getMessage());
	            
	        }
			
		}
		
	public static void delete(int clienteId) {
		sql = "DELETE FROM cliente WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.printf("[LOG] Cliente deletado com sucesso.");
			
			
		} catch (SQLException e) {
			System.out.printf("[ERROR] Deletar cliente falhou. Message:\n%s" + e.getMessage());
			
		}
		
	};
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM cliente WHERE nomeCompleto like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setId(resultSet.getInt("id"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNomeCompleto(resultSet.getString("nomeCompleto"));
                cliente.setRua(resultSet.getString("rua"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setNumero(resultSet.getString("numero"));
                
                clientes.add(cliente);
                
			}
			
			System.out.printf("[LOG] Busca de cliente feita.");
			return clientes;
			
		} catch(SQLException e) {
			System.out.printf("[ERROR] busca cliente falhou. Message:\n%s" + e.getMessage());
			return null;
			
		}
	}
	
	public static Cliente findByPk(int clienteId) {
		
		sql = String.format("SELECT * FROM cliente WHERE id = %d ", clienteId);
		
		
		try {
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery(sql);
			
			Cliente cliente = new Cliente();
			
			while (resultSet.next()) {
								
				cliente.setId(resultSet.getInt("id"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNomeCompleto(resultSet.getString("nomeCompleto"));
                cliente.setRua(resultSet.getString("rua"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setNumero(resultSet.getString("numero"));
                
			}
			
			System.out.printf("[LOG] Busca por Chave feita.");
			return cliente;
			
		} catch(SQLException e) {
			System.out.printf("[ERROR] busca por Chave falhou. Message:\n%s" + e.getMessage());
			return null;
			
		}
	}
	
	public static void update(Cliente cliente) {
		
		sql = "UPDATE cliente SET cpf=?, nomeCompleto=?, rua=?, bairro=?, cep=?,"
				+ " cidade=?, estado=?, email=?, numero=? WHERE id=?";
		
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, cliente.getCpf());
	            preparedStatement.setString(2, cliente.getNomeCompleto());
	            preparedStatement.setString(3, cliente.getRua());
	            preparedStatement.setString(4, cliente.getBairro());
	            preparedStatement.setString(5, cliente.getCep());
	            preparedStatement.setString(6, cliente.getCidade());
	            preparedStatement.setString(7, cliente.getEstado());
	            preparedStatement.setString(8, cliente.getEmail());
	            preparedStatement.setString(9, cliente.getNumero());
	            preparedStatement.setInt(10, cliente.getId());

	            preparedStatement.executeUpdate();
	            
	            System.out.println("[LOG] Update feito.");
	            

	        } catch (SQLException e) {
	            System.out.printf("[ERROR] Update falhou. Message:\n%s", e.getMessage());
	            
	        }
			
		}

}
