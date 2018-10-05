package sort;

import java.util.Random;

public class Sorting {
	private int[] sorted; // 정렬 후 결과배열
	private int[] paramArr; // 원배열
	private int count; // 반복회수

	public void printCount() {
		System.out.println("반복회수: " + count);
	}

	public Sorting(Integer[] list) {
		sorted = new int[list.length];
		paramArr = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			paramArr[i] = list[i].intValue();
		}
	}

	public void sortingPrint() {
		for (int i = 0; i < sorted.length; i++) {
			System.out.println((i + 1) + ":" + sorted[i]);
		}
	}

	public void sortingPrint2() {
		for (int i = 0; i < paramArr.length; i++) {
			System.out.println((i + 1) + ":" + paramArr[i]);
		}
		// Arrays.stream(sorted).forEach(s -> System.out.println(s));
	}

	public void sorting(String sort) {
		if ("merge".equals(sort)) {
			mergeSort(0, paramArr.length - 1, paramArr);
		} else if ("quick".equals(sort)) {
			quickSort(paramArr, 0, paramArr.length - 1);
		} else if ("randomQuick".equals(sort)) {
			quickSort_ranPivot(paramArr, 0, paramArr.length - 1);
		}
	}

	///////////////////////////////////// merge
	///////////////////////////////////// sort/////////////////////////////////////

	public void mergeSort(int left, int right, int[] arr) {

		int mid;
		if (left < right) {
			if (right - left < 8) { // 서브배열의 길이가 8 이하일 때
				insertionSort(left, right, arr);
				count++;
				// System.out.println("- 삽입정렬 -");
			} else {
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

	///////////////////////////////////// insertion
	///////////////////////////////////// sort/////////////////////////////////////
	public void insertionSort(int[] data) { // 원본
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

	public void insertionSort(int left, int right, int[] data) { // left부터 right까지 정렬
		for (int index = left + 1; index < right + 1; index++) {
			int temp = data[index];
			int aux = index - 1;

			while ((aux >= left) && (data[aux] > temp)) {
				data[aux + 1] = data[aux];
				aux--;
			}
			data[aux + 1] = temp;
		}
	}

	///////////////////////////////////// quick
	///////////////////////////////////// sort/////////////////////////////////////
	public void quickSort(int data[], int left, int right) {
		if (left < right) {
			int pivot = partition(data, left, right);
			quickSort(data, left, pivot - 1); 
			quickSort(data, pivot + 1, right); 
		}
	}

	int partition(int data[], int left, int right) {
		int pivot = right;

		while (left < right) {
			while (data[left] <= data[pivot] && left < right)
				left++;
			while (data[right] >= data[pivot] && left > right)
				right--;
			if (left < right)
				swap(data, left, right);
		}

		swap(data, right, pivot);
		count++;
		return right; // 최종 오른쪽 피봇 반환
	}

	private void swap(int arr[], int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

	public void quickSort_ranPivot(int data[], int left, int right) {
		if (left < right) {
			int pivot = randomize_partition(data, left, right);
			quickSort_ranPivot(data, left, pivot - 1);
			quickSort_ranPivot(data, pivot + 1, right);
		}
	}

	int randomize_partition(int data[], int left, int right) {
		int ran = (int) (Math.random() * (right - left + 1)) + left;
		int pivot = data[ran];

		while(left<right) {
			while(data[left]<=pivot && left<right) left++;
			while(data[right]>pivot && left<right) right--;
			if(left<right) swap(data,left,right);
			if(right==ran) return left;
		}
		swap(data,ran,right);
		count++;
		return right;

	}

}
