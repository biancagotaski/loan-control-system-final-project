package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gotaski.business.Product;

import connection.Conexao;

public class ProductDao {
	
	
//	private int id;
//	private String name;
//	private float value;
//	private int serialNumber;
//	private String brand;
//	private Set<Loan> loans;
	
	
	public static Product insert(Product product) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO tproduct"
							+ "(name, value, serial_number, brand) "
							+ "VALUES "
							+ "(?,?,?,?)", 
							Statement.RETURN_GENERATED_KEYS
						);

			ps.setString(1, product.getName());
			ps.setFloat(2, product.getValue());
			ps.setInt(3, product.getSerialNumber());
			ps.setString(4, product.getBrand());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				product.setId(rs.getInt(1));
				return product;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;		
	}
}
