package CircleQueue;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * @program: DataStructure
 * @description: 环形队列
 * @author: Mr.Sun
 * @create: 2021-06-10 22:23
 **/
public class CircleQueueTest {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3 );
        queue.add(3);
        queue.add(2);
        queue.getQueue();
        queue.getQueue();
        queue.add(6);
        queue.add(7);
//      queue.getQueue();//取出队列的一个元素
//      System.out.println(queue.getHead());//输出队列的第一个元素
        System.out.println("****");
        queue.show();
    }
    }


class CircleQueue{
    private int maxSize;
    private int rear ;
    private int head ;
    private int[] arr ;
    //    初始化队列的大小
    public CircleQueue(int maxSize){
        this.maxSize = maxSize;
        rear = 0;
        head = 0;
        arr = new int[maxSize];
    }

    //    判断队列为空
    public boolean isEmpty(){
        return rear == head;
    }

    //    判断队列已满
    public boolean isFull(){
        return (rear+1)%maxSize==head ;
    }

//    向队列添加元素

    public void add(int n){
        if (isFull()){
            throw new RuntimeException("队列已满，不能添加");
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    //    显示队列头的值
    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能获取队头元素");
        }
        return arr[head];
    }

//    显示队列所有的元素

    public void show(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能展示");
        }
        for (int i =head;i< head+getNum();i++){
            System.out.println(arr[i%maxSize]);
        }

    }

//    获取队列中有效数据的个数
    public int getNum(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能获取个数");
        }
        return (rear+maxSize-head)%maxSize;
    }

    //    取出队列的头元素
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不可取");
        }
        int value = arr[head];
        head = (head+1)%maxSize;
        return value ;
    }
}
