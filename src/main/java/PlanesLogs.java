import java.text.SimpleDateFormat;

/**
 * Created by asus on 24.05.2015.
 */
public class PlanesLogs {

    private String year;
    private String quarter;
    private String month;
    private String dayOfMonth;
    private String dayOfWeek;
    private String flDate;
    private String origin;
    private String dest;


    // Constructor
    public PlanesLogs(String year, String quarter, String month, String dayOfMonth, String dayOfWeek, String flDate, String origin, String dest) {

        if (year == null) {
            throw new IllegalArgumentException("year = null");
        }
        this.year = year;

        if (quarter == null) {
            throw new IllegalArgumentException("quarter = null");
        }
        this.quarter = quarter;

        if (month == null) {
            throw new IllegalArgumentException("month = null");
        }
        this.month = month;

        if (dayOfMonth == null) {
            throw new IllegalArgumentException("dayOfMonth = null");
        }
        this.dayOfMonth = dayOfMonth;

        if (dayOfWeek == null) {
            throw new IllegalArgumentException("dayOfWeek = null");
        }
        this.dayOfWeek = dayOfWeek;

        if (flDate == null) {
            throw new IllegalArgumentException("flDate = null");
        }
        this.flDate = flDate;

        if (origin == null) {
            throw new IllegalArgumentException("origin = null");
        }
        this.origin = origin;

        if (dest == null) {
            throw new IllegalArgumentException("dest = null");
        }
        this.dest = dest;
    }

    public String getQuarter() {
        return quarter;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDest() {
        return dest;
    }

    public String getFlDate() {
        return flDate;
    }

    @Override
    public String toString() {
        return "\nPlanesLogs{year=" + year +
                ", quarter=" + quarter +
                ", month=" + month +
                ", dayOfMonth=" + dayOfMonth +
                ", dayOfWeek=" + dayOfWeek +
                ", flDate=" + flDate +
                ", origin=" + origin +
                ", dest=" + dest +
                "}";
    }
}
