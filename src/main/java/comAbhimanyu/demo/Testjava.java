package comAbhimanyu.demo;

class P {

    void m1() {
        System.out.println("m1() from Parent");
    }

    void m2() {
        System.out.println("m2() from Parent");
    }

    void m3() {
        System.out.println("m3() from Parent");
    }
}

class C extends P {

    void m4() {
        System.out.println("m4() from Child");
    }
}

public class Testjava {

    public static void main(String[] args) {

        // Parent reference -> Child object (Upcasting)
        P ref = new C();

        ref.m1();
        ref.m2();
        ref.m3();

        // ref.m4(); //  Compile-time Error
    }
}
