//
//  三子棋
//

#include <stdio.h>

void print_field(int line_1[3], int line_2[3], int line_3[3]);
void c_move(int a[3], int b[3], int c[3], int p[1], int state[1]);
int check(int a[3], int b[3], int c[3]);
void change(int p[1]);
void turn(int p[1]);
void system_(void);
int quit(void);


//The game.
void game(void)
{
    int turns=0;
    int cheat[1] = {0};
    int state = 8;
    int p[1]={1};//this is player identity
    int line_1[3]={0,0,0};
    int line_2[3]={0,0,0};
    int line_3[3]={0,0,0};
    printf("游戏开始!\n 先手玩家为玩家1, 后手玩家为玩家2.\n");
    printf("玩家1图标: o\n玩家2图标: x\n");
    print_field(line_1, line_2, line_3);
    while (state==8)
    {
        turn(p);
        c_move(line_1, line_2, line_3,p, cheat);
        turns+=1;
        state=check(line_1, line_2, line_3);
        if (turns==9&state==8)
        {
            printf("平局!\n");
            state=9;
        }
        change(p);
    }
    int k;
    printf("游戏结束! \n输入2开始新游戏。\n输入其他任意键来退出。\n");
    scanf("%d", &k);
    if (k==2)
    {
        game();
    }
    else
    {
        quit();
    }
}

