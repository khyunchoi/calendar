package calendar;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		System.out.println("두 수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int s1 = scan.nextInt();
		int s2 = scan.nextInt();
		int sum = s1+s2;
		System.out.println("두 수의 합은 "+sum+"입니다.");
		scan.close();
	}

}
