package hackerrank;

public class ProgrammerDay {

    public static String dayOfProgrammer(int year) {
        String simplePrefix = "13.09.";
        String leapYearPrefix = "12.09.";
        if (1918 < year) {              //Gregorian
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                return leapYearPrefix + year;
            } else {
                return simplePrefix + year;
            }
        } else if (year < 1918) {       //Julian
            if (year % 4 == 0) {
                return leapYearPrefix + year;
            } else {
                return simplePrefix + year;
            }
        } else {                         //in 1918
            return "26.09.1918";
        }
    }

}
