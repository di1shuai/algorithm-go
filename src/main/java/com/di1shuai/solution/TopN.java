package com.di1shuai.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Shea
 * @date 2021-01-17
 * @description
 */
public class TopN {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 前置校验
        if (arr.length <= k) {
            return arr;
        }
        int[] res = priorityQueue(arr, k);
        return res;
    }

    public int[] priorityQueue(int[] arr, int k) {
        //pq
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        // 构建前K个元素的pq
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        // 之后的元素与队首作比较，大于队首 -> 删除队首，新元素加入队列
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        //返回队列内的元素
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


    /**
     * 使用堆排序构建大根堆 寻找前K个元素
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] heap(int[] arr, int k) {
        // 构建前K个元素的大顶堆
        buildMaxHeap(arr, k);
        // 之后的元素如果比堆顶a[0]小，就替换堆顶，并让新的堆顶下沉有序化
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                swap(arr, i, 0);
                heapify(arr, 0, k);
            }
        }
        // 返回堆
        int[] res = Arrays.copyOf(arr, k);
        return res;
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private void buildMaxHeap(int[] arr, int n) {
        for (int i = n >> 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    private void heapify(int[] arr, int i, int n) {
        //比较孩子节 获取大值
        int lagest = i;
        int lChild = (i << 1) + 1;
        int rChild = (i + 1) << 1;

        if (lChild < n && arr[lChild] > arr[lagest]) {
            lagest = lChild;
        }
        if (rChild < n && arr[rChild] > arr[lagest]) {
            lagest = rChild;
        }
        //最大值为孩子，则下沉交换
        if (lagest != i) {
            // 下沉 交换
            swap(arr, lagest, i);
            // 递归
            heapify(arr, lagest, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        int k = 2;
        System.out.println("原数组");
        Arrays.stream(arr).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
        System.out.println("k -> " + k);

        TopN topN = new TopN();
        int[] leastNumbers = topN.getLeastNumbers(arr, k);
        System.out.println("结果");
        Arrays.stream(leastNumbers).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

}
