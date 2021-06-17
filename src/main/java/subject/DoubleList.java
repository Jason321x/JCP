package subject;

/**
 * @className: DoubleList
 * @description: TODO 类描述
 * @author: jxx
 * @date: 2021/6/17 3:23 PM
 **/
public class DoubleList {

    private Node head;

    private Node tail;

    private int size;

    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    public Node removeLast(){
        if (head.next == tail) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public int size(){
        return size;
    }
}
