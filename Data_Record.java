

public abstract class Data_Record 
{
	String myPrimaryKey;

	public abstract void insert(String s);
	public abstract void update(String s);


	public abstract void search(String primaryKey);

	//public abstract void searchByName(String name);

}