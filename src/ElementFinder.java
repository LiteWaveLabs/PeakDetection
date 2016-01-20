import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ElementFinder {

	
	public static List<String> mySQLHandler (double wavelenght, int numberOfElements) {
		
		List<String> myElement = new ArrayList<String>();
		
		 final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	     final String DB_URL="jdbc:mysql://simplescopedb.tunw.net/ASD";

	      //  Database credentials
	      final String USER = "simplescope";
	      final String PASS = "simplescope";

	     Connection conn = null;
		Statement stmt = null;
		try{
	         // Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);

	         // Execute SQL query
	         stmt = conn.createStatement();
	         String sql;
	         sql = "(SELECT * FROM elements ORDER BY abs(wavelength - "+ wavelenght +") LIMIT "+ numberOfElements +") ORDER BY intensity DESC";
	         ResultSet rs = stmt.executeQuery(sql);

	         while(rs.next()){
	            //Retrieve by column name
	            int intensity = rs.getInt("intensity");
	            String element = rs.getString("element");
	            myElement.add(element);
	            System.out.println(intensity);
	         }

	         // Clean-up environment
	         rs.close();
	         stmt.close();
	         conn.close();
	      }catch(SQLException se){
	         //Handle errors for JDBC
	         se.printStackTrace();
	      }catch(Exception e){
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }finally{
	         //finally block used to close resources
	         try{
	            if(stmt!=null)
	               stmt.close();
	         }catch(SQLException se2){
	         }// nothing we can do
	         try{
	            if(conn!=null)
	            conn.close();
	         }catch(SQLException se){
	            se.printStackTrace();
	         }//end finally try
	      } //end try
		return myElement;	
	}
}

