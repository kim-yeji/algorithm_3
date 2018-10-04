package sort;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Integer[] list = null;
		String cnt = "";
		Sorting sort = null;
		
		try {
			cnt = "100";
			System.out.println("============== merge " + cnt + "개 테스트 ===============");
	
			list = FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("merge");	//합병정렬
			sort.printCount();		//반복회수 출력
//			sort.sortingPrint();	//정렬배열 출력
			
			System.out.println("============== quick " + cnt + "개 테스트 ===============");
			sort = new Sorting(list);
			sort.sorting("quick");	//퀵정렬
			sort.printCount();
//			sort.sortingPrint2();
			
			
			cnt = "1000";
			System.out.println("============== merge " + cnt + "개 테스트 ===============");
			list = FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("merge");	//합병정렬
			sort.printCount();		//반복회수 출력
			
			System.out.println("============== quick " + cnt + "개 테스트 ===============");
			sort = new Sorting(list);
			sort.sorting("quick");	//퀵정렬
			sort.printCount();		//반복회수 출력
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
