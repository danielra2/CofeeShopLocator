package mycode.cofeeshop.service;
import java.util.List;
import mycode.cofeeshop.models.CoffeeShop;

public interface CoffeeShopQuerryService{
    List<CoffeeShop>getClosestShops(double userX,double userY,String path);
}