import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    	
      int n = in.nextInt();
      in.nextLine();
      String values = in.nextLine();
      String[] integerStrings = values.split(" "); 
      int[] v = new int[integerStrings.length]; 
      for (int j = 0; j < v.length; j++) {
    	  v[j] = Integer.parseInt(integerStrings[j]); 
      }
      
      troubleSort(n, v);
      boolean notSorted = false;
      int wrongIndex = 0;
      
      for (int l = 0; l < v.length - 1; l++) {
    	  if (v[l] > v[l + 1]) {
    		  notSorted = true;
    		  wrongIndex = l;
    		  break;
    	  }
      }
      
      if (notSorted) {
    	  System.out.println("Case #" + i + ": " + wrongIndex);
      } else {
          System.out.println("Case #" + i + ": OK");
      }
    }
  }
  
  public static void troubleSort(int n, int[] v) {
      for (int i = 0; i < n - 1; i++)
          for (int j = 0; j < n - i - 2; j++)
              if (v[j] > v[j + 2]) {
                  int temp = v[j];
                  v[j] = v[j + 2];
                  v[j + 2] = temp;
              }
  }
}