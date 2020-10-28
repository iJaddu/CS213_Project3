package sample;

/**
 Date class to provide functionality for storing and retrieving the date of an account, useful for the printing and sorting of the account database.
 Methods include compareTo which compares the Date object to another Date object (useful for sorting), toString to print the date in a more clear manner,
 and isValid to see if the Date given is a valid date (32 days, 13th month, etc. would be invalid dates)
 @author Tanuj Desai, Nicholas Makar
 */



public class Date implements Comparable<Date>{

    private int year;
    private int month;
    private int day;



    public Date(int year, int month, int day) {

        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    /**
     Compares given date to the current date by converting
     dates to strings, then uses string.compareTo
     @return o:Objects Match, -1:Objects do not match(Obj smaller), 1:Objects do not match(obj bigger)
     */
    public int compareTo(Date date) { // return 0,1, or -1

        int return_value;
        return_value = this.toString().compareTo(date.toString());

        return return_value;
    }

    @Override
    /**
     Converts Date object to string type
     @return date as a string in format mm/dd/yyyy
     */
    public String toString() {  // in format mm/dd/yyyy

        return (month + "/" + day + "/" + year);
    }

    /**
     Checks to see if the given date is valid by checking if
     @return returns true if day, month, and year values are in the valid ranges, false otherwise
     */
    public boolean isValid() {

        if(month < 0 || month > 12) { // General check for valid months (1-12)
            return false;
        }

        if(day < 0 || day > 31) { // General check for valid days (1 - 31)
            return false;
        }

        if(year < 1000 || year > 10000 ) {   //check for 4 digits to match format (mm/dd/yyyy)
            return false;
        }

        if(month == 2) {   // February: 28 days
            if(day < 0 || day > 28) {
                return false;
            }
        }

        if(month == 4 || month == 6 || month == 9 || month == 10) { //April, June, September, November: 30 days
            if(day < 0 || day > 30) {
                return false;
            }
        }

        return true;
    }
}
