package C;

import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long denominator[] = new long[N];// 분모
		long numerator[] = new long[N];// 분자
		long lcm = 0;
		long gcd = 0;

		for (int i = 0; i < N; i++) {
			numerator[i] = sc.nextInt();
			denominator[i] = sc.nextInt();
			long gcdAB = 0;
			gcdAB = getGCD(numerator[i], denominator[i]);
			numerator[i] /= gcdAB;
			denominator[i] /= gcdAB;
		}
		lcm = getLCM(denominator);
		gcd = getGCD(numerator);
		System.out.println(gcd + " "+ lcm);


	}

	public static long getGCD(long num1, long num2) {
		if (num1 % num2 == 0)
			return num2;
		else
			return getGCD(num2, num1 % num2);
	}

	public static long getGCD(long[] arr) {
		if (arr.length < 2) {
			return arr[0];
		}
		long result = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			result = getGCD(result, arr[i]);
		}
		return result;
	}

	public static long getLCM(long num1, long num2) {
		return num1 * num2 / getGCD(num1, num2);
	}

	public static long getLCM(long[] arr) {
		if (arr.length < 2) {
			return arr[0];
		}
		long result = arr[0];
		for (int i = 1; i < arr.length; ++i) {
			result = getLCM(result, arr[i]);
		}
		return result;
	}

}
