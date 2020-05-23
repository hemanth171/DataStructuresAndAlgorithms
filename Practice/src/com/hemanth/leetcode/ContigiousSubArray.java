package com.hemanth.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContigiousSubArray {

    public int contigiousArray(int[] nums) {
        int start_index = 0;
        int end_index = 0;
        int tmp_cnt = 0;
        int max = 0;
        int arr_len = nums.length;

        for (int i=0; i<arr_len; i++) {
            start_index = i;
            end_index = start_index;
            tmp_cnt = 0;

            while(end_index < arr_len) {
                if (nums[end_index] == 0) {
                    tmp_cnt++;
                } else {
                    tmp_cnt--;
                }

                if (tmp_cnt == 0) {
                    int len = (end_index - start_index) + 1;
                    if (len > max) {
                        max = len;
                    }
                } else {
                    if (Math.abs(tmp_cnt) - ((arr_len - end_index) - 1) > 0) {
                        break;
                    }
                }

                end_index++;
            }
        }

        return max;
    }

    public int findSums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
//        int[] arr = {0,0,1,0,0,0,1,1};
//        int[] arr = {1,0,1,0,1,1,0,1,1,1};
        int[] arr = {1,0,0,0,0,1,1,1,0,0};
        ContigiousSubArray contigiousSubArray = new ContigiousSubArray();
        System.out.println(contigiousSubArray.contigiousArray(arr));
    }
}
