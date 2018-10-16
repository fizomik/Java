package pkg1;
import pkg2.*;

public class B extends A {


    protected void decrement()
    {
        number-=2;
        System.out.println(number);
    }


    private void increment()
    {
        number+=2;
        System.out.println(number);
    }

    void changeName()
    {
        name="Robert";
        System.out.println(name);

    }
    public B(){

    }

}