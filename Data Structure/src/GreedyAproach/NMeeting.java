package GreedyAproach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Meeting {
	int start;
	int end;
	int index;

	Meeting(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}
}

class meetingComparator implements Comparator<Meeting> {

	@Override
	public int compare(Meeting o1, Meeting o2) {
		// TODO Auto-generated method stub
		if (o1.end < o2.end)
			return -1;
		else if (o1.end > o2.end)
			return 1;
		return 0;
	}

}

public class NMeeting {
	public static void main(String[] args) {
		int n = 6;
		// Start times
		int s[] = { 1, 2, 0, 6, 9, 10 };
		// Finish times
		int f[] = { 3, 5, 7, 8, 11, 12 };
		maxMeetings(s, f, n);
	}

	private static void maxMeetings(int[] start, int[] end, int n) {
		// TODO Auto-generated method stub
		ArrayList<Meeting> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Meeting m = new Meeting(start[i], end[i], i);
			list.add(m);
		}
		Collections.sort(list, new meetingComparator());
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(list.get(0).index);
		int prev = list.get(0).end;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).start > prev) {
				ans.add(list.get(i).index);
				prev=list.get(i).end;
			} 
		}
		System.out.println(list.size());
	}
}
