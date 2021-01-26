package subject;

import dataStructure.BinaryTree;

/**
 * @className: BinaryTreeOpr
 * @description: 二叉树操作
 * @author: jxx
 * @date: 2021/1/25 3:13 PM
 **/
public class BinaryTreeOpr {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.setValue(1);
        BinaryTree tree2 = new BinaryTree();
        tree2.setValue(2);
        BinaryTree tree3 = new BinaryTree();
        tree3.setValue(3);
        BinaryTree tree4 = new BinaryTree();
        tree4.setValue(4);
        tree1.setLeftChild(tree2);
        tree1.setRightChild(tree3);
        tree2.setLeftChild(tree4);
        reverseBinaryTree(tree1);
        preTraverse(tree1);
    }

    // 先序遍历二叉树
    private static void preTraverse(BinaryTree binaryTree) {
        // 这里不能使用while,会死循环
//        while (binaryTree != null) {
        if (binaryTree != null) {
            System.out.print(binaryTree.getValue() + " ");
            preTraverse(binaryTree.getLeftChild());
            preTraverse(binaryTree.getRightChild());
        }
    }

    //翻转二叉树 左右孩子交换
    private static BinaryTree reverseBinaryTree(BinaryTree root) {
        if (root == null) {
            return null;
        }

        // 左右节点交换
        BinaryTree tmp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(tmp);

        reverseBinaryTree(root.getLeftChild());
        reverseBinaryTree(root.getRightChild());

        return root;
    }





}
