package pkg1;
import pkg2.*;

public class A {
    protected int number;
    protected String name;

    public A(int number, String name){
        this.number=number;
        this.name=name;
    }

    public A() {
        number=100;
        name="Damian";
    }

    public void callDecrement(){
        decrement();
    }

    public void callIncrement(){
        increment();
    }

    public void callChangeName(){ changeName(); }

    private void increment(){
        number++;
        System.out.println(number);
    }

    protected void decrement(){
        number--;
        System.out.println(number);
    }

    void changeName(){
        name="Krzysiek";
        System.out.println(name);
    }
}