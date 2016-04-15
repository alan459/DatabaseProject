# DatabaseProject

Need to layout a mechanism for which the GUI sends a patient ssn to the backend and gets the data to display.

LIZ'S STUFF:

This is just an example for one class, Nurse. In the DataRecord abstract class there is an instance variable info which is a string that holds information that the Nurse instance will use for its query (so it could hold ssn, name info, etc.).

In the GUI, a user either puts in information and presses a search button, or puts in information, selects an option from a drop down menu and pushes a search button. When the search button in pressed, a new instance of the Nurse class is created with the information that the user put in the search field assigned to its instance variable info. Then, depending on what information the user wants back, a string is passed to the search method which is called on the instance that was just created (see below).

1. User puts in Nurse SSN and pushes search to get Nurse's name and Nurse's supervisor's name information
2. A new instance of Nurse is created using Nurse n = new Nurse(whatever information was in the GUI field)
3. The search method is called on Nurse with the String "NURSE" since you're searching the NURSE table in the database for information: n.search("NURSE")
4. The search method will return a string containing the information requested that the GUI can then just print, the string will be properly formatted to immediately printed.
