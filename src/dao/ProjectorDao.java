package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Projector;

import connection.Conexao;

public class ProjectorDao {
	public static List<Projector> getList(){
		List<Projector> list = new ArrayList<Projector>();
		String sql = "SELECT * FROM tprojector ORDER BY resolution";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(
							new Projector(
										rs.getInt("idtprojector"),
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
}
