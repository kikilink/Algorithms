package com.khlin.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxHeap<M> implements Heap<M> {

    private ArrayList<M> nodes;

    private Comparator<M> comparator;

    public MaxHeap(ArrayList<M> original, Comparator<M> comparator) {
        if (null == original || original.size() <= 2) {
            throw new IllegalArgumentException("nodes number must larger than 2");
        }
        this.nodes = new ArrayList<M>(original.size() + 1);
        this.nodes.add(null);
        this.nodes.addAll(original);
        this.comparator = comparator;
        buildHeap();
    }

    private void buildHeap() {
        //从有叶子的节点开始构造子堆
        for (int index = nodes.size() / 2; index >= 1; index--) {
            heapify(index);
        }
    }

    /**
     * 最大堆化
     * @param index
     */
    private void heapify(int index) {
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);
        int next = index;
        //开始最大堆化子树
        if (isInRange(leftChild) && largerThan(nodes.get(leftChild), nodes.get(next))) {
            next = leftChild;
        }

        if (isInRange(rightChild) && largerThan(nodes.get(rightChild), nodes.get(next))) {
            next = rightChild;
        }

        //说明当前节点已经比它的子节点都大，不需要再最大堆化了
        if (next == index) {
            return;
        }

        //否则进行一次交换
        swap(next, index);

        //注意，虽然以子节点为根的子树已经最大堆化，但经过上面的交换，可能已经破坏了该子树的最大堆属性。
        //需要继续递归向下最大堆化子树
        heapify(next);
    }

    private boolean largerThan(M firstObj, M secondObj) {
        return comparator.compare(firstObj, secondObj) > 0;
    }

    private boolean isInRange(int index) {
        return index <= nodes.size() - 1;
    }

    private void swap(int i, int j) {
        M tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    @Override
    public M root() {
        return nodes.size() > 1 ? nodes.get(1) : null;
    }

    @Override
    public M extractRoot() {
        if(nodes.size() < 2) {
            return null;
        }
        //删除根节点的算法是，将最后一个节点和根节点的值交换，然后从根节点开始下沉
        M maxNode = nodes.get(1);
        swap(1, nodes.size() - 1);
        nodes.remove(nodes.size() - 1);

        //从根节点开始下沉
        shiftDown(1);
        return maxNode;
    }

    @Override
    public void insert(M node) {
        nodes.add(node);
        shiftUp(nodes.size() - 1);
    }

    //递归实现
    //    private void shiftUp(int index) {
//        if (index > 1) {
//            int parent = index / 2;
//            if (largerThan(nodes.get(index), nodes.get(parent))) {
//                swap(index, parent);
//                shiftUp(parent);
//            }
//        }
//    }
    private void shiftUp(int index) {
        int cursor = index;
        while (cursor > 1) {
            int parent = cursor / 2;
            if (largerThan(nodes.get(cursor), nodes.get(parent))) {
                swap(cursor, parent);
                cursor = parent;
            } else {
                break;
            }
        }
    }

    private void shiftDown(int index) {
        int cursor = index;
        while (cursor <= nodes.size() - 1) {
            if (!hasLeaves(cursor)) {
                break;
            }
            int leftChild = leftChild(cursor);
            int rightChild = rightChild(cursor);
            //正常的时候和子节点中最大的那个进行对比
            int next = largerIndex(leftChild, rightChild);
            if (largerThan(nodes.get(next), nodes.get(cursor))) {
                swap(next, cursor);
                cursor = next;
            } else {
                break;
            }
        }
    }

    private int largerIndex(int leftChild, int rightChild) {
        if (!isInRange(leftChild)) {
            throw new IndexOutOfBoundsException("Index out of nodes bounds.");
        }

        if (!isInRange(rightChild)) {
            return leftChild;
        }

        return comparator.compare(nodes.get(leftChild), nodes.get(rightChild)) >= 0 ? leftChild : rightChild;
    }

    private boolean hasLeaves(int index) {
        return 2 * index <= nodes.size() - 1;
    }

    private int leftChild(int index) {
        return index * 2;
    }

    private int rightChild(int index) {
        return index * 2 + 1;
    }

    @Override
    public void print() {
        System.out.println(nodes);
    }
}
