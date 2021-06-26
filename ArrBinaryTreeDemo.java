package ArrBinaryTree;

/**
 * @program: DataStructure
 * @description: 顺序存储二叉树
 * @author: Mr.Sun
 * @create: 2021-05-31 08:48
 **/
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder(0);

    }

}


class ArrBinaryTree{
    private int[] arr ;


    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

//    前序遍历输出顺序存储二叉树
    public void preOrder(int index){
//        1.如果当前数组为空，则不能以顺序存储方式遍历二叉树
        if (arr==null||arr.length==0){
            System.out.println("不能用顺序存储二叉树方式遍历数组");
        }
//        2.输出当前节点
        System.out.println(arr[index]);
//        3.如果 index*2+1<arr.length，对左节点进行递归调用前序遍历方法
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
//        3.如果index*2+2<arr.length,对右节点进行递归调用前序遍历方法
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
    //    中序遍历输出顺序存储二叉树
    public void inOrder(int index){
//        1.如果当前数组为空，则不能以顺序存储方式遍历二叉树
        if (arr==null||arr.length==0){
            System.out.println("不能用顺序存储二叉树方式遍历数组");
        }
//        2.如果 index*2+1<arr.length，对左节点进行递归调用前序遍历方法
       if (index*2+1<arr.length){
           inOrder(index*2+1);
        }
//        3.输出当前节点
        System.out.println(arr[index]);

//        4.如果index*2+2<arr.length,对右节点进行递归调用前序遍历方法
        if (index*2+2<arr.length){
            inOrder(index*2+2);
        }
    }

    //    后序遍历输出顺序存储二叉树
    public void postOrder(int index){
//        1.如果当前数组为空，则不能以顺序存储方式遍历二叉树
        if (arr==null||arr.length==0){
            System.out.println("不能用顺序存储二叉树方式遍历数组");
        }
//        2.如果 index*2+1<arr.length，对左节点进行递归调用前序遍历方法
        if (index*2+1<arr.length){
            postOrder(index*2+1);
        }
//        3.如果index*2+2<arr.length,对右节点进行递归调用前序遍历方法
        if (index*2+2<arr.length){
            postOrder(index*2+2);
        }
//        4.输出当前节点
        System.out.println(arr[index]);
    }

}