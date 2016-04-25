import java.sql.*;
import java.util.*;

public class Patient extends DataRecord 
{
    /**
     * Takes as a parameter a string that contains all the info of a Patient and populates a Patient instance appropriately
     */
    public Patient(String s)
    {
        //Just call the super constructor to set info to be the supplied string
        super(s);
    }

    /**
     * Performs an update in the Patient table using the information provided in an info string    
     */
    public void update(String s)
    {
        try 
        {
            String[] values = s.split("\t");
            if(values.length == 4)
            {
                String query = "UPDATE Patient SET Fname=?,Minit=?,Lname=?,DOB=?,location=?,sex=?, age=? WHERE Pssn = (?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1,values[0]);
                pstmt.setString(2,values[1]);
                pstmt.setString(3,values[2]);
                pstmt.setString(4,values[3]);
                pstmt.setString(5,values[4]);
                pstmt.setString(6,values[5]);
                pstmt.setString(7,info);

                int affectedRows = pstmt.executeUpdate();
                if(affectedRows == 0)
                { System.err.println("Failed to update to Patient info.");} 
                else 
                { System.out.println("\tSuccessfully updated Patient info. \n");}

                pstmt.close();
            }
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new Patient into the database using the info contained in the string  
     */
    public static void insert(String s)
    {
        try 
        {
            //Depending on the information provided for the search, if it was by ssn or by name/DOB construct the query
            //Which one you do depends on whether or not info contains a tab character b/c ssn has no tab wheras the other one does
            String query = "";
            PreparedStatement ps = null;
                  
            String template = "INSERT INTO Patient (Pssn,Fname,Minit,Lname,DOB,age,sex,location) VALUES (?,?,?,?,?,?,?,?)";
            String[] values = s.split("\t");
            if(values.length == 8)
            {
                PreparedStatement pstmt = conn.prepareStatement(template);
                pstmt.setString(1,values[0]);
                pstmt.setString(2,values[1]);
                pstmt.setString(3,values[2]);
                pstmt.setString(4,values[3]);
                pstmt.setDate(5,formatDate(values[4]));
                pstmt.setString(6,values[5]);
                pstmt.setString(7,values[6]);
                pstmt.setString(8,values[7]);

                int affectedRows = pstmt.executeUpdate();
                if(affectedRows == 0)
                { System.err.println("Failed to insert to Patients table.");} 
                else 
                { System.out.println("\n Successfully inserted new Patient. \n");}
                pstmt.close();
            }
        }
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Patient from the database where the string parameter is the primary key of the patient to be deleted
     */
    public void delete(String s)
    {
        String delete = "delete from Patient where Pssn = " + s;
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
     * Deletes a tuple from the Treatment, Procedure, or Prescription Relation using the ID of the tuple to be deleted
     */
    public static void delete(String id, String table)
    {
        //Determine which table to delete the tuple from
        String delete = "";
        if(table.equals("PROCEDURE"))
        {
            delete = "delete from Procedure where procedureID = " + id;
        }
        else if(table.equals("TREATMENT"))
        {
            delete = "delete from Treatment where treatmentID = " + id;
        }
        else
        {
            delete = "delete from Prescription where prescriptionID = " + id;
        }

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
     * Searches the database to get information about a particular Patient, including name DOB sex and location.
     */
    private String searchPatient()
    {
        String result = "";
        try 
        {
            //Depending on the information provided for the search, if it was by ssn or by name/DOB construct the query
            //Which one you do depends on whether or not info contains a tab character b/c ssn has no tab wheras the other one does
            String query = "";
            PreparedStatement ps = null;
            if(info.contains("\t"))
            {
                //System.out.println("Contains tab");
                String[] values = info.split("\t");
                String tmp = "select * from Patient where FName = ? and Minit = ? and Lname = ? and DOB = ?";
                ps = conn.prepareStatement(tmp);
                ps.setString(1, values[0]);
                ps.setString(2, values[1]);
                ps.setString(3, values[2]);
                ps.setDate(4, formatDate(values[3]));
            }
            else
            {
                query = "SELECT * FROM Patient WHERE Pssn = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, info);
            }

            ResultSet rs = ps.executeQuery();
            rs.next();

            String patientInfo = "Patient: " + rs.getString("Fname") + " " + rs.getString("Minit") + " " + rs.getString("Lname")
                + "\n" + "SSN: " + rs.getString("Pssn") + "  DOB: "+rs.getString("DOB")+ "  Age: " + rs.getString("age") +  "\nSex: " + rs.getString("sex") + " Location: " 
                + rs.getString("location") +   "\n";
            result = patientInfo;

            //The retrieve all existing patient records for the patient
            String rQuery = "select * from Record where patient = ?";
            PreparedStatement records = conn.prepareStatement(rQuery);
            records.setString(1, info);
            ResultSet recordSet = records.executeQuery();
            recordSet.next();

            String queryD = "SELECT Fname, Minit, Lname FROM Doctor WHERE Dssn = ?";
            PreparedStatement psD = conn.prepareStatement(queryD);

            while(!recordSet.isAfterLast())
            {
                //Get the name of the Dr that admitted/diagnosed the patient
                psD.setString(1, recordSet.getString("primary_doctor"));
                ResultSet d = psD.executeQuery();
                d.next();
                String docName = d.getString("Fname") + " " + d.getString("Minit") + " " + d.getString("Lname");

                String recordInfo = "Date Admitted: " + recordSet.getString("admittanceDate") + " Admitted by Dr. " + docName + "\nCondition: " + recordSet.getString("patient_diagnosis"); 
                String recordStatus = recordSet.getString("status");

                if(recordStatus.equals("0"))
                    recordInfo = recordInfo + " Record is: INACTIVE" +  "\n";
                else
                    recordInfo = recordInfo + " Record is: ACTIVE" +  "\n";

                result = result + recordInfo;
                recordSet.next();
            }

            rs.close();
            recordSet.close();
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Searches the database to get information about a particular Patient's scheduled procedures.
     */
    private String searchProcedure()
    {
        String result = "";
        try 
        {
            String query = "SELECT Fname, Minit, Lname FROM Patient WHERE Pssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();

            String pName = "PATIENT NAME: " + rs.getString("Lname") + ", " + rs.getString("Fname") + " " + rs.getString("Minit") + "\n";
            result = pName;
            rs.close();

            String pQuery = "select * from Procedure where Pssn = " + info;
            PreparedStatement psP = conn.prepareStatement(pQuery);
            ResultSet pro = psP.executeQuery();

            String queryD = "SELECT Fname, Minit, Lname FROM Doctor WHERE Dssn = ?";
            PreparedStatement psD = conn.prepareStatement(queryD);

            String queryN = "SELECT Fname, Minit, Lname FROM Nurse WHERE Nssn = ?";
            PreparedStatement psN = conn.prepareStatement(queryN);

            if(!pro.isBeforeFirst())
            {
                result = "No procedures reported for this patient";
            }
            else{
                pro.next();
                while(!pro.isAfterLast())
                {   
                    //Get the name of the Dr involved in the procedure
                    psD.setString(1, pro.getString("Dssn"));
                    ResultSet d = psD.executeQuery();
                    d.next();
                    String docName = d.getString("Fname") + " " + d.getString("Minit") + " " + d.getString("Lname");

                    //Get the name of the Nurse involved in the procedure
                    psN.setString(1, pro.getString("Nssn"));
                    ResultSet n = psN.executeQuery();
                    n.next();
                    String nurseName = n.getString("Fname") + " " + n.getString("Minit") + " " + n.getString("Lname");

                    String procedure = "Procedure ID: " + String.format("%05d", (pro.getInt("procedureID"))) + "  Procedure Type: " + pro.getString("procedureDescription") + "\n"
                        + " Date/Time: " + pro.getDate("scheduled_Date") + "  "+ pro.getInt("scheduled_Time") + ":00"+ "\n"
                        + "Supervising Doctor: " + docName + "  Assisting Nurse: " + nurseName + "\n\n";

                    result = result + procedure;

                    pro.next();
                    d.close();
                    n.close();
                }
            }
            pro.close();
        } 
        catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return result;
    }

    public String searchTreatment()
    {
        String result = "";

        try
        {
            //Get the name of the patient recieving the treatments
            String query = "SELECT * FROM Patient WHERE Pssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();

            String pName = "PATIENT NAME: " + rs.getString("Lname") + ", " + rs.getString("Fname") + " " + rs.getString("Minit") + "\n";
            result = pName;
            rs.close();

            String tQuery = "select * from Treatment where Pssn = " + info;
            PreparedStatement psT = conn.prepareStatement(tQuery);
            ResultSet trt = psT.executeQuery();

            String queryD = "SELECT Fname, Minit, Lname FROM Doctor WHERE Dssn = ?";
            PreparedStatement psD = conn.prepareStatement(queryD);

            String queryM = "select Mname from medication where MID = ?";
            PreparedStatement psM = conn.prepareStatement(queryM);

            if(!trt.isBeforeFirst())
            {
                result = "No treatments reported for this patient";
            }
            else{
                trt.next();
                while(!trt.isAfterLast())
                {   
                    //Get the name of the Dr ordering the treatment
                    psD.setString(1, trt.getString("Dssn"));
                    ResultSet d = psD.executeQuery();
                    d.next();
                    String docName = d.getString("Fname") + " " + d.getString("Minit") + " " + d.getString("Lname");

                    //Get the name of the medication used in the treatment
                    psM.setString(1, trt.getString("medication"));
                    ResultSet m = psM.executeQuery();
                    m.next();
                    String mName = m.getString("Mname");

                    String treatment = "Treatment ID: " + trt.getString("treatmentID") + "  Medication: " + mName + "\nDosage: " + trt.getString("dosage" ) + "  Method of Delivery: " + trt.getString("method_of_delivery") + 
                        "\n Start Date: " + trt.getString("start_date") + "  End Date: " + trt.getString("end_date") + "\nSupervising Doctor: " + docName + "\n\n";

                    result = result + treatment;

                    trt.next();
                    d.close();
                }
            }
            trt.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
            e.printStackTrace();
        }

        return result;
    }

    public String searchPrescription()
    {
        String result = "";

        try
        {
            //Get the name of the patient recieving the treatments
            String query = "SELECT * FROM Patient WHERE Pssn = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();
            rs.next();

            String pName = "PATIENT NAME: " + rs.getString("Lname") + ", " + rs.getString("Fname") + " " + rs.getString("Minit") + "\n";
            result = pName;
            rs.close();

            String pQuery = "select * from Prescription where Pssn = " + info;
            PreparedStatement psP = conn.prepareStatement(pQuery);
            ResultSet pre = psP.executeQuery();

            String queryD = "SELECT Fname, Minit, Lname FROM Doctor WHERE Dssn = ?";
            PreparedStatement psD = conn.prepareStatement(queryD);

            String queryM = "select Mname from medication where MID = ?";
            PreparedStatement psM = conn.prepareStatement(queryM);
            if(!pre.isBeforeFirst())
            {
                result = "No prescriptions reported for this patient";
            }
            else{
                pre.next();
                while(!pre.isAfterLast())
                {   
                    //Get the name of the Dr writing the prescription
                    psD.setString(1, pre.getString("Dssn"));
                    ResultSet d = psD.executeQuery();
                    d.next();
                    String docName = d.getString("Fname") + " " + d.getString("Minit") + " " + d.getString("Lname");

                    //Get the name of the medication ordered in the prescription
                    psM.setString(1, pre.getString("medication"));
                    ResultSet m = psM.executeQuery();
                    m.next();
                    String mName = m.getString("Mname");

                    String prescription = "Prescription ID: " + pre.getString("prescriptionID") + "  Medication: " + mName + "\nDosage: " + pre.getString("dosage") + "  Generic Okay? " + pre.getString("optional_generic") + 
                        "\n Date Prescribed: " + pre.getString("prescribed_date") + "  Number of Refills: " + pre.getString("num_refills") + "\nPrescribing Doctor: " + docName + "\n\n";

                    result = result + prescription;

                    pre.next();
                    d.close();
                }
            }
            pre.close();
        }
        catch(Exception e)
        {
            System.err.println(e);
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Searches the database to get information about a particular Patient.
     */
    public String search(String table)
    {
        String result = "";
        //Construct a select query using the appropriate key and table to search
        if(table.equals("TREATMENT"))   //Searching the TREATMENT table for information about a patient's treatments
        {
            result = searchTreatment();
        }
        else if(table.equals("PROCEDURE"))  //Searching the procedures table to get information about a patient's procedures 
        {                                   
            result = searchProcedure();
        }
        else if (table.equals("PATIENT"))   //Searching the patients table to get information about a patient, including the previous patient records of the patient
        {
            result = searchPatient();
        }
        else if (table.equals("PRESCRIPTION"))  //Searching the prescriptions table to get information about a patient's prescriptions
        {
            result = searchPrescription();
        }
        return result;
    }
}
