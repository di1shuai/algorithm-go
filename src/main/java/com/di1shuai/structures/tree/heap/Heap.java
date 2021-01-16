package com.di1shuai.structures.tree.heap;

import com.di1shuai.Base;

/**
 * @author Shea
 * @date 2021-1-15
 * @description 堆
 * 实质: 以数组形式表现的一个完全二叉树
 * 关注: 最大（最小）值
 * 位置: 为k的元素的父节点位置为->k/2 子节点为 2k | 2k+1   e.g. a[3]的父节点为a[1] ,子节点为a[6] a[7]
 * a[0] 不存放元素
 */
public interface Heap extends Base<Comparable> {

    /**
     * 上浮 由下自上的堆有序化
     *
     * @param indexK
     */
    void swim(int indexK);

    /**
     * 下沉 由上自下的堆有序化
     *
     * @param indexK
     */
    void sink(int indexK);


}
