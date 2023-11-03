package clienteDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexao.MySqlConnection;
import modelo.Cliente;

public class ClienteDao implements CRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Cliente cliente) {
		 sql = "INSERT INTO clientes VALUES (null, ?, ?, ?, ?, ?)";
		 
		 try {
			 PreparedStatement str = connection.prepareStatement(sql);
			 
			 str.setString(1, cliente.getNome());
			 str.setString(2, cliente.getCpf());
			 str.setString(3, cliente.getEndereco());
			 str.setString(4, cliente.getTelefone());
			 str.setString(5, cliente.getEmail());
			 
			 str.executeUpdate();
			 
			 System.out.println("insert on database");
			 
		 } catch(SQLException e) {
			 System.out.println("Not insert database");
			 
		 }
		 
	 }
	 
	 public static void delete(int clienteId) {
		 sql = "DELETE FROM clientes WHERE id = ?";
		 
		 try {
			 PreparedStatement str = connection.prepareStatement(sql);
			 
			 str.setInt(1, clienteId);
			 str.executeUpdate();
			 
			 System.out.println("Delete on cliente");
			 
		 } catch (SQLException e) { 
			 
			 System.out.println("Not Delete on cliente" + e.getMessage());
			 
		 }
		 
	 }
	 
	 public static List<Cliente> find(String pesquisa) {
		    sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%'", pesquisa);
		    List<Cliente> clientes = new ArrayList<Cliente>();
		    
		    try {
		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(sql);

		        while (resultSet.next()) {
		            Cliente cliente = new Cliente();
		            
		            cliente.setId(resultSet.getInt("id"));
		            cliente.setNome(resultSet.getString("nome"));
		            cliente.setCpf(resultSet.getString("cpf"));
		            cliente.setEndereco(resultSet.getString("endereco"));
		            cliente.setTelefone(resultSet.getString("telefone"));
		            cliente.setEmail(resultSet.getString("email"));
		            
		            clientes.add(cliente);
		        }
		        
		        System.out.println("find on clientes");
		        return clientes;
		        
		    } catch (SQLException e) {
		        System.out.println("not find clientes. " + e.getMessage());
		        return null;
		    }
		}

	 
	 public static Cliente findByPk(int clienteId) {
		 
		   sql = String.format("SELECT * FROM clientes WHERE id = %d", clienteId);
		    
		    try {
		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(sql);
		        Cliente cliente = new Cliente();
		        
		        while (resultSet.next()) {
		            
		            cliente.setId(resultSet.getInt("id"));
		            cliente.setNome(resultSet.getString("nome"));
		            cliente.setCpf(resultSet.getString("cpf"));
		            cliente.setEndereco(resultSet.getString("endereco"));
		            cliente.setTelefone(resultSet.getString("telefone"));
		            cliente.setEmail(resultSet.getString("email"));     
		        }
		        
		        System.out.println("find on  by pk clientes");
		        return cliente;
		 
	 } catch (SQLException e) {
	        System.out.println("not find by pk clientes. " + e.getMessage());
	        return null;
	    }
	 }
	 
	 public static void update(Cliente cliente) {
 sql = "UPDATE clientes SET nome=?, cpf=?, endereco=?, telefone=?, email=? WHERE id=?";
		 
		 try {
			 PreparedStatement str = connection.prepareStatement(sql);
			 
			 str.setString(1, cliente.getNome());
			 str.setString(2, cliente.getCpf());
			 str.setString(3, cliente.getEndereco());
			 str.setString(4, cliente.getTelefone());
			 str.setString(5, cliente.getEmail());
			 str.setInt(6, cliente.getId());
			 
			 str.executeUpdate();
			 
			 System.out.println("Update on database");
			 
		 } catch(SQLException e) {
			 System.out.println("Not Update database");
			 
		 }
	 }

}
