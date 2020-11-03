package F;

import java.io.*;
import java.util.*;

public class Main {

	static int playerNum, limit, count, curLevel, next;
	static PlayerInfo player[];
	static LinkedList<PlayerInfo> list;
	static ArrayList room;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstInput[] = br.readLine().split(" ");
		playerNum = Integer.parseInt(firstInput[0]);
		limit = Integer.parseInt(firstInput[1]);
		count = 0;
		curLevel = 1;
		next = 0;
		player = new PlayerInfo[playerNum];
		list = new LinkedList<>();
		room = new ArrayList<>();
		for (int i = 0; i < playerNum; i++) {
			String secInput[] = br.readLine().split(" ");

			player[i] = new PlayerInfo(Integer.parseInt(secInput[0]), secInput[1]);
			list.add(player[i]);
		}
//이 부분 수정 -> for each 문 활용
		while (count < playerNum) {
			if (room.size() == 0)
				curLevel = list.get(next).getLevel();

			if (curLevel - 10 <= list.get(next).getLevel() && list.get(next).getLevel() <= curLevel + 10) {

				room.add(list.get(next));

				count++;
				list.remove(next);
			} else {
				next++;
			}
			if (room.size() == limit) {
				Collections.sort(room);
				System.out.println("Started!");
				for (int i = 0; i < room.size(); i++) {

					System.out
							.println(((PlayerInfo) room.get(i)).getLevel() + " " + ((PlayerInfo) room.get(i)).getId());
				}
				room.clear();
				next = 0;
				curLevel = 1;
			}
			else if (next == list.size()) {
				System.out.println("Waiting!");
				for (int i = 0; i < room.size(); i++) {

					System.out
							.println(((PlayerInfo) room.get(i)).getLevel() + " " + ((PlayerInfo) room.get(i)).getId());
				}
				room.clear();
				next = 0;
				curLevel = 1;
			}

		}
	}

}

class PlayerInfo implements Comparable<Object> {

	private int level;
	private String id;

	public PlayerInfo(int level, String id) {
		this.level = level;
		this.id = id;
	}

	public int getLevel() {
		return this.level;
	}

	public String getId() {
		return this.id;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return id.compareTo(((PlayerInfo) o).id);

	}
}
