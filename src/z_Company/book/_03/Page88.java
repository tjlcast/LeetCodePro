package z_Company.book._03;

import Type.TreeNode;
import com.sun.tools.javac.jvm.ByteCodes;

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.pop;

/**
 * Created by tangjialiang on 2018/4/3.
 */
public class Page88 {

    public static List inTravel(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>() ;
        Stack<TreeNode> stack = new Stack() ;

        TreeNode node = root ;
        while(node != null) {
            stack.push(node) ;
            node = node.left ;
        }

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            ans.addLast(pop.val);
            node = pop.right ;
            while(node != null) {
                stack.push(node) ;
                node = node.left ;
            }
        }

        return ans ;
    }

    public static List<Integer> beforeTravel(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>() ;
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode node = root ;

        while(node != null) {
            ans.add(node.val) ;
            stack.push(node) ;
            node = node.left ;
        }

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop() ;
            node = pop.right;
            while(node != null) {
                ans.add(node.val) ;
                stack.push(node) ;
                node = node.left ;
            }
        }

        return ans ;
    }

    public static List<Integer> afterTravel(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>() ;
        LinkedList<Integer> ans = new LinkedList<>() ;
        HashSet<TreeNode> hasVisited = new HashSet<>() ;
        TreeNode node = root ;

        while(node != null) {
            stack1.push(node) ;
            node = node.left ;
        }

        while(!stack1.isEmpty()) {
            TreeNode pop = stack1.peek();
            if (hasVisited.contains(pop)) {
                ans.add(pop.val) ;
                stack1.pop() ;
                continue;
            }
            hasVisited.add(pop) ;

            node = pop.right ;
            while(node != null) {
                stack1.push(node) ;
                node = node.left ;
            }
        }

        return ans ;
    }

    public static TreeNode buildTree(int[] arr, int idx) {
        if (idx<1 || idx>arr.length) return null ;

        TreeNode node = new TreeNode(arr[idx-1]) ;
        node.left = buildTree(arr, idx*2) ;
        node.right = buildTree(arr, idx*2+1) ;

        return node ;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6} ;
        TreeNode treeNode = buildTree(arr, 1);

        List<Integer> list = inTravel(treeNode);
        for (Integer n :
                list) {
            System.out.print(n + " ");
        }
        System.out.println();

        List<Integer> list2 = beforeTravel(treeNode);
        for (Integer n :
                list2) {
            System.out.print(n + " ");
        }
        System.out.println();

        List<Integer> list3 = afterTravel(treeNode);
        for (Integer n :
                list3) {
            System.out.print(n + " ");
        }
        System.out.println();
    }


}
