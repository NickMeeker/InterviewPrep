/*
    a = "11", b = "1"
    
    1) reverse both strings:
        a = 11
        b = 1
        
    2) append 0s to the shorter one
        a = 11
        b = 10
        
    3) iterate over them, simulating addition
        - be sure to store the carry bit

*/

class Solution {
  public String addBinary(String a, String b) {
    char carry = '0';
    int i = 0;
    StringBuilder A = new StringBuilder(a);
    StringBuilder B = new StringBuilder(b);
    StringBuilder output = new StringBuilder();

    // reverse
    A.reverse();
    B.reverse();

    // now pad
    while (A.length() < B.length()) {
      A.append("0");
    }

    while (B.length() < A.length()) {
      B.append("0");
    }

    // now add
    int n = A.length();
    while (i < n) {
      char a_bit = A.charAt(i);
      char b_bit = B.charAt(i);
      char added_bit = '0';
      char next_carry = '0';

      if (a_bit == '0' && b_bit == '0') {
        if (carry == '0') {
          added_bit = '0';
          next_carry = '0';
        } else {
          added_bit = '1';
          next_carry = '0';
        }
      } else if ((a_bit == '1' && b_bit == '0') || (a_bit == '0' && b_bit == '1')) {
        if (carry == '0') {
          added_bit = '1';
          next_carry = '0';
        } else {
          added_bit = '0';
          next_carry = '1';
        }
      } else {
        if (carry == '0') {
          added_bit = '0';
        } else {
          added_bit = '1';
        }
        next_carry = '1';
      }
      output.append(added_bit);
      carry = next_carry;
      i++;
    }

    if (carry == '1')
      output.append(carry);

    return output.reverse().toString();
  }
}