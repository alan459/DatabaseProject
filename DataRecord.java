import java.sql.*;

public abstract class DataRecord 
{
	public String info; //A string to hold the information passed to instance to be used in the query
	public static Connection conn; //One database connection for all the instances to use to execute queries
	static final String URL = "jdbc:oracle:thin:@abacus1:1525:C325";     
	static final String USR = "sl7dz";  
	static final String PWD = "kookaburra";
	
	public DataRecord(String s)
	{
		this.info = s;
	}
	
	//Sets up a connection to the database that all the instances of DataRecord can use for their queries need to call this
	//in the GUI (DataRecord.setUpConnection()) before you can actually do any queries
	public static void setUpConnection()
	{
		try{
			//The information necessary to create a connection to the database, need to figure out what this will be
	
		
			// Register driver by finding the class that corresponds do it             
			String driverName = "oracle.jdbc.OracleDriver"; 
			Class.forName(driverName);
		
			conn = DriverManager.getConnection(URL, USR, PWD);
		
			System.out.println("Connected to C325.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void insert(String s)
        {
            // will be overridden in subclasses
        }
	public abstract void update(String s);


	public abstract String search(String searchType);

	//public abstract void searchByName(String name);

}
