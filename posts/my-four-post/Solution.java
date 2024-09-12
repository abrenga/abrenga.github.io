public class Solution {
  public static int zeros(int n) {
    int m = 1;
    int count = 0;
    for (int i = 1; i < n; i++) {
      m *= i;
    }
    while (m % 10 == 0) {
      m /= 10;
      count++;
    }

    return count;
  }
}