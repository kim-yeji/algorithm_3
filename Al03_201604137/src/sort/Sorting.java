package sort;
import java.util.Random;

public class Sorting {
	private int[] sorted;	//정렬 후 결과배열
	private int[] paramArr;	//원배열
	private int count;		//반복회수
	
	
	public void printCount(){
		System.out.println("반복회수: "+count);
	}
	
	public Sorting(Integer[] list){
		sorted = new int[list.length];
		paramArr = new int[list.length];
		for(int i = 0; i < list.length; i++){
			paramArr[i] = list[i].intValue();
		}
	}
	
	public void sortingPrint(){
		for(int i=0; i<sorted.length; i++){
			System.out.println((i+1)+":"+sorted[i]);
		}
	}
		
	public void sortingPrint2(){
		for(int i=0; i<paramArr.length; i++){
			System.out.println((i+1)+":"+paramArr[i]);
		}	
//		Arrays.stream(sorted).forEach(s -> System.out.println(s));
	}
	
	public void sorting(String sort){
		if("merge".equals(sort)) {
			mergeSort(0, paramArr.length-1, paramArr);
		} else if("quick".equals(sort)) {
			quickSort( paramArr,0, paramArr.length-1);
		}
	}

	///////////////////////////////////// merge sort/////////////////////////////////////

	public void mergeSort(int left, int right, int[] arr) {

		int mid;
		if (left < right) {
			if(right - left < 8) {
				insertionSort(left, right, arr);
				count++;
//				System.out.println("- 삽입정렬 -");
			}else {
				mid = (left + right) / 2;
				mergeSort(left, mid, arr);
				mergeSort(mid + 1, right, arr);
				merge(left, mid, right, arr);
			}
		}
	}

	public void merge(int left, int mid, int right, int[] arr) {
		int l = left;
		int m = mid + 1;
		int k = left;

		while (l <= mid || m <= right) {
			if (l <= mid && m <= right) {
				if (arr[l] <= arr[m]) {
					sorted[k] = arr[l++];
				} else {
					sorted[k] = arr[m++];
				}
			} else if (l <= mid && m > right) {
				sorted[k] = arr[l++];
			} else {
				sorted[k] = arr[m++];
			}
			
			count++;
			k++;
		}

		for (int i = left; i < right + 1; i++) {
			arr[i] = sorted[i];
		}

	}

	///////////////////////////////////// insertion sort/////////////////////////////////////
	public void insertionSort(int[] data) { //원본
		for (int index = 1; index < data.length; index++) {
			int temp = data[index];
			int aux = index - 1;

			while ((aux >= 0) && (data[aux] > temp)) {
				data[aux + 1] = data[aux];
				aux--;
			}
			data[aux + 1] = temp;
		}
	}
	
	public void insertionSort(int left, int right, int[] data) { //left부터 right까지 정렬
		for (int index = left+1; index < right+1; index++) {
			int temp = data[index];
			int aux = index - 1;

			while ((aux >= left) && (data[aux] > temp)) {
				data[aux + 1] = data[aux];
				aux--;
			}
			data[aux + 1] = temp;
		}
	}

	///////////////////////////////////// quick sort/////////////////////////////////////
	
	public void quickSort(int arr[], int left, int right) {
	 
	    if (left < right) {
//	        int pivotNewIndex = partition(arr, left, right);
	    	int ranPivot = randomize_partition(arr, left, right);
//	        quickSort(arr, left, pivotNewIndex - 1);
//	        quickSort(arr, pivotNewIndex + 1, right);
	        quickSort(arr, left, ranPivot - 1);
	        quickSort(arr, ranPivot + 1, right);
	    }
	}
	
	void Swap(int[] data, int idx1, int idx2){ 
		int temp = data[idx1]; 
		data[idx1] = data[idx2]; 
		data[idx2] = temp; 
	}
	
	int randomize_partition(int[] data, int left, int right){ 
		
		int ranNum = (int) (Math.random() * (right-left+1)) + left; 
		int pivot = data[ranNum];
		int low = left+1; 
		int high = right; 
		while(low <= high) { 
			while(pivot >= data[low] && low <= right) { 
				if(low == data.length-1) { break; } 
				low++; 
				} 
			while(pivot <= data[high] && high >= (left+1)) 
			{ high--; } 
			if(low <= high) { 
				Swap(data, low, high); 
			} 
			if(low == data.length-1) { break; } 
			} 
		Swap(data, left, high); 
		
		count++;
		return high; 
		}

	 
}
