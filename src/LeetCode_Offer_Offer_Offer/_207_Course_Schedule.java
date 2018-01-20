package LeetCode_Offer_Offer_Offer;

import java.util.*;

/**
 * Created by tangjialiang on 2018/1/18.
 */
public class _207_Course_Schedule {

    public static void main(String[] args) {
        int numCourses = 3 ;
        int[][] prerequisites = {
                {1, 0},
                {1, 2},
                {0, 1}
        } ;

        Solution solution = new Solution();
        boolean b = solution.canFinish(numCourses, prerequisites);

        System.out.println("The work is; " + b) ;
    }

    static class Solution {
        /**
         * There are a total of n courses you have to take, labeled from 0 to n - 1.

         Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

         Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

         For example:

         2, [[1,0]]
         There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

         2, [[1,0],[0,1]]
         There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

         Note:
         The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
         You may assume that there are no duplicate edges in the input prerequisites.
         * @param numCourses
         * @return
         */
        public boolean canFinish(int numCourses,  int[][] prerequisites) {
            class Course implements Comparable<Course>{
                int lab;
                List<Course> inLinks = new LinkedList<>() ;
                List<Course> outLinks = new LinkedList<>() ;

                public Course(int lab) {
                    this.lab = lab ;
                }

                @Override
                public int compareTo(Course o) {
                    return  this.outLinks.size() - o.outLinks.size();
                }
            }

            Course[] courses = new Course[numCourses] ;
            for(int i=0; i<numCourses; i++)
                courses[i] = new Course(i) ;

            for(int i=0; i<prerequisites.length; i++) {
                int[] prerequisite = prerequisites[i];
                int a = prerequisite[0] ;
                int b = prerequisite[1] ;
                courses[b].inLinks.add(courses[a]) ;
                courses[a].outLinks.add(courses[b]) ;
            }

            LinkedList<Course> pQueue = new LinkedList<>() ;
            for(Course c : courses)
                if (c.outLinks.size() == 0)
                    pQueue.add(c) ;

            int count = 0 ;
            while(!pQueue.isEmpty()) {
                Course curCourse = pQueue.poll();
                count++ ;

                int lab = curCourse.lab;
                for(Course c : curCourse.inLinks) {
                    c.outLinks.remove(curCourse) ;
                    if (c.outLinks.size() == 0) pQueue.add(c) ;
                }
            }

            return count == numCourses ;
        }
    }
}
