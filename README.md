# Yawrricks
Yawrricks - Johnny Wong, Richard Wong, and Zane Wang <br />
APCS pd1 <br />
L01 -- What Does the Data Say? <br />
2018-03-14

## Hypothesis
  <p> Yawrricks hypothesizes that the best case of QuickSort would be the median as the pivot with a runtime of O(nlogn). 
  The worst case would be a random index of an array as the pivot with a runtime of O(n*n). The average case is approximately
   O(nlogn) with the pivot either being the left or right bound of the array.</p>
   
## Background
  <p> Due to requiring communication like a strong team should, we had other applications such as Google Chrome to write code 
   cohesively through https://codeshare.io/ (great site) and Discord for verbal communication. These processes required memory
   which may have slowed down our program. </p>
   
## Experiment Methodology
  1. Perform 500 trials on the best case, the worst case, and the average case by creating 500 different arrays, that increment
  in size by 100, starting at a size of 1000.
  2. Start timing after these processes have been initialized. Run the quicksort method corresponding to each case, changing the
  pivot depending on the case. Stop timing after each array is sorted.
  3. Print this data into qsort.csv.
  4. Import qsort.csv into Google Spreadsheets in order to create the graphs below.
  
## Results
  Best Case: <br/>
  ![alt text](bestcase.png)<br/>
  Worst Case: <br/>
  ![alt text](worstcase.png)<br/>
  Average Case: <br/>
  ![alt text](averagecase.png)
  
## Conclusions
  <p> Our data appears to show that when QuickSort is run, indiscrimnate of the pivot position and size, the runtime will be O(n^2).
  The best case of QuickSort should have been O(nlogn) because the partition divided the array into two parts at each call. 
  The problem may have arisen from the randomness in our arrays resulting in outliers and abnormal data.
  One improvement to our experiment would have been running multiple trials on the same array and taking the average time to reduce inconsistencies. </p>
