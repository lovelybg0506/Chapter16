package part01.sec01.exam02;

public class MultithreadExample3_04 {

	public static void main(String[] args) {
		Thread thread =new Thread(new SmallLetters());
		thread.start();
		
		char arr[] = {'ㄱ','ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
		
		for(char ch:arr)
			System.out.print(ch);		
	}
}

class SmallLetters implements Runnable{	// Runnable을 써도 실질적인 일은 스레드가한다.
	
	public void run() {
		for(char ch= 'a'; ch<='z' ; ch++)
			System.out.print(ch);
	}
}
