package BinaryTree;

import javax.sound.midi.SoundbankResource;

/**
 * @program: DataStructure
 * @description: 二叉树前中后序遍历
 * @author: Mr.Sun
 * @create: 2021-05-28 19:28
 **/
public class BinaryTree {

    public static void main(String[] args) {

//        新建一个二叉树
        BiTree biTree = new BiTree();
        Node node1 = new Node(1,"张三");
        Node node2 = new Node(2,"李四");
        Node node3 = new Node(3,"王五");
        Node node4 = new Node(4,"赵六");
        Node node5 = new Node(5,"王七");
        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node3.setRightNode(node4);
        node3.setLeftNode(node5);
        biTree.setRoot(node1);
//        前序遍历二叉树
        biTree.proOrder();//1->2->3->4
        /*Node{num=1, name='张三'}
          Node{num=2, name='李四'}
          Node{num=3, name='王五'}
          Node{num=4, name='赵六'}

*/
        System.out.println("_____________________________");
//        中序遍历二叉树
        biTree.indexOrder();//2->1->3->4
/*Node{num=2, name='李四'}
Node{num=1, name='张三'}
Node{num=3, name='王五'}
Node{num=4, name='赵六'}
*/
        System.out.println("_____________________________");
//       后序遍历二叉树
        biTree.postOrder();//2->4->3->1
/*Node{num=2, name='李四'}
Node{num=4, name='赵六'}
Node{num=3, name='王五'}
Node{num=1, name='张三'}*/
        System.out.println("_____________________________");

//前序查找
        Node prenode = biTree.proOrderSearch(5);
        if (prenode != null){
            System.out.printf("前序查找找到编号为%d的英雄，名字叫%s",prenode.getNum(),prenode.getName());
        }else{
            System.out.printf("前序查找没有找到此英雄");
        }
        System.out.println("\n_________________________________");
//中序查找
        Node indNode = biTree.indixOrderSearch(5);
        if (indNode != null){
            System.out.printf("中序查找找到编号为%d的英雄，名字叫%s",indNode.getNum(),indNode.getName());
        }else{
            System.out.printf("中序查找没有找到此英雄");
        }

        System.out.println("\n_________________________________");
//后序查找

        Node postNode = biTree.postOrderSearch(5);
        if (postNode != null){
            System.out.printf("后序查找找到编号为%d的英雄，名字叫%s",postNode.getNum(),postNode.getName());
        }else{
            System.out.printf("后序查找没有找到此英雄");
        }
        System.out.println("\n_________________________________");
////        删除节点（删除5号叶子节点）
//        System.out.println("删除5号节点前的前序遍历：");
//        biTree.proOrder();//1->2->3->5->4 //前序遍历
//        biTree.delNode(5);//删除编号为5的英雄
//        System.out.println("删除5号节点后的前序遍历：");
//        biTree.proOrder();//前序遍历 1->2->3->4
//        删除节点（删除3号子树）
        System.out.println("删除3号节点前的前序遍历：");
        biTree.proOrder();//1->2->3->5->4 //前序遍历
        biTree.delNode(3);//删除编号为3的英雄
        System.out.println("删除3号节点后的前序遍历：");
        biTree.proOrder();//前序遍历 1->2


    }
}

class BiTree{
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

//    前序遍历
    public void proOrder(){
        if (this.root!=null){
            this.root.proindex();
        }else {
            System.out.println("此二叉树为空，不能遍历");
        }
    }

//    中序遍历
    public void indexOrder(){
        if (this.root!=null){
            this.root.inindex();
        }else{
            System.out.println("此二叉树为空，不能遍历");
        }
    }

//    后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postindex();
        }else{
            System.out.println("此二叉树为空，不能遍历");
        }
    }

//    前序查找
    public Node proOrderSearch(int num){
       Node resNode = null;
        if (this.root!=null){
            return this.root.proOrderSearch(num);
        }
        return null ;
    }

//中序查找
    public Node indixOrderSearch(int num){
//        当前根节点不为空，继续中序查找
        Node resNode = null;
        if (this.root!=null){
            resNode = this.root.infixOrderSerach(num);
        }
        return resNode ;
    }

//    后序查找
    public Node postOrderSearch(int num){
//        当前根节点不为空，继续后序查找
        Node resNode = null ;
        if (this.root!=null){
            resNode = this.root.postOrderSearch(num);
        }
        return resNode ;
    }

