package sort;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Integer[] list = null;
		String cnt = "";
		Sorting sort = null;
		
		try {
			cnt = "100";
			System.out.println("============== merge " + cnt + "�� �׽�Ʈ ===============");
	
			list = FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("merge");	//�պ�����
			sort.printCount();		//�ݺ�ȸ�� ���
//			sort.sortingPrint();	//���Ĺ迭 ���
			
			System.out.println("============== quick " + cnt + "�� �׽�Ʈ ===============");
			sort = new Sorting(list);
			sort.sorting("quick");	//������
			sort.printCount();
//			sort.sortingPrint2();
			
			System.out.println("============== (random) quick " + cnt + "�� �׽�Ʈ ===============");
			sort = new Sorting(list);
			sort.sorting("randomQuick");	//������
			sort.printCount();
			
			
			cnt = "1000";
			System.out.println("============== merge " + cnt + "�� �׽�Ʈ ===============");
			list = FileReading.readFileForList(cnt);
			sort = new Sorting(list);
			sort.sorting("merge");	//�պ�����
			sort.printCount();		//�ݺ�ȸ�� ���
			
			System.out.println("============== quick " + cnt + "�� �׽�Ʈ ===============");
			sort = new Sorting(list);
			sort.sorting("quick");	//������(�����Ǻ�)
			sort.printCount();		//�ݺ�ȸ�� ���
			
			System.out.println("============== (random) quick " + cnt + "�� �׽�Ʈ ===============");
			sort = new Sorting(list);
			sort.sorting("randomQuick");	//������
			sort.printCount();
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
