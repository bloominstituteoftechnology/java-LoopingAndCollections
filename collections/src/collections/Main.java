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
        System.out.println("For Loop");
        for (int i = 0; i < dogArr.length; i++)
        {
            System.out.println(dogArr[i]);
        }

        System.out.println("Breed 3 good for apartment? " + dogArr[3].isApartment());

        System.out.println("\nprint out array");
        System.out.println(dogArr.toString());
        System.out.println(Arrays.toString(dogArr));



        System.out.println("*** Array List ***");
        ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
        dogsArrayList.addAll(Arrays.asList(dogArr));

        dogsArrayList.add(new Dogs ("Mutt", 15, true));

        for (Dogs d : dogsArrayList)
        {
            System.out.println(d);
        }
        System.out.println();

        dogsArrayList.add(2, new Dogs("Labrador", 75, false));
        dogsArrayList.forEach (d -> System.out.println(d));
        System.out.println();

        dogsArrayList.set(2, new Dogs("Poodle", 50, false));
        for (Dogs d : dogsArrayList)
        {
            System.out.println(d);
        }
        System.out.println();


        System.out.println("dogArrayList is (size) " + dogsArrayList.size());
        System.out.println(dogsArrayList.get(3));
        dogsArrayList.remove(3);
        System.out.println(dogsArrayList.get(3));
        System.out.println();

        Iterator<Dogs> iterator = dogsArrayList.iterator();
        while (iterator.hasNext())
        {
            Dogs tempDog = iterator.next();
            System.out.println(tempDog);
        }
        System.out.println();

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

        Collections.sort(dogsArrayList, new Comparator <Dogs>()
        {
            public int compare (Dogs o1, Dogs o2)
            {
                return o2.getBreed().compareToIgnoreCase(o1.getBreed());
            }
        });

        for (Dogs d : dogsArrayList)
        {
            System.out.println(d);
        }



        System.out.println("*** HashMap ***");
        HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();
        int hashCount = 0;
        for (Dogs d : dogsArrayList)
        {
            dogsHashMap.put(hashCount, d);
            hashCount++;
        }
        dogsArrayList.clear();

        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        dogsHashMap.remove(3);
        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        System.out.println();

        for (Integer i : dogsHashMap.keySet())
        {
            System.out.println("key: " + i + " value: " + dogsHashMap.get(i));
        }
        System.out.println();

        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
        sortedMap.addAll(dogsHashMap.entrySet());

        Collections.sort(sortedMap, new Comparator<Map.Entry<Integer, Dogs> >()
        {
            public int compare (HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2)
            {
                return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
            }
        });

        for (HashMap.Entry<Integer, Dogs> d : sortedMap)
        {
            System.out.println("key: " + d.getKey() + " value: " + d.getValue());
        }
        System.out.println();



        System.out.println("*** HashSet ***");
        HashSet<String> dogsHashSet = new HashSet<String>();
        dogsHashSet.add("Springer");
        dogsHashSet.add("Mutt");
        dogsHashSet.add("Bulldog");

        for (String d : dogsHashSet)
        {
            System.out.println(d);
        }
        System.out.println();

        dogsHashSet.add("Mutt");
        for (String d : dogsHashSet)
        {
            System.out.println(d);
        }

    }
}
