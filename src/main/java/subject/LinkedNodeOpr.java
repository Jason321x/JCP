package subject;

import dataStructure.LinkedNode;

/**
 * @className: LinkedList
 * @description: 链表相关题目
 * @author: jxx
 * @date: 2021/1/23 6:20 PM
 **/
public class LinkedNodeOpr {

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode();
        node1.setVal(1);
        LinkedNode node2 = new LinkedNode();
        node1.setVal(2);
        node1.setNext(node2);
        LinkedNode node3 = new LinkedNode();
        node1.setVal(3);
        node2.setNext(node3);
        LinkedNode node4 = new LinkedNode();
        node1.setVal(1);
        node3.setNext(node4);
        node4.setNext(node1);

        System.out.println(hasCircle(node1));

    }

    //判断链表是否有环
    public static boolean hasCircle(LinkedNode node){
        while (node.next != null) {
            node = node.next;
        }
        return false;
    }

    //判断链表是否有环 快慢指针 如何定义？
    //快慢指针什么时候会相遇？
    private boolean hasCircleByTwoPoints(LinkedNode head){
        LinkedNode fast, slow;
        slow = fast = head;
        while (slow.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //已知链表中有环，返回环的起始位置
    //快指针与慢指针相遇时，快慢指针之间的距离
    //相遇点、环的起始点
    private LinkedNode findCircleBeginning(LinkedNode head) {
        LinkedNode fast,slow;
        fast = slow = head;
        while (fast.next != null && slow.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


}
