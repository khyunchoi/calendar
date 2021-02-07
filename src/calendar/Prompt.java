package calendar;

import java.util.Scanner;

public class Prompt {
	private final static String PROMPT = "> ";

	public int parseDay(String week) {
		if (week.equals("su")) {
			return 0;
		} else if (week.equals("mo")) {
			return 1;
		} else if (week.equals("tu")) {
			return 2;
		} else if (week.equals("we")) {
			return 3;
		} else if (week.equals("th")) {
			return 4;
		} else if (week.equals("fr")) {
			return 5;
		} else if (week.equals("sa")) {
			return 6;
		} else {
			return 0;
		}
	}

	public void runPrompt() {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		int month = 1;
		int year = 2021;
		int weekday = 0;

		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print(PROMPT);
			year = scanner.nextInt();
			System.out.println("월을 입력하세요.");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			System.out.println("첫번째 요일을 입력하세요.(su, mo, tu, we, th, fr, sa)");
			System.out.print(PROMPT);
			String first = scanner.next();
			weekday = parseDay(first);
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}
			cal.printCalendar(year, month, weekday);
		}
		System.out.println("Bye");
		scanner.close();
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
