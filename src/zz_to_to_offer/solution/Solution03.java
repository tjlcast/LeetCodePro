package zz_to_to_offer.solution;

import Type.TreeNode;
import java.util.* ;
import java.io.* ;

/**
 * Created by tangjialiang on 2018/3/26.
 */
public class Solution03 {

    public static void main(String[] args) throws IOException {
        String iStr1 = null ;
        String iStr2 = null ;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        iStr1 = br.readLine() ;
        iStr2 = br.readLine() ;

        int[] pre = Arrays.stream(iStr1.split(",")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int[] in = Arrays.stream(iStr2.split(",")).mapToInt(x -> Integer.parseInt(x)).toArray();

        Solution03 sol = new Solution03() ;
        TreeNode treeNode = sol.reConstructBinaryTree(pre, in);

        printTreeIn(treeNode);
    }

    /*
    *
    * 1,2,4,7,3,5,6,8
    * 4,7,2,1,5,3,8,6
    * */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return build(pre, 0, in, 0, pre.length) ;
    }

    private TreeNode build(int[] pre, int s1, int[] in, int s2, int len) {
        if (len <= 0) return null ;
        if (len == 1) return new TreeNode(pre[s1]) ;

        int val = pre[s1] ;
        TreeNode node = new TreeNode(val) ;

        int idx = s2 ;
        while(in[idx]!=val) {idx++;}
        int len1 = idx - s2 ;
        int len2 = len - len1 - 1 ;

        node.left = build(pre, s1+1, in, s2, len1) ;
        node.right = build(pre, s1+len1+1, in, idx+1, len2) ;

        return node ;
    }

    public static void printTreeIn(TreeNode root) {
        if (root == null) return ;

        printTreeIn(root.left);
        System.out.print(root.val + " ") ;
        printTreeIn(root.right);
    }

    public static void printArray(int[] arr) {
        for(int t : arr) {
            System.out.print(t + " ") ;
        }
        System.out.println() ;
    }
}
