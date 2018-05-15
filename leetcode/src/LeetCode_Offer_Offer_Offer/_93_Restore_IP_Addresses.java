package LeetCode_Offer_Offer_Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tangjialiang on 2017/9/20.
 */
public class _93_Restore_IP_Addresses {
    /**
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

     For example:
     Given "25525511135",

     return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     */

    public static void main(String[] args) {
        String s = "010010" ;

        _93_Restore_IP_Addresses restore_ip_addresses = new _93_Restore_IP_Addresses();
        List<String> work = restore_ip_addresses.work(s);

        System.out.println("work is: ") ;
        for(String str : work) {
            System.out.println(str) ;
        }
    }

    public List<String> work(String s) {
        Solution solution = new Solution();
        List<String> strings = solution.restoreIpAddresses(s);

        return strings ;
    }

    class Solution {
        private String s = null ;
        private int len = -1 ;
        private LinkedList<String> ans = new LinkedList<>() ;

        public List<String> restoreIpAddresses(String s) {
            this.s = s ;
            this.len = s.length() ;

            if (s.length() > 12) return ans ;

            generateIP(0, new LinkedList<String>()) ;

            return ans ;
        }

        private void generateIP(int pos, LinkedList<String> ip) {
            // System.out.format("pos is: %d\n", pos) ;

            if (pos >= len && ip.size()==4) {
                StringBuilder ipStr = new StringBuilder() ; ipStr.append(ip.get(0)) ;
                for(int j=1; j<ip.size(); j++) ipStr.append("."+ip.get(j)) ;
                ans.add(ipStr.toString()) ;
            }

            int i=pos ;
            int count = 0 ;
            while(i<len && i<=pos+2) {
                if (i!=pos && count==0 ) return ;

                count = count*10 + (s.charAt(i)-'0') ;

                if (count <= 255) {
                    ip.add(s.substring(pos, i + 1)) ;
                    generateIP(i+1, ip) ;
                    ip.removeLast() ;
                }

                i++ ;
            }

        }
    }
}
