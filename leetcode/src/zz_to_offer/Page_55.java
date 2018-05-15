package zz_to_offer;

import Type.TreeNode;
import Utils.TreeUtils;

/**
 * Created by tangjialiang on 2017/8/21.
 */
public class Page_55 {

    /**
     *
     * 更具先序遍历和中序遍历的数组来重新建立二叉树结构
     *
     */

    public static void main(String[] args) {
        int[] preTravel = {1, 2, 4, 7, 3, 5, 6, 8} ;
        int[] inTravel = {4, 7, 2, 1, 5, 3, 8, 6} ;
        TreeNode work = new Page_55().work(preTravel, inTravel);

        System.out.println("preTravel:") ;
        TreeUtils.preTravel(work);
        System.out.println("inTravel:") ;
        TreeUtils.inTravel(work);
    }

    public TreeNode work(int[] preTravel, int[] inTravel) {
        return new MySolution().buildTreeFromTraversal(preTravel, inTravel) ;
    }

    class MySolution {
        public TreeNode buildTreeFromTraversal(int[] preTravel, int[] inTravel) {
            return buildTreeNode(preTravel, 0, inTravel, 0, inTravel.length) ;
        }

        private TreeNode buildTreeNode(int[] preTravel, int aPos, int[] inTravel, int bPos, int len) {
            if (len <= 0) return null ;
            int v = preTravel[aPos] ;

            TreeNode node = new TreeNode(v) ;
            if (len == 1) return node ;

            int tempPos = bPos ;
            while(inTravel[tempPos] != v) {
                tempPos += 1 ;
            }

            node.left = buildTreeNode(preTravel, aPos+1, inTravel, bPos, tempPos-bPos) ;
            node.right = buildTreeNode(preTravel, aPos+1+tempPos-bPos,  inTravel, tempPos+1, len-1-(tempPos-bPos)) ;

            return node ;
        }
    }
 }
