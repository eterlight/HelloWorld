package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestScanner {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("������һ������(����0����):");
		int num = in.nextInt();
		List<Integer> arraylist = new ArrayList<Integer>();
		while(num != 0){
			arraylist.add(num);
			System.out.print("������һ������:");
			num = in.nextInt();
		}
		int max = 0;
		int min = 0;
		if(arraylist.size() > 0){
			max = arraylist.get(0);
			min = arraylist.get(0);
			for(int i=0;i<arraylist.size();i++){
				if(max < arraylist.get(i)){ max = arraylist.get(i); }
				if(min > arraylist.get(i)){ min = arraylist.get(i);}
			}
		}
		System.out.println("�������:"+max+",��С����:"+min);
	}

}
