package figura;

public class Prostokąt extends Kwadrat {
    protected double b;

    public Prostokąt(double a, double b){
        super(a);
        this.b=b;

    }
    public void setB(double b){
        this.b=b;

    }

    public double getB(){

        return b;

    }

    public boolean isBigger(Prostokąt o1){

        return o1.a*o1.b>this.a*this.b;

    }
}
