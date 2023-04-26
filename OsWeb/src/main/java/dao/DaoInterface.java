package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Os;

public interface DaoInterface {
	
	public ArrayList<Os> getAllOs() throws SQLException; //estrae tutti  i record
	
	public Os getOsById(int id)throws SQLException; //prende OS dal numero id e mostra 
	
	public ArrayList<Os> getOsByCompany(String company)throws SQLException; //mostra/richiama company

	public void saveOs(Os os)throws SQLException; //modifica record
	
	public boolean updateOs(Os os)throws SQLException; //carica/inserire SO su db
	
	public boolean deleteOs(int id)throws SQLException; //cancella un record
	

}