//    删除节点
    public void delNode(int num){
//        1.判断该树是否是空树，如果是空树不能删除；反之，树非空，判断根节点是否是要删除的节点，是则将树置空，否则对根节点进行递归删除
        if (root==null){
            System.out.println("空树，无法删除");
            return ;
        }
        else if (root!=null&&root.getNum()==num){
            root = null;
        }else{
            root.delNode(num);
        }
    }
}










 class Node{
    private int num ;

     @Override
     public String toString() {
         return "Node{" +
                 "num=" + num +
                 ", name='" + name + '\'' +
                 '}';
     }
    private String name ;
    private Node leftNode ;
    private Node rightNode;

     public Node() {
     }

     public Node(int num, String name) {
         this.num = num;
         this.name = name;
     }

     public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }


    //        前序遍历
    public void proindex(){
//            如果当前的节点不为空，输出当前节点
        if (this!=null){
            System.out.println(this);
        }

//            如果左边节点不为空，则递归调用前序遍历
        if (this.leftNode!=null){
            this.leftNode.proindex();
        }
//            如果右边节点不为空，则递归调用前序遍历
        if (this.rightNode!=null){
            this.rightNode.proindex();
        }
    }

    //        中序遍历
    public void inindex(){
//            如果当前节点的左节点不为空，则递归调用中序遍历
        if (this.leftNode!=null){
            this.leftNode.inindex();
        }
//            输出当前节点
        if (this!=null){
            System.out.println(this);
        }
//            如果当前节点的右节点不为空，则递归调中序遍历
        if (this.rightNode!=null){
            this.rightNode.inindex();
        }

    }




    //        后序遍历
    public void postindex(){
//            如果当前节点的左节点不为空，则递归调用后序遍历
        if (this.leftNode!=null){
            this.leftNode.postindex();
        }
//            如果当前节点的右节点不为空，则递归调用后序遍历
        if (this.rightNode!=null){
            this.rightNode.postindex();
        }
//            如果当前节点不为空，则输出此节点
        if (this!=null){
            System.out.println(this);
        }

    }


//前序查找
     public Node proOrderSearch(int num){
//         1.先判断当前节点的num是否等于要查找的节点的num,若果是则输出
         System.out.println("进入前序查找");
         if (this.num == num){
             return this;
         }
//         2.当前节点的num不等于查找的，判断左子树是否为空，递归调用前序查找，如果找到就返回，否则判断右子树是否为空。
         Node resNode = null ;
         if (this.leftNode != null){
             resNode = this.leftNode.proOrderSearch(num);
         }
//         如果左子树前序查找不为空，则返回该节点
         if (resNode != null){
             return resNode ;
         }
//         3.判断右子树是否为空，递归调用前序查找
         if (this.rightNode!=null){
             resNode = this.rightNode.proOrderSearch(num);
         }
         return resNode;

     }

//中序查找
     public Node infixOrderSerach(int num){
//         1.判断当前节点的左节点是否为空,不为空则继续调用中序查找
         Node resNode = null;
         if (this.leftNode != null){
             resNode = this.leftNode.infixOrderSerach(num);
         }
//         若果左子树中序查找不为空，则返回该节点
         if (resNode != null){
             return resNode ;
         }
//         2.判断当前节点是否为要查找的节点，是则返回
         System.out.println("进入中序查找");
         if (this.num == num){
             return this ;
         }
//         3.判断右子树是否为空，不为空则继续递归调用中序查找
         if (this.rightNode!=null){
             resNode = this.rightNode.infixOrderSerach(num);
         }
         return  resNode;
     }



//后序查找
     public Node postOrderSearch(int num){
         Node resNode = null ;
//        1. 如果左子树不为空，则递归调用后序查找
         if (this.leftNode!=null){
             resNode = this.leftNode.postOrderSearch(num);
         }
//         如果左子树后序查找不为空，则返回该节点
         if (resNode!=null){
             return resNode ;
         }
//         2.如果右子树不为空，则递归调用后序查找
         if (this.rightNode!=null){
             resNode = this.rightNode.postOrderSearch(num);
         }
//         如果右子树后序查找不为空，则返回该节点
         if (resNode!=null){
             return resNode ;
         }
//         3.判断当前节点是否为要查找的节点
         System.out.println("进入后序查找");
         if (this.num == num){
             return this ;
         }
         return resNode ;

     }

//     删除指定节点：/*
//     删除规则：1。如果要删除的节点是叶子节点，则删除该叶子节点；
//     2.如果要删除的节点是非叶子节点，则删除该子树。
     public void delNode(int num){
//         1.如果该节点的左子节点不为空，且为要删除的节点，将该节点置空。
         if (this.leftNode!=null && this.leftNode.num == num){
             this.leftNode = null ;
             return ;//这里返回，是因为删除了要删除的节点，不用再去寻找节点。
         }
//          2.如果该节点的右子节点不为空，且为要删除的节点，将该节点置空。
         if (this.rightNode!=null&&this.rightNode.num==num){
             this.rightNode = null ;
             return ;//这里返回，是因为删除了要删除的节点，不用再去寻找节点。
         }
//         3.该节点的左右子节点都不是要删除的节点，对左子节点进行递归删除
         if (this.leftNode!=null){
             this.leftNode.delNode(num);
         }
//         4.如果该节点的左子节点为空，对该节点的右子节点进行递归删除
         if (this.rightNode!=null){
             this.rightNode.delNode(num);
         }
     }



}
