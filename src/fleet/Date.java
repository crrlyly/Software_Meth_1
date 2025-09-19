package fleet;
import java.util.StringTokenizer;

/**
 * A simple Date class that represents a calendar date in mm/dd/yyyy format.
 * Provides validation, string conversion, equality, and comparison methods.
 *
 * @author Alec Cotler
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public static final int Quadrennial = 4;
    public static final int Centennial = 100;
    public static final int Quatercentennial = 400;

    public static final int monthsInYear = 12;
    public static final int minimumMonth = 1;
    public static final int minimumDay = 1;
    public static final int daysInJanuary = 31;
    public static final int daysInFebruaryNonLeap = 28;
    public static final int daysInFebruaryLeap = 29;
    public static final int daysInMarch = 31;
    public static final int daysInApril = 30;
    public static final int daysInMay = 31;
    public static final int daysInJune = 30;
    public static final int daysInJuly = 31;
    public static final int daysInAugust = 31;
    public static final int daysInSeptember = 30;
    public static final int daysInOctober = 31;
    public static final int daysInNovember = 30;
    public static final int daysInDecember = 31;


    // Constructor: parses a date string in "mm/dd/yyyy" format
    /**
     *
     * @param dateStr
     */
    public Date(String dateStr) {
        StringTokenizer st = new StringTokenizer(dateStr, "/");
        this.month = Integer.parseInt(st.nextToken());
        this.day = Integer.parseInt(st.nextToken());
        this.year = Integer.parseInt(st.nextToken());
    }

    // Checks if the date is a valid calendar date, including leap year logic
        public boolean isValid() {
            if (year <= 0) {
                return false; // optional: disallow year 0 or negatives
            }

            // Months: must be 1–12
            if (month < minimumMonth || month > monthsInYear) {
                return false;
            }

            // Validate day
            if (day < minimumDay) {
                return false;
            }
            int maxDays;
            switch (month) {
                case 1:  maxDays = daysInJanuary; break;
                case 2:  maxDays = isLeap() ? daysInFebruaryLeap : daysInFebruaryNonLeap; break;
                case 3:  maxDays = daysInMarch; break;
                case 4:  maxDays = daysInApril; break;
                case 5:  maxDays = daysInMay; break;
                case 6:  maxDays = daysInJune; break;
                case 7:  maxDays = daysInJuly; break;
                case 8:  maxDays = daysInAugust; break;
                case 9:  maxDays = daysInSeptember; break;
                case 10: maxDays = daysInOctober; break;
                case 11: maxDays = daysInNovember; break;
                case 12: maxDays = daysInDecember; break;
                default: return false;
            }

            return day <= maxDays;
        }

//Checks if a year is a leap year
    public boolean isLeap() {
        if (this.year % Quadrennial == 0) {
            if (this.year % Centennial == 0) {
                if (this.year % Quatercentennial == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date other = (Date) obj;
        return month == other.month && day == other.day && year == other.year;
    }

    @Override
    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    @Override
    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to null Date");
        }
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        }
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        }
        return Integer.compare(this.day, other.day);
    }
}
