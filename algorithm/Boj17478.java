package algo;

import java.util.Scanner;

public class Boj17478 {
	static int N;
	static void underBar(int t) {
		StringBuilder sb = new StringBuilder("");
		for (int i=0;i<t;i++) {
			sb.append("____");
		}
		System.out.print(sb.toString());
	}
	
	static void recursive(int n) {
		underBar(n);
		System.out.println("\"재귀함수가 뭔가요?\"");
		if (n==N) {
			underBar(n);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			underBar(n);
			System.out.println("라고 답변하였지.");
			return;
			
		} else {
			underBar(n);
			System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			underBar(n);
			System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			underBar(n);
			System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			recursive(n+1);
		}
		underBar(n);
		System.out.println("라고 답변하였지.");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive(0);
	}

}
