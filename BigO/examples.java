/*
What is the runtime of the below code?
*/

/* Example 1*/
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


/* Example 2 */
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


/* Example 3 */
void printUnordoredPairs(int[] array) {
  for (int i =0; i < array.length; i++) {
    for (int j = i + 1; j < array.length; j++) {
      System.out.println(array[i] + "," + array[j]);
    }
  }
}
/* This pattern of for loop is very common. It is important that you know the runtime and that you deeply
understand it.
Runtime and irerations:
The first time through j runs for N-1 steps. The second time, it's N-2 steps. Then N-3 steps. And so on.
Therefore the number os steps total is: (N-1) + (N-2) + (N-3) + ... + 2 + 1.
= 1 + 2 + 3 + ... + N-1
= sum of 1 through N-1.
The sum of 1 through N-1 is (N(N-1)/2). So the runtime will be O(N^2).

Alternatively we can figure out the runtime by thinking about what code "means". It iretates
through each pair of values for (i, j) where j is bigger than i.
There are N^2 total pairs. Roughly hlaf those will have i < j and the remaining half will have i > j. This
code goes through  roughly N^2/2 pairs so it does O(N^2) work.
*/


/* Example 4 */
void printUnordoredPairs(int[] arrayA, int[] arrayB) {
  for (int i = 0; i < arrayA.length; i++) {
    for (int j = 0; j < arrayB.length; j++) {
      if (arrayA[i] < arrayB[j]) {
        System.out.println(arrayA[i] + "," + arrayB[j]); /* O(1) work */
      }
    }
  }
}
/* For each element of arrayA, the inner loop goes through b iterations, where b = arrayB.length.
If a = arrayA.length, then the runtime is O(ab).
It's a commoon mistake to assume that the runtime is O(N^2), but it's not because there are 2 different
inputs. Both matter. This os exetremely common mistake. */


/* Example 5 */
void reverse(int[] array) {
  for (int i = 0; i < array.length / 2; i++) {
    int other = array.length - i - 1;
    int temp = array[i];
    array[i] = array[other];
    array[other] = temp;
  }
}
/* This algorithm runs in O(N) time. The fact that it only goes through half of the array (in terms of iterations)
does not impact the big O time. */


/* Example 6 */
/* Which of the following are equivalent to O(N)? Why?
-> O(N + P), where P < N/2.
-> O(2N).
-> O(N + logN).
-> O(N + M).

R:
1) if p<N/2, then we know that N is the doinant term so we can drop the O(P).
2) O(2N) is O(N) since we drop constants.
3) O(N) dominates O(log N), so we can drop the O(log N).
4) There is no established relationships between N and M, so we have to keep both variables in there.
Therefore, all but the last one are equivalent to O(N).
*/
