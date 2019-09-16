package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gotaski.business.Administrator;

import connection.Conexao;

public class AdministratorDao {
	
	public static Administrator insert(Administrator administrator) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
					"INSERT into tuser (name, email, password, admin) values (?,?,?,?)"
					);

			ps.setString(1, administrator.getName());
			ps.setString(2, administrator.getEmail());
			ps.setString(3, administrator.getPassword());
			ps.setBoolean(4, true);
			
			ps.execute();
			
			return administrator;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
}
