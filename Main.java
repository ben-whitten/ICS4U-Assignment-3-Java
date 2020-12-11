/*
* The Main program handles the inputs and outputs of the binarySearch object.
*
* @author  Ben Whitten
* @version 1.0
* @since   2020-12-10 
*/

import java.util.Scanner;  // Import the Scanner class

public class Main {
  
  /////////////////////////////////////////////////////////////////////////////

  /**
   * This function handles the input and output of the program.
   */
  public static void main(String[] args) {

    // Creating a scanner.
    Scanner scanSearch = new Scanner(System.in);

    String searchedNumber;
    String foundNumber;

    try {
      BinarySearch someValues = new BinarySearch();
      String listValues = someValues.generate();
      System.out.println(listValues);

      while (true) {
        System.out.println("");
        System.out.println("What number would you like to search for?");
        searchedNumber = scanSearch.nextLine();
        foundNumber = someValues.search(searchedNumber);
        if (foundNumber.equals("-1")) {
          System.out.println("");
          System.out.println("ERROR: INVALID INPUT");
        } else {
          System.out.println("");
          System.out.println(foundNumber);
        }
      }
      

    } catch (Exception e) {
      System.out.println("AN ERROR HAS OCCURED");
    }
  }
}
