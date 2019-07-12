package com.shenjg.book;

import java.util.Random;
import java.util.Scanner;

public class ElasticsearchBookApplicationTests {

    public static void main(String[] args) {
        Scanner scnner = new Scanner(System.in);
        Random random = new Random();
        int n = scnner.nextInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = random.nextInt(n);//随机产生0~n-1的随机数
            }
        }
        int start = 0;
        int end = n;
        for(int i=0;i<n;++i)
        {
            for(int j=0;j<n;++j)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        while (start != end){
            if (start > end){
                for(int i = end ; i < start ; ){
                    System.out.println(a[start][i]);
                    i --;

                }
            }
            if (start < end){
                for(int i = start ; i < end ; ){
                    System.out.print(a[start][i]);
                    i ++;
                    if (i == end){
                        start +=1;
                    }
                }
                System.out.println();
            }
        }



    }

    private static void toLeft(int[][] arr, int start, int end){
        for (int i = start ; i < end ; i ++){
            System.out.println(arr[start][i]);
        }
    }

    private static void toRight(int[][] arr,int start, int end){
        for (int i = start ; i < end ; i ++){
            System.out.println(arr[end][i]);

        }
    }


}
