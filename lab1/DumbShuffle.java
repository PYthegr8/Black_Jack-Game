/*
file name:      DumbShuffle.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea DumbShuffle
*/

import java.util.ArrayList;
import java.util.Random;

import javax.smartcardio.Card;

public class DumbShuffle {

    /**
     * "Shuffles" the arraylist by reversing the order
     */
    public static ArrayList<Integer> dumbShuffle( ArrayList<Integer> integerArray ) {

        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;

        //Add the last to the new list and remove it until the end
        for ( int i = integerArray.size() - 1 ; i >= 0 ; i -- ) {
            newIntegerArray.add( integerArray.get( i ) );
        }

        return newIntegerArray ;
    }

    /**
     * Doesn't shuffle the arraylist, just returns a copy
     */
    public static ArrayList<Integer> noShuffle( ArrayList<Integer> integerArray ) {

        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;

        //Add the last to the new list and remove it until the end
        for ( int i = 0 ; i < integerArray.size() ; i ++ ) {
            newIntegerArray.add( integerArray.get( i ) );
        }

        return newIntegerArray ;
    }

    public static ArrayList<Integer> myLabShuffle( ArrayList<Integer> integerArray ){
        ArrayList<Integer> newIntegerArray = new ArrayList<Integer>() ;
        Random ran = new Random();

        for (int i =0;i<10;i++){
            int value = ran.nextInt(integerArray.size());
            int y = integerArray.remove(value);
            newIntegerArray.add(y);
        }
        return newIntegerArray;
            
    }

    public static ArrayList<Integer> myProjectShuffle( ArrayList<Integer> integerArray ){
    
        ArrayList<Integer> newIntegerArray = new ArrayList<>(integerArray); // Create a copy of the input list

        Random rand = new Random();
        int rdm_idx;

        for (int i = integerArray.size() - 1; i >= 0; i--) {
            rdm_idx = rand.nextInt(i + 1);

            // Swap elements at indices i and rdm_idx
            int temp = newIntegerArray.get(rdm_idx);
            newIntegerArray.set(rdm_idx, newIntegerArray.get(i));
            newIntegerArray.set(i, temp);
        }
        return newIntegerArray; // Return the shuffled list
}


public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i =0;i<10;i++){
            nums.add(i);
        }
    System.out.println(nums);
    ArrayList<Integer> Copyofnums = new ArrayList<>(nums);
    
    ArrayList<Integer> projectshufflenums = DumbShuffle.myProjectShuffle(Copyofnums);
    ArrayList<Integer> dumbshufflenums = DumbShuffle.dumbShuffle(Copyofnums);
    ArrayList<Integer> labshufflenums = DumbShuffle.myLabShuffle(Copyofnums);
    
    
    System.out.println(dumbshufflenums);
    System.out.println(labshufflenums);
    System.out.println(projectshufflenums);

    

}
}