import java.util.*;
import java.io.*;

public class Solution {
	
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int d = in.nextInt();
      String p = in.next();
      int numswap = 0;
      
	  while (!outOfSwaps(p) && dead(p, d)) {
		  for (int j = p.length() - 1; j > 0; j--) {
			  if (p.charAt(j) == 'S' && p.charAt(j - 1) == 'C') {
				  char[] c = p.toCharArray();
				  char temp = c[j];
				  c[j] = c[j - 1];
				  c[j - 1] = temp;
				  p = new String(c);
				  numswap++;
			  }
		  }
	  }
	  
	  if (dead(p, d)) {
		  System.out.println("Case #" + i + ": IMPOSSIBLE");
	  } else {
		  System.out.println("Case #" + i + ": " + numswap);
	  }
    }
  }
  
  public static boolean outOfSwaps(String p) {
	  boolean shouldbeend = false;
	  if (!p.contains("C")) {
		  return true;
	  }
	  for (int i = 0; i < p.length(); i++) {
		  if (p.charAt(i) == 'C') {
			  shouldbeend = true;
		  } else if (p.charAt(i) == 'S' && shouldbeend) {
			  return false;
		  }
	  }
	  return true;
  }
  
  public static boolean dead(String p, int d) {
	  int health = d;
	  int damage = 1;
	  for (int i = 0; i < p.length(); i++) {
		  if (p.charAt(i) == 'C') {
			  damage = damage * 2;
		  } else {
			  health = health - damage;
		  }
	  }
	  return health < 0;
  }
} 