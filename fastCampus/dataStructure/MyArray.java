package dataStructure;

import java.util.Arrays;

public class MyArray {
    int[] intArr;
    int count;

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -999999999;

    public MyArray(){
        count=0;
        ARRAY_SIZE=10;
        intArr = new int[ARRAY_SIZE];
    }
    public MyArray(int size){
        count=0;
        ARRAY_SIZE=size;
        intArr = new int[ARRAY_SIZE];
    }
    public void addElement(int element){
        if(count>=ARRAY_SIZE) System.out.println("memory over");
        else intArr[count++] = element;
    }
    public void insertElement(int position, int element){
        if(position<0 || position>count) return;
        if(count>= ARRAY_SIZE) return;

        for(int i = count-1;i>=position;i--){
            intArr[i+1]=intArr[i];
        }
        intArr[position] = element;
        count++;
    }
    public int removeElement(int position){
        int ret = ERROR_NUM;
        if(getSize()==0) return ret;
        if(position<0||position>count-1) return ret;

        ret = intArr[position];
        for(int i = position; i<count-1;i++){
            intArr[i] = intArr[i+1];
            if(i+2 == count) intArr[i+1] =0;
        }
        count--;

        return ret;
    }
    public int getSize(){
        return count;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "intArr=" + Arrays.toString(intArr) +
                '}';
    }
}
