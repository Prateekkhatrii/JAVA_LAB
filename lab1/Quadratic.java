import java.util.*;
public class Quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficient of a: ");
        double a = sc.nextDouble();
        System.out.println("Enter coefficient of b: ");
        double b = sc.nextDouble();
        System.out.println("Enter coefficient of c: ");
        double c = sc.nextDouble();
        double d =(b*b)- (4*a*c);
        if(d>0)
        {
            double r1= (-b+Math.sqrt(d))/(2*a);
            double r2= (-b-Math.sqrt(d))/(2*a);
            System.out.println("The roots are real and diffrent");
            System.out.println("1st root="+r1);
            System.out.println("2nd root="+r2);
        }
       else if (d == 0) {
            double r = -b / (2 * a);
            System.out.println("Roots are equal and real: " + r);
        } else {
            double realpart = -b / (2 * a);
            double imgpart = Math.sqrt(-d) / (2 * a);
            System.out.println("The roots are complex:");
            System.out.println("root1 = " + realpart + " + " + imgpart + "i");
            System.out.println("root2 = " + realpart + " - " + imgpart + "i");
        }
       
        }
    }
