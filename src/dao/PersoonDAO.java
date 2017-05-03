package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import domeinBackup.Persoon;
public class PersoonDAO {

	public void create(Persoon persoon) {
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("joukebouwe");
			dataSource.setURL("jdbc:mysql://localhost:3306/worlddb");

			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT 5 FROM DUAL");
			stmt.close();
			conn.close();} catch(SQLException sqle){sqle.printStackTrace();}
			
	}
	

}
