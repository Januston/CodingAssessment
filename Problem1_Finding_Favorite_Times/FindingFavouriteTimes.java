// 31 Possible Time Combinations / 12 Hours = 720min
// 12:34 (difference 1),
// 1:11 (difference 0),
// 1:23 (difference 1),
// 1:35 (difference 2),
// 1:47 (difference 3),
// 1:59 (difference 4),
// 2:10 (difference -1),
// 2:22 (difference 0),
// 2:34 (difference 1),
// 2:46 (difference 2),
// 2:58 (difference 3),
// 3:21 (difference -1),
// 3:33 (difference 0),
// 3:45 (difference 1),
// 3:57 (difference 2),
// 4:20 (difference -2),
// 4:32 (difference -1),
// 4:44 (difference 0),
// 4:56 (difference 1),
// 5:31 (difference -2),
// 5:43 (difference -1),
// 5:55 (difference 0),
// 6:30 (difference -3),
// 6:42 (difference -2),
// 6:54 (difference -1),
// 7:41 (difference -3),
// 7:53 (difference -2),
// 8:40 (difference -4),
// 8:52 (difference -3),
// 9:51 (difference -4),
// 11:11 (difference 0)

import java.io.*;
import java.util.*;

public class FindingFavouriteTimes {
  public static void main(String [] args) {
    // Variables
    Scanner scan = new Scanner(System.in);
    int D;
    int hour = 12;
    int minute = 0;
    int totalPossibleCombinations = 31;
    int minPer12Hours = 720;
    int counter = 0;
    // Input Error Handling
    try {
      D = Integer.parseInt(scan.nextLine());
    }
    catch(Exception e) {
      System.out.println("Input Exception " + e);
      return;
    }

    // Finding Number Count For Remainder Of Minutes 
    for(int i = 0; i < (D % minPer12Hours); i++) {
      if(minute + 1 == 60) {
        minute = 0;
        if(hour + 1 == 13) hour = 1;
        else hour++;
      }
      else minute++;
      String time = Integer.toString(hour) + String.format("%02d" , minute);
      int difference = Character.getNumericValue(time.charAt(1)) - Character.getNumericValue(time.charAt(0));
      for(int j = 2; j < time.length(); j++) {
        if((Character.getNumericValue(time.charAt(j)) - Character.getNumericValue(time.charAt(j-1))) != difference) break;
        else if(j+1 >= time.length()) counter++;
      }
    }
    System.out.println((totalPossibleCombinations * Math.floorDiv(D, minPer12Hours)) + counter);
  }
}