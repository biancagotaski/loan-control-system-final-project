package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Printer;

import connection.Conexao;

public class PrinterDao {
	public static List<Printer> getList(){
		List<Printer> list = new ArrayList<Printer>();
		String sql = "SELECT * FROM tprinter ORDER BY idtprinter";
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//FALTA RELACIONAMENTO DE HERANÇA COM PRODUTO. DAR JOIN NO BANCO PRA PEGAR INFO DAS DUAS TABELAS
			while(rs.next()){
				list.add(
							new Printer(
										rs.getInt("idtprinter"),
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
}
