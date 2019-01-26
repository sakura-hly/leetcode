package com.sakura.leetcode.divideandconquer;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        // 第一步: 初始化大顶堆(从最后一个有子节点开始往上调整最大堆)
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        int count = 0;
        while (count++ < k) {
            // 第二步: 堆顶元素与最后一个元素交换，交换后堆长度减一
            int temp = nums[0];
            nums[0] = nums[nums.length - count];
            nums[nums.length - count] = temp;
            // 第三步: 重新调整堆。从顶点开始往下调整
            adjustHeap(nums, 0, nums.length - count);
        }

        return nums[nums.length - k];
    }

    private void adjustHeap(int[] nums, int i, int len) {
        int temp = nums[i];

        for (int k = 2 * i + 1; k < len; k = 2 * i + 1) {
            if (k + 1 < len && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInArray().findKthLargest(new int[]{3, 1, 2, 4}, 2));
    }
}
