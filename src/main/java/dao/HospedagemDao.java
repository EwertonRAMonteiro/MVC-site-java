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
import model.Hospedagem;

public class HospedagemDao implements CrudHospedagem {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Hospedagem hospedagem, int clienteId) {
		sql = "INSERT INTO hospedagem VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hospedagem.getNomeHotel());
            preparedStatement.setString(2, hospedagem.getEndereco());
            preparedStatement.setString(3, hospedagem.getEstado());
            preparedStatement.setString(4, hospedagem.getValorIntegral());
            preparedStatement.setString(5, hospedagem.getCheckIn());
            preparedStatement.setString(6, hospedagem.getCheckOut());
            preparedStatement.setString(7, hospedagem.getNumeroHotel());
            preparedStatement.setLong(8, clienteId);

            preparedStatement.executeUpdate();
            
            System.out.println("[LOG] Hospedagem inserido com sucesso.");
            

        } catch (SQLException e) {
            System.out.printf("[ERROR] Hospedagem não foi inserido. Message:\n%s", e.getMessage());
            
        }
		
	}
	
	public static List<Hospedagem> fin(String pesquisa){
		sql = String.format("SELECT * FROM hospedagem WHERE nomeHotel like '%s%%' OR endereco LIKE '%s%%' ", pesquisa, pesquisa);
		List<Hospedagem> hospedagems = new ArrayList<Hospedagem>();
		
		try {
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Hospedagem hospedagem = new Hospedagem();
				hospedagem.cliente = new Cliente();
				
				hospedagem.setId(resultSet.getInt("id"));
				hospedagem.setNomeHotel(resultSet.getString("nomeHotel"));
				hospedagem.setEndereco(resultSet.getString("endereco"));
				hospedagem.setEstado(resultSet.getString("estado"));
				hospedagem.setValorIntegral(resultSet.getString("valorIntegral"));
				hospedagem.setCheckIn(resultSet.getString("checkIn"));
				hospedagem.setCheckOut(resultSet.getString("checkOut"));
				hospedagem.setNumeroHotel(resultSet.getString("numeroHotel"));
				hospedagem.cliente.setCpf(resultSet.getString("cpf"));
				hospedagem.cliente.setNomeCompleto(resultSet.getString("nomeCompleto"));
				hospedagem.cliente.setRua(resultSet.getString("rua"));
				hospedagem.cliente.setBairro(resultSet.getString("bairro"));
				hospedagem.cliente.setCep(resultSet.getString("cep"));
				hospedagem.cliente.setCidade(resultSet.getString("cidade"));
				hospedagem.cliente.setEstado(resultSet.getString("estado"));
				hospedagem.cliente.setEmail(resultSet.getString("email"));
				hospedagem.cliente.setNumero(resultSet.getString("numero"));
				
				hospedagems.add(hospedagem);
				
		}
			System.out.printf("[LOG] Busca de Hospedagem feita.");
			return hospedagems;
			
		} catch(SQLException e) {
			System.out.printf("[ERROR] busca Hospedagem falhou. Message:\n%s" + e.getMessage());
			return null;
			
		}
	}

}
