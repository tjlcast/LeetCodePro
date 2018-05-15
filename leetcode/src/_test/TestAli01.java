package _test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by tangjialiang on 2018/5/11.
 */
public class TestAli01 {

    final static int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    } ;

    

    public static void main(String[] args) {
        HashMap<State, State> stepRecorders = new HashMap<>() ;

        Scanner scanner = new Scanner(System.in) ;
        int sR, sC, sD ;
        int lR, lC, lD ;

        String s = scanner.nextLine();
        String[] split = s.split(" ");
        sR = Integer.parseInt(split[0]) ;
        sC = Integer.parseInt(split[1]) ;
        if (split[2].equals("EAST")) {
            sD = 0 ;
        } else if (split[2].equals("NORTH")) {
            sD = 1 ;
        } else if (split[2].equals("EAST")) {
            sD = 2 ;
        } else {
            sD = 3 ;
        }

        s = scanner.nextLine() ;
        String[] split1 = s.split(" ") ;
        lR = Integer.parseInt(split1[0]) ;
        lC = Integer.parseInt(split1[1]) ;
        if (split[2].equals("EAST")) {
            lD = 0 ;
        } else if (split[2].equals("NORTH")) {
            lD = 1 ;
        } else if (split[2].equals("EAST")) {
            lD = 2 ;
        } else {
            lD = 3 ;
        }

        s = scanner.nextLine() ;
        int rows, cols ;
        String[] split2 = s.split(" ");
        rows = Integer.parseInt(split2[0]) ;
        cols = Integer.parseInt(split2[1]) ;

        int[][] map = new int[rows][cols] ;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = scanner.nextInt() ;
            }
        }

        LinkedList<State> queue = new LinkedList<>() ;
        State root = new State();
        State state = new State(sR, sC, sD, root);
        queue.add(state) ;
        stepRecorders.put(state, root) ;

        State pop = null ;
        while (!queue.isEmpty()) {
            pop = queue.pop();
            int curR = pop.x ;
            int curC = pop.y ;
            int curD = pop.d ;

            if (pop.x==lR && pop.y==lC && pop.d==lD) {
                break ;
            }

            int newR = pop.x + directions[pop.d][0] ;
            int newC = pop.y + directions[pop.d][1] ;

            if (newR<0 || newC<0 || newR>=rows || newC>=cols || map[newR][newC]==1) continue;

            for (int i = 0; i < directions.length; i++) {
                queue.add(new State(newR, newC, i, pop)) ;
            }

        }

        if (pop == null) System.out.println(65535) ;
        else {
            Stack<State> stack = new Stack<>() ;
            while(pop != root) {
                stack.push(pop) ;
                pop = pop.p ;
            }

            for (State ansState: stack) {
                System.out.println(ansState) ;
            }
        }
    }

    static class State {
        int x ;
        int y ;
        int d ;

        State p ;

        public State() {}

        public State(int x, int y, int d, State p) {
            this.x = x ;
            this.y = y ;
            this.d = d ;
            this.p = p ;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", p=" + p +
                    '}';
        }
    }
}
