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

			if (temp.equals("������ ����� ����")) {
				continue;
			} else if (temp.equals("����")) {
				questions++;
				continue;
			} else if (temp.equals("������")) {
				if (questions != 0) {
					questions--;
				} else if (questions == 0) {
					questions += 2;

				}
				continue;
			} else if (temp.equals("������ ����� ��")) {
				if (questions == 0) {
					bw.write("�������� �����");
					break;
				} else {
					bw.write("����");
					break;
				}

			}
		}
		bw.close();

	}

}
