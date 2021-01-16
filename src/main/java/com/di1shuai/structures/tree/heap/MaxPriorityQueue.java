package com.di1shuai.structures.tree.heap;

import com.di1shuai.utils.DataUtil;
import com.di1shuai.utils.TitleUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Shea
 * @date 2021-01-15
 * @description 最大优先队列
 */
public class MaxPriorityQueue<E extends Comparable> implements Heap {

    private static final int DEFAULT_SIZE = 1 << 4 + 1;

    private int size;

    /**
     * [0] 不存东西， [1] 存放最值
     */
    private E[] queue;

    public MaxPriorityQueue() {
        this(DEFAULT_SIZE);
    }

    public MaxPriorityQueue(int initQueueLength) {
        queue = (E[]) Array.newInstance(Comparable.class, initQueueLength + 1);
    }


    /**
     * 插入
     *
     * @param e
     */
    public void insert(E e) {
        // 先插入数组序列的最后一位
        if (size + 1 > queue.length - 1) {
            grow();
        }
        queue[++size] = e;
        if (size != 1) {
            // 上浮
            swim(size);
        }
    }

    /**
     * 扩容
     */
    private void grow() {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + (
                (oldCapacity < 64) ?
                        oldCapacity : (oldCapacity >> 1)
        );
        queue = Arrays.copyOf(queue, newCapacity);
    }

    /**
     * 删除并返回最值
     *
     * @return
     */
    public E delMax() {
        //先将根节点[1] 与 序列末元素[size] 互换
        swap(queue, 1, size);
        //临时存储并删除 序列末元素(原最大值)
        E result = queue[size];
        queue[size--] = null;
        //根节点下沉
        sink(1);
        return result;
    }

    /**
     * @return 最值
     */
    public E max() {
        return size > 0 ? queue[1] : null;
    }


    @Override
    public void swim(int indexK) {
        // indexK的父节点[indexK>>1]比indexK节点小,就交换
        while (indexK > 1 && less(queue[indexK >> 1], queue[indexK])) {
            // 上浮
            swap(queue, indexK >> 1, indexK);
            // index同步上浮
            indexK >>>= 1;
        }
    }

    @Override
    public void show(Comparable[] array) {
        Arrays.stream(array).skip(1).limit(size).forEach(n -> System.out.print(n + "\t"));
        System.out.println();
    }

    @Override
    public void sink(int indexK) {
        while (indexK << 1 < queue.length) {
            int childIndex = indexK << 1;
            // 找到子节点(2k | 2k+1)中较大的孩子
            if (childIndex < queue.length && less(queue[childIndex], queue[childIndex + 1])) {
                childIndex++;
            }
            // 比大孩子大 跳出
            if (!less(queue[indexK], queue[childIndex])) {
                break;
            }
            // 比大孩子小 下沉
            swap(queue, indexK, childIndex);
            // index同步下沉
            indexK = childIndex;
        }
    }

    public E[] toArray() {
        return Arrays.copyOf(queue, size + 1);
    }

    public E[] getQueue() {
        return queue;
    }

    public static void main(String[] args) {
        int size = 1 << 4;
        // 原始数组
        DataUtil.generateData(size);
        Comparable[] array = DataUtil.getArrayRandom();

        TitleUtil.title("原始数据\t size:" + array.length);
        Arrays.stream(array).limit(100).forEach(n -> System.out.print(n + "\t"));
        System.out.println();


        //构建优先队列
        MaxPriorityQueue<Comparable> pq = new MaxPriorityQueue(array.length);
        Arrays.stream(array).forEach(n -> pq.insert(n));
        TitleUtil.title("优先队列 size" + pq.size);
        pq.show(pq.queue);

        //返回最值
        TitleUtil.title("max: " + pq.max());
        pq.show(pq.queue);

        //插入大数
        int insertMax = size + 1;
        pq.insert(insertMax);
        TitleUtil.title("inster " + insertMax);
        pq.show(pq.queue);

        //插入小数
        pq.insert(-1);
        TitleUtil.title("inster -1 ");
        pq.show(pq.queue);

        //删除并返回最值
        Comparable max = pq.delMax();
        TitleUtil.title("del Max : max -> " + max);
        pq.show(pq.queue);
    }


}
