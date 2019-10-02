package collections;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Dogs dogArr[];
        dogArr = new Dogs[5];
        // Dogs[] dogArr = new Dogs[5];

        System.out.println("*** Arrays ***");

        dogArr[0] = new Dogs ("Springer", 50, false);
        dogArr[1] = new Dogs ("Bulldog", 50, true);
        dogArr[2] = new Dogs ("Collie", 50, false);
        dogArr[3] = new Dogs ("Chihuahua", 5, true);
        dogArr[4] = new Dogs ("Corgie", 35, true);
        // dogArr[5] = new Dogs ("Mutt", 15, true);

        // Print out the array
        System.out.println("\n*** For Loop ***");
        for (int i = 0; i < dogArr.length; i++)
        {
            System.out.println(dogArr[i]);
        }

        System.out.println("\n*** Work with Data ***");

        System.out.println("Breed 3 good for apartment? " + dogArr[3].isApartment());

        System.out.println("\n*** Print out array ***");
        System.out.println(dogArr.toString());
        System.out.println();
        System.out.println(Arrays.toString(dogArr));
 

        System.out.println("\n\n\n*** ArrayList ***");
        ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
        dogsArrayList.addAll(Arrays.asList(dogArr));

        dogsArrayList.add(new Dogs ("Mutt", 15, true));


        // ********** ARRAYLIST **********

        System.out.println("*** Print ArrayList ***");
        for (Dogs d : dogsArrayList)
        {
            System.out.println(d);
        }
        System.out.println();

        System.out.println("\n Print ArrayList with Conditional");
        for (Dogs d : dogsArrayList)
        {
            if (d.getAvgWeight() >= 50)
            {
                System.out.println(d.getBreed() + " are large");
            } else
            {
                System.out.println(d.getBreed() + " are small");
            }
        }
        System.out.println();


        if (dogsArrayList.get(2).getBreed().equals("Turtle"))
        {
            System.out.println("We have a Match!!!");
        } else
        {
            System.out.println("No match for " + dogsArrayList.get(2).getBreed());
        }
        System.out.println();

        System.out.println("\n*** Work with Elements ***");
        dogsArrayList.add(2, new Dogs("Labrador", 75, false));
        dogsArrayList.forEach (d -> System.out.println(d));
        System.out.println();

        dogsArrayList.set(2, new Dogs("Poodle", 50, false));

        System.out.println();
        dogsArrayList.forEach (d -> System.out.println(d));


        System.out.println("\ndogArrayList is (size) " + dogsArrayList.size());
        System.out.println("\nDog[3] " + dogsArrayList.get(3));
        dogsArrayList.remove(3);
        System.out.println("Dog[3] " + dogsArrayList.get(3));
        System.out.println();

        Iterator<Dogs> iterator = dogsArrayList.iterator();
        while (iterator.hasNext())
        {
            Dogs tempDog = iterator.next();
            System.out.println(tempDog);
        }
        System.out.println();

        System.out.println("*** Let's Sort ***");
        Collections.sort(dogsArrayList, new Comparator <Dogs>()
        {
            public int compare (Dogs o1, Dogs o2)
            {
                return o1.getBreed().compareToIgnoreCase(o2.getBreed());
            }
        });

        for (Dogs d : dogsArrayList)
        {
            System.out.println(d);
        }
        System.out.println();

        dogsArrayList.sort ((o1, o2) -> o2.getBreed().compareToIgnoreCase(o1.getBreed()));
        dogsArrayList.forEach(d -> System.out.println(d));


        // ********** HashMap **********

        System.out.println("\n\n\n*** HashMap ***");
        HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();
        int hashCount = 0;
        for (Dogs d : dogsArrayList)
        {
            dogsHashMap.put(hashCount, d);
            hashCount++;
        }
        dogsArrayList.clear();

        System.out.println("\n*** Work with elements ***");

        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        dogsHashMap.remove(3);
        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        System.out.println();
        dogsHashMap.forEach((k, v) -> System.out.println("key: " + k + " value: " + v.getBreed()));
        System.out.println();

        System.out.println("*** Let's Sort ***");
        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
        sortedMap.addAll(dogsHashMap.entrySet());
        sortedMap.sort((o1, o2) -> o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight());
        sortedMap.forEach(d -> System.out.println("key: " + d.getKey() + " value: " + d.getValue()));
        System.out.println();
    }
}
