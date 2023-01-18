public class SimpleCircle {
    //Property
    double radius = 10;

    //Constructor
    SimpleCircle(){}
    SimpleCircle(double r) {radius = r;}

    //Behaviour - Method - Function
    double calculateArea(){
        double area;
        area = radius * radius * Math.PI;
        return area;
    }
}
