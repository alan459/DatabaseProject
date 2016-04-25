/** 
 * @author Sarah Lambert
 */

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Populate_Hospital {
    static final String URL = "jdbc:oracle:thin:@abacus1:1525:C325";
    static final String USR = "sl7dz";
    static final String PWD = "kookaburra";
    
    static String BuildingFilename = "data/Building.txt";
    static String RoomFilename = "data/Room.txt";
    static String PatientFilename = "data/Patient.txt";
    static String DepartmentFilename = "data/Department.txt";
    static String DoctorFilename = "data/Doctor.txt";
    static String RecordFilename = "data/Record.txt";
    static String NurseFilename = "data/Nurse.txt";
    static String ProcedureFilename = "data/Procedure.txt";
    static String MedicationFilename = "data/Medication.txt";
    static String TreatmentFilename = "data/Treatment.txt";
    static String PrescriptionFilename = "data/Prescription.txt";
    
    /**
     * Parse data from Buildings file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateBuildings(Connection conn)
    {
        try
        {
            File file = new File(BuildingFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Building (code,name) values (?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 2)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Buildings table.");} 
                    else 
                    { System.out.println("\n Successfully updated Buildings. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Rooms file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateRooms(Connection conn)
    {
        try
        {
            File file = new File(RoomFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Room (roomcode,building,roomtype,patient_capacity) values (?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 4)
                {
                    
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setInt(4,Integer.parseInt(values[3]));
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Rooms table.");} 
                    else 
                    { System.out.println("\n Successfully updated Rooms. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Convert from String to Date object
     * @param String    date as String
     * @return Date     date as Date object
     */
    private static Date formatDate(String string)
    {
        String[] components = string.split("-");
        
        int yy = Integer.parseInt(components[0].substring(2));
        int mm = Integer.parseInt(components[1]);
        int dd = Integer.parseInt(components[2]);
        
        Date date = new Date((yy+100),mm,dd);
        return date;
    }
    
    /**
     * Parse data from Patients file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populatePatients(Connection conn)
    {
        try
        {
            File file = new File(PatientFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Patient (Pssn,Fname,Minit,Lname,DOB,age,sex) values (?,?,?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 8)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setString(4,values[3]);
                    pstmt.setDate(5,formatDate(values[4]));
                    pstmt.setInt(6,Integer.parseInt(values[5]));
                    pstmt.setString(7,values[6]);
                    
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Patients table.");} 
                    else 
                    { System.out.println("\n Successfully updated Patients. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Departments file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateDepartments(Connection conn)
    {
        try
        {
            File file = new File(DepartmentFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Department (Dno,Dname,Dbuilding) values (?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 3)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Departments table.");} 
                    else 
                    { System.out.println("\n Successfully updated Departments. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Doctors file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateDoctors(Connection conn)
    {
        try
        {
            File file = new File(DoctorFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Doctor (Dssn,Fname,Minit,Lname,Dcode) values (?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 5)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setString(4,values[3]);
                    pstmt.setString(5,values[4]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Doctors table.");} 
                    else 
                    { System.out.println("\n Successfully updated Doctors. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Records file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateRecords(Connection conn)
    {
        try
        {
            File file = new File(RecordFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Record (recordID,patient,admittanceDate,primary_doctor,patient_diagnosis,status) values (?,?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 6)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setDate(3,formatDate(values[2]));
                    pstmt.setString(4,values[3]);
                    pstmt.setString(5,values[4]);
                    pstmt.setInt(6,Integer.parseInt(values[5]));
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Records table.");} 
                    else 
                    { System.out.println("\n Successfully updated Records. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Nurses file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateNurses(Connection conn)
    {
        try
        {
            File file = new File(NurseFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Nurse (Nssn,Fname,Minit,Lname,supervisor) values (?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 5)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setString(4,values[3]);
                    pstmt.setString(5,values[4]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Nurses table.");} 
                    else 
                    { System.out.println("\n Successfully updated Nurses. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Procedures file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateProcedures(Connection conn)
    {
        try
        {
            File file = new File(ProcedureFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Procedure (procedureID,procedureDescription,scheduled_Time,scheduled_Date,Pssn,Dssn,Nssn) values (?,?,?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 7)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setInt(3,Integer.parseInt(values[2]));
                    pstmt.setDate(4,formatDate(values[3]));
                    pstmt.setString(5,values[4]);
                    pstmt.setString(6,values[5]);
                    pstmt.setString(7,values[6]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Procedures table.");} 
                    else 
                    { System.out.println("\n Successfully updated Procedures. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Medications file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateMedications(Connection conn)
    {
        try
        {
            File file = new File(MedicationFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Medication (Mid,Mname,use) values (?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 3)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Medications table.");} 
                    else 
                    { System.out.println("\n Successfully updated Medications. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Treatments file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populateTreatments(Connection conn)
    {
        try
        {
            File file = new File(TreatmentFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Treatment (treatmentID,Pssn,Dssn,start_date,end_date,medication,dosage,method_of_delivery) values (?,?,?,?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 8)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setDate(4,formatDate(values[3]));
                    pstmt.setDate(5,formatDate(values[4]));
                    pstmt.setString(6,values[5]);
                    pstmt.setString(7,values[6]);
                    pstmt.setString(8,values[7]);
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Treatments table.");} 
                    else 
                    { System.out.println("\n Successfully updated Treatments. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Parse data from Prescriptions file, insert data into table
     * @param conn is the Connection to the DB
     */
    public static void populatePrescriptions(Connection conn)
    {
        try
        {
            File file = new File(PrescriptionFilename);
            Scanner sc = new Scanner(file);
            sc.useDelimiter("/t");
            String Template = "insert into Prescription (prescriptionID,Pssn,Dssn,prescribed_date,medication,dosage,optional_generic,num_refills) values (?,?,?,?,?,?,?,?)";
            
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if(values.length == 8)
                {
                    PreparedStatement pstmt = conn.prepareStatement(Template);
                    pstmt.setString(1,values[0]);
                    pstmt.setString(2,values[1]);
                    pstmt.setString(3,values[2]);
                    pstmt.setDate(4,formatDate(values[3]));
                    pstmt.setString(5,values[4]);
                    pstmt.setString(6,values[5]);
                    pstmt.setString(7,values[6]);
                    pstmt.setInt(8,Integer.parseInt(values[7]));
           
                    int affectedRows = pstmt.executeUpdate();
                    if(affectedRows == 0)
                    { System.err.println("Failed to insert to Prescriptions table.");} 
                    else 
                    { System.out.println("\n Successfully updated Prescriptions. \n");}
                pstmt.close();
                }
            }
            sc.close();
        }
        catch (FileNotFoundException o)
        {
            System.err.println(o);
            o.printStackTrace();
        }
        catch (SQLException e) 
        {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String [] args){
        System.out.println(new java.util.Date());
        try {
            // Register driver by finding the class that corresponds do it.
            String driverName="oracle.jdbc.OracleDriver";
            Class.forName(driverName);
            
            // Create a connection to the DBMS
            Connection conn = DriverManager.getConnection(URL, USR, PWD);
            // If no exception, then we connected successfully
            System.out.println("Connected to C325.");
            
            populateBuildings(conn);
            populatePatients(conn);
            populateDoctors(conn);
            populateMedications(conn);
            populateRooms(conn);
            populateDepartments(conn);
            populateRecords(conn);
            populateNurses(conn);
            populateProcedures(conn);
            populateTreatments(conn);
            populatePrescriptions(conn);

            conn.close();
            
        } catch (ClassNotFoundException c){
            System.err.println("Couldn't find the driver, check CLASSPATH " +
                    "or Netbeans project preferences.");
            System.err.println(c);
        } catch (SQLException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
}
