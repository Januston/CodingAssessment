// indexs
// 0 - O negative
// 1 - O positive
// 2 - A negative
// 3 - A positive
// 4 - B negative
// 5 - B positive
// 6 - AB negative
// 7 - AB positive

import java.io.*;
import java.util.*;

public class BloodDistribution {
  // methods
  public static int giveBlood(int[] availableBlood, int[] patientsBlood, int i, int j) {
    int givenBlood = Math.min(availableBlood[i], patientsBlood[j]);
    availableBlood[i] -= givenBlood;
    patientsBlood[j] -= givenBlood;
    return givenBlood;
  }

  public static void main(String[] args) {
    // Variables
    int totalBloodDistributed = 0;
    int totalBloodDistributed2 = 0;
    Scanner scan = new Scanner(System.in);
    int [] availableBlood = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int [] patientsBlood = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int [] availableBlood2 = Arrays.copyOf(availableBlood, availableBlood.length);
    int [] patientsBlood2 = Arrays.copyOf(patientsBlood, patientsBlood.length);
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Note: Could Optimize By Moving The Negative And Positve Blood Distribution To A Function But To Save Time Will
    //       Copy And Paste The Negative And Positive Blood In Both Cases Instead.
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Case One: Assign Negative Blood First (General Approach Should Cover Majority Of Cases)
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Give Out Negative Blood
    // O Negative
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,0);
    // A Negative
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 2,2);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,2);
    // B Negative
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 4,4);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,4);
    // AB Negative
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 6,6);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 4,6);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 2,6);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,6);

    // Give Out Positive Blood
    // O Positive
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 1,1);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,1);
    // A Positive
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 3,3);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 2,3);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 1,3);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,3);
    // B Positive
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 5,5);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 4,5);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 1,5);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,5);
    // Reassign all remaining blood to AB Positive
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 7,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 6,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 5,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 4,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 3,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 2,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 1,7);
    totalBloodDistributed += giveBlood(availableBlood, patientsBlood, 0,7);
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Case Two: Assign Positive Blood First (Accounts For Edge Cases Where Positive First Distributes More)
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Give Out Positive Blood
    // O Positive
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 1,1);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,1);
    // A Positive
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 3,3);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 2,3);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 1,3);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,3);
    // B Positive
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 5,5);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 4,5);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 1,5);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,5);
    // Reassign all remaining blood to AB Positive
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 7,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 6,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 5,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 4,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 3,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 2,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 1,7);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,7);

    // Give Out Negative Blood
    // O Negative
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,0);
    // A Negative
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 2,2);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,2);
    // B Negative
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 4,4);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,4);
    // AB Negative
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 6,6);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 4,6);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 2,6);
    totalBloodDistributed2 += giveBlood(availableBlood2, patientsBlood2, 0,6);
    System.out.println(Math.max(totalBloodDistributed, totalBloodDistributed2));
  }
}