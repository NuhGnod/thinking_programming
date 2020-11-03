package A;

import java.util.*;
import java.io.*;

public class A {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int questions = 0;

		while (true) {
			String temp = "";
			temp = br.readLine();

			if (temp.equals("고무오리 디버깅 시작")) {
				continue;
			} else if (temp.equals("문제")) {
				questions++;
				continue;
			} else if (temp.equals("고무오리")) {
				if (questions != 0) {
					questions--;
				} else if (questions == 0) {
					questions += 2;

				}
				continue;
			} else if (temp.equals("고무오리 디버깅 끝")) {
				if (questions == 0) {
					bw.write("고무오리야 사랑해");
					break;
				} else {
					bw.write("힝구");
					break;
				}

			}
		}
		bw.close();

	}

}
