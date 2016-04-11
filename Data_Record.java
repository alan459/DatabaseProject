import java.sql.*;

public abstract class Data_Record 
{
	private String info;
	private static Connection connection;
	
	public DataRecord(String s)
	{
		this.info = s;
	}
	
	//Sets up a connection to the database that all the instances of DataRecord can use for their queries need to call this
	//in the GUI (DataRecord.setUpConnection()) before you can actually do any queries
	public static void setUpConnection()
	{
		try{
		//The information necessary to create a connection to the database
		String USR = "";
		String PWD = "";
		String URL = "";
		
		String driverName = "";
		Class.forName(driverName);
		
		connection = DriverManager.getConnection(URL, USR, PWD);
		
		System.out.println("Connected to C325.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public abstract void insert(String s);
	public abstract void update(String s);


	public abstract void search(String primaryKey);

	//public abstract void searchByName(String name);

}
