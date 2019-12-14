//
//  move_.c
//  三子棋
//
//  Created by Darin Wang on 2017/11/17.
//  Copyright © 2017年 Darin Wang. All rights reserved.
//

void print_field(int line_1[3], int line_2[3], int line_3[3]);

#include <stdio.h>
void move_(int a[3], int b[3], int c[3], int p[1])
{
    
    int n;
    printf("输入位置: [1..9]");
    scanf("%d", &n);
    if (n<0)
    {
        printf("请输入在[1,9]区间内的数\n");
        move_(a, b, c, p);
    }
    else if (n>9)
    {
        printf("请输入在[1,9]区间内的数\n");
        move_(a, b, c, p);
    }
    else if (n<=3)
    {
        int q=n-1;
        if (a[q]!=0)
        {
            printf("这个位置已有棋子!\n");
            print_field(a, b, c);
            move_(a,b,c,p);
        }
        else
        {
        a[q]=p[0];
        }
    }
    else if (n>3&n<=6)
    {
        int q=n-4;
        if (b[q]!=0)
        {
            printf("这个位置已有棋子!\n");
            print_field(a, b, c);
            move_(a,b,c,p);
        }
        else
        {
        b[q]=p[0];
        }
    }
    else if (n>6&n<=9)
    {
        int q=n-7;
        if (c[q]!=0)
        {
            printf("这个位置已有棋子!\n");
            print_field(a, b, c);
            move_(a,b,c,p);
        }
        else
        {
        c[q]=p[0];
        }
    }
}
