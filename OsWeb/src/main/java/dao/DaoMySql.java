package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
//import com.mysql.cj.xdevapi.Statement;

import model.Os;

public class DaoMySql implements DaoInterface {
	
	private String url ="jdbc:mysql://localhost:3306/smartphone";
	private String username = "root";
	private String password ="CorsoJava@";
	private Connection conn;
	
	public DaoMySql() throws SQLException {
		 conn = DriverManager.getConnection(url, username, password); //registra il drive e creare una connessione al db
	}

	@Override
	public ArrayList<Os> getAllOs() throws SQLException {
		String sql = "select * from Os";
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql); //estrae risultato della query
		
		ArrayList<Os> osList = new ArrayList();
		
		while(rs.next()) {//per ogni indice e vai avanti fino all'ultimo indice 
			//estrarre tutti i record
			Os os = new Os();
			os.setId(rs.getInt("id"));
			os.setDescrizione(rs.getString("descrizione"));//nome passato col nome del db
			os.setCompany(rs.getString("company"));
			os.setOpenSource(rs.getInt("open_source"));
			osList.add(os);
		} return osList;
	}

	@Override
	public Os getOsById(int id) throws SQLException {
		String sql = "select * from Os where id ="+id;
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql); //estrae risultato della query
		
		Os os = null;
		
		while(rs.next()) {//per ogni indice e vai avanti fino all'ultimo indice 
			//estrarre tutti i record
			os = new Os();
			os.setId(rs.getInt("id"));
			os.setDescrizione(rs.getString("descrizione"));//nome passato col nome del db
			os.setCompany(rs.getString("company"));
			os.setOpenSource(rs.getInt("open_source"));
			
		} return os;
	}

	@Override
	public ArrayList<Os> getOsByCompany(String company)  throws SQLException{
		// TODO Auto-generated method stub
		String sql =  "select * from Os where company ='"+company+"'";
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql); //estrae risultato della query
		
		ArrayList<Os> companyList = new ArrayList();
		
		while(rs.next()) {//per ogni indice e vai avanti fino all'ultimo indice 
			//estrarre tutti i record
			Os os = new Os();			
			os.setId(rs.getInt("id"));
			os.setDescrizione(rs.getString("descrizione"));//nome passato col nome del db
			os.setCompany(rs.getString("company"));
			os.setOpenSource(rs.getInt("open_source"));
			companyList.add(os);
			
		} return companyList;
	}

	@Override
	public void saveOs(Os os)  throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateOs(Os os) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOs(int id)  throws SQLException{
		// TODO Auto-generated method stub
		return false;
	}

} 