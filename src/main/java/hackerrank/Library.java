package hackerrank;
// Given the expected and actual return dates for a library book, create a program that calculates
// the fine (if any). If the book is returned on or before the expected return date, no fine
// will be charged. Charges as follows.. Charges are based only on the least precise measure of
// lateness. For example, whether a book is due January 1, 2017 or December 31, 2017,
// if it is returned January 1, 2018, that is a year late.
public class Library {

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int fine = 0;
        if (y1 > y2) {
            fine = 10_000;
        } else if (m1 > m2 && y1 == y2) {                  //but no fine if earlier
            fine = (m1 - m2) * 500;
        } else if (d1 > d2 && m1 == m2 && y1 == y2) {      //but no fine if earlier
            fine = (d1 - d2) * 15;
        }
        return fine;
    }

}
