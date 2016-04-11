import java.sql.*;

public abstract class Data_Record 
{
	String info;
	Connection connection;
	
	public DataRecord(String s, Connection conn)
	{
		this.info = s;
		this.connection = conn;
	}

	public abstract void insert(String s);
	public abstract void update(String s);


	public abstract void search(String primaryKey);

	//public abstract void searchByName(String name);

}
