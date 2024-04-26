package ERRONKA3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaldeaDAO {
	private Connection konexioa;
	
	public TaldeaDAO() {
		try {
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rugby", "root", "");
		}catch(SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public ArrayList<Taldea> getAllTaldeak(){
		ArrayList<Taldea> taldeakList = new ArrayList<Taldea>();
        String sql = "SELECT * FROM taldea";
        try (Statement statement = konexioa.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
        	while (resultSet.next()) {
        		Taldea talde = new Taldea();
				talde.setTalde_kod(resultSet.getInt("talde_kod"));
	            talde.setTalde_izena(resultSet.getString("talde_izena"));
	            talde.setHerria(resultSet.getString("herria"));
	            talde.setZuzendaria(resultSet.getString("zuzendaria"));
	            taldeakList.add(talde);
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return taldeakList;
	}
	
	public void insertTaldea(Taldea taldea){
        String sql ="INSERT INTO taldea(talde_izena, herria, zuzendaria) VALUES (?, ?, ?)";
        try {
        	PreparedStatement statement = konexioa.prepareStatement(sql);
            statement.setString(2, taldea.getTalde_izena());
            statement.setString(3, taldea.getHerria());
            statement.setString(4, taldea.getZuzendaria());
            statement.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void deleteTaldea(String izena){
        String sql = "DELETE FROM taldea WHERE talde_izena = ?";
        try (PreparedStatement statement = konexioa.prepareStatement(sql)) {
            statement.setString(1, izena);
            statement.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public boolean TaldeDBGaldetu(String izena){
        String sql = "SELECT 1 FROM taldea WHERE talde_izena = ?";
        try (PreparedStatement statement = konexioa.prepareStatement(sql)) {
        	
        	statement.setString(1, izena);
        	ResultSet resultSet = statement.executeQuery();

            // Si resultSet tiene al menos una fila, el grupo existe
            return resultSet.next();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
	
	public void deskonektatu(){
        try {
			if (konexioa != null && !konexioa.isClosed()) {
			    konexioa.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}