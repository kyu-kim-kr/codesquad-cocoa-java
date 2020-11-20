package mission04;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

class Hhmmss {

//	private static final String ANSI_GREEN = "\u001B[32m"; //m 콘솔 색상 변경 by 새리
//    private static final String ANSI_RESET = "\u001B[0m";
//  
	static boolean exitClock = false;

	String[][] clock = { { "한", "두", "세", "네", "다", "섯" }, { "여", "섯", "일", "곱", "여", "덟" },
			{ "아", "홉", "열", "한", "두", "시" }, { "자", "이", "삼", "사", "오", "십" }, { "정", "일", "이", "삼", "사", "오" },
			{ "오", "육", "칠", "팔", "구", "분" }, { "🤣", "이", "삼", "사", "오", "십" }, { "🤣", "일", "이", "삼", "사", "오" },
			{ "오", "육", "칠", "팔", "구", "초" } }; // String[][] clock = new String[9][6]

	public void run() {

		ThreadScanner t = new ThreadScanner();
		t.start();
		Timer timer = new Timer(); // 타이머라는 기능을하는 객체 생성
		TimerTask timerTask = new TimerTask() { // 실행할 로직 설정

			@Override
			public void run() {
				if (!exitClock) {
					runClock();
				}
				else {
					timer.cancel();
					Main.selectClockOrCal();
				}
			}
		};
		timer.schedule(timerTask, 0, 1000); // timerTask를 0초후에 1초간격으로 실행

	}

	void runClock() {
//		int count = 0;
		for (int i = 0; i < 25; i++) {
			System.out.println();
		}
//		count++; // 타이머로 실행할때 반복될때 카운트는 안됨
		init();
		LocalTime cT = LocalTime.now(); // 궁금 메소생성 while반
		hh(cT.getHour(), cT.getMinute());
		mm(cT.getMinute());
		ss(cT.getSecond());

		System.out.println(LocalTime.now());
//		System.out.println("\n" + count + "회 출력");
		for (int i = 0; i < clock.length; i++) {
			for (int j = 0; j < clock[0].length; j++) {
				System.out.print(clock[i][j]);
			}
			System.out.println();
		} // for() end
	}

	private void init() {
		for (int i = 0; i < clock.length; i++) {
			for (int j = 0; j < clock[0].length; j++) {
				clock[i][j] = "🤣";
			}
		}
	}

	private void hh(int h, int m) {
		if (13 <= h && h <= 23) {
			h = h - 12;
		}
		if (h == 0 && m == 0) {
			clock[3][0] = "자";
			clock[4][0] = "정";
		}
		if (h == 12 && m == 0) {
			clock[4][0] = "정";
			clock[5][0] = "오";
		}
		if (h == 1) {
			clock[0][0] = "한";
			clock[2][5] = "시";
		}
		if (h == 2) {
			clock[0][1] = "두";
			clock[2][5] = "시";
		}
		if (h == 3) {
			clock[0][2] = "세";
			clock[2][5] = "시";
		}
		if (h == 4) {
			clock[0][3] = "네";
			clock[2][5] = "시";
		}
		if (h == 5) {
			clock[0][4] = "다";
			clock[0][5] = "섯";
			clock[2][5] = "시";
		}
		if (h == 6) {
			clock[1][0] = "여";
			clock[1][1] = "섯";
			clock[2][5] = "시";
		}
		if (h == 7) {
			clock[1][2] = "일";
			clock[1][3] = "곱";
			clock[2][5] = "시";
		}
		if (h == 8) {
			clock[1][4] = "여";
			clock[1][5] = "덟";
			clock[2][5] = "시";
		}
		if (h == 9) {
			clock[2][0] = "아";
			clock[2][1] = "홉";
			clock[2][5] = "시";

		}
		if (h == 10) {
			clock[2][2] = "열";
			clock[2][5] = "시";
		}
		if (h == 11) {
			clock[2][2] = "열";
			clock[2][3] = "한";
			clock[2][5] = "시";
		}
		if (h == 12) {
			clock[2][2] = "열";
			clock[2][4] = "두";
			clock[2][5] = "시";
		}
	}

	private void mm(int m) {
		if (m / 10 == 1) {
			clock[3][5] = "십";
		}
		if (m / 10 == 2) {
			clock[3][1] = "이";
			clock[3][5] = "십";
		}
		if (m / 10 == 3) {
			clock[3][2] = "삼";
			clock[3][5] = "십";
		}
		if (m / 10 == 4) {
			clock[3][3] = "사";
			clock[3][5] = "십";
		}
		if (m / 10 == 5) {
			clock[3][4] = "오";
			clock[3][5] = "십";
		}
		if (m % 10 == 1) {
			clock[4][1] = "일";
		}
		if (m % 10 == 2) {
			clock[4][2] = "이";
		}
		if (m % 10 == 3) {
			clock[4][3] = "삼";
		}
		if (m % 10 == 4) {
			clock[4][4] = "사";
		}
		if (m % 10 == 5) {
			clock[4][5] = "오";
		}
		if (m % 10 == 6) {
			clock[5][1] = "육";
		}
		if (m % 10 == 7) {
			clock[5][2] = "칠";
		}
		if (m % 10 == 8) {
			clock[5][3] = "팔";
		}
		if (m % 10 == 9) {
			clock[5][4] = "구";
		}
		if (m != 0) {
			clock[5][5] = "분";
		}
	}

	private void ss(int s) {

		if (s / 10 == 1) {
			clock[6][5] = "십";
		}
		if (s / 10 == 2) {
			clock[6][1] = "이";
			clock[6][5] = "십";
		}
		if (s / 10 == 3) {
			clock[6][2] = "삼";
			clock[6][5] = "십";
		}
		if (s / 10 == 4) {
			clock[6][3] = "사";
			clock[6][5] = "십";
		}
		if (s / 10 == 5) {
			clock[6][4] = "오";
			clock[6][5] = "십";
		}
		if (s % 10 == 1) {
			clock[7][1] = "일";
		}
		if (s % 10 == 2) {
			clock[7][2] = "이";
		}
		if (s % 10 == 3) {
			clock[7][3] = "삼";
		}
		if (s % 10 == 4) {
			clock[7][4] = "사";
		}
		if (s % 10 == 5) {
			clock[7][5] = "오";
		}
		if (s % 10 == 6) {
			clock[8][1] = "육";
		}
		if (s % 10 == 7) {
			clock[8][2] = "칠";
		}
		if (s % 10 == 8) {
			clock[8][3] = "팔";
		}
		if (s % 10 == 9) {
			clock[8][4] = "구";
		}
		if (s != 0) {
			clock[8][5] = "초";
		}
	}
}
