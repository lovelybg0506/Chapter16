package part01.sec01.exam02;

public class DerivedThreadMain_02 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		DerivedThread A = new DerivedThread();
		A.start();
		System.out.println("프로그램 종료");
		
	}

}	// 관리 : JVM

class DerivedThread extends Thread {
	
	public void run() {
		for(int i=0;i<50;i++)
			System.out.print(i+"\t");
	}
}