

public class Relation_Attributes
{
	public static String[] patient = {"Pssn", "Fname", "M Init", "Lname", "DOB", "age", "sex", "location"};

	public static String[] doctor = {"Dssn", "Fname", "M Init", "Lname", "D code"};

	public static String[] nurse = {"Dssn", "Fname", "M Init", "Lname", "Supervisor"};

	public static String[] treatment = {"Treatment ID", "Pssn", "Dssn", "Start Date", "End Date", "Medication", "Dosage", "Method of Delivery"};

	public static String[] prescription = {"Prescription ID", "Pssn", "Dssn", "Prescribed Date", "Medication", "Dosage", "Optional", "Num Refills"};

	public static String[] procedure = {"Procedure ID", "Procedure Description", "Scheduled Time", "Pssn", "Dssn", "Nssn"};
}