package com.sigom.Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class appArrays {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pQueue
//                = new PriorityQueue<Integer>((a, b) -> a - b);
//        pQueue.add(10);
//        pQueue.add(5);
//        pQueue.add(15);
//        pQueue.add(20);
//        pQueue.add(5);
//        pQueue.add(20);
//        System.out.println(pQueue.peek());
//        pQueue.poll();
//        System.out.println(pQueue.peek());
//        System.out.println(pQueue);
//        System.out.println("--------");

//         int[] val1 = {1,3,4,8,9};
//         int[] val2 = {1,2,5,7,9};
//         System.out.println(kSmallestPair(val1, val2, 3));

//        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
//        int k = 4;
//        int n = arr.length;
//        System.out.println(maxSum(arr, n, k));

        //int[] rating = {2, 1, 3};
        //showRating(rating);
 //       System.out.println(lengthOfLargeString("pwwkew"));
        System.out.println(minWindowForString("ABCDDDDDDEEAFFBC", "ABC"));

    }
    static Integer maxSum(int[] arr, int n, int k){
        int MAX_SUM = 0;
        if( n < k){
            return MAX_SUM;
        }
        for(int i = 0; i < k; i++) MAX_SUM += arr[i];
        int windowsSum = MAX_SUM;
        for (int i = k ; i < n ; i++){
            windowsSum += arr[i] - arr[i - k];
            MAX_SUM = Math.max(MAX_SUM, windowsSum);
        }
        return MAX_SUM;
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while( right < s.length() ){
            char r = s.charAt(right);
            chars[r]++;
            while (chars[r] > 1){
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    public static int lengthOfLargeString(String s){
        int res= 0;
        Map<Character, Integer> chars = new HashMap<>();
        for(int j=0, i=0; j < s.length(); j++){
           if(chars.containsKey(s.charAt(j))) {
               i = Math.max(chars.get(s.charAt(j)), i);
           }
           res = Math.max(res, j - i + 1);
           chars.put(s.charAt(j), j + 1);
        }
        return res;
    }
    public static void showRating(int[] rating) {

        int n = rating.length;
        int k = n;
        int target = k * -1;
        while (k > 0){

            k--;
        }
    }
    public static List<List<Integer>> kSmallestPair(int[] nu1, int[] nu2, int k){

        List<List<Integer>> retList= new ArrayList<>();
        // Base case
        if (nu1.length ==0 || nu2.length == 0 || k ==0) {
            return retList;
        }

        PriorityQueue<SumPair> queue = new PriorityQueue<>();
        /*
        Step-1 Initialize the heap of size nums1.length
        Add all the elements of nums1.length with first element of nums2
        */

        for (int i = 0 ; i < nu1.length && i < k; i++) {
            SumPair temp = new SumPair(i, 0, nu1[i] + nu2[0]);
            queue.add(temp);
        }

        // Iterate till k elements. In case the k is less than nums1.lengtth + nums2.length
        // then return elements till the end only.
        while (k > 0 && !queue.isEmpty()) {
            k--;
            SumPair elem = queue.poll();

            int i = elem.i;
            int j = elem.j;
            List<Integer> childList = new ArrayList<>();
            childList.add(nu1[i]);
            childList.add(nu2[j]);
            retList.add(childList);

            // if Nums2.length is equals j, then continue for next i;
            if (nu2.length == j+1) {
                continue;
            }

            // Add tthe next Jth element to the queue
            queue.add(new SumPair(i , j+1, nu1[i] + nu2[j+1]));
        }

        return retList;

    }
    static class SumPair implements Comparable<SumPair>{
        int i;
        int j;
        int sum;
        public SumPair(int i, int j, int sum){
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        @Override
        public int compareTo(SumPair o) {
            return Integer.compare(this.sum, o.sum);
        }

        @Override
        public String toString() {
            return "SumPair{" +
                    "i=" + i +
                    ", j=" + j +
                    ", sum=" + sum +
                    '}';
        }
    }
    static class Rating implements Comparable<Rating>{
        int elements;
        int value;
        List<Integer> group;

        public Rating(int i, int j, List<Integer> list){
            elements = i;
            value = j;
            group = list;
        }

        @Override
        public int compareTo(Rating o) {
            return Integer.compare(this.value,o.value);
        }
    }
    public static String minWindowForString(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            // Dictionary which keeps a count of all the unique characters in t.
            Map<Character, Integer> dictT = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            // Number of unique characters in t, which need to be present in the desired window.
            int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            // formed is used to keep track of how many unique characters in t
            // are present in the current window in its desired frequency.
            // e.g. if t is "AABC" then the window must have two A's, one B and one C.
            // Thus formed would be = 3 when all these conditions are met.
            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            // ans list of the form (window length, left, right)
            int[] ans = {-1, 0, 0};

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and contract the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done contracting.
                r++;
            }
            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            if (n < 3) return n;

            // sliding window left and right pointers
            int left = 0;
            int right = 0;
            // hashmap character -> its rightmost position
            // in the sliding window
            HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

            int max_len = 2;

            while (right < n) {
                // when the slidewindow contains less than 3 characters
                hashmap.put(s.charAt(right), right++);

                // slidewindow contains 3 characters
                if (hashmap.size() == 3) {
                    // delete the leftmost character
                    int del_idx = Collections.min(hashmap.values());
                    hashmap.remove(s.charAt(del_idx));
                    // move left pointer of the slidewindow
                    left = del_idx + 1;
                }

                max_len = Math.max(max_len, right - left);
            }
            return max_len;
    }
}
