package ru.hse.my;

// точка с координатами x,y,z
// наследуется от Point
public class Point3D extends Point{
    double z = 0;

    Point3D(double x, double y, double z) {
        super(x, y); // обращаемся к конструктору родительского класса
        this.z = z;
    }

    @Override
    public void show(){
        System.out.printf("(%f ; %f ; %f)\n", x, y, z);
    }


}
