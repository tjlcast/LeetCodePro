package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tangjialiang on 2017/8/21.
 */
public class Page_54 {
    /**
    *
    * 有关于树的遍历：先序遍历，中序遍历，后序遍历，宽度遍历
    * 以及对应的递归和非递归遍历。
    * 非递归遍历：    [先序 和 中序]先把树的左边界加入stack中，后 while{ 取一个，加入右分支 }
    *               [后序遍历]通过判断节点是否有访问过，如果没有访问过则该节点不进行pop，访问过则进行接收处理并pop
    *
    * */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7} ;
        TreeNode treeNode = TreeUtils.buildTreeFromArr(arr);
        new Page_54().traversal(treeNode);
    }

    public void traversal(TreeNode node) {
        List<Integer> work = new PreTraversal().work(node);
        for(Integer i : work) System.out.println(work) ;
    }

    class PreTraversal {
        LinkedList<Integer> ans = new LinkedList<>() ;

        List<Integer> work(TreeNode node) {
            notRecursion(node);
            return ans ;
        }

        void recursion(TreeNode node) {
            if (node != null) {
                ans.add(node.val) ;
                recursion(node.left);
                recursion(node.right);
            }
        }

        void notRecursion(TreeNode node) {
            ans.clear();
            if (node == null) return ;
            Stack<TreeNode> stack = new Stack<>() ;

            while(node != null) {
                stack.push(node) ;
                ans.add(node.val) ;
                node = node.left ;
            }


            while(!stack.isEmpty()) {
                TreeNode pop = stack.pop();

                if (pop.right!= null) {
                    TreeNode tempNode = pop.right ;
                    while(tempNode != null) {
                        stack.push(tempNode) ;
                        ans.add(tempNode.val) ;
                        tempNode = tempNode.left ;
                    }
                }
            }
        }

    }

    class InTraversal {
        LinkedList<Integer> ans = new LinkedList<>() ;

        List<Integer> work(TreeNode node) {
            notRecursion(node);
            return ans ;
        }

        void recursion(TreeNode node) {
            if (node != null) {
                recursion(node.left);
                ans.add(node.val) ;
                recursion(node.right);
            }
        }

        void notRecursion(TreeNode node) {
            ans.clear();
            if (node == null) return ;
            Stack<TreeNode> stack = new Stack<>() ;

            while(node != null) {
                stack.push(node) ;
                node = node.left ;
            }


            while(!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                ans.add(pop.val) ;

                if (pop.right!= null) {
                    TreeNode tempNode = pop.right ;
                    while(tempNode != null) {
                        stack.push(tempNode) ;
                        tempNode = tempNode.left ;
                    }
                }
            }
        }
    }

    class AfterTraversal {
        LinkedList<Integer> ans = new LinkedList<>() ;

        List<Integer> work(TreeNode node) {
            recursion(node);
            return ans ;
        }

        void recursion(TreeNode node) {
            if (node != null) {
                ans.add(node.val) ;
                recursion(node.left);
                recursion(node.right);
            }
        }

        void notRecursion(TreeNode node) {
            ans.clear();
            HashSet<TreeNode> isVisited = new HashSet<>() ;
            if (node == null) return ;
            Stack<TreeNode> stack = new Stack<>() ;
            
            while(node != null) {
                stack.push(node) ;
                node = node.left ;
            }
            
            while(!stack.isEmpty()) {
                TreeNode peek = stack.peek();

                if (isVisited.contains(peek)) {
                    stack.pop() ;
                    ans.add(peek.val) ;
                } else {
                    isVisited.add(peek) ;

                    TreeNode tempPtr = peek.right ;
                    while(tempPtr != null) {
                        stack.add(tempPtr) ;
                        tempPtr = tempPtr.left ;
                    }
                }

            }
        }
    }

    class BroadTraversal {
        LinkedList<Integer> ans = new LinkedList<>() ;

        List<Integer> work(TreeNode node) {
            if (node != null) notRecursion(node);
            return ans ;
        }


        List<Integer> notRecursion(TreeNode node) {
            LinkedList<TreeNode> q = new LinkedList<>() ;
            q.add(node) ;

            while(!q.isEmpty()) {
                TreeNode pop = q.pop();
                ans.add(pop.val) ;

                if (pop.left != null) q.add(pop.left) ;
                if (pop.right != null) q.add(pop.right) ;
            }
            return ans ;
        }
    }
}
