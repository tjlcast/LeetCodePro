package z_Company.tencent;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/4/5.
 */
public class Main002 {

    private static final int N=100005;
    private static class node{
        int x,y;
    };
    private static class cmp implements Comparator<node> {
        @Override
        public int compare(node a,node b){
            if(a.x == b.x){
                if(a.y==b.y) return 0;
                return a.y<b.y?1:-1;
            }
            if(a.x==b.x) return 0;
            return a.x<b.x?1:-1;
        }
    }
    public static int book[]=new int[105];
    public static node s1[]=new node[N];
    public static node s2[]=new node[N];

    public static void main(String[] args){
        for(int i=0;i<N;i++){
            s1[i]=new node();
            s2[i]=new node();
        }
        int n,m,i,j,cnt;
        long sum;
        Scanner sc=new Scanner(new InputStreamReader(System.in));
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            for(i = 0; i<n; i++){
                s1[i].x=sc.nextInt();
                s1[i].y=sc.nextInt();
            }
            for(i = 0; i<m; i++){
                s2[i].x=sc.nextInt();
                s2[i].y=sc.nextInt();
            }
            Arrays.sort(s1,0,n,new cmp());
            Arrays.sort(s2,0,m,new cmp());
            sum=cnt=0;
            Arrays.fill(book,0);
            for(i=0,j=0;i<m;i++){
                while(j<n&&s1[j].x>=s2[i].x){
                    book[s1[j].y]++;
                    j++;
                }
                for(int k=s2[i].y;k<=100;k++){
                    if(book[k]>0){
                        book[k]--;
                        sum+=(s2[i].x*200+s2[i].y*3);
                        cnt++;
                        break;
                    }
                }
            }
            System.out.println(cnt+" "+sum);
        }
        sc.close();
    }

    public static void work(String[] args) {

    }
}
