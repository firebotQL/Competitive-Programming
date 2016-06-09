import java.io.*;
import java.util.*;

public class Main {

    public static void insertionSortPart2(int[] arr)
    {       
           for(int i = 1; i < arr.length; i++) {
               int e = arr[i];
               int j = i - 1;
               for(; j >= 0; j--) {
                   if (e < arr[j]) {
                       arr[j+1] = arr[j];
                   } else {
                     break;  
                   }
               }
               arr[j+1] = e;
               printArray(arr);
           }
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
