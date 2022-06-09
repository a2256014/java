package dataStructure;
interface Queue{
    public void enQueue(String data);
    public String deQueue();
}
public class MyQueue extends MyLinkedList implements Queue{
    MyNode front;
    MyNode rear;

    @Override
    public void enQueue(String data) {
        MyNode newNode = addElement(data);;
        if(isEmpty()) {
            front = newNode;
            rear = newNode;
        }
        else{
            rear = newNode;
        }
    }

    @Override
    public String deQueue() {
        if(isEmpty()) return "error";
        String data = front.getData();
        front = front.next;

        if(front==null) rear=null;

        return data;
    }
}
