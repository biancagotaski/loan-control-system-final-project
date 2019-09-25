package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Projector;

import connection.Conexao;

public class ProjectorDao {
	
	public static List<Projector> getList(){
		List<Projector> list = new ArrayList<Projector>();
		String sql = "SELECT * FROM tprojector P INNER JOIN tproduct T ON T.idtproduct = P.idtprojector";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(
							new Projector(
										rs.getInt("idproduct"),
										rs.getString("name"),
										rs.getFloat("value"),
										rs.getInt("serial_number"),
										rs.getString("brand"),
										rs.getString("resolution"),
										rs.getBoolean("has_LCD"),
										rs.getBoolean("has_laser")
									)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Projector insert(Projector projector) {
		try {
			
			ProductDao.insert(projector);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO tprojector"
							+ "(idproduct, resolution, has_lcd, has_laser) "
							+ "VALUES "
							+ "(?,?,?,?)", 
							Statement.RETURN_GENERATED_KEYS
						);
			ps.setInt(1, projector.getId());
			ps.setString(2, projector.getResolution());
			ps.setBoolean(3, projector.isHasLCD());
			ps.setBoolean(4, projector.isHasLaser());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				projector.setId(rs.getInt(1));
				return projector;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;		
	}
	
//	public static boolean delete(int id) {
//		try {
//			PreparedStatement = ps Conexao.obterConexao().prepareStatement(
//						"DELETE FROM tprinter R INNER JOIN tproduct P ON R.idtprinter = P.idtproduct WHERE"
//					)
//		}
//	}
}
