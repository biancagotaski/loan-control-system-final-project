package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Computer;

import connection.Conexao;

public class ComputerDao {
	public static List<Computer> getList(){
		List<Computer> list = new ArrayList<Computer>();
		String sql = "SELECT * FROM tcomputer ORDER BY idtcomputer";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//FALTA RELACIONAMENTO DE HERANÇA COM PRODUTO. DAR JOIN NO BANCO PRA PEGAR INFO DAS DUAS TABELAS
			while(rs.next()){
				list.add(
							new Computer(
										rs.getInt("idtcomputer"),
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
}
