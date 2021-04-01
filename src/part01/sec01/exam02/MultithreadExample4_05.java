package part01.sec01.exam02;

class Account {
	String accountNo;
	String ownerName;
	int balance;

	Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public int withdraw(int amount) {
		if (balance < amount)
			return 0;
		balance -= amount;
		return amount;
	}
}

class SharedArea {
	Account account1;
	Account account2;

}

class TransferThread extends Thread {
	SharedArea sharedArea;

	TransferThread(SharedArea area) {
		sharedArea = area;
	}

	public void run() {
		for (int cnt = 0; cnt < 12; cnt++) {
			synchronized(sharedArea) { // 동기화
				sharedArea.account1.withdraw(1000000);
				System.out.println("이몽룡 계좌:100만원 인출");
				
				sharedArea.account2.deposit(1000000);
				System.out.println("성춘향 계좌:100만원 입금");
			}

		}
	}
}

class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread(SharedArea area) {
		sharedArea = area;
	}

	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {
			synchronized(sharedArea) {
			int sum = sharedArea.account1.balance + sharedArea.account2.balance;
		System.out.println("계좌 잔액 합계 : " + sum);
			}	
		
		try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

public class MultithreadExample4_05 {

	public static void main(String[] args) {
		SharedArea area = new SharedArea();

		area.account1 = new Account("111-111-1111", "이몽룡", 20000000);
		area.account2 = new Account("222-222-2222", "성춘향", 10000000);

		TransferThread tft = new TransferThread(area);
		PrintThread ptt = new PrintThread(area);

		tft.start();
		ptt.start();
	}

}
