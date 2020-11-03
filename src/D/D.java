package D;

import java.util.*;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();

		for (int i = 1; i <= A; i++) {
			if(31 % (i+1) == 1) System.out.println(i);
		}
	}

}
