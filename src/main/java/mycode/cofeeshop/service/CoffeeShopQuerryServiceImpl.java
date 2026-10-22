package mycode.cofeeshop.service;
import java.util.*;
import java.io.*;
import java.net.*;
import mycode.cofeeshop.models.CoffeeShop;

public class CoffeeShopQuerryServiceImpl implements CoffeeShopQuerryService{
    @Override
    public List<CoffeeShop>getClosestShops(double userX,double userY,String path){
        List<CoffeeShop>shops=new ArrayList<>();
        try{
            InputStream in=path.startsWith("http")?new URL(path).openStream():new FileInputStream(path);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            String line;
            while((line=br.readLine())!=null){
                String[]p=line.split(",");
                if(p.length!=3){
                    System.err.println("Malformed entry");
                    System.exit(1);
                }
                // Parsed col 1 as X and col 2 as Y to match the exact distances in the example.
                double shopX=Double.parseDouble(p[1].trim());
                double shopY=Double.parseDouble(p[2].trim());
                double dist=Math.sqrt(Math.pow(shopX-userX,2)+Math.pow(shopY-userY,2));
                shops.add(new CoffeeShop(p[0].trim(),shopX,shopY,dist));
            }
            br.close();
        }catch(Exception e){
            System.err.println("Fatal error");
            System.exit(1);
        }
        shops.sort(Comparator.comparingDouble(CoffeeShop::getDistance));
        if(shops.size()>3){
            return shops.subList(0,3);
        }
        return shops;

    }
}