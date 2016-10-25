import java.util.Scanner;

public class Shape {
    //三角形面积方法1(底乘高):
    public void riangle1(){
        System.out.println("请输入三角形底和高");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s;
        s = n * m / 2;
        System.out.println("三角形面积为:"+s);
    }
}
class test extends Shape {
    //三角形面积方法2:
    public void riangle2() {
        System.out.println("请输入三角形三边长");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        if (a + b > c && a + c > b && b + c > a) {
            double l, s, S;
            l = (a + b + c) / 2;
            s = l * (l - a) * (l - b) * (l - c);
            S = Math.sqrt(s);
            System.out.println("三角形面积大约为:"+S);
        } else {
            System.out.print("无法构成三角形");
        }
    }

    //正方形面积方法:
    public void square() {
        System.out.println("请输入正方形边长");
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        double s;
        s = Math.pow(d, 2);
        System.out.println("正方形面积为:"+s);
    }

    //圆形面积方法:
    public void circular() {
        System.out.println("请输入圆半径");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double π = 3.1415926535;
        double s;
        s = π * (Math.pow(r, 2));
        System.out.println("圆形面积大约为:"+s);
    }
    public static void main(String[] args) {
        Shape a = new test();
        test b = (test)a;
        b.riangle1();
        b.riangle2();
        b.square();
        b.circular();
    }
}


