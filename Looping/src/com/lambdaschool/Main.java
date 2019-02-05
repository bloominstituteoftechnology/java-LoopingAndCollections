package com.lambdaschool;

import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        Random rand = new Random();

        System.out.println("Min Integer is " + Integer.MIN_VALUE);
        System.out.println("Max Integer is " + Integer.MAX_VALUE);

        System.out.println("\nRandom Numbers");
        for (int i = 0; i < 7; i++)
        {
            System.out.println("Random Number no bound: " + rand.nextInt());
            System.out.println("Random Number 5 bound:  " + rand.nextInt(5));
        }

        System.out.println("\nRandom Doubles");
        int i = 0;
        while (i < 7)
        {
            System.out.println("Random Number: " + rand.nextDouble());
            i++;
        }

/*        System.out.println("\nRandoms Until 0");
        do
        {
            int myTest = rand.nextInt(7);
        } while (myTest != 0);*/

        System.out.println("\nRandoms Until 0");
        int myTest;
        do
        {
            myTest = rand.nextInt(7);
            System.out.println("Testing Random: " + myTest);
        } while (myTest != 0);


        System.out.println("\nOnly Random Evens");
        for (int j = 0; j < 10; j++)
        {
            int myTester = rand.nextInt(10);
            System.out.println("Number testing: " + myTester);
            if ((myTester % 2) == 0)
            {
                continue;
            }
            System.out.println(myTester);
        }

        System.out.println("\nStop Random Evens");
        for (int j = 0; j < 10; j++)
        {
            int myTester = rand.nextInt(10);
            System.out.println("Number testing: " + myTester);
            if ((myTester % 2) == 0)
            {
                break;
            }
            System.out.println(myTester);
        }

        System.out.println("\nPrint Days (0 = Sunday)");

        int randDay = rand.nextInt(7);
        System.out.println("*** " + randDay);
        if ((randDay == 0) || (randDay == 6)) // && and
        // != not equal so ! is not
        {
            System.out.println("Weekend");
        } else
        {
            System.out.println("Weekday");
        }

        if (randDay == 0)
        {
            System.out.println("Sunday");
        } else if (randDay == 1)
        {
            System.out.println("Monday");
        } else if (randDay == 2)
        {
            System.out.println("Tuesday");
        } else if (randDay == 3)
        {
            System.out.println("Wednesday");
        } else if (randDay == 4)
        {
            System.out.println("Thursday");
        } else if (randDay == 5)
        {
            System.out.println("Friday");
        } else if (randDay == 6)
        {
            System.out.println("Saturday");
        } else
        {
            System.out.println("Error");
        }

        System.out.println("\nSwitch Days");
        switch (randDay)
        {
            case 0:
                System.out.println("Sunday");
            case 1:
                System.out.println("Monday");
            case 2:
                System.out.println("Tuesday");
            case 3:
                System.out.println("Wednesday");
            case 4:
                System.out.println("Thursday");
            case 5:
                System.out.println("Friday");
            case 6:
                System.out.println("Saturday");
        }

        String randDayStr;
        System.out.println("\nSwitch Day");

        switch (randDay)
        {
            case 0:
                randDayStr = "Sunday";
                break;
            case 1:
                randDayStr = "Monday";
                break;
            case 2:
                randDayStr = "Tuesday";
                break;
            case 3:
                randDayStr = "Wednesday";
                break;
            case 4:
                randDayStr = "Thursday";
                break;
            case 5:
                randDayStr = "Friday";
                break;
            case 6:
                randDayStr = "Saturday";
                break;
            default:
                randDayStr = "Error";
        }

        System.out.println(randDayStr);
    }
}
