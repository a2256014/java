package dataStructure;

public class MyStack {
    MyArray Stack;
    int top;

    public MyStack(){
        top = 0;
        Stack = new MyArray();
    }
    public MyStack(int size){
        top = 0;
        Stack = new MyArray(size);
    }

    public void push(int data){
        if(isFull()){
            System.out.println("Full");
            return;
        }
        Stack.insertElement(top++,data);
    }
    public boolean isFull(){
        return top>= Stack.getSize();
    }

    public int pop(){
        if(Stack.getSize()==0) return MyArray.ERROR_NUM;
        return Stack.removeElement(--top);
    }
}
