package mycode;
import mycode.cofeeshop.service.*;
import mycode.cofeeshop.models.*;
import java.util.*;

public class Main{
    public static void main(String[]args){
        if(args.length!=3){
            System.err.println("Invalid args");
            System.exit(1);
        }
        try{
            double x=Double.parseDouble(args[0]);
            double y=Double.parseDouble(args[1]);
            String path=args[2];
            CoffeeShopQuerryService service=new CoffeeShopQuerryServiceImpl();
            List<CoffeeShop>result=service.getClosestShops(x,y,path);
            for(CoffeeShop s:result){
                System.out.printf(Locale.US,"%s,%.4f\n",s.getName(),s.getDistance());
            }
        }catch(Exception e){
            System.exit(1);
        }
    }
}