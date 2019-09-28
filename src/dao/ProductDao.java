package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

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
	
	public static Product getById(int id) {
		String sql = "SELECT * FROM tcustomer WHERE id = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Product(
							rs.getInt("idtproduct"),
							rs.getString("name"),
							rs.getFloat("value"),
							rs.getInt("serial_number"),
							rs.getString("brand")
						);
//				LoanDao.getById(rs.getInt("idloan"))
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Set<Product> getListByProduct(int idLoan){
		Set<Product> list = new HashSet<Product>();
		
		String sql = "SELECT * FROM tloanproduct WHERE idloan = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ps.setInt(1, idLoan);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(
							getById(rs.getInt("idproduct"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Set<Product> getList(){
		Set<Product> list = new HashSet<Product>();
		
		list.addAll(ComputerDao.getList());
		list.addAll(PrinterDao.getList());
		list.addAll(ProjectorDao.getList());
		
		return list;
	}
}
