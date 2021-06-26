package ArraryQueue;

/**
 * @program: DataStructure
 * @description: 用数组模拟队列
 * @author: Mr.Sun
 * @create: 2021-06-10 20:49
 **/
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3 );
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.getQueue();//取出队列的一个元素
        System.out.println(queue.getHead());//输出队列的第一个元素
        queue.show();
}
}

class ArrayQueue{
    private int maxSize;
    private int rear ;
    private int head ;
    private int[] arr ;
//    初始化队列的大小
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        rear = -1;
        head = -1;
        arr = new int[maxSize];
    }

//    判断队列为空
    public boolean isEmpty(){
        return rear == head;
    }

//    判断队列已满
    public boolean isFull(){
        return rear == maxSize-1 ;
    }

//    向队列添加元素

    public void add(int n){
        if (isFull()){
            throw new RuntimeException("队列已满，不能添加");
        }
        rear++;
        arr[rear] = n;
    }

//    显示队列头的值
    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能获取队头元素");
        }
        return arr[head+1];
    }

//    显示队列所有的元素

    public void show(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能展示");
        }
        for (int i =head+1;i<=rear;i++){
            System.out.println(arr[i]);
        }

    }

//    取出队列的头元素
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不可取");
        }
        head++;
       return arr[head];
    }



}

