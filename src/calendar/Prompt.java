package calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	public void printMenu() {
		System.out.println("+------------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+------------------------+");
	}

	private final static String PROMPT = "> ";

	public void runPrompt() throws ParseException {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		boolean isTrue = true;
		while (isTrue) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();

			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isTrue = false;
				break;
			}

		}
		System.out.println("Bye");
		scanner.close();
	}

	public void cmdCal(Scanner scanner, Calendar cal) {

		int month = 1;
		int year = 2021;

		System.out.println("년도를 입력하세요.");
		System.out.print(PROMPT);
		year = scanner.nextInt();
		System.out.println("월을 입력하세요.");
		System.out.print(PROMPT);
		month = scanner.nextInt();

		cal.printCalendar(year, month);

	}

	public void cmdSearch(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		PlanItem plan = cal.searchPlan(date);
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}

	}

	public void cmdRegister(Scanner scanner, Calendar cal) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
		String date = scanner.next();
		scanner.nextLine();
		System.out.println("일정을 입력해 주세요.");
		String text = scanner.nextLine();
		cal.registerPlan(date, text);
	}

	public static void main(String[] args) throws ParseException {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
