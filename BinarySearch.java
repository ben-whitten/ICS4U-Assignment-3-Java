/*
* The BinarySearch program implements an application that
* creates a stack of 250 generated numbers and allows you to search it.
*
* @author  Ben Whitten
* @version 1.3
* @since   2020-12-10
*/

import java.util.ArrayList;  // Import the ArrayList class

///////////////////////////////////////////////////////////////////////////////

public class BinarySearch {


  // variables for later.
  private final int maxNumberOfValues = 250;
  private final int maxGeneratedNumber = 100;
  private int position;
  private int position2;
  private int randomNumber;
  private String listValues;
  private int remainder;
  private int intSearchedNumber;
  private String foundNumber;
  private String foundPositions;
  private int temp;
  
  private ArrayList<Integer> values = new ArrayList<Integer>();

  /////////////////////////////////////////////////////////////////////////////
  /**
   * Generate function generates the list of numbers.
   */
  public String generate() {
    try {
      listValues = "Current List Values: \n[Values 1-10] ";
      // Generating the list.
      for (position = 0; position < maxNumberOfValues; position++) {
        randomNumber = (int) (Math.random() * maxGeneratedNumber + 1);
        values.add(randomNumber);
      }

      // Sorting the numbers.
      for (position = 0; position < maxNumberOfValues; position++) {
        for (position2 = (position + 1); position2 < maxNumberOfValues;
             position2++) {
          if (values.get(position) > values.get(position2)) {
            temp = values.get(position);
            values.set(position, values.get(position2));
            values.set(position2, temp);
          }
        }
      }

      // Turning it to string.
      listValues += values.get(0);
      for (position = 1; position < maxNumberOfValues; position++) {
        remainder = position % 10;
        if (remainder == 0) {
          listValues += (" \n[Values " + (position + 1) + "-" + (position + 10)
                         + "] " + values.get(position));
        } else {
          listValues = listValues + ", " + values.get(position);
        }
      }
    } catch (Exception e) {
      listValues = "-1";
    }

    return listValues;
  }

  /////////////////////////////////////////////////////////////////////////////
  /**
   * Search function searches for a value in the stack.
   */
  public String search(String searchedNumber) {
    try {
      foundPositions = "";
      intSearchedNumber = Integer.parseInt(searchedNumber);
      for (position = 0; position < maxNumberOfValues; position++) {
        if (intSearchedNumber == values.get(position)) {
          foundPositions += (" " + (position + 1));
        }
      }
      foundNumber = ("Found: " + searchedNumber + " at position(s): "
                     + foundPositions);
      if (foundPositions.equals("")) {
        foundNumber = "Value was not found.";
      }
    } catch (Exception e) {
      foundNumber = "-1";
    }

    return foundNumber;
  }
}
