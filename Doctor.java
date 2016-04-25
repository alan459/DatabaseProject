import java.sql.*;
import java.util.*;

public class Doctor extends DataRecord 
{
    /**
     * Takes as a parameter a string that contains all the info of a Doctor and populates a Doctor instance appropriately
     */
    public Doctor(String s)
    {
        //Just call the super constructor to set info to be the supplied string
        super(s);
    }

    /**
     * Performs an update in the Doctor table using the information provided in an info string    
     */
    public void update(String s)
    {
        try 
        {
            String[] values = s.split("\t");
            if(values.length == 4)
            {
            String query = "UPDATE Doctor SET Fname=?,Minit=?,Lname=?,Dcode=? WHERE Dssn = (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,values[0]);
            pstmt.setString(2,values[1]);
            pstmt.setString(3,values[2]);
            pstmt.setString(4,values[3]);
            pstmt.setString(5,info);

            int affectedRows = pstmt.executeUpdate();
                if(affectedRows == 0)
                { System.err.println("Failed to update to Doctor info.");} 
                else 
                { System.out.println("\tSuccessfully updated Doctor info. \n");}
                
            pstmt.close();
            }
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new Doctor into the database using the info contained in the string  
     */
    public static void insert(String s)
    {
        try 
        {
            String template = "INSERT INTO Doctor (Dssn,Fname,Minit,Lname,Dcode) VALUES (?,?,?,?,?)";
            String[] values = s.split("\t");
                if(values.length == 5)
                {
                    PreparedStatement pstmt = conn.prepareStatement(template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setString(4,values[3]);
                    pstmt.setString(5,values[4]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Doctors table.");} 
                    else 
                    { System.out.println("\n Successfully inserted new Doctor. \n");}
                pstmt.close();
                }
        }
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Doctor from the database where the string parameter is the primary key of the doctor to be deleted
     */
    public void delete(String s)
    {
        String delete = "delete from Doctor where Dssn = " + s;
        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);  
        }
        catch(Exception e)
        {   
            e.printStackTrace();
        }
    }
    
    /**
     * Searches the database to get information about a particular Doctor, including name and department.
     */
    private String searchDoctor()
    {
        String result = "";
        try 
        {
            String query = "SELECT * FROM Doctor WHERE Dssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String docName = "Doctor: " + rs.getString("Fname") + " " + rs.getString("Minit") + " " + rs.getString("Lname")+ "\n";
            
            String depQuery = "select Dname from Department where Dno = ?";
            PreparedStatement ds = conn.prepareStatement(depQuery);
            ds.setString(1, rs.getString("Dcode"));
            ResultSet deps = ds.executeQuery();
            deps.next();
            String depInfo = "Department: " + deps.getString("Dname");
            
            result = docName + depInfo;
            
            rs.close();
            ps.close(); 
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Searches the database to get information about a particular Doctor's scheduled procedures.
     */
    private String searchProcedure()
    {
        String result = "";
        try 
        {
            String query = "SELECT * FROM Procedure WHERE Dssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            String queryP = "SELECT Fname,Minit,Lname FROM Patient WHERE Pssn = ?";
            PreparedStatement psP = conn.prepareStatement(queryP);
            
            String queryN = "SELECT Fname, Minit, Lname FROM Nurse WHERE Nssn = ?";
            PreparedStatement psN = conn.prepareStatement(queryN);
            
            
            while(!rs.isAfterLast())
                {   
                    // Get the name of the patient undergoing the current procedure
                    psP.setString(1, rs.getString("Pssn"));
                    ResultSet p = psP.executeQuery();
                    p.next();
                    String patientName = p.getString("Fname") + " " + p.getString("Minit") + " " + p.getString("Lname");

                    //Get the name of the Nurse involved in the procedure
                    psN.setString(1, rs.getString("Nssn"));
                    ResultSet n = psN.executeQuery();
                    n.next();
                    String nurseName = n.getString("Fname") + " " + n.getString("Minit") + " " + n.getString("Lname");

                    String procedure = "Procedure Type: " + rs.getString("procedureDescription") + "\n"
                            + "Date/Time: " + rs.getDate("scheduled_Date") + " "+ rs.getInt("scheduled_Time") + ":00"+ "\n"
                            + "Assisting Nurse: " + nurseName + "\n"
                            + "Patient: " + patientName + "\n\n";
                    result = result + procedure;
                    
                    rs.next();
                    p.close();
                    n.close();
                }
            
            rs.close();
            ps.close(); 
            psP.close();
            psN.close();
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Searches the database to get information about a particular Doctor's patients.
     */
    private String searchPatient()
    {
        String result = "";
        try 
        {
            String query = "SELECT * FROM Patient WHERE Dssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            String queryP = "SELECT Fname,Minit,Lname FROM Patient WHERE Pssn = ?";
            PreparedStatement psP = conn.prepareStatement(queryP);
            
            while(!rs.isAfterLast())
                {   
                    // Get the name of the patient undergoing the current procedure
                    psP.setString(1, rs.getString("Pssn"));
                    ResultSet p = psP.executeQuery();
                    p.next();
                    String patient = "Patient: " + p.getString("Fname") + " " + p.getString("Minit") + " " + p.getString("Lname") + "\n\n";
                    result = result + patient;
                    
                    rs.next();
                    p.close();
                }
            
            rs.close();
            ps.close(); 
            psP.close();
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Inserts a new treatment/procedure/prescription
     */
    public static String insertPPT(String s, String x)
    {
        String success = "";
        if(s.equals("PRESCRIPTION"))
        {
            success = Doctor.insertPre(x);
        }
        else if(s.equals("PROCEDURE"))
        {
            success = Doctor.insertPro(x);
        }
        else if(s.equals("TREATMENT"))
        {
            success = Doctor.insertTre(x);
        }
    }
    
    /**
     * Inserts a new prescription using the information provided by the GUI
     */
    private static String insertPre(String s)
    {
        String tmp = "insert into Prescription (prescriptionID, Pssn, Dssn, prescribed_date, medication, dosage, optional_generic, num_refills) values (?,?,?,?,?,?,?,?)";
        String[] values = s.split("\t");
        String success = ""
        try
        {
            if(values.length == 7)
                {
                    //Get the highest value for prescriptionID in the database, then increment it by one to use for the new prescription's ID
                    String maxStr = "select max(prescriptionID) from Prescription";
                    PreparedStatement max = conn.prepareStatement(maxStr);
                    ResultSet vals = max.executeQuery();
                    vals.next();
                    int preID = Integer.parseInt(vals.getString(1)) + 1;
                    
                    PreparedStatement pstmt = conn.prepareStatement(tmp);
                    pstmt.setString(1, String.valueOf(preID)); //This one you need to assign the prescriptionID based on how many prescriptions are already in the database
                    pstmt.setString(2,values[0]);
                    pstmt.setString(3,values[1]);
                    pstmt.setDate(4,formatDate(values[2]));
                    pstmt.setString(5,values[3]);
                    pstmt.setString(6,values[4]);
                    pstmt.setString(7,values[5]);
                    pstmt.setString(8,values[6]);
           
                    int affectedRows = pstmt.executeUpdate();

                    if(affectedRows == 0)
                    {success = "Failed to insert to Prescription table."; }
                    else 
                    { success = "Successfully inserted new Prescription.";}
                pstmt.close();
                }
        } catch (Exception e)
        {
            System.err.println(e);
            e.printStackTrace();
        }
        return success;
    }
    
        /**
     * Convert from String to Date object
     * @param String    date as String
     * @return Date     date as Date object
     */
    private static java.sql.Date formatDate(String string)
    {
        String[] components = string.split("-");
        
        int yy = Integer.parseInt(components[0].substring(2));
        int mm = Integer.parseInt(components[1]);
        int dd = Integer.parseInt(components[2]);
        
        java.sql.Date date = new java.sql.Date((yy+100),mm,dd);
        return date;
    }
    
    /**
     * Inserts a new procedure using the information provided by the GUI
     */
    private static void insertPro(String s)
    {
        String tmp = "insert into Procedure (procedureID, procedureDescription, scheduled_Time, scheduled_Date, Pssn, Dssn, Nssn) values (?,?,?,?,?,?,?)";
        String[] values = s.split("\t");
        try
        {
            if(values.length == 6)
                {
                    //Get the highest value for prescriptionID in the database, then increment it by one to use for the new prescription's ID
                    String maxStr = "select max(procedureID) from Procedure";
                    PreparedStatement max = conn.prepareStatement(maxStr);
                    ResultSet vals = max.executeQuery();
                    vals.next();
                    int proID = Integer.parseInt(vals.getString(1)) + 1;
                    
                    System.out.println(values[1]);
                    
                    PreparedStatement pstmt = conn.prepareStatement(tmp);
                    pstmt.setString(1, String.valueOf(proID)); //This one you need to assign the procedureID based on how many prescriptions are already in the database
                    pstmt.setString(2,values[0]);
                    pstmt.setInt(3,Integer.parseInt(values[1]));
                    pstmt.setDate(4,formatDate(values[2]));
                    pstmt.setString(5,values[3]);
                    pstmt.setString(6,values[4]);
                    pstmt.setString(7,values[5]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Procedure table.");} 
                    else 
                    { System.out.println("\n Successfully inserted new Procedure. \n");}
                pstmt.close();
                }
        } catch (Exception e)
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Inserts a new treatment using the information provided by the GUI
     */
    private static void insertTre(String s)
    {
        String tmp = "insert into Treatment (treatmentID, Pssn, Dssn, start_date, end_date, medication, dosage, method_of_delivery) values (?,?,?,?,?,?,?,?)";
        String[] values = s.split("\t");
        try
        {
            if(values.length == 7)
                {
                    //Get the highest value for prescriptionID in the database, then increment it by one to use for the new prescription's ID
                    String maxStr = "select max(treatmentID) from Treatment";
                    PreparedStatement max = conn.prepareStatement(maxStr);
                    ResultSet vals = max.executeQuery();
                    vals.next();
                    int trtID = Integer.parseInt(vals.getString(1)) + 1;
                    
                    System.out.println(values[1]);
                    
                    PreparedStatement pstmt = conn.prepareStatement(tmp);
                    pstmt.setString(1, String.valueOf(trtID)); //This one you need to assign the procedureID based on how many prescriptions are already in the database
                    pstmt.setString(2,values[0]);
                    pstmt.setString(3,values[1]);
                    pstmt.setDate(4,formatDate(values[2]));
                    pstmt.setDate(5,formatDate(values[3]));
                    pstmt.setString(6,values[4]);
                    pstmt.setString(7,values[5]);
                    pstmt.setString(8, values[6]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Treatment table.");} 
                    else 
                    { System.out.println("\n Successfully inserted new Treatment. \n");}
                pstmt.close();
                }
        } catch (Exception e)
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Searches the database to get information about a particular Doctor, info will contain the primary key of NURSE
     * in this case. It will return a string containing the information requested in the search.
     */
    public String search(String table)
    {
        String result = "";
            //Construct a select query using the appropriate key and table to search
            if(table.equals("DOCTOR"))   //If you're searching the Doctor table using the Dssn then you'll return all the info about the requested Doctor
            {
                result = searchDoctor();
            }
            else if(table.equals("PROCEDURE"))  //If you're searching the Procedure table using the Dssn then you'll return info about 
            {                                   //the procedures that the doctor is assisting with
                result = searchProcedure();
            }
            else if (table.equals("PATIENT"))   //If you're searching the patient table you'll get a list of the doctor's patients
            {
                result = searchPatient();
            }
        return result;
    }
}
