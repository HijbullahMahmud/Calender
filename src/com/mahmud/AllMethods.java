package com.mahmud;

import java.util.Scanner;

public class AllMethods {

    public static void printCalender(){
        // promt user to enter year and month
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year (ex: 2019): ");
        int year = scanner.nextInt();
        System.out.println("Enter the month number (ex: 3): ");
        int month = scanner.nextInt();

        printMonth(month, year);

        printMonthBody(month, year);

    }

    private static void printMonth(int month, int year) {

        //print the heading of the Calender
        System.out.println("          " + getMonthName(month) + " " +year);
        System.out.println("------------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    private static String getMonthName(int month) {
        String monthName = "";
        switch (month){
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";

        }

        return monthName;
    }

    private static void printMonthBody(int month, int year){
        //get start day of the week for the first date in the month
        int startDay = getStartDay(month, year);

        //get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(month, year);

        //pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++){
            System.out.print("    ");
        }

        for (i = 1; i <= numberOfDaysInMonth; i++){
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    //get the start day of month/1/year
    private static int getStartDay(int month, int year) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        //get total number of days from jan 1 1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(month, year);

        //return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;

    }

    //get total number of days from jan 1 1800
    private static int getTotalNumberOfDays(int month, int year) {
        int total = 0;

        //get the total days from 1800 to jan/1/year
        for (int i = 1800; i < year; i++){
            if (isLeapYear(i)){
                total = total + 366;
            }else {
                total = total + 365;
            }
        }

        //add days from Jan to the month prior to the calender month
        for (int i = 1; i < month; i++){
            total = total + getNumberOfDaysInMonth(i, year);
        }
        return total;
    }

    //get the number of days in a month
    private static int getNumberOfDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12){
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2)
            return isLeapYear(year) ? 29 : 28;

        return 0; //if month is incorrect
    }

    //check whether the year is leap year
    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
