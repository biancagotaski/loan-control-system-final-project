package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Printer;

import connection.Conexao;

public class PrinterDao {
	
	
	public static List<Printer> getList(){
		List<Printer> list = new ArrayList<Printer>();
		String sql = "SELECT * FROM tprinter C INNER JOIN tproduct P ON P.idtproduct = C.idproduct";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(
							new Printer(
										rs.getInt("idproduct"),
										rs.getString("name"),
										rs.getFloat("value"),
										rs.getInt("serial_number"),
										rs.getString("brand"),
										rs.getBoolean("is_laser"),
										rs.getInt("max_leaf"),
										rs.getBoolean("has_wifi")
									)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Printer insert(Printer printer) {
		try {
			
			ProductDao.insert(printer);
			
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT INTO tprinter"
							+ "(idproduct, is_laser, max_leaf, has_wifi) "
							+ "VALUES "
							+ "(?,?,?,?)", 
							Statement.RETURN_GENERATED_KEYS
						);
			ps.setInt(1, printer.getId());
			ps.setBoolean(2, printer.isLaser());
			ps.setInt(3, printer.getMaxLeaf());
			ps.setBoolean(4, printer.isHasWifi());
			
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				printer.setId(rs.getInt(1));
				return printer;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;		
	}
	
	public static boolean delete(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM tprinter WHERE id = ?"
						);

			ps.setInt(1, id);
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
}
