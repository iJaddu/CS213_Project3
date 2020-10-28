package sample;

/**
 Profile class creates an object to store in the Account class, stores a first name and last name.
 @author Tanuj Desai, Nicholas Makar
 */



public class Profile {

    private String fname;
    private String lname;

    /**
     Default Profile Constructor: creates a new Profile with default values for fname & lname
     */
    public Profile() {
        this.fname = null;
        this.lname = null;
    }

    /**
     Profile Constructor: creates a new Profile with given values for fname & lname
     @param fname first name of account holder
     @param lname last name of account holder
     */
    public Profile(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    /**
     Getters/Setter Methods
     */

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

