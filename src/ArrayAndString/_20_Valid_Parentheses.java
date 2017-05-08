package ArrayAndString;

import java.util.LinkedList;

public class _20_Valid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()";
		boolean work = new _20_Valid_Parentheses().work(s);
		System.out.println(work);
	}

	public boolean work(String s) {
		return new Solution().isValid(s);
	}

	public class Solution {
		public boolean isValid(String s) {
			LinkedList<Character> stack = new LinkedList<Character>();

			for (int i = 0; i < s.length(); i++) {
				Character c = new Character(s.charAt(i));
				Character topC = stack.pollLast();
				
				if (topC == null) {
					stack.add(c) ;
					continue ;
				}
				
				if (!isCouple(c, topC)) {
					stack.add(topC);
					stack.add(c);
				}

			}

			if (stack.isEmpty())
				return true;
			return false;
		}

		private boolean isCouple(Character c2, Character c1) {
			if (c1.equals('(') && c2.equals(')'))
				return true;
			if (c1.equals('{') && c2.equals('}'))
				return true;
			if (c1.equals('[') && c2.equals(']'))
				return true;
			return false;
		}
	}

}
