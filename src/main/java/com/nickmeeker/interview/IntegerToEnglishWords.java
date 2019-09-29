class Solution {
  static final int HUNDRED = 100;
  static final int THOUSAND = 1000;
  static final int MILLION = 1000000;
  static final int BILLION = 1000000000;

  static final int HUNDRED_MODE = 0;
  static final int THOUSAND_MODE = 1;
  static final int MILLION_MODE = 2;
  static final int BILLION_MODE = 3;

  HashMap<Integer, String> dictionary = new HashMap<>();

  void initDictionary() {
    dictionary.put(1, "One");
    dictionary.put(2, "Two");
    dictionary.put(3, "Three");
    dictionary.put(4, "Four");
    dictionary.put(5, "Five");
    dictionary.put(6, "Six");
    dictionary.put(7, "Seven");
    dictionary.put(8, "Eight");
    dictionary.put(9, "Nine");
    dictionary.put(0, "Zero");
    dictionary.put(10, "Ten");
    dictionary.put(11, "Eleven");
    dictionary.put(12, "Twelve");
    dictionary.put(13, "Thirteen");
    dictionary.put(14, "Fourteen");
    dictionary.put(15, "Fifteen");
    dictionary.put(16, "Sixteen");
    dictionary.put(17, "Seventeen");
    dictionary.put(18, "Eighteen");
    dictionary.put(19, "Nineteen");
    dictionary.put(20, "Twenty");
    dictionary.put(30, "Thirty");
    dictionary.put(40, "Forty");
    dictionary.put(50, "Fifty");
    dictionary.put(60, "Sixty");
    dictionary.put(70, "Seventy");
    dictionary.put(80, "Eighty");
    dictionary.put(90, "Ninety");
    dictionary.put(HUNDRED, "Hundred");
    dictionary.put(THOUSAND, "Thousand");
    dictionary.put(MILLION, "Million");
    dictionary.put(BILLION, "Billion");
  }

  String writeThreeDigits(StringBuilder digits, int mode) {
    List<String> outputs = new ArrayList<>();
    boolean onesIsZero = false, oneIsOne = false, onesAndTensAreZero = false;
    for (int i = 0; i < digits.length(); i++) {
      if (i == 0) {
        // ones column

        // zero case - multiple of 10, multiple of hundred, or all 0s
        if (digits.charAt(i) == '0') {
          onesIsZero = true;
          continue;
        }

        // we only want to append if the next number isn't a 1 - otherwise we'll need to
        // append a teen
        if ((digits.length() > 1 && digits.charAt(1) != '1') || digits.length() == 1)
          outputs.add(dictionary.get(Integer.parseInt(digits.substring(0, 1))));

      } else if (i == 1) {

        // oneIsZero
        if (onesIsZero && digits.charAt(i) == '0') {
          onesAndTensAreZero = true;
          continue;
        }

        // dont care
        if (digits.charAt(i) == '0') {
          continue;
        }

        // 10 or a teen
        if (digits.charAt(i) == '1') {
          outputs.add(dictionary.get(Integer.parseInt("1" + digits.substring(0, 1))));
          continue;
        }

        // normal case
        outputs.add(dictionary.get(Integer.parseInt(digits.substring(1, 2)) * 10));
      } else {

        // all 0s - like 123,000,123. dont append anything
        if (onesAndTensAreZero && digits.charAt(i) == '0') {
          return "";
        }

        // dont care
        if (digits.charAt(i) == '0') {
          continue;
        }

        // otherwise pretty straightforward - just add the number of hundreds
        outputs.add(dictionary.get(Integer.parseInt(digits.substring(2))) + " Hundred");
      }
    }
    StringBuilder output = new StringBuilder();
    // the outputs will be in the wrong order since the digits were reversed, so we
    // need to reverse them before appending
    Collections.reverse(outputs);
    for (String s : outputs) {
      output.append(s);
      output.append(" ");
    }
    // finally, add the thousand, million, or billion
    switch (mode) {
    case THOUSAND_MODE:
      output.append(dictionary.get(THOUSAND));
      break;
    case MILLION_MODE:
      output.append(dictionary.get(MILLION));
      break;
    case BILLION_MODE:
      output.append(dictionary.get(BILLION));
      break;
    default:
      break;
    }
    return output.toString();
  }

  public String numberToWords(int num) {
    initDictionary();

    // handle the zero case separately
    if (num == 0)
      return dictionary.get(0);

    // we're going to build the answer three digits at a time and add them to the
    // list
    // since num % 10 gives us the ones column every time, this will ultimately be
    // in reverse order
    // from our final output:
    // 123.456
    // doing num % 10 3 times will build the string 654 first, which is backwards
    // and also
    // the last three-digit grouping that we want to print
    List<String> arr = new ArrayList<>();

    // used to switch over the mode
    int mode = 0;

    while (num > 0) {
      StringBuilder digits = new StringBuilder();

      // get up to three digits at a time
      while (num > 0 && digits.length() < 3) {
        int d = num % 10;
        num /= 10;

        digits.append(Integer.toString(d));
      }

      // and write them
      arr.add(writeThreeDigits(digits, mode++));
    }

    // like we said up there ^, these will be backwards
    Collections.reverse(arr);
    StringBuilder output = new StringBuilder();
    // append each word with a space - then we'll trim excess whitespace
    for (String s : arr)
      output.append(s + " ");

    StringBuilder finalOutput = new StringBuilder();
    // trim the excess whitespace
    for (int i = 0; i < output.length(); i++) {
      // if this character is a ' ' and so was the preceeding character, don't add it
      // to final output
      if (i > 0 && output.charAt(i) == ' ' && output.charAt(i - 1) == ' ')
        continue;
      else
        finalOutput.append(output.charAt(i));
    }
    // and finally, return the string, minus the one excess space at the end
    return finalOutput.substring(0, finalOutput.length() - 1);
  }
}