package com.example.raspisanie;

public class Day {
    public int type[] = new int[6]; //Тип 0 Практика Тип 1 Лекция Тип 2 Пустая пара

    public String place[] = new String[6];
    public String subject[] = new String[6];
    public String teacher[] = new String[6];
    public String info[] = new String[6];

    public Day(){
        for(int i = 0; i < 6; i++){
            type[i] = 3;
            place[i] = "";
            subject[i] = "";
            teacher[i] = "";
            info[i] = "";
        }
    }
}
