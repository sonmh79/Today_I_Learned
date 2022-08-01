package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244 {

	static int N;
	static int[] arr;
	static int M;
	
	static void toggle(int n) { // Change Status of Lightbulbs
		if (arr[n]==1) {
			arr[n]=0;
		} else {
			arr[n] = 1;
		}
	}
	
	static void switchLight(int student, int num) { // Do Something (It Depends on Student and Number They Have)
		if (student == 1) {
			for (int i=1;i*num<=N;i++) {
				toggle(i*num);
			}
		} else {
			int i =1;
			while (num-i>=1 && num+i<=N) {
				if (arr[num-i]==arr[num+i]) {
					i++;
				}
				else {
					break;
				}
			}
			i--;
			for (int j=num-i;j<=num+i;j++) {
				toggle(j);
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int student = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			switchLight(student,num);
		}
		for (int i=1;i<N+1;i++) {
			if(i%20==0) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i]+" ");
			}
	}
}
}
