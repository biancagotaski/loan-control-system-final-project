package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gotaski.business.Loan;

import connection.Conexao;

public class LoanDao {
	private static String sql = "SELECT * FROM tloan ORDER BY startDate";
	private static String sqlByID = "SELECT * FROM tloan WHERE idtloan = ?";
	
	public static Loan getLoanByID(int id) {
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sqlByID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Loan(
							rs.getInt("idtloan"),
							rs.getString("startDate"),
							rs.getString("endDate"),
							rs.getString("cpfcustomer"),
							CustomerDao.getById(rs.getInt("idcustomer")),
							ProductDao.getListByProduct(rs.getInt("idproduct"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Loan associateCustomer(Loan loan) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
							"UPDATE tloan SET idcustomer = ? WHERE idtloan = ?"
						);

			ps.setInt(1, loan.getCustomer().getId());
			ps.setInt(2, loan.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return loan;
		
	}
	
//	public static boolean associateLoan(int idLoan, int idProduct) {
//		try {
//			PreparedStatement ps = Conexao.obterConexao().prepareStatement(
//						"INSERT INTO tloanproduct (idloan, idproduct) VALUES (?,?)"
//					);
//			
//			ps.setInt(1, idLoan);
//			ps.setInt(2, idProduct);
//			
//			ps.execute();
//			
//			return true;
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	public static List<Loan> getList(){
		List<Loan> list = new ArrayList<Loan>();
		
		try {
			PreparedStatement ps = Conexao.obterConexao().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(
							new Loan(
										rs.getInt("idtloan"),
										rs.getString("startDate"),
										rs.getString("endDate"),
										rs.getString("cpfcustomer"),
										CustomerDao.getById(rs.getInt("idcustomer")),
										ProductDao.getListByProduct(rs.getInt("idproduct"))
									)
						);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Loan insert(Loan loan) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
								"INSERT INTO tloan " +
								"(startDate, endDate, cpfcustomer) " +
								"VALUES " +
								"(?,?,?)"
							);
			
			ps.setString(1, loan.getStartDate());
			ps.setString(2, loan.getEndDate());
			ps.setString(3, loan.getCPFCustomer());
			
			ps.execute();
			
			return loan;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean delete(int idLoan) {
		try {
			PreparedStatement ps = 
					Conexao.obterConexao().prepareStatement(
								"DELETE FROM tloanproduct WHERE idloan = ?"
							);
			
			ps.setInt(1, idLoan);
			
			ps.execute();
			
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
