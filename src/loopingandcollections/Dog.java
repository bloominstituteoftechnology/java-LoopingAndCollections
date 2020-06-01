package loopingandcollections;

/**
 * A class that contains some characteristics of Dogs. Used to demonstrate how collections handle objects.
 * interface Comparable is implemented so an Array of Dog can be sorted.
 * Otherwise Comparable interface and the compareTo method are not needed!
 */
public class Dog implements Comparable<Dog>
{
    /**
     * The type of dog (String)
     */
    private String breed;

    /**
     * The average weight (int) of this type of dog. Might not be completely accurate but work with me people. I need demonstration data.
     */
    private int avgWeight;

    /**
     * Is this dog good for apartment living (boolean)? Yes I know this is subjective
     */
    private boolean apartment;

    /**
     * The constructor method used to create a new Dog object.
     *
     * @param breed The type of dog (String)
     * @param avgWeight The average weight (int) of this type of dog.
     * @param apartment Is this dog good for apartment living (boolean)?
     */
    public Dog(String breed, int avgWeight, boolean apartment)
    {
        this.breed = breed;
        this.avgWeight = avgWeight;
        this.apartment = apartment;
    }

    /**
     * Getter for breed
     *
     * @return Returns the breed, type, (String) of this dog
     */
    public String getBreed()
    {
        return breed;
    }

    /**
     * Setter for breed
     *
     * @param breed The new breed, type, (String) for this dog object
     */
    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    /**
     * Getter for average weight
     *
     * @return Returns the average weight (int) of this dog
     */
    public int getAvgWeight()
    {
        return avgWeight;
    }

    /**
     * Setter for average weight
     *
     * @param avgWeight the new average weight (int) for this dog
     */
    public void setAvgWeight(int avgWeight)
    {
        this.avgWeight = avgWeight;
    }

    /**
     * Getter for apartments. Notice the use of the word *is* as opposed to *get* in the method header
     *
     * @return Is this dog good for apartments?
     */
    public boolean isApartment()
    {
        return apartment;
    }

    /**
     * Setter for apartment
     *
     * @param apartment Whether this dog is good for apartments or not (boolean)
     */
    public void setApartment(boolean apartment)
    {
        this.apartment = apartment;
    }

    /**
     * When printing this object use this custom toString Method
     *
     * @return the current state of this object
     */
    @Override public String toString()
    {
        return "Dog{" +
            "breed='" + breed + '\'' +
            ", avgWeight=" + avgWeight +
            ", apartment=" + apartment +
            '}';
    }

    /**
     * Add this override when implementing comparable
     *
     * @param o the object to compare to this object
     * @return 0, 1, -1 depending on comparing of object<br>
     *     comparable actually works this way<br>
     *     returns 0 if the primitive types compared are the same<br>
     *         No change in order<br>
     *     returns 1 if the current field is greater than the one being compared,<br>
     *        so move the current object after the one being compared<br>
     *     else returns -1 we know the current field is less than the one being compared,<br>
     *        so move the object ahead of the object being compared<br>
     *     logic to implement this is built into the Array.sort method<br>
     */
    @Override public int compareTo(Dog o)
    {
        if (this.getAvgWeight() == o.getAvgWeight())
        {
            return 0;
        } else if (this.getAvgWeight() > o.getAvgWeight())
        {
            return 1;
        } else
        {
            // so we know this.getAvgWeight() < o.getAvgWeight()
            return -1;
        }
    }
}
