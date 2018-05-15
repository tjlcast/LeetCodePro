package _test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by tangjialiang on 2018/3/23.
 */
public class TestAli {
    /**
     * 小明中午路过一家公共停车场，出于程序员的职业习惯，他很想知道这个停车场上午的最大化利用率有多少。经与门卫大叔沟通，他获得了该停车场上午车辆入场时间与出场时间的记录表（数据格式参考样例输入），你能通过拿到的数据写一个函数快速的帮小明算出这家停车场，上午最多的时候同时停放了多少辆车吗？要求时间复杂度不高于：O(n)*lgN

     注意事项：
     1、为方便起见，简化计算，驶入时间和开出时间以整点记录，如9点，10点。
     2、如停车记录中入场时间晚于出场时间，该停车记录视为无效，如7,3
     3、假定如果有多辆车同时出入场，出场车辆优先。

     样例输入：
     8,9;4,6;3,7;6,8 （车辆以分号分隔，车辆入场和出场时间以逗号分隔）
     样例输出：
     2
     */

    static class Main {

        private static final String carSplit =";";
        private static final String timeSplit =",";
        private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";

        public static void main(String[] args) {
            String inString = null;
            // 数据输入
            Scanner in = new Scanner(System.in);
            inString = in.nextLine();
            //字符串数组格式校验
            Pattern pat = Pattern.compile(regress);
            if(inString == null || inString.trim().equals("")||!pat.matcher(inString).matches()){
                System.out.println("输入错误!");
                return;
            }
            Main sol = new Main();
            int countCars = sol.countCars(sol.convertToArray(inString));
            System.out.println(countCars);
        }

        //输入字符串转数组
        public int[][] convertToArray(String str) {
            String[] strArray = str.split(carSplit);
            int row = strArray.length;
            int col = 2;
            // 字符转数组判断
            int[][] carArray = new int[row][col];
            int start,end;
            for (int i = 0; i < row; i++) {
                start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
                end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
                if(start>end){
                    continue;
                }
                carArray[i][0] = start;
                carArray[i][1] = end;
            }
            return carArray;
        }
        //核心算法实现
        public int countCars(int[][] carArray) {
            int ans = 0;
            List<helper> ls = new LinkedList<helper>();
            for(int[] time:carArray){
                ls.add(new helper(time[0],time[1]));
            }
            Collections.sort(ls);
            Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
            Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();

            for(helper h:ls){
                for(int i=h.in;i<h.out;i++){
                    if(map1.containsKey(i)&&!map2.containsKey(i)){
                        map1.put(i, map1.get(i)+1);
                    }else if(!map1.containsKey(i)){
                        map1.put(i, 1);
                    }else{

                    }
                }
                map2.put(h.out, 1);
            }

            for(Map.Entry<Integer, Integer> en:map1.entrySet()){
                ans = Math.max(ans, en.getValue());
            }
            return ans; // 返回计算结果
        }
    }

    static class helper implements Comparable<helper> {
        @Override
        public int compareTo(helper arg0) {
            if (in == arg0.in) return out - arg0.out;
            return in - arg0.in;
        }

        public int in, out;

        public helper(int a1, int a2) {
            in = a1;
            out = a2;
        }
    }
}
