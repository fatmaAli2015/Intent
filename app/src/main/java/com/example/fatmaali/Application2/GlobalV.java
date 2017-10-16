package com.example.fatmaali.Application2;

import android.app.Application;

/**
 * Created by Fatma Ali on 06/09/2017.
 */

public class GlobalV extends Application{
    private String name="eman";
    private int Num=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }
}
