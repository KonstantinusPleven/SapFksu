/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapfksu;

import java.util.Scanner;

/**
 *
 * @author v
 */
public class Date {

    private final Scanner scan = new Scanner(System.in);
    private final Validate val = new Validate();

    private int Day;
    private int Month;
    private int Year;
    private int[] time;

    public Date() {
        this.Month = setMonthC();
        this.Day = setDayC(this.Month);
        this.Year = setYearC();
        this.time = setHourC();
    }  
    public Date(int[] date){
        int[] HM = new int[2];
        HM[0] = date [0];
        HM[1] = date [1];
        
        this.time=HM;
        this.Day = date[2];
        this.Month = date [3];
        this.Year = date[4];
    }
    public void setDay(int Day) {
        this.Day = setDayC(this.Month);
    }
    public void setMonth(int Month) {
        this.Month = setMonthC();
    }
    public void setYear(int Year) {
        this.Year = setYearC();
    }
    public void setTime(int[] time) {
        this.time = setHourC();
    }
    public int getDay() {
        return Day;
    }
    public int getMonth() {
        return Month;
    }
    public int getYear() {
        return Year;
    }
    public int[] getTime() {
        return time;
    }
    public String getTimeStr(){
        String str = time[0]+":"+time[1];
        return str;
    }
    @Override
    public int hashCode() {
        int hash = 291;
        hash = hash + this.Day * 24;
        hash = hash + this.Month * 31 * 24;
        hash = hash + this.Year*365;
        hash = hash + this.time[0];
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()) {
            Date d = (Date) obj;
            if (this.Day == d.getDay()) {
                if (this.Month == d.getMonth()) {
                    if (this.time == d.getTime()) {
                        return true;
                    }
                }
            }

        }
        return false;
    }  
    private int setYearC() {
        int year = 0;
        String current;

        System.out.print("Enter the year for your event:");
        do {
            try {
                current = scan.nextLine();
                year = Integer.parseInt(current);
            } catch (Exception ex) {
                System.out.printf("Something went wrong!Try again:");
                year = 0;
            }
        } while (year == 0);
        return year;
    }
    private int setMonthC() {
        int month = 0;
        String current;

        System.out.print("Enter the month for your event (from 1 to 12):");
        do {
            try {
                current = scan.nextLine();
                month = Integer.parseInt(current);
                val.monthValidate(month);

            } catch (MonthException ex) {
                System.out.print(ex.getMessage());
                month = 0;
            } catch (Exception ex) {
                System.out.printf("Something went wrong!Try again:");
                month = 0;
            }
        } while (month == 0);
        return month;

    }
    private int setDayC(int month) {
        int day = 0;
        String current;

        System.out.print("Enter the day for your event(from 1 to 31):");
        do {
            try {
                current = scan.nextLine();
                day = Integer.parseInt(current);
                val.dayValidate(month, day);

            } catch (DaysException ex) {
                System.out.print(ex.getMessage());
                day = 0;

            } catch (MonthException ex) {
                System.out.print(ex.getMessage());
                day = 0;
            } catch (Exception ex) {
                System.out.printf("Something went wrong!Try again:");
                day = 0;
            }
        } while (day == 0);
        return day;
    }
    private int[] setHourC() {
        int hour[] = {-1, -1};
        String current;

        System.out.print("Enter hour(from 0 to 23):");
        do {
            try {
                current = scan.nextLine();
                hour[0] = Integer.parseInt(current);
                val.timeValidateHour(hour[0]);

            } catch (TimeException ex) {
                System.out.print(ex.getMessage());
                hour[0] = -1;
            } catch (Exception ex) {
                System.out.printf("Something went wrong!Try again:");
                hour[0] = 0;
            }
        } while (hour[0] == -1);

        System.out.print("Enter mins(from 0 to 59):");
        do {
            try {
                current = scan.nextLine();
                hour[1] = Integer.parseInt(current);
                val.timeValidateMin(hour[1]);

            } catch (TimeException ex) {
                System.out.print(ex.getMessage());
                hour[0] = -1;
            } catch (Exception ex) {
                System.out.printf("Something went wrong!Try again:");
                hour[1] = 0;
            }
        } while (hour[1] == -1);
        return hour;
    }
}
