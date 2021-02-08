package calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Calendar {
	private final static int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static String SAVE_FILE="calendar.dat";
	public HashMap<Date, PlanItem> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if (!f.exists()) {
			return;
		}
		try {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String[] words = line.split(",");
				String date = words[0];
				String detail = words[1].replaceAll("\"", "");
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public int getWeekDay(int year, int month) {
		int sumDay = 0;
		for (int i = 1; i < year; i++) {
			if (isLeapYear(i)) {
				sumDay += 366;
			} else {
				sumDay += 365;
			}
		}
		for (int i = 0; i < month - 1; i++) {
			if (isLeapYear(year)) {
				sumDay += LEAP_MAX_DAYS[i];
			} else {
				sumDay += MAX_DAYS[i];
			}
		}
		return sumDay % 7;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int weekday = (getWeekDay(year, month) + 1) % 7;

		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		// print days
		int maxday = getMaxDaysOfMonth(year, month);
		for (int i = 1; i <= maxday; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == ((7 - weekday) % 7)) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
	
}
