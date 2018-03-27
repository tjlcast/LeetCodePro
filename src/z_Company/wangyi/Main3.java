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