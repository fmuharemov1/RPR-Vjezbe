package com.example.tut6;

public class Model {
    public double izracunaj(double broj1, double broj2, String operator)
    {

        if(operator.equals("+")) return broj1 + broj2;
        if(operator.equals("-")) return broj1 - broj2;
        if(operator.equals("/")) return broj1 / broj2;
        if(operator.equals("x")) return broj1 * broj2;
        if(operator.equals("%")) return (broj1*100)/broj2;

        return 0;
    }
}
