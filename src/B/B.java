package B;

import java.util.*;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int parm[][] = new int[N + 1][N + 1];
		int max = Integer.MIN_VALUE;
		int arr[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {// 300 * 300
			for (int j = 1; j <= N; j++) {

				parm[i][j] = sc.nextInt();

			}
		}
		arr[1][1] = parm[1][1];
		for (int i = 2; i <= N; i++) {
			arr[1][i] += parm[1][i] + arr[1][i - 1];
		}
		for (int i = 2; i <= N; i++) {
			arr[i][1] += parm[i][1] + arr[i - 1][1];
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + parm[i][j];

			}
		}
		int x = 0;
		int y = 0;
		int r = 0;
		for (int row = 1; row < N + 1; row++) {
			for (int col = 1; col < N + 1; col++) {
				for (int rate = 1; (row - rate >= 0) && (col - rate >= 0); rate++) {
					int value = arr[row][col] - arr[row - rate][col] - arr[row][col - rate]
							+ arr[row - rate][col - rate];
					if (value > max)
						max = value;
						x = row;
						y=col;
						r= rate;
						
				}
			}
		}
		System.out.println(max);
	}

}
