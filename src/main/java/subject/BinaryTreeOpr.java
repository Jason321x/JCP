package subject;

import dataStructure.BinaryTree;
import dataStructure.LinkedNode;

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
//        reverseBinaryTree(tree1);
//        preTraverse(tree1);
        flatten(tree1);
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


    // 二叉树展开为链表,要求链表仍然使用二叉树的结构
    // 第一反应是链表作为新的结构,有点问题
    static void flatten(BinaryTree root) {
        LinkedNode node = new LinkedNode();
        LinkedNode nextNode = new LinkedNode();
        LinkedNode nextNextNode = new LinkedNode();

        if (root == null) {
            return;
        }
        node.setVal(root.value);
        System.out.println(node.getVal());
        if (root.leftChild != null) {
           nextNode.setVal(root.leftChild.value);
           node.setNext(nextNode);
           System.out.println("-" + nextNode.getVal());
        }
        if (root.rightChild != null) {
            nextNextNode.setVal(root.rightChild.value);
            nextNode.setNext(nextNextNode);
            System.out.println(nextNextNode.getVal() + "-");
        }

        flatten(root.leftChild);
        flatten(root.rightChild);
    }

    //将以root为根的树拉平为链表
    //右节点放到左节点的下面，然后将整个左子树作为右子树
    static void flattenNew(BinaryTree root) {
        if (root == null) {
            return;
        }

        /**后序遍历位置**/
        //1.左右子树已经被拉平成链表
        BinaryTree left = root.leftChild;
        BinaryTree right = root.rightChild;

        // 2、将左子树作为右子树
        root.leftChild = null;
        root.rightChild = left;

        // 3、将原先的右子树接到当前右子树的末端
        BinaryTree p = root;
        while (p.rightChild != null) {
            p = p.rightChild;
        }
        p.rightChild = right;

    }






}
