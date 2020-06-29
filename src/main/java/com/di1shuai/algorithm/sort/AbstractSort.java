package com.di1shuai.algorithm.sort;

/**
 * @author: Shea
 * @date: 2020/6/29
 * @description:
 */
public abstract class AbstractSort implements Sort<Integer>, Comparable<AbstractSort> {

    protected String name = getClass().getSimpleName();

    protected long cost;

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
        if (cost > otherSort.cost) {
            return 1;
        } else if (cost < otherSort.cost) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return name + "\t"  + cost + "\t";
    }
}
