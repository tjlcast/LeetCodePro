package z_Company.wangyi;

/**
 * Created by tangjialiang on 2018/3/27.
 */
import java.util.* ;

/**
3 3
10 1000
1 100
1000000000 1001
9 10 1000000000
 */

public class Main3 {

    public static void main(String[] args) {
        solution2() ;
    }

    /**
     * by tjlcast
     *
     * sort cost and max profit
     * binearySearch on cost to get max profit.
     */
    public static void solution2() {
        Scanner sc = new Scanner(System.in) ;
        int works = sc.nextInt() ;
        int friends = sc.nextInt() ;
        int[] abilities = new int[friends] ;
        int[][] arr = new int[works][2] ;

        for(int i=0; i<works; i++) {
            int cost = sc.nextInt() ;
            int val = sc.nextInt() ;

            arr[i][0] = cost ;
            arr[i][1] = val ;
        }

        for(int i=0; i<works; i++) {
            abilities[i] = sc.nextInt() ;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int localMax = 0 ;
        for(int i=0; i<works; i++) {
            arr[i][1] = (localMax = Math.max(localMax, arr[i][1])) ;
        }

        for(int i=0; i<friends; i++) {
            int ability = abilities[i] ;

            int l=0, r=works-1;
            while(l<r) {
                int mid = ((r-l)>>1) + l + 1 ;
                if (arr[mid][0] == ability) {
                    break ;
                } else if (arr[mid][0] > ability) {
                    r = mid-1 ;
                } else {
                    l = mid ;
                }
            }
            System.out.println(arr[r][1]) ;
        }
    }

    /**
     * by cc
     *
     * sort cost and max profit
     * binearySearch on cost to get max profit.
     *
     * (better use TreeMap, the key of ts is sorted and could use bs on it's key. )
     */
    public static void solution1() {
        Scanner sc = new Scanner(System.in);
        int works = sc.nextInt();
        int friends = sc.nextInt();
        int[] Ai = new int[friends];
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i=0;i<works;i++){
            int key = sc.nextInt();
            int val = sc.nextInt();
            if(map.containsKey(key)){
                int v1 = map.get(key);
                v1 = Math.max(v1, val);
                map.put(key, v1);
            }else{
                map.put(key, val);
            }
        }

        for(int i=0;i<friends;i++){
            Ai[i] = sc.nextInt();
        }

        int currMax = 0;

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            currMax = Math.max(currMax, val);
            map.put(key, currMax);
        }

        for(int i:Ai){
            Map.Entry<Integer, Integer> e = map.floorEntry(i);
            if(e==null)
                System.out.println(0);
            else
                System.out.println(e.getValue());
        }
    }

}