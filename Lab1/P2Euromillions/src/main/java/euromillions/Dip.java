package euromillions;

import java.util.Objects;

import sets.SetOfNaturals;

import java.security.SecureRandom;

/**
 * A set of 5 numbers and 2 starts according to the Euromillions ranges.
 *
 * @author ico0
 */
public class Dip {


    private SetOfNaturals numbers;
    private SetOfNaturals starts;
    private static final int NUMEROFNUMBERS = 5;
    private static final int NUMEROFSTARTS = 2;
    private static final int MAXNUMBERVALUE = 50;
    private static final int MAXSTARTSVALUE = 10;
    private static SecureRandom generator = new SecureRandom();



    public Dip() {
        numbers = new SetOfNaturals();
        starts = new SetOfNaturals();
    }

    public Dip(int[] arrayOfNumbers, int[] arrayOfStarts) {
        this();

        if (NUMEROFNUMBERS == arrayOfNumbers.length && NUMEROFSTARTS == arrayOfStarts.length) {
            numbers.add(arrayOfNumbers);
            starts.add(arrayOfStarts);
        } else {
            throw new IllegalArgumentException("wrong number of elements in numbers/stars");
        }

    }

    public SetOfNaturals getNumbersColl() {
        return numbers;
    }

    public SetOfNaturals getStarsColl() {
        return starts;
    }

    public static Dip generateRandomDip() {


        Dip randomDip = new Dip();
        for (int i = 0; i < 5;i++) {
            int candidate = generator.nextInt(MAXNUMBERVALUE -1) + 1;
            if (!randomDip.getNumbersColl().contains(candidate)) {
                randomDip.getNumbersColl().add(candidate);
            }
        }
        for (int i = 0; i < 2;i++) {
            int candidate = generator.nextInt(MAXSTARTSVALUE -1) + 1;
            if (!randomDip.getStarsColl().contains(candidate)) {
                randomDip.getStarsColl().add(candidate);
            }
        }
        return randomDip;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numbers);
        hash = 29 * hash + Objects.hashCode(this.starts);
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dip other = (Dip) obj;
        if (!Objects.equals(this.numbers, other.numbers)) {
            return false;
        }
        return Objects.equals(this.starts, other.starts);
    }


    /**
     * prepares a string representation of the data structure, formated for
     * printing
     *
     * @return formatted string with data
     */
    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("N[");
        for (int number : getNumbersColl()) {
            sb.append(String.format("%3d", number));
        }
        sb.append("] S[");
        for (int star : getStarsColl()) {
            sb.append(String.format("  %d", star));
        }
        sb.append("]");
        return sb.toString();
    }
}
