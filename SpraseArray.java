package SpraseArray;

import java.awt.*;

/**
 * @program: DataStructure
 * @description: 情景，棋盘。稀疏数组，压缩数据。
 * @author: Mr.Sun
 * @create: 2021-05-28 07:41
 **/
public class SpraseArray {
    public static void main(String[] args) {

//        原始二维数组
        int[][] arr = new int[6][7];
        arr[0][3] = 22;
        arr[0][6] = 15;
        arr[1][1] = 11;
        arr[1][5] = 17;
        arr[2][3] = -6;
        arr[3][5] = 39;
        arr[4][0] = 91;
        arr[5][2] = 28;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println();
        }
//遍历二维数组：获取数组中大于零的数字的个数
        int sum = 0 ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //    初始化稀疏数组
        int[][] sprase = new int[sum+1][3];
        sprase[0][0]=6;
        sprase[0][1]=7;
        sprase[0][2]=sum;
//        遍历二维数组，把非零值赋值给稀疏数组
        int n = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]!=0){
                  sprase[n][0] = i;
                  sprase[n][1] = j;
                  sprase[n][2]= arr[i][j];
                  n++;
                }
            }
        }
//将稀疏数组遍历输出、
        for (int i = 0; i < sprase.length; i++) {
            for (int j = 0; j < sprase[0].length; j++) {
                System.out.printf("%d\t",sprase[i][j]);
            }
            System.out.println();
        }
//    将稀疏数组还原成为二维数组
//    首先读取稀疏数组的第一行，获取到二维数组的行和列
        int row = sprase[0][0];
        int rol = sprase[0][1];
//        根据稀疏数组的第一行得到的行和列初始化二维数组
        int[][] arr1 = new int[row][rol];
//        遍历稀疏数组，将值赋值给二维数组
        for (int i = 1; i < sprase.length; i++) {
            arr1[sprase[i][0]][sprase[i][1]] = sprase[i][2];
        }
//        遍历二维数组
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                System.out.printf("%d\t",arr1[i][j]);
            }
            System.out.println();
        }


    }












}
