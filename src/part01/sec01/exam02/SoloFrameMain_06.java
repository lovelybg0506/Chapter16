package part01.sec01.exam02;

import java.awt.Frame;

class SoloFrame extends Frame{
	
	public SoloFrame() {
		SoloThread st = new SoloThread(this);
		st.start();
	}
	
}

class SoloThread extends Thread{
	private Frame f = null;
	
	public SoloThread(Frame f) {
		this.f=f;
	}
	
	public void run() {
		int i = 0;
		System.out.println("스레드 시작!");
		while (i < 20) {
			System.out.print(i + "\t");
			f.setTitle("스레드 동작중" + i++);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		System.out.println("스레드 종료!");
	}
}

public class SoloFrameMain_06 {

	public static void main(String[] args) {
		SoloFrame s = new SoloFrame();
		s.setSize(300,100);
		s.setVisible(true);
		
		
	}

}
