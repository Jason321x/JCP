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

    //对于完美二叉树，填充每个节点的下一个右侧指针
    //主函数
    BinaryTree connect(BinaryTree root){
        if (root == null) {
            return null;
        }
        connectTwo(root.leftChild, root.rightChild);
        return root;
    }

    //「将每一层二叉树节点连接起来」可以细化成「将每两个相邻节点都连接起来」
    //辅助函数
    void connectTwo(BinaryTree node1, BinaryTree node2){
        if (node1 == null || node2 == null) {
            return ;
        }
        node1.setNext(node2);
        connectTwo(node1.leftChild, node1.rightChild);
        connectTwo(node2.leftChild, node2.rightChild);
        connectTwo(node1.rightChild, node2.leftChild);
    }






}
