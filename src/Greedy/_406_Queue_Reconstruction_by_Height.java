package Greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class _406_Queue_Reconstruction_by_Height {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		int[][] res = new _406_Queue_Reconstruction_by_Height().work(people);
		for(int[] per : res) {
			System.out.println(per[0]+" "+per[1]);
		}
	}

	int[][] work(int[][] people) {
		return new Solution().reconstructQueue(people);
	}

	class Solution {
		public int[][] reconstructQueue(int[][] people) {

			Arrays.sort(people, (x, y) -> (x[0] == y[0]) ? (x[1] - y[1]) : (y[0] - x[0]));

			LinkedList<int[]> list = new LinkedList<int[]>();

			for (int[] person : people) {
				int score = person[1];
				int rank = (list.size() != 0) ? (score % (list.size() + 1)) : (0); // attention
																					// !!
																					// size+1

				list.add(rank, person);
			}

//			for (int i=0; i < list.size(); i++) {    // attention ,容器中存储的是对象的指针
//				people[i][0] = list.get(i)[0];
//				people[i][1] = list.get(i)[1];
//			}
			int[][] res = new int[people.length][2] ;
			for (int i=0; i < list.size(); i++) {
				res[i][0] = list.get(i)[0];
				res[i][1] = list.get(i)[1];
		}
			
			return res;
		}
	}
}
