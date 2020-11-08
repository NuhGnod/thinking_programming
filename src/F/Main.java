package F;

import java.io.*;
import java.util.*;

public class Main {

	static int playerNum, limit, count, curLevel, next;
	static PlayerInfo player[];
	static LinkedList<PlayerInfo> list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String firstInput[] = br.readLine().split(" ");
		playerNum = Integer.parseInt(firstInput[0]);
		limit = Integer.parseInt(firstInput[1]);
		count = 0;
		curLevel = 1;
		next = 0;
		player = new PlayerInfo[playerNum];

		ArrayList<LinkedList<PlayerInfo>> rooms = new ArrayList();

		for (int i = 0; i < playerNum; i++) {
			String secInput[] = br.readLine().split(" ");
			int level = Integer.parseInt(secInput[0]);
			String id = secInput[1];
			boolean isFind = false;
			for (LinkedList<PlayerInfo> roomList1 : rooms) {
				if (roomList1.size() >= limit) {
					continue;
				}
				int standard = roomList1.peek().getLevel();
				if (standard - 10 <= level && level <= standard + 10) {
					isFind = true;
					roomList1.add(new PlayerInfo(level, id));
					break;
				}

			}
			if (!isFind) {
				LinkedList<PlayerInfo> roomList = new LinkedList<>();
				roomList.add(new PlayerInfo(level, id));
				rooms.add(roomList);
			}

		}
		for (LinkedList<PlayerInfo> room : rooms) {
			bw.write(room.getClass().toString());
			Collections.sort(room);
			if (room.size() == limit) {
				bw.write("Started!\n");
			} else {
				bw.write("Waiting!\n");
			}
			while (!room.isEmpty()) {
				PlayerInfo info = room.poll();
				bw.write(info.getLevel() + " " + info.getId() + "\n");
			}
		}
		bw.flush();
//이 부분 수정 -> for each 문 활용

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
