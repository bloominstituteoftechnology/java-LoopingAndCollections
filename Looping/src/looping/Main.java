package looping;

import java.util.Random;

public class Main
{
    // Enter with Part 6 Recursion

    public static int gcd(int p, int q) 
    {
        if (q == 0)
        {
            System.out.println("GCD Returning " + p); 
            return p;
        }

        else 
        {
            System.out.println("GCD Running with p = " + q + " q = " + p % q);
            return gcd(q, p % q);
        }    
    }


    public static void main(String[] args)
    {
        // Part 1 Random Numbers

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



        // Part 2 scope

//        System.out.println("\nRandoms Until 0");
//        do
//        {
//            int myTest = rand.nextInt(7);
//        } while (myTest != 0);



        System.out.println("\nRandoms Until 0");
        int myTest;
        do
        {
            myTest = rand.nextInt(7);
            System.out.println("Testing Random: " + myTest);
        } while (myTest != 0);


  
        // Part 3 If, continue, break
     
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

  

        // Part 4 If..Else and Switch

        System.out.println("\nPrint Days (0 = Sunday)");

        int randDay = rand.nextInt(7);
        System.out.println("*** " + randDay);

        // == equals
        // != not equal
        // !  not
        // && and
        // || or

        if ((randDay == 0) || (randDay == 6))
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



        // Part 5 Improved Switch

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



        // Part 6 Recursion

        System.out.println("\nRecursion");

        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println("GCD Running with p = " + p + " q = " + q);
        int d  = gcd(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
    }
}
