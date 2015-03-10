import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	// check connection = null
	
	public Connection conn = null;
	
	public DB(){
		// connection to database
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://127.0.0.1:3306/db";
			conn = DriverManager.getConnection(url, "root", "");
			System.out.println("conn built");
		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//exeptions sql
	
	public ResultSet runSql(String sql) throws SQLException{
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
	
	public boolean runSql2(String sql) throws SQLException{
		Statement sta = conn.createStatement();
		return sta.execute(sql);
	}
	
	@Override
	protected void finalize() throws Throwable{
		if(conn != null || !conn.isClosed()){
			conn.close();
		}
	}

}
