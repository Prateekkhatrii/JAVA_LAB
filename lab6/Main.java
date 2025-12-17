// Custom Exception Class
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Base Class
class Father {
    int fatherAge;

    Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        fatherAge = age;
        System.out.println("Father's age: " + fatherAge);
    }
}

// Derived Class
class Son extends Father {
    int sonAge;

    Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);  // Call Father constructor

        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative!");
        }

        // Additional check: Son age must be less than Father age
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age must be less than father's age!");
        }

        this.sonAge = sonAge;
        System.out.println("Son's age: " + sonAge);
    }
}

// Main Class to Test
public class Main {
    public static void main(String[] args) {
        try {
            Son s = new Son(40, 20);   // valid
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("------------------");

        try {
            Son s2 = new Son(30, 35);  // invalid -> son's age > father's
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("------------------");

        try {
            Son s3 = new Son(-45, 10); // invalid -> father's age is negative
        } catch (WrongAge e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
