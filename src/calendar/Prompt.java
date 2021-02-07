package calendar;

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

	public void runPrompt() {
		printMenu();
		Scanner scanner = new Scanner(System.in);


		
		while (true) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			Calendar cal = new Calendar();
			if(cmd.equals("1") ) {
				cmdRegister();
				System.out.println("[일정 등록] 날짜를 입력하세요.");
			} else if(cmd.equals("2")) {
				cmdSearch();
			} else if(cmd.equals("3")) {
				cmdCal(scanner, cal);
			} else if(cmd.equals("h")) {
				printMenu();
			} else if(cmd.equals("q")) {
				break;
			}
			
		}
		System.out.println("Bye");
		scanner.close();
	}

	private void cmdCal(Scanner scanner, Calendar cal) {

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

	private void cmdSearch() {
		// TODO Auto-generated method stub
		
	}

	private void cmdRegister() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// 셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}

}
