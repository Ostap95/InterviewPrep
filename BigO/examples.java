/*
What is the runtime of the below code?
*/

void foo(int[] array) {
  int sum = 0;
  int product = 1;
  for (int i = 0; i < array.length; i++) {
    sum += array[i];
  }
  for (int i = 0; i < array.length; i++) {
    product *= array[i];
  }
  System.out.println(sum + ",  " + product);
}
/* This will take O(N) time. The fact that we iterate through the array twice doesn't matter. */

void printPairs(int[] array) {
  for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array.length; j++) {
      System.out.println(array[i] + "," + array[j]);
    }
  }
}
 /* The inner for loop has O(N) iterations and it is called N times. Therefore, the runtime is O(N^2).
 Another way we can see ths is by inspecting what the meaning of the code is. is is printing all pairs (two-element sequences).
 Therefore are O(N^2) pairs; Therefore the runtime is O(N^2). */
