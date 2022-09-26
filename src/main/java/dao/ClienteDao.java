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
		
	};
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM clientes WHERE cpf like '%s%%' OR nomeCompleto LIKE '%s%%' ", pesquisa, pesquisa);
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
			
			System.out.printf("[ERROR] Busca de cliente feita. Message:\n%s");
			return clientes;
			
		} catch(SQLException e) {
			System.out.printf("[ERROR] busca falha. Message:\n%s" + e.getMessage());
			return null;
			
		}
	}
	
	public static Cliente findByPk(int clienteId) {
		return null;
	}
	
	public static void update(Cliente cliente) {
		
	}

}
