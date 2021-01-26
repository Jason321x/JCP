package dataStructure;

/**
 * @className: BinaryTree
 * @description: 二叉树
 * @author: jxx
 * @date: 2021/1/25 2:41 PM
 **/
public class BinaryTree {

    public BinaryTree leftChild;
    public BinaryTree rightChild;
    public Integer value;

    public BinaryTree next;

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinaryTree getNext() {
        return next;
    }

    public void setNext(BinaryTree next) {
        this.next = next;
    }
}
