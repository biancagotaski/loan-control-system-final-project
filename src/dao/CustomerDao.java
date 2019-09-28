package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Computer;
import com.gotaski.business.Customer;

import connection.Conexao;

public class CustomerDao {

	public static List<Customer> getList(){
		List<Customer> list = new ArrayList<Customer>();
		String sql = "SELECT * FROM tcustomer ORDER BY name";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(
						new Customer(
									rs.getInt("idtcustomer"),
									rs.getString("name"),
									rs.getString("lastname"),
									rs.getString("email"),
									rs.getString("birthday"),
									rs.getString("CPF"),
									rs.getString("street"),
									rs.getInt("number"),
									rs.getString("city"),
									rs.getString("state")
								)
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Customer insert(Customer customer){
		
		try {
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO tcustomer"
							+ "(idtcustomer, name, lastname, email, birthday, CPF, street, number, city, state) "
							+ "VALUES "
							+ "(?,?,?,?,?,?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS
						);

			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getBirthday());
			ps.setString(6, customer.getCPF());
			ps.setString(7, customer.getStreet());
			ps.setInt(8, customer.getNumber());
			ps.setString(9, customer.getCity());
			ps.setString(10, customer.getState());			
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				customer.setId(rs.getInt(1));
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	public static Customer getById(int id) {
		String sql = "SELECT * FROM tcustomer WHERE id = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Customer(
							rs.getInt("idtcustomer"),
							rs.getString("name"),
							rs.getString("lastname"),
							rs.getString("email"),
							rs.getString("birthday"),
							rs.getString("CPF"),
							rs.getString("street"),
							rs.getInt("number"),
							rs.getString("city"),
							rs.getString("state")
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
