/**
* Author: Papa Yaw Owusu Nti
* 
* Purpose of the class
*/	

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {

public static void main (String[] args) { 

ArrayList<Integer> arr0 = new ArrayList<Integer>();
Random ran = new Random();

for (int i =0;i<10;i++){
    arr0.add(ran.nextInt(100));

}

for (int i =0; i<arr0.size(); i++){
    System.out.println(arr0.get(i));
}

ArrayList<Integer> arr1 = new ArrayList<Integer>();   
for (int i =0; i<arr0.size(); i++){
    arr1.add(arr0.get(i));
}

ArrayList<Integer> arr2 = arr0;

System.out.println("arr0 == arr1: " + (arr0 == arr1)  + "\narr1 == arr2: " + (arr1 == arr2)   + "\narr2 == arr0: " + (arr2 == arr0));
System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2)) + "\narr2.equals(arr0): " + (arr2.equals(arr0)));



System.out.println("Original Array:" + arr0);
System.out.println();
for (int i =0;i<10;i++){
    int value = ran.nextInt(arr0.size());
    int y = arr0.remove(value);
    System.out.print("Value removed:" + y + "  ");
    System.out.println("Remaining Values In the Array:" + arr0);
    

    // for (int j =0;j<arr0.size();j++){

    //     System.out.print(+ arr0.get(j));
    
    // }

    System.out.println();
}




}
}