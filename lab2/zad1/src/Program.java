import pkg1.*;
import pkg2.*;

public class Program {
    public static void main(String[] args){
        A o1 = new A(20,"Damian");
        B o2 = new B();
        C o3 = new C();

        o1.callDecrement();
        o1.callDecrement();
        o1.callIncrement();
        o1.callChangeName();

        o2.callDecrement();
        o2.callDecrement();
        o2.callIncrement();
        o2.callChangeName();

        o3.callDecrement();
        o3.callDecrement();
        o3.callIncrement();
        o3.callChangeName();
    }

}