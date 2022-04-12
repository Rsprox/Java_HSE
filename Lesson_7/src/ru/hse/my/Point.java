package ru.hse.my;

// точка с координата x,y
public class Point extends AbstractPoint{
    double x = 0;
    double y = 0;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void show() {
        System.out.printf("(%f ; %f)\n", x, y);
    }
}
