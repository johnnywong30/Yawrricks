// Yawrricks - Johnny Wong, Richard Wong, and Zane Wang
// APCS pd1
// L01 -- What Does the Data Say?
// 2018-03-14

/****
* QuickSortTester
* Timing Mechanism
* We will generate 500 arrays each with increments of 100.
* For each array, we will perform QuickSort and record the time elapsed in nanoseconds.
* We will then compile all the times and divide by the number of arrays we performed QuickSort on to get the average time.

****/

public class QuickSortTester{
     private static long timeStart;
     private static int numTrials;
     private static long timeEnd;
     private static long totalTime;
     private static long averageTime;
     private static int[] testArray;
     private static int arrSize;

     //return int array of size s, with each element fr range [0,maxVal)
     public static int[] buildArray( int s, int maxVal ) {
          int[] retArr = new int[s];
          for( int i = 0; i < retArr.length; i++ )
          retArr[i] = (int)( maxVal * Math.random() );
          return retArr;
     }

     public static void main(String[] args) {
          numTrials = 500;
          // testing the best case of median as pivot
          System.out.println("Best case tests: ");
          System.out.println("Trial, Time");
          for (int i = 0; i < numTrials; i++){
               arrSize = 1000 + (i * 100);
               testArray = buildArray(arrSize, arrSize);
               // start time is after each array is built
               // and they are then sorted by qsort
               timeStart = System.nanoTime();
               QuickSort.qsortM(testArray);
               // end time is after the inputted array is
               // sorted after qsort
               timeEnd = System.nanoTime();
               // the actual time spent is the different between
               // end time and start time
               totalTime = timeEnd - timeStart;
               // add total time to averageTime for later
               // calculation
               averageTime += totalTime;
               System.out.println(i  + ", " + timeEnd);
          }
          // avg time for best case
          averageTime /= numTrials;
          System.out.println("average, " + averageTime);
          // testing the worst case of leftbound as pivot
          System.out.println("Worst case tests: ");
          System.out.println("Trial, Time");
          for (int i = 0; i < numTrials; i++){
               arrSize = 1000 + (i * 100);
               testArray = buildArray(arrSize, arrSize);
               // start time is after each array is built
               // and they are then sorted by qsort
               timeStart = System.nanoTime();
               QuickSort.qsortL(testArray);
               // end time is after the inputted array is
               // sorted after qsort
               timeEnd = System.nanoTime();
               // the actual time spent is the different between
               // end time and start time
               totalTime = timeEnd - timeStart;
               // add total time to averageTime for later
               // calculation
               averageTime += totalTime;
               System.out.println(i  + ", " + timeEnd);
          }
          // avg time for worst case
          averageTime /= numTrials;
          System.out.println("average, " + averageTime);
          // testing the average case of rightbound as pivot
          System.out.println("Average case tests: ");
          System.out.println("Trial, Time");
          for (int i = 0; i < numTrials; i++){
               arrSize = 1000 + (i * 100);
               testArray = buildArray(arrSize, arrSize);
               // start time is after each array is built
               // and they are then sorted by qsort
               timeStart = System.nanoTime();
               QuickSort.qsortR(testArray);
               // end time is after the inputted array is
               // sorted after qsort
               timeEnd = System.nanoTime();
               // the actual time spent is the different between
               // end time and start time
               totalTime = timeEnd - timeStart;
               // add total time to averageTime for later
               // calculation
               averageTime += totalTime;
               System.out.println(i  + ", " + timeEnd);
          }
          // avg time for average case
          averageTime /= numTrials;
          System.out.println("average, " + averageTime);

     }
}
