package mycode.cofeeshop.models;
public class CoffeeShop{
    private String name;
    private double x;
    private double y;
    private double distance;

    public CoffeeShop(String name,double x,double y,double distance){
        this.name=name;
        this.x=x;
        this.y=y;
        this.distance=distance;
    }

    public String getName(){return name;}
    public double getDistance(){return distance;}
}