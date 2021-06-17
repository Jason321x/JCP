package subject;

/**
 * @className: Node
 * @description: TODO 类描述
 * @author: jxx
 * @date: 2021/6/17 3:21 PM
 **/
public class Node {

    public int key;

    public int value;

    public Node prev;

    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
