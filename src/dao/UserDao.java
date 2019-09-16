package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Administrator;
import com.gotaski.business.User;

import connection.Conexao;

public class UserDao {
	
	public static List<User> getList(){
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM tuser ORDER BY name";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				if(rs.getBoolean("admin")) {
					list.add(
							new Administrator(
										rs.getInt("idtuser"),
										rs.getString("name"),
										rs.getString("email"),
										rs.getString("password")
									)
							);
				} else {
					list.add(
							new User(
									rs.getInt("idtuser"),
									rs.getString("name"),
									rs.getString("email"),
									rs.getString("password")
								)
							);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static User validation(String email, String password){
		String sql = "SELECT * FROM tuser WHERE EMAIL = ? AND PASSWORD = ?";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				if(rs.getBoolean("admin")) {
					return new Administrator(
								rs.getInt("idtuser"),
								rs.getString("name"),
								rs.getString("email"),
								rs.getString("password")
							);
				} else {
					return new User(
							rs.getInt("idtuser"), 
							rs.getString("name"), 
							rs.getString("email"), 
							rs.getString("password")
						);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static User addUser(User user){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"INSERT into tuser (name, email, password, admin) values (?,?,?,?)"
						);

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setBoolean(4, false);
			
			ps.execute();
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	public static boolean update(User user){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"UPDATE tuser SET name = ?, email = ?, password = ? WHERE idtuser = ?"
						);

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	
	public static boolean delete(int id){
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"DELETE FROM tuser WHERE idtuser = ?"
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
