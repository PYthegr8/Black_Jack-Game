/*
file name:      ShuffleTests.java
Authors:        Ike Lage & Max Bender & Allen Harper
last modified:  02/26/2024

How to run:     java -ea ShuffleTests
*/

import java.util.ArrayList;

public class ShuffleTests {

    public static void shuffleTestsLab() {
        // case 1: testing that the arrays before and after shuffle are not equal
        {
            // set up
            //Make an array of integers from 0 to 10
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (int i =0;i<10;i++){
                nums.add(i);

            }
            
            //Shuffle it and save the output as a new array
            ArrayList<Integer> newnums = DumbShuffle.dumbShuffle(nums);
            // verify
            // Print the original and the shuffled arrays 
            System.out.println("Original Array: " + nums);
            System.out.println("Reversed Array: " + newnums);
            // test
            //Assert that the original and new arrays aren't equal
            assert nums.equals(newnums) : "These Two Arrays aren't equal";
        }
       
        //Print that your tests have all passed!
        System.out.println("All TESTS PASSED!");
    }

    
    public static void shuffleTestsReflection() {
        //This is where you will write your code for reflection question 1
        ArrayList<Integer> nums = new ArrayList<Integer>();
            for (int i =0;i<10;i++){
                nums.add(i);

            }
            ArrayList<Integer> copyofnums = new ArrayList<>(nums);

            //Shuffle it and save the output as a new array
            ArrayList<Integer> testdumbshufflenums = DumbShuffle.dumbShuffle(copyofnums);
            ArrayList<Integer> testmylabshufflenums = DumbShuffle.myLabShuffle(copyofnums);

            // System.out.println(testdumbshufflenums);
            // System.out.println(testmylabshufflenums);
          
            // if i shuffle twice, i should not be able to get my orginial array, but for my test the dumb shuffle will give the original array
            ArrayList<Integer> testdumbshufflenums1 = DumbShuffle.dumbShuffle(testdumbshufflenums);
            ArrayList<Integer> testmylabshufflenums1 = DumbShuffle.myLabShuffle(testmylabshufflenums);
            // System.out.println(testdumbshufflenums1);
            // System.out.println(testmylabshufflenums1);

        
            // Assert that the shuffled ArrayList is not the same as the original
            assert !nums.equals(testdumbshufflenums1) : "DumbShuffle failed to shuffle the array";
            assert !nums.equals(testmylabshufflenums1) : "myLabShuffle(Smart) failed to shuffle the array";
    }

    public static void main(String[] args) {
        // shuffleTestsLab();
        shuffleTestsReflection();
    }
}


