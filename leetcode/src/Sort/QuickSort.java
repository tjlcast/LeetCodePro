package Sort;

import java.util.Scanner;

/**
 * Created by tangjialiang on 2018/3/30.
 */
public class QuickSort {

    interface Solution {
        void sort(int[] arr) ;
    }

    static class Solution2 implements Solution {

        @Override
        public void sort(int[] arr) {
            sort(arr, 0, arr.length-1);
        }

        private void sort(int[] arr, int l, int r) {
            if (l >= r) return ;

            int pivot = arr[l] ;
            int i = l ;
            int j = l + 1 ;

            while(j <= r) {
                if (arr[j] <= pivot) {
                    i++ ;
                    swap(arr, i, j) ;
                    j++ ;
                } else {
                    j++ ;
                }
            }
            swap(arr, l, i);

            sort(arr, l, i-1);
            sort(arr, i+1, r);
        }

        private void swap(int[] arr, int i, int j) {
            if (i<0 || j<0) return ;
            if (i>=arr.length || j>=arr.length) return ;

            int tmp = arr[i] ;
            arr[i] = arr[j] ;
            arr[j] = tmp ;
        }
    }

    static class Solution1 implements Solution {
        @Override
        public void sort(int[] arr) {
            sort(arr, 0, arr.length-1);
        }

        private void sort(int[] arr, int l, int r) {
            if (l>=r) return ;

            int pivot = arr[l] ;
            int i = l ;
            int j = r ;

            while(i < j) {
                while(i<j && pivot<=arr[j]) j-- ;
                arr[i] = arr[j] ;
                while(i<j && pivot>=arr[i]) i++ ;
                arr[j] = arr[i] ;
            }
            arr[i] = pivot ;

            sort(arr, l, i-1);
            sort(arr, i+1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt() ;
        int[] arr = new int[n] ;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt() ;
        }

        Solution sol = new Solution2() ;
        sol.sort(arr);

        for (Integer i :
                arr) {
            System.out.print(i + " ") ;
        }
        System.out.println() ;
    }
}
