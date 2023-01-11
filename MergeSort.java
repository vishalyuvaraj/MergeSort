package PracticeMergeSort;
import java.util.Scanner;

public class MergeSort {
	static void merge(int[] arr, int beg, int mid, int end) {
		int n1 = mid - beg + 1;
		int n2 = end - mid;
		
		int l[] = new int[n1];
		int r[] = new int[n2];
		
		for(int i=0; i<n1; i++) {
			l[i] = arr[beg + i];
		}
		for(int j=0; j<n2; j++) {
			r[j] = arr[mid + 1 + j];
		}
		
		int i=0;
		int j=0;
		int k=beg;
		
		while(i<n1 && j<n2) {
			if(l[i] <= r[j]) {
				arr[k] = l[i];
				i++;
			}
			else {
				arr[k] = r[j];
				j++;
			}
			
			k++;
		}
		while(i<n1) {
			arr[k] = l[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = r[j];
			j++;
			k++;
		}
	}
	static void mergeSort(int[] arr, int beg, int end) {
		if(beg < end) {
			int mid = (beg + end)/2;
			mergeSort(arr, beg, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, beg, mid, end);
			
		}
	}
	void displayArray(int[] arr, int num) {
		for(int i=0; i<num; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner myArr = new Scanner(System.in);
		System.out.println("Enter the number of elements in an Array: ");
		int num = myArr.nextInt();
		int[] arr = new int[num];
		System.out.println("Listing the Number of Elements in an Array: ");
		for (int i=0; i<num; i++) {
			arr[i] = myArr.nextInt();
		}
		System.out.println("Elements in an Array are: ");
		for(int i=0; i<num; i++) {
			System.out.print(arr[i] + " ");
		}
		MergeSort m = new MergeSort();
		System.out.println("\nElements Before Merge Sorting: ");
		m.displayArray(arr, num);
		m.mergeSort(arr, 0, num-1);
		System.out.println("\nElements After Merge Sorting: ");
		m.displayArray(arr, num);
		
	}

}
