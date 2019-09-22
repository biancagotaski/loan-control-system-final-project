package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Computer;

import connection.Conexao;

public class ComputerDao {
	public static List<Computer> getList(){
		List<Computer> list = new ArrayList<Computer>();
		String sql = "SELECT * FROM tcomputer C INNER JOIN tproduct P ON P.idtproduct = C.idproduct";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(
							new Computer(
										rs.getInt("idproduct"),
										rs.getString("name"),
										rs.getFloat("value"),
										rs.getInt("serial_number"),
										rs.getString("brand"),
										rs.getString("operational_system"),
										rs.getInt("cores"),
										rs.getBoolean("has_accessories")
									)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Computer insert(Computer computer){
		
		try {
			
			ProductDao.insert(computer);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO tcomputer"
							+ "(idproduct, operational_system, cores, has_accessories) "
							+ "VALUES "
							+ "(?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS
						);

			ps.setInt(1, computer.getId());
			ps.setString(2, computer.getOperationalSystem());
			ps.setInt(3, computer.getCores());
			ps.setBoolean(4, computer.isHasAccessories());
			
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				computer.setId(rs.getInt(1));
				return computer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
}
