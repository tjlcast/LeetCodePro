package LeetCode_Offer_Offer_Offer;

import java.util.* ;

/**
 * Created by tangjialiang on 2018/1/21.
 */
public class _210_Course_Schedule_II {

    public static void main(String[] args) {
        int numCourses = 4 ;
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        } ;

        Solution sol = new Solution() ;
        int[] res = sol.findOrder(numCourses, prerequisites) ;

        System.out.println("The work is: ") ;
        for(Integer r : res) {
            System.out.println(r) ;
        }
    }

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            CourseNode[] courses = new CourseNode[numCourses] ;
            int[] ans = new int[numCourses] ;
            LinkedList<CourseNode> queue = new LinkedList<>() ;

            for(int i=0; i<numCourses; i++) {
                courses[i] = new CourseNode(i) ;
            }

            for(int i=0; i<prerequisites.length; i++) {
                int a = prerequisites[i][0] ;
                int b = prerequisites[i][1] ;

                courses[a].outLinks.add(courses[b]) ;
                courses[b].inLinks.add(courses[a]) ;
            }

            for(CourseNode course : courses) {
                if(course.noOutLink()) queue.add(course) ;
            }

            int total = 0 ;
            while(!queue.isEmpty()) {
                CourseNode pollCourse = queue.poll();
                ans[total++] = pollCourse.lab ;

                for(CourseNode node : pollCourse.inLinks) {
                    node.removeOutLinkCourse(pollCourse);
                    if (node.noOutLink()) queue.add(node) ;
                }
            }

            if(total != numCourses) {
                ans = new int[0] ;
            }
            return ans ;
        }

        class CourseNode {
            int lab ;
            List<CourseNode> inLinks = new LinkedList<>() ;
            List<CourseNode> outLinks = new LinkedList<>() ;

            public CourseNode(int lab) {
                this.lab = lab ;
            }

            public void removeOutLinkCourse(CourseNode courseNode) {
                this.outLinks.remove(courseNode) ;
            }

            public boolean noOutLink() {
                return this.outLinks.isEmpty() ;
            }

            public boolean noInLink() {
                return this.inLinks.isEmpty() ;
            }
        }
    }
}
