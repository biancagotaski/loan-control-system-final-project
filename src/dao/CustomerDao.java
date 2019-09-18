package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				if(rs.getBoolean("admin")) {}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
