// Yawrricks - Johnny Wong, Richard Wong, and Zane Wang
// APCS pd1
// L01 -- What Does the Data Say?
// 2018-03-14

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): calls partition to partition each "half" of the array until the
 * array has been partitioned to sections of length one. It will partition an
 * array and then recursively partition the part of the array that is greater
 * than and the part that is less than the pivot.
 *
 * 2a. Worst pivot choice and associated runtime:
 * The chosen pivot is the largest number because this results in going through
 * the whole array and calling partition, each time decreasing the size of the
 * partitioned section by only 1, since the largest number would be by itself.
 * The runtime in this case would be O(n * n - 1)  or O(n^2).
 *
 * 2b. Best pivot choice and associated runtime:
 * The best case would be if the pivot was consistently the median because then
 * you can keep dividing the partitioned segment of the array by half, so there
 * would be a total of logn calls. The runtime in this case is O(n * logn) or
 * O(nlogn).
 *
 * 3. Approach to handling duplicate values in array:
 * We changed the partition so that numbers less than or equal to would be sent
 * to the left side, this was so that they would be able to clump together.
 *
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsortR( int[] d )
    {
	qsortHR(d, 0, d.length - 1);
    }

    public static void qsortL( int[] d)
    {
	qsortHL(d, 0, d.length - 1);
    }

    public static void qsortM( int[] d)
    {
	qsortHM(d, 0, d.length - 1);
    }

    //you may need a helper method...
    public static void qsortHR(int[] d, int left, int right)
    {
	if (left < right) {
	    int pvtPos = partition(d, left, right, right);
	    qsortHR(d, left, pvtPos - 1);
	    qsortHR(d, pvtPos + 1, right);
	}
	else {
	    return ;
	}
    }

        public static void qsortHL(int[] d, int left, int right)
    {
	if (left < right) {
	    int pvtPos = partition(d, left, right, left);
	    qsortHL(d, left, pvtPos - 1);
	    qsortHL(d, pvtPos + 1, right);
	}
	else {
	    return ;
	}
    }

    public static void qsortHM(int[] d, int left, int right)
    {
	if (left < right) {
	    int pvtPos = partition(d, left, right, d.length / 2);
	    qsortHM(d, left, pvtPos - 1);
	    qsortHM(d, pvtPos + 1, right);
	}
	else {
	    return ;
	}
    }

    public static int partition(int[] arr, int left, int right, int pvtPos)
    {
	int pvtVal = arr[pvtPos];
	swap(pvtPos, right, arr);
	int storPos = left;
	for (int i = left; i < right; i++) {
	    if (arr[i] <= pvtVal) {
		swap(storPos, i, arr);
		storPos += 1;
	    }
	}
	swap(right, storPos, arr);
	return storPos;
    }

    //main method for testing
    public static void main( String[] args )
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	arrN[i] = i;

	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	arrMatey[i] = (int)( 48 * Math.random() );

	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
