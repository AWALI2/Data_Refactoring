import java.util.Scanner;
public class Date{

private String month;
private int day;
private int year; //a four digit number.
public Date( )
{
    month = "January";
    day = 1;
    year = 1000;
}
public Date(int monthInt, int day, int year)
{
    setDate(monthInt, day, year);
}
public Date(String monthString, int day, int year)
{
    setDate(monthString, day, year);
}
public Date(int year)
{
    setDate(1, 1, year);
}
public Date(Date aDate)
{
    if (aDate == null)//Not a real date.
    {
        System.out.println("Fatal Error.");
        System.exit(0);
    }
    month = aDate.month;
    day = aDate.day;
    year = aDate.year;
}
public void setDate(int monthInt, int day, int year)
{
    if (dateOK(monthInt, day, year))
    {
        this.month = monthString(monthInt);
        this.day = day;
        this.year = year;
    }
    else
    {
        System.out.println("Fatal Error");
        System.exit(0);
    }
}
public void setDate(String monthString, int day, int year)
{
    if (dateOK(monthString, day, year))
    {
        this.month = monthString;
        this.day = day;
        this.year = year;
    }
    else
    {
        System.out.println("Fatal Error");
        System.exit(0);
    }
}
public void setDate(int year)
{
    setDate(1, 1, year);
}
public void setYear(int year)
{
    if ( (year < 1000) || (year > 9999) )
    {
        System.out.println("Fatal Error");
        System.exit(0);
    }
    else
        this.year = year;
}
public void setMonth(int monthNumber)
{
    if ((monthNumber <= 0) || (monthNumber > 12))
    {
        System.out.println("Fatal Error");
        System.exit(0);
    }
    else
        month = monthString(monthNumber);
}
public void setDay(int day)
{
    if ((day <= 0) || (day > 31))
    {
        System.out.println("Fatal Error");
        System.exit(0);
    }
    else
        this.day = day;
}
public int getMonth( )
{
    if (month.equals("January") || month.equals("Jan"))
        return 1;
    else if (month.equals("February")|| month.equals("Feb"))
        return 2;
    else if (month.equalsIgnoreCase("March")|| month.equalsIgnoreCase("Mar"))
        return 3;
    else if (month.equalsIgnoreCase("April")|| month.equalsIgnoreCase("Apr"))
        return 4;
    else if (month.equalsIgnoreCase("May"))
        return 5;
    else if (month.equals("June")|| month.equalsIgnoreCase("Jun"))
        return 6;
    else if (month.equalsIgnoreCase("July")|| month.equalsIgnoreCase("Jul"))
        return 7;
    else if (month.equalsIgnoreCase("August")|| month.equalsIgnoreCase("Aug"))
        return 8;
    else if (month.equalsIgnoreCase("September")|| month.equalsIgnoreCase("Sep"))
        return 9;
    else if (month.equalsIgnoreCase("October")|| month.equalsIgnoreCase("Oct"))
        return 10;
    else if (month.equals("November")|| month.equalsIgnoreCase("Nov"))
        return 11;
    else if (month.equals("December")|| month.equalsIgnoreCase("Dec"))
        return 12;
    else
    {
        System.out.println("Fatal Error");
        System.exit(0);
        return 0; //Needed to keep the compiler happy
    }
}
public int getDay( )
{
    return day;
}
public int getYear( )
{
    return year;
}
public String toString( )
{
    return (month + " " + day + ", " + year);
}
public boolean equals(Date otherDate)
{
    return ( (month.equals(otherDate.month))
            && (day == otherDate.day) && (year == otherDate.year) );
}
public boolean precedes(Date otherDate)
{
    return ( (year < otherDate.year) ||
            (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
            (year == otherDate.year && month.equals(otherDate.month)
                    && day < otherDate.day) );
}
public void readInput( )
{
    boolean tryAgain = true;
    Scanner keyboard = new Scanner(System.in);
    while (tryAgain)
    {
        System.out.println("Enter month, day, and year.");
        System.out.println("Do not use a comma.");
        String monthInput = keyboard.next( );
        int dayInput = keyboard.nextInt( );
        int yearInput = keyboard.nextInt( );
        if (dateOK(monthInput, dayInput, yearInput) )
        {
            setDate(monthInput, dayInput, yearInput);
            tryAgain = false;
        }
        else
            System.out.println("Illegal date. Reenter input.");
    }
}
private boolean dateOK(int monthInt, int dayInt, int yearInt)
{
    return ( (monthInt >= 1) && (monthInt <= 12) &&
            (dayInt >= 1) && (dayInt <= 31) &&
            (yearInt >= 1000) && (yearInt <= 9999) );
}
private boolean dateOK(String monthString, int dayInt, int yearInt)
{
    return ( monthOK(monthString) &&
            (dayInt >= 1) && (dayInt <= 31) &&
            (yearInt >= 1000) && (yearInt <= 9999) );
}
private boolean monthOK(String month)
{
    return (month.equals("January") || month.equals("February") ||
            month.equals("March") || month.equals("April") ||
            month.equals("May") || month.equals("June") ||
            month.equals("July") || month.equals("August") ||
            month.equals("September") || month.equals("October") ||
            month.equals("November") || month.equals("December") );
}
private String monthString(int monthNumber)
{
	String a;
    switch (monthNumber)
    {
        case 1:
        	a= "Jan";
        case 2:
            a= "Feb";
        case 3:
            a= "Mar";
        case 4:
            a= "Apr";
        case 5:
            a= "May";
        case 6:
            a= "Jun";
        case 7:
            a= "Jul";
        case 8:
            a= "August";
        case 9:
            a= "September";
        case 10:
            a= "October";
        case 11:
            a= "November";
        case 12:
            a= "December";
        default:
            System.out.println("Fatal Error");
            System.exit(0);
            a= "Error"; //to keep the compiler happy
            
            return a;
    }
}

public static void main(String[] args) {
    Date date = new Date();
    date.setDate("January",30,2021);
    System.out.println("date.getDay() = " + date.getDay());
    System.out.println("date.getMonth() = " + date.getMonth());
    System.out.println("date.getYear() = " + date.getYear());
    System.out.println("date.toString() = " + date.toString());

    date.readInput();

    System.out.println("date.toString() = " + date.toString());

    System.out.println("date.getDay() = " + date.getDay());
    System.out.println("date.getMonth() = " + date.getMonth());
    System.out.println("date.getYear() = " + date.getYear());

}
}