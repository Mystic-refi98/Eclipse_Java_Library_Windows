package helper;

import java.sql.*;

public class Connect {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;

    public Connect() {
    	String username = "root";
    	String password = "", database = "project";
    	String conection = "jdbc:mysql://localhost:3306/" + database;
    	try{  
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(conection, username, password);  
            st = con.createStatement();
            System.out.println("Connect !");
        }catch(Exception e){
        	System.out.println("Not Connect !");
        }  
    }

    public Connection getConnection(){
    	return con;
    }
    
    public ResultSet executeQuery(String query){
        try{
            rs = st.executeQuery(query);
        }catch(Exception e){}
        return rs;
    }

    public void executeUpdate(String query){
        try{
            st.executeUpdate(query);
        }catch(Exception e){}
    }
}