class Solution {
  public List<String> fizzBuzz(int n) {
    List<String> ans = new ArrayList<String>();

    for (int num = 1; num <= n; num++) {

      boolean divisibleBy3 = (num % 3 == 0);
      boolean divisibleBy5 = (num % 5 == 0);

      String numAnsStr = "";

      if (divisibleBy3) {

        numAnsStr += "Fizz";
      }

      if (divisibleBy5) {
        numAnsStr += "Buzz";
      }

      if (numAnsStr.equals("")) {

        numAnsStr += Integer.toString(num);
      }

      ans.add(numAnsStr);
    }

    return ans;
  }
}