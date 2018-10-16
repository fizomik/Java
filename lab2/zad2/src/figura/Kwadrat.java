package figura;

public class Kwadrat {
    protected double a;

    public Kwadrat(double a){
        this.a=a;
    }

    public double getA(){

        return a;
    }

    public void setA(double a){

        this.a=a;

    }

    public double area(){

        return a*a;

    }

    public boolean isBigger(Kwadrat o1){

        return o1.a>this.a;

    }
}
