package part01.sec01.exam02;

import java.awt.Frame;

class RunFrame extends Frame implements Runnable { // Runnable을 구현하면 반드시 run()을 만들어줘야한다.
	public void run() {
		int i = 0;
		System.out.println("스레드 시작!");
		while (i < 20) {
			System.out.println(i + "\t");
			this.setTitle("스레드 동작중" + i++);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println("스레드 종료!");
	}

}

public class RunFramemain_05 {

	public static void main(String[] args) {
		RunFrame r = new RunFrame();
		r.setSize(300, 100);
		r.setVisible(true);
		Thread t = new Thread(r);
		t.start();

	}

}
