package bitonic;

public class BitonicPoint 
{
	private static int ascendingBinarySearch(int[] arr, int key, int left, int right)
	{
		while (left <= right) 
		{
			int mid = left + (right - left) / 2;

			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}
		
		return -1;
	}
	
	private static int descendingBinarySearch(int[] arr, int key, int left, int right)
	{
		while (left <= right) 
		{
			int mid = left + (right - left) / 2;

			if (arr[mid] == key)
				return mid;
			if (arr[mid] < key)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return -1;
	}
	
	private static int findBitonicPoint(int[] arr, int left, int right)
	{	
		int mid = left + (right - left) / 2;
		
		if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) 
		{
			return mid;
		}
		
		if (arr[mid] < arr[mid + 1])
		{
			return findBitonicPoint(arr, mid + 1, right);
		}
		else
		{
			return findBitonicPoint(arr, left, mid);
		}
	}
	
	private static int findElement(int[] arr, int key, int left, int right, int bitonicIndex)
	{
		if (arr[bitonicIndex] == key) 
		{
			return bitonicIndex;
		}
		else if (arr[bitonicIndex] < key) 
		{
			return -1;
		}
		else
		{
			int index = ascendingBinarySearch(arr, key, left, bitonicIndex);

			return (index > -1) ? index : descendingBinarySearch(arr, key, bitonicIndex + 1, right);
		}
	}
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {-2, -1, 0, 10, 18, 3, 1, -3};
		int key = 1;
		int left = 0;
		int right = arr.length - 1;
		
		int bitonicIndex = findBitonicPoint(arr, left, right);
		
		System.out.println("Bitonic Point Index : " + bitonicIndex);
		System.out.println("Index of " + key + " : " + findElement(arr, key, left, right, bitonicIndex));
	}
}
