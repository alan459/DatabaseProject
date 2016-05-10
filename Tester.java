import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    /*public boolean validSSN(String ssn)
    {
        String regex = "\\d+";
        return ssn.matches(regex);
    }*/
    
    
    public static void main(String[]args)
    { 
        DataRecord.setUpConnection();
        
        Nurse n1 = new Nurse("184356380");
        
        String nurseInfo = n1.search("NURSE");
        System.out.println(nurseInfo); 
        
        String procedureInfo = n1.search("PROCEDURE");
        System.out.println(procedureInfo);
        
        n1.update("Mary\tA\tPol");
        nurseInfo = n1.search("NURSE");
        System.out.println(nurseInfo);
        
        Nurse.insert("789000789\tMary\tG\tPollard\t456000200");
        
        Nurse n2 = new Nurse("789000789");
        nurseInfo = n2.search("NURSE");
        System.out.println(nurseInfo);
        
        n2.delete("789000789");
        

        // following should lead to an error!!!
        //nurseInfo = n2.search("NURSE");
        //System.out.println(nurseInfo);
        
        //System.out.println("----------------- DOCTOR TESTING -----------------");
        
        Doctor d1 = new Doctor("456000206");
        String docInfo = d1.search("DOCTOR");
        System.out.println(docInfo); 
        
        String procedureInfo2 = d1.search("PROCEDURE");
        System.out.println(procedureInfo2);
        
        d1.update("Susannah\tK\tMillerson\t4");
        docInfo = d1.search("DOCTOR");
        System.out.println(docInfo);
        
        Doctor.insert("456000300\tSarah\tG\tLambert\t5");
        
        Doctor d2 = new Doctor("456000300");
        docInfo = d2.search("DOCTOR");
        System.out.println(docInfo);  
        
        d2.delete("456000300");
        
        System.out.println("----------------------PATIENT TESTING----------------");
        
        Patient p1 = new Patient("123000141");
        String p1Info = p1.search("PATIENT");
        System.out.println(p1Info);
        
        Patient p2 = new Patient("John\tP\tSmith\t2000-01-01");
        String p2Info = p2.search("PATIENT");
        System.out.println(p2Info);
        
        String p1T = p1.search("TREATMENT");
        System.out.println(p1T);
        
        String p1P = p1.search("PROCEDURE");
        System.out.println(p1P);
        
        String p1Pr = p1.search("PRESCRIPTION");
        System.out.println(p1Pr);
        
        Patient.insert("123000399\tLiz\tG\tGonye\t2001-03-19\t15\tF\tC299");
        Patient.insert("111111111	Franci	C	Cuerva	1993-10-31	22	M	C299");
        
        System.out.println("TESTING PRESCRIPTION INSERT");
        
        String prescription = "123000399\t456000206\t2015-09-08\t008\t50 mg\tY\t1";
        Doctor.insertPPT("PRESCRIPTION", prescription);
        
        String procedure = "check vitals\t8\t2015-09-07\t123000399\t456000206\t184356380";
        Doctor.insertPPT("PROCEDURE", procedure);
        
        String treatment = "123000399\t456000206\t2015-09-08\t2015-09-10\t015\t100 mg\toral";
        Doctor.insertPPT("TREATMENT", treatment);
        
        Patient p = new Patient("123000399");
        String pPre = p.search("PRESCRIPTION");
        System.out.println(pPre);
        
        String pPro = p.search("PROCEDURE");
        System.out.println(pPro);
        
        String pTrt = p.search("TREATMENT");
        System.out.println(pTrt);
        
        Patient.delete("10008", "TREATMENT");
        
        String pTrt2 = p.search("TREATMENT");
        System.out.println(pTrt2);
        
    }
}
