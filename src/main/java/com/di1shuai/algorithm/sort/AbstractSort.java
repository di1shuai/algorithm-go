package com.di1shuai.algorithm.sort;

import com.di1shuai.utils.TimeUtil;

/**
 * @author: Shea
 * @date: 2020/6/29
 * @description:
 */
public abstract class AbstractSort implements Sort<Comparable>, Comparable<AbstractSort> {

    protected String name = getClass().getSimpleName();

    protected long cost;

    protected long compareCount;

    protected long swapCount;

    @Override
    public void swap(Comparable[] array, int index1, int index2) {
        Sort.super.swap(array, index1, index2);
        swapCount++;
    }

    @Override
    public boolean less(Comparable one, Comparable other) {
        compareCount++;
        return Sort.super.less(one, other);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof AbstractSort) {
            AbstractSort otherSort = (AbstractSort) obj;
            if (name == otherSort.name && cost == otherSort.cost) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(AbstractSort otherSort) {
        int flag = 1;
        if (cost > otherSort.cost) {
            flag = 1;
        } else if (cost < otherSort.cost) {
            flag = -1;
        }
        return flag;
    }

    @Override
    public String toString() {
        return name + "\t" +
                "cost -> " + TimeUtil.costTimeString(cost) + "\t" +
                "compareCount -> " + compareCount + "\t" +
                "swapCount -> " + swapCount + "\t";
    }
}
