package subject;

import dataStructure.BinaryTree;



/**
 * @className: BuildTree
 * @description: TODO 类描述
 * @author: jxx
 * @date: 2021/2/22 4:35 PM
 **/
public class TreeOpr {

    //根据树的前序和中序序列构造树
    private static BinaryTree buildTree(int[] preOrder, int[] inOrder) {
        return treeHelper(preOrder, 0, preOrder.length, inOrder, 0, inOrder.length);
    }

    private static BinaryTree treeHelper(int[] preOrder, int pStart, int pEnd, int[] inOrder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }

        int root = preOrder[pStart];
        int indexOfIRoot = 0;
        //找到中序序列中root的位置
        for (int i = iStart;i < iEnd;i++) {
            if (inOrder[i] == root) {
                indexOfIRoot = i;
                break;
            }
        }
        //构造树
        BinaryTree tree = new BinaryTree();
        tree.setValue(root);

        //分别划分前序序列中的左、右子树，递归操作
        int leftNum = indexOfIRoot - iStart;
        tree.setLeftChild(treeHelper(preOrder, pStart + 1, pStart + leftNum + 1, inOrder, iStart, indexOfIRoot));
        tree.setRightChild(treeHelper(preOrder, pStart + leftNum + 1, pEnd, inOrder, indexOfIRoot + 1, iEnd));

        return tree;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{9,3,5,7,8};
        int[] inOrder = new int[]{3,9,7,5,8};
        BinaryTree tree = buildTree(preOrder, inOrder);
        printTree(tree);
    }

    public static void printTree(BinaryTree binaryTree) {
        if (binaryTree.getValue() == null) {
            return;
        }
        System.out.println(binaryTree.getValue() + " ");
        printTree(binaryTree.getLeftChild());
        printTree(binaryTree.getRightChild());
    }

}
