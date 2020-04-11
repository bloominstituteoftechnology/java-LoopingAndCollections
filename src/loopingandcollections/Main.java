package loopingandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * The controlling class to show work on Collections, Looping, and Branching
 */
public class Main
{
    /**
     * Recursively call the function to find the Greatest Common Divisor given the two operands.
     * What is the largest integer that divides each operand evenly
     * For demonstration purposes, the function displays some text while executing.
     *
     * @param p One of the Operands (int)
     * @param q The other Operand (int)
     * @return int - the common divisor of the given operands
     */
    private static int gcd(int p, int q)
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

    /**
     * Random integers will be generated to demonstrate while loops
     */
    private static Random rand = new Random();

    /**
     * The main, initial, method for this application
     *
     * @param args Not used in this application but would be where command line interface arguments could be sent to the application
     */
    public static void main(String[] args) 
    {
        // ***************************
        // ********** ARRAY **********
        // ***************************

        // Let's start working with Arrays

        // Declare the array
        // We do it all on one line but it is really two statements.
        // Dogs dogArr[];
        // dogArr = new Dogs[5];
        Dog[] dogArr = new Dog[5];

        System.out.println("*** Arrays ***");
        dogArr[0] = new Dog("Springer", 50, false);
        dogArr[1] = new Dog("Bulldog", 45, true);
        dogArr[2] = new Dog("Collie", 45, false);
        dogArr[3] = new Dog("Chihuahua", 5, true);
        dogArr[4] = new Dog("Corgie", 35, true);
        // Would not work. The array can only hold 5 elements - 0, 1, 2, 3, 4
        // dogArr[5] = new Dogs ("Mutt", 15, true);

        System.out.println("\n*** Print out array ***");
        System.out.println("The pointer to the array " + dogArr.toString());
        System.out.println();
        System.out.println(Arrays.toString(dogArr));

        System.out.println("\n*** For Loop ***");
        System.out.println("\n*** Dogs Not Good for Apartments ***");
        // Take a look at a for loop with a continue statement
        // Print out the array with a regular for loop
        // not necessarily best programming practice but show how to use continue
        // these for loops are the way I normally print arrays
        for (int i = 0; i < dogArr.length; i++)
        {
            // Notice that a boolean is *is* and not *get*. Common naming for booleans ONLY
            // since the boolean answer the question *is* this true or false
            // the conditional has to be surrounded by ()
            if (dogArr[i].isApartment())
            {
                continue;
            }
            System.out.println(dogArr[i]);
        }
        System.out.println("Breed 3 good for apartment? " + dogArr[3].isApartment());

        System.out.println("\n*** Let's Sort by Weight***");
        // now add the implements Comparable<Dogs> to Dogs
        // required for Arrays.sort
        Arrays.sort(dogArr);

        for (Dog d : dogArr)
        {
            System.out.println(d);
        }
        System.out.println();

        // *******************************
        // ********** ARRAYLIST **********
        // *******************************

        // Create an ArrayList and add the elements from the Array

        System.out.println("\n\n\n*** ArrayList ***");
        List<Dog> dogArrayList = new ArrayList<>();
        dogArrayList.addAll(Arrays.asList(dogArr));

        // Add another element
        dogArrayList.add(new Dog("Mutt", 15, true));

        System.out.println("\n*** Print ArrayList Using For Each ***");
        for (Dog d : dogArrayList)
        {
            System.out.println(d);
        }
        System.out.println();

        System.out.println("\nPrint ArrayList with Switch Statement");
        for (Dog d : dogArrayList)
        {
            // notice the use of print, print, println to build a full System.out.println statement!
            System.out.print(d.getBreed() + " are ");

            // the numbers are out of order for a reason. Poor programming practice but works
            // Categories might not be exactly accurate but shows what is happening
            switch (d.getAvgWeight())
            {
                case 35 :
                    System.out.print(d.getAvgWeight() + " large");
                    break;
                case 25 :
                    System.out.print(d.getAvgWeight() + " medium");
                    break;
                case 15 :
                    System.out.print(d.getAvgWeight() + " small");
                    break;
                case 45 :
                    System.out.print(d.getAvgWeight() + " very large");
                    break;
                case 5 :
                    System.out.print(d.getAvgWeight() + " very small");
                    break;
                default :
                    System.out.print(d.getAvgWeight() + " non-accounted for");
            }
            System.out.println(" dogs");
        }
        System.out.println();

        // Let's manipulate elements
        System.out.println("\n*** Work with Elements ***");
        if (dogArrayList.get(2).getBreed().equals("Turtle"))
        {
            System.out.println("We have a Match!!!");
        } else
        {
            System.out.println("No match for " + dogArrayList.get(2).getBreed());
        }
        System.out.println();

        // add - adds the element at index 2 and shifts all other elements done one.
        //       so the previous element 2 becomes element 3, 3 becomes 4 and so on!
        // set - replaces the element at index 2. So bye Labrador and hello Poodle
        dogArrayList.add(2, new Dog("Labrador", 75, false));
        dogArrayList.set(2, new Dog("Poodle", 50, false));

        // print using an iterator
        Iterator<Dog> iterator = dogArrayList.iterator();
        while (iterator.hasNext())
        {
            Dog tempDog = iterator.next();
            System.out.println(tempDog);
        }
        System.out.println();

        System.out.println("\ndogArrayList is (size) " + dogArrayList.size());
        System.out.println("\nDog[3] " + dogArrayList.get(3));
        System.out.println("remove element at index 3");
        dogArrayList.remove(3);
        System.out.println("Dog[3] " + dogArrayList.get(3));
        System.out.println();

        System.out.println("*** Let's Sort by Weight From Largest to Smallest***");
        // Collections, other than arrays, have their own sort so no need to implement the interface Comparable in Dogs
        // Here you get to easily pick what you want to sort by! And yes you can do the reverse order if you wish!
        //
        // The issue is that Arrays are not derived from the Collections class while the rest of the Collections are
        dogArrayList.sort(Comparator.comparing(o -> o.getAvgWeight(), Comparator.reverseOrder()));

        // print using for each loop - most common way to loop through ArrayList!
        for (Dog d : dogArrayList)
        {
            System.out.println(d);
        }
        System.out.println();

        // *****************************
        // ********** HashMap **********
        // *****************************

        System.out.println("\n\n\n*** HashMap ***");
        Map<Integer, Dog> dogsHashMap = new HashMap<>();

        // add Dogs as our values in our HashMap
        // our key will be a simple counter 0 - (size of HashMap - 1)
        // loop through the arraylist of add the elements to the HashMap
        int hashCount = 0;
        for (Dog d : dogArrayList)
        {
            dogsHashMap.put(hashCount, d);
            hashCount++;
        }

        System.out.println("\n*** Work with elements ***");
        System.out.println("element with key 3 " + dogsHashMap.get(3));
        System.out.println("Size of HashMap " + dogsHashMap.size());
        System.out.println("Remove element with key 3");
        dogsHashMap.remove(3);
        System.out.println("element with key 3 " + dogsHashMap.get(3));
        System.out.println("And now Size of HashMap " + dogsHashMap.size());

        System.out.println("\n*** Print the HashMap ***");
        System.out.println();
        for (HashMap.Entry mapElem : dogsHashMap.entrySet())
        {
            System.out.print("Key is " + mapElem.getKey());
            System.out.println("   Value is " + mapElem.getValue());
        }
        System.out.println();

        System.out.println("*** Let's Sort ***");
        // Convert HashMap to ArrayList. At the end of the sorting, the original HashMap remains unchanged
        List<HashMap.Entry> sortedMap = new ArrayList<>(dogsHashMap.entrySet());
        // Sorting by breed
        // getValue returns an object, type caste that object of Dog and then call getBreed
        sortedMap.sort(Comparator.comparing(o -> ((Dog) o.getValue()).getBreed()));
        System.out.println(sortedMap);
        System.out.println();
        System.out.println("*** Printed another way ***");
        for (HashMap.Entry hashEntry : sortedMap)
        {
            System.out.print("Key = " + hashEntry.getKey());
            System.out.println(" Value = " + hashEntry.getValue());
        }

        // this is just a copy of paste from above. This shows the that original HashMap is unaffected by the sort!
        System.out.println("\n*** Print the Original HashMap ***");
        System.out.println();
        for (HashMap.Entry mapElem : dogsHashMap.entrySet())
        {
            System.out.print("Key is " + mapElem.getKey());
            System.out.println("   Value is " + mapElem.getValue());
        }
        System.out.println();

        // *****************************
        // ********** HashSet **********
        // *****************************
        // Time Permitting
        System.out.println("\n\n\n*** HashSets ***");
        Set<Dog> dogSet = new HashSet<>();
        // add Dogs as our values in our HashSet from our ArrayList
        dogSet.addAll(dogArrayList);
        // Add a "duplicate dog"
        dogSet.add(new Dog("Springer", 50, false));

        // print using for each loop - another way to print a Set
        for (Dog d : dogSet)
        {
            System.out.println(d);
        }
        System.out.println();

        // A set contains unique items so why did the second springer get added.
        // The second Springer got added even though the state of the objects are the same,
        // the actual object are different.
        // There are solutions to this but normally I just use sets with primitive types or Strings
        // Let's create a set with just breed names
        Set<String> dogBreedSet = new HashSet<>();
        for (Dog d : dogArrayList)
        {
            dogBreedSet.add(d.getBreed());
        }
        dogBreedSet.add("Springer");
        System.out.println("*** HashSet of Strings ***");
        // notice no second Springer is in the set
        System.out.println("The Current Size of the Set is " + dogBreedSet.size());
        System.out.println(dogBreedSet);

        System.out.println("Does the Set contain Labrador? " + dogBreedSet.contains("Labrador"));
        System.out.println("Does the Set contain Mutt? " + dogBreedSet.contains("Mutt"));
        System.out.println("Remove Mutt");
        dogBreedSet.remove("Mutt");
        System.out.println("\n*** The set without mutt :-( ***");
        System.out.println("The Current Size of the Set is " + dogBreedSet.size());
        System.out.println(dogBreedSet);

        // *****************************
        // ******** Recursion **********
        // *****************************
        // Time Permitting
        // This does not use Dogs, Just a Recursion example!

        System.out.println("\n\n\n*** Recursion ***");

        int p = 100;
        int q = 255;
        System.out.println("GCD Running with p = " + p + " q = " + q);
        int d  = gcd(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);

        // *****************************
        // ******** While loop *********
        // *****************************
        // Time Permitting
        // This does not use Dogs, Just a Recursion example!

        System.out.println("\n\n\n*** Do While Loop ***");
        // this will also pick one number and loop until the number is 7
        // pick has to be declared outside of the body the do while loop,
        // otherwise the do while loop rand, comparison, does not know about it!
        int pick;
        do
        {
            pick = rand.nextInt(10);
            System.out.println("Picked: " + pick);
        } while (pick != 7);
    }
}
