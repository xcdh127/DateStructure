import java.util.Stack;

/**
 * @program: DataStructure
 * @description: 单向链表
 * @author: Mr.Sun
 * @create: 2021-06-03 20:42
 **/
public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"孙啸辰","老板");
        HeroNode heroNode2 = new HeroNode(2,"郭建军","副总");
        HeroNode heroNode3 = new HeroNode(3,"王昭君","副总");
        HeroNode heroNode4 = new HeroNode(4,"高渐离","副总");
        SinglingList singlingList = new SinglingList();



//        无序方式形成单链表
        singlingList.addNode(heroNode1);
        singlingList.addNode(heroNode2);
        singlingList.addNode(heroNode4);
        singlingList.addNode(heroNode3);

      /*  //        按照英雄编号顺序，添加节点，形成单链表
        singlingList.addById(heroNode1);
        singlingList.addById(heroNode4);
        singlingList.addById(heroNode2);
        singlingList.addById(heroNode3);
*/



      /*  System.out.println("------------------------------");

        singlingList.updateNode(new HeroNode(1,"南财","小才子"));
        singlingList.updateNode(new HeroNode(2,"南邮","小柚子"));
        singlingList.updateNode(new HeroNode(3,"南京","六朝古都"));
        singlingList.updateNode(new HeroNode(4,"鼎山","好地方"));



//        显示单链表
        singlingList.list();


        System.out.println("------------------------------");


//        singlingList.deleteNode(2);
////        singlingList.deleteNode(1);
//        singlingList.deleteNode(4);
//        singlingList.deleteNode(3);

//        显示单链表
        singlingList.list();

        int nodeCount = singlingList.getNodeCount(singlingList.getHead());
        System.out.println(nodeCount);
        System.out.println("-------------------------------------");

//        获取链表中倒数第K个节点
        HeroNode node = singlingList.getLastIndexNode(singlingList.getHead(), 5);
        System.out.println(node);
        System.out.println("---------------------------");
*/


        System.out.println("原来链表的情况~~");
        singlingList.list();

		/*System.out.println("反转单链表~~");
        SinglingList.reversetList(singlingList.getHead());
        singlingList.list();*/

        System.out.println("---------");
        System.out.println("逆序打印链表，不改变链表的结构");
        singlingList.reservePrint(singlingList.getHead());


    }






    }


class HeroNode{
    int no ;
    String name ;
    String nickname ;
    HeroNode next ;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}


class SinglingList{
//    先初始化头结点，头结点不要动，不存放具体的数据。
    HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void addNode(HeroNode heroNode){
//        因为head节点不能动，所以定义一个辅助变量temp
        HeroNode temp = head ;
        while(true){
            if (temp.next!=null){
                temp = temp.next ;
            }else{
                break ;
            }
        }
        temp.next = heroNode ;
    }

//    按照英雄编号顺序添加节点，形成单链表
    public void addById(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false ;
       while(temp.next!=null){
            if (temp.next.no > heroNode.no){
              break ;
            }
            if (temp.next.no == heroNode.no){
                flag = true ;
            }
           temp = temp.next;
        }

       if (flag==false){
           heroNode.next = temp.next;
           temp.next = heroNode;
       }else{
           System.out.println("您要插入的英雄节点已经存在了");
       }

    }


//    修改链表的节点
    public void updateNode(HeroNode heroNode){
        if (head.next == null){
            System.out.println("链表为空不能修改");
        }
        HeroNode temp = head ;
        boolean flag = false ;
        while(true){

            if (temp.next==null) break ;

            if(temp.next.no == heroNode.no){
                flag = true ;
                break ;
            }
            temp = temp.next ;
        }

        if (flag){
            temp.next.nickname = heroNode.nickname;
            temp.next.name = heroNode.name;
        }else{
            System.out.println("您要修改的英雄不在列表中");
        }

    }



//    删除链表中指定编号的节点
    public void deleteNode(int no){
        if (head.next == null){
            System.out.println("链表为空不能删除");
        }
        HeroNode temp = head ;
        boolean flag = false ;
        while(true){
            if (temp.next==null) break;
            if (temp.next.no == no){
                flag = true;
                break ;
            }
            temp = temp.next ;
        }
        if (flag){
            temp.next = temp.next.next ;
        }else{
            System.out.println("您要删除的节点不在链表中");
        }

    }



//    统计链表中有效节点的个数，即头结点不算在内。
    public int getNodeCount(HeroNode head ){
        if (head.next == null){
            return 0;
        }
        HeroNode temp = head.next;//这一句表明，从头结点的下一个节点开始遍历。
        int count = 0;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count ;
    }



//输出链表中倒数第K个节点
    public HeroNode getLastIndexNode(HeroNode head , int index){
        if (head.next == null){
            return null ;
        }
        HeroNode temp = head.next ;
//        获取链表中的有效节点数
        int size = getNodeCount(head);

//        对index进行判断，如果index<=0 或者说 index>size,返回空
        if (index<=0 || index >size){
            return null ;
        }
//      从头遍历链表
        for (int i = 0; i < size - index; i++) {
            temp = temp.next ;
        }
        return temp ;

    }





    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if(head.next == null || head.next.next == null) {
            return ;
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }




//    逆序打印链表
    public void reservePrint(HeroNode head){
        if (head.next == null){
            return;
        }
        HeroNode temp = head.next ;
        Stack<HeroNode> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp);
//            指针向后移动
            temp = temp.next;
        }
        while(stack.size()>0){
            System.out.println(stack.pop());
        }

    }




//显示单链表
    public  void list(){
//       先判断链表是否为空
        if (head.next==null){
            System.out.println("此链表为空");
            return ;
        }
//        定义一个辅助变量temp
        HeroNode temp = head.next ;
        while(true){
            if (temp!=null){
                System.out.println(temp);
                temp = temp.next ;
            }else {
                break ;
            }
        }

    }


}
