package com.di1shuai.algorithm.sort.heap;

import com.di1shuai.algorithm.sort.AbstractSort;

/**
 * @author Shea
 * @date 2021-01-16
 * @description 堆排序
 * 主要分为两个步骤
 * 1 堆的构建
 * 2 将原数组分为两部分    堆 | 最值序列
 * 每次缩小堆的大小，将左侧最值移至右侧最值序列
 */
public class HeapSort extends AbstractSort {

    @Override
    public Comparable[] sort(Comparable[] array) {
        //构建堆
        buildMaxHeap(array);
        // 将原数组分为两部分 堆 | 最值序列
        int n = array.length;
        while (n > 1) {
            // 每次获取堆的最大值由右至左存放
            swap(array, 0, n - 1);
            // 使n-1的堆有序化 此时a[0] 存放原叶子节点的数据
            heapify(array, 0, --n);
        }
        return array;
    }

    /**
     * 构建堆
     *
     * @param array 原数组
     */
    private void buildMaxHeap(Comparable[] array) {
        int n = array.length;
        for (int i = n >> 1; i >= 0; i--) {
            heapify(array, i, n);
        }
    }

    /**
     * 堆有序化 下沉
     *
     * @param array 原数组
     * @param i     index
     * @param n     限定范围
     */
    private void heapify(Comparable[] array, int i, int n) {
        // 比较左右孩子节点 获取最大节点
        int lChild = (i << 1) + 1;
        int rChild = (i + 1) << 1;
        int largest = i;
        if (lChild < n && less(array[largest], array[lChild])) {
            largest = lChild;
        }
        if (rChild < n && less(array[largest], array[rChild])) {
            largest = rChild;
        }
        // 递归跳出 最大节点 = 自身
        if (largest != i) {
            // 下沉
            swap(array, i, largest);
            // 递归
            heapify(array, largest, n);
        }

    }
}
