package part01.sec01.exam02;

public class MultithreadExample1_01 {

	public static void main(String[] args) {
		/*
		 * DigitThread thread = new DigitThread(); // thread.run(); thread.start(); //
		 * 내용이 계속 바뀜. main의 for문과 DigitThread의 for문이 동시에 실행 되기 때문에 (멀티스레드) // <run과 함께
		 * 사용되는메소드 start>
		 * 
		 * for (char ch = 'A'; ch <= 'Z'; ch++) System.out.print(ch); }
		 * 
		 * }
		 * 
		 * class DigitThread extends Thread{
		 * 
		 * public void run() { for (int cnt = 0; cnt < 10; cnt++) System.out.print(cnt);
		 * } }
		 */

		DigitThread thread = new DigitThread();
		thread.start();

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
			try {
				Thread.sleep(1000); // sleep(1000) 1초단위로텀을 둔다. <=> InterruptedException 사용
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

class DigitThread extends Thread {

	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt);
			try {
				Thread.sleep(1000); // sleep
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}










