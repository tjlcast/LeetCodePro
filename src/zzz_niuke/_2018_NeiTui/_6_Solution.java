package zzz_niuke._2018_NeiTui;

import java.io.* ;
import java.util.* ;

public class _6_Solution {

    // merge find set
    class Edge implements Comparable<Edge> {
        int aPos ;
        int bPos ;
        int edge ;

        public Edge(int aPos, int bPos, int edge) {
            this.aPos = aPos ;
            this.bPos = bPos ;
            this.edge = edge ;
        }

        @Override
        public int compareTo(Edge e) {
            return edge - e.edge ;
        }
    }

    private int[] rows = null ;
    private int[] cols = null ;
    private int len = -1 ;

    private HashSet<Integer> visited = new HashSet<Integer>() ;
    private HashSet<Integer> unVisited = new HashSet<Integer> () ;
    private PriorityQueue<Edge> edges = new PriorityQueue<>() ;

    private int[] ans = null ;

    public String work(int len, int[] rows, int[] cols) {
        int count = 0 ;
        int step = 0 ;

        this.rows = rows ;
        this.cols = cols ;
        this.len = len ;

        ans = new int[len] ;


        for(int i=0; i<len; i++) {
            unVisited.add(i) ;
            for(int j=i+1; j<len; j++) {
                edges.add(new Edge(i, j, distance(i, j))) ;
            }
        }

        if (!edges.isEmpty()) {
            Edge poll = edges.poll();
            unVisited.remove(poll.aPos) ;
            unVisited.remove(poll.bPos) ;

            visited.add(poll.aPos);
            visited.add(poll.bPos) ;

            step += poll.edge ;
            ans[count++] = step ;
        }

        while(!edges.isEmpty()) {
            Edge poll = edges.poll();

            if (unVisited.contains(poll.aPos) && visited.contains(poll.bPos)) {
                unVisited.remove(poll.aPos) ;
                visited.add(poll.bPos) ;

                step += poll.edge ;
                ans[count++] = step ;
            }

            if (unVisited.contains(poll.bPos) && visited.contains(poll.aPos)) {
                unVisited.remove(poll.bPos) ;
                visited.add(poll.aPos) ;

                step += poll.edge ;
                ans[count++] = step ;
            }

        }

        return l2S(ans) ;
    }

    private int distance(int i, int j) {
        return Math.abs(rows[i]-rows[j]) + Math.abs(cols[i]-cols[j]) ;
    }

    private String l2S(int[] nums) {
        StringBuilder sb = new StringBuilder() ;
        for(int i=0; i<nums.length; i++) sb.append(nums[i]+" ") ;
        return sb.toString().trim() ;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;

        String i1 = br.readLine() ;
        String i2 = br.readLine() ;
        String i3 = br.readLine() ;

        int len = Integer.parseInt(i1) ;
        String[] i2_ = i2.split(" ") ;
        int[] rows = new int[len] ; for(int i=0; i<len; i++) rows[i] = Integer.parseInt(i2_[i]) ;
        String[] i3_ = i3.split(" ") ;
        int[] cols = new int[len] ; for(int i=0; i<len; i++) cols[i] = Integer.parseInt(i3_[i]) ;

        _6_Solution main = new _6_Solution() ;
        String res = main.work(len, rows, cols) ;

        System.out.println(res) ;

    }
}