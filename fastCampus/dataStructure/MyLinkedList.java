package dataStructure;

class MyNode{
    private final String data;
    public MyNode next;

    public MyNode(){
        data = null;
        next = null;
    }
    public MyNode(String data){
        this.data = data;
        next = null;
    }
    public MyNode(String data, MyNode link){
        this.data = data;
        next = link;
    }
    public String getData(){
        return this.data;
    }
}

public class MyLinkedList {
    private MyNode head;
    int count;

    public MyLinkedList(){
        head=null;
        count=0;
    }

    public MyNode addElement(String data){
        MyNode newNode = new MyNode(data);
        if(head==null){
            head = newNode;
        }else{
            MyNode temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        count++;
        return newNode;
    }

    public MyNode insertElement(int position, String data){
        MyNode tempNode = head;
        MyNode prevNode = null;
        MyNode newNode = new MyNode(data);

        if(position<0||position>count)return null;
        if(position==0){
            newNode.next = head;
            head = newNode;
        }
        else{
            for(int i =0; i<position; i++){
                prevNode = tempNode;
                tempNode = tempNode.next;
            }

            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        count++;
        return newNode;
    }

    public MyNode removeElement(int position){
        MyNode tempNode = head;
        MyNode prevNode = null;

        if(position==0) head = tempNode.next;
        else{
            for(int i =0; i<position; i++){
                prevNode = tempNode;
                tempNode = tempNode.next;
            }
            prevNode.next = tempNode.next;
        }

        count --;
        return tempNode;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void printAll(){
        MyNode curNode = head;
        StringBuilder data = new StringBuilder();
        while (curNode!=null){
            data.append(curNode.getData());
            if(curNode.next!=null)data.append("->");
            curNode = curNode.next;
        }
        System.out.println(data);
    }
}
