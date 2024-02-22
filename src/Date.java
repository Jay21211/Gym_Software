import java.util.Calendar;
/*
This class allows a user to create a date object.
It has various methods to check if it is a valid date or not including leap years
It has a testbed main at the very bottom.
@author Thuyen Doan
*/
public class Date implements Comparable<Date> {
    private final int year;
    private final int month;
    private final int day;

    // Constants for leap year calculation
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;


    /**
     * Constructs a Date object with the specified year, month, and day.
     * @param year the year of the date.
     * @param month the month of the date.
     * @param day the day of the date.
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getter for year
    public int getYear() {

        return year;
    }

    // Getter for month
    public int getMonth() {

        return month;
    }

    // Getter for day
    public int getDay() {

        return day;
    }

    public static Date calculateExpiration(String command){
        Calendar current = Calendar.getInstance();
        int year = current.get(Calendar.YEAR);
        int month = current.get(Calendar.MONTH);
        int day = current.get(Calendar.DAY_OF_MONTH);

        if(command.equals("AB")){
            current.add(Calendar.MONTH, 1);
            // Ensure that the day of the month doesn't exceed the last day of the month
            int lastDay = current.getActualMaximum(Calendar.DAY_OF_MONTH);
            current.set(Calendar.DAY_OF_MONTH, Math.min(current.get(Calendar.DAY_OF_MONTH), lastDay));
            return new Date(year,month,day);
        }
        if(command.equals("AF")){
            current.add(Calendar.MONTH, 3);
            // Ensure that the day of the month doesn't exceed the last day of the month
            int lastDay = current.getActualMaximum(Calendar.DAY_OF_MONTH);
            current.set(Calendar.DAY_OF_MONTH, Math.min(current.get(Calendar.DAY_OF_MONTH), lastDay));
            return new Date(year,month,day);
        }
        if(command.equals("AP")){
            current.add(Calendar.YEAR, 1);
            // Ensure that the day of the month doesn't exceed the last day of the month
            int lastDay = current.getActualMaximum(Calendar.DAY_OF_MONTH);
            current.set(Calendar.DAY_OF_MONTH, Math.min(current.get(Calendar.DAY_OF_MONTH), lastDay));
            return new Date(year,month,day);
        }
        return null;
    }

    /**
     * Checks if the date is a valid calendar date.
     * @return true if the date is valid, false otherwise.
     */
    public boolean isValid() {
        // Check if the month is valid

        if (month < 1 || month > 12) {
            return false;
        }

        // Check if the day is valid for the given month
        if (day < 1 || day > daysInMonth(year, month)) {
            return false;
        }

        if(year < 1900){
            return false;
        }

        // Check if the year is in the future
        Calendar current = Calendar.getInstance();
        if (year > current.get(Calendar.YEAR)) {
            return false;
        } else if (year == current.get(Calendar.YEAR)) {
            // If the year is the same as the current year, check the month
            if (month > current.get(Calendar.MONTH) + 1) {
                return false;
            } else if (month == current.get(Calendar.MONTH) + 1) {
                // If the month is the same as the current month, check the day
                if (day > current.get(Calendar.DAY_OF_MONTH)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Helper method to determine the number of days in a month.
     *
     * @param year  the year for which to determine the number of days.
     * @param month the month for which to determine the number of days.
     * @return the number of days in the specified month.
     * @throws IllegalArgumentException if the month value is not within the range [Calendar.JANUARY, Calendar.DECEMBER].
     */
    private int daysInMonth(int year, int month) {

        switch (month -1) {
            case Calendar.FEBRUARY:
                return isLeapYear(year) ? 29 : 28;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                return 30;
            case Calendar.JANUARY:
            case Calendar.MARCH:
            case Calendar.MAY:
            case Calendar.JULY:
            case Calendar.AUGUST :
            case Calendar.OCTOBER :
            case Calendar.DECEMBER :
                return 31;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    /**
     * Helper method to check if the given year is a leap year.
     *
     * @param year the year to check for leap year status.
     * @return {@code true} if the year is a leap year, {@code false} otherwise.
     */
    private boolean isLeapYear(int year) {
        if (year % QUADRENNIAL == 0) {
            if (year % CENTENNIAL == 0) {
                return year % QUATERCENTENNIAL == 0;
            }
            return true;
        }
        return false;
    }

    /**
     * Compares this Date object with another Date object.
     * @param other the Date object to be compared.
     * @return a negative integer, zero, or a positive integer as this Date object is before, equal to, or after the specified Date object.
     */

    //Integer.compare returns 0 if (x==y), if (x<y) <0, if (x>y)>0
    @Override
    public int compareTo(Date other) {
        if (year != other.year) {
            return Integer.compare(year, other.year);
        } else if (month != other.month) {
            return Integer.compare(month, other.month);
        } else {
            return Integer.compare(day, other.day);
        }
    }

    /**
     * Returns a string representation of the date in the format: month/day/year.
     * @return a string representation of the date.
     */
    @Override
    public String toString(){

        return month + "/" + day + "/" + year;
    }


    /**
     * Testbed main method to test the isValid() method.
     * @param args the command line arguments (not used).
     */
    public static void main(String[] args) {
        Date date1 = new Date(2024, 2, 9);
        Date date2 = new Date(2024, 2, 29);
        Date date3 = new Date(2023, 2, 29);
        Date date4 = new Date(2024, 4, 31);
        Date date5 = new Date(2022, 13, 1);
        Date date6 = new Date(1899, 10, 3);
        Date date7 = new Date(2020, 2, 29);

        System.out.println("Date 1 is valid: " + date1.isValid()); // Should be true
        System.out.println("Date 2 is valid: " + date2.isValid()); // Should be false 2/29 hasn't happened yet
        System.out.println("Date 3 is valid: " + date3.isValid()); // Should be false (2023 is not a leap year)
        System.out.println("Date 4 is valid: " + date4.isValid()); // Should be false (April doesn't have 31 days)
        System.out.println("Date 5 is valid: " + date5.isValid()); // Should be false (Invalid month)
        System.out.println("Date 6 is valid: " + date6.isValid()); // Should be false instructions say to do past 1900 as false
        System.out.println("Date 7 is valid: " + date7.isValid()); // Should be true
    }
}