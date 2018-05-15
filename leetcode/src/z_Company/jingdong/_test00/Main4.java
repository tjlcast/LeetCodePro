package z_Company.jingdong._test00;

/**
 * Created by tangjialiang on 2018/5/12.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String query = sc.nextLine();
        String doc = sc.nextLine();
        int count = 0;
        Map<Character,List<Integer>> map = new HashMap<>();
        char[] chars = doc.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.get(chars[i]).add(i);
            }else{
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(chars[i],ls);
            }
        }

        char[] keywords = query.toCharArray();
        List<Integer> res = new LinkedList<Integer>();
        helper(keywords,0,map,res,0,0);
        if(res.size()==0){
            System.out.println(0);
        }else{
            int min = Integer.MAX_VALUE;
            for(int a:res){
                min = Math.min(min, a);
            }
            System.out.println(100-min);
        }
    }

    public static void helper(char[] keywords,int index,Map<Character,List<Integer>> map,List<Integer> ans,int lastIndex,int sum){
        if(index == keywords.length){
            ans.add(sum);
            return ;
        }
        if(map.containsKey(keywords[index])){
            List<Integer> ls = map.get(keywords[index]);
            ls.forEach(i->{
                if(i>lastIndex){
                    if(index==0){
                        helper(keywords,index+1,map,ans,i,sum);
                    }else{
                        helper(keywords,index+1,map,ans,i,sum+i-lastIndex-1);
                    }

                }
            });
        }

    }
}