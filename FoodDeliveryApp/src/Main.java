import java.util.*;
import java.lang.*;
import java.io.*;

interface Payment{
    void pay(String uname,int total);
}

class Cash implements Payment{


    public void pay(String uname, int total){
        System.out.println("thank you "+ uname+ " for paying "+ total+" in cash");
    }
}

class UPI implements Payment{
    public void pay(String uname, int total){
        System.out.println("thank you "+ uname+ " for paying "+ total+" through UPI");
    }
}

class Notification{

    public void sendNotification(String uname){
        System.out.println("thank you for ordering "+uname);
    }
}


class Item{
    String iname;
    int price;

    public Item(String iname, int price){
        this.iname=iname;
        this.price=price;
    }
}

class Restaurant{
    String rname;
    List<Item> menu;

    public Restaurant(String rname){
        this.rname=rname;
        this.menu=new ArrayList<>();
    }

    public void addMenu(Item item){
        menu.add(item);
    }

    public Item selectItem(String name){
        for(Item i:menu){
            if(i.iname==name){
                return i;
            }
        }
        return null;
    }

}

class Cart{
    List<Item> items= new ArrayList<>();
    int total;


    public void addItem(Item item){
        items.add(item);
    }

    public int getTotal(){
        total=0;
        for(Item i:items){
            total = total+i.price;
        }
        return total;
    }
}

class RestaurantManager{
    List<Restaurant> restaurants= new ArrayList<>();

    public void addRestaurant(Restaurant r){
        this.restaurants.add(r);
    }

    public Item getItemFromRes(String rname, String iname){
        for(Restaurant r: restaurants){
            if(rname==r.rname){
                Item item=r.selectItem(iname);
                return item;
            }
        }
        return null;
    }

    public Restaurant getRestaurant(String rname){
        for(Restaurant r: restaurants){
            if(rname==r.rname){
                return r;
            }
        }
        return null;
    }

    public void addItemToRes(String rname, Item item){
        for(Restaurant r: restaurants){
            if(rname==r.rname){
                r.addMenu(item);
            }
        }
    }


}


class User{
    String uname;
    Cart cart;
    RestaurantManager rm;
    Payment paymentStrategy; // paymentStrategy
    Notification notificationStrategy;

    public User(String name, Cart cart, RestaurantManager rm, Payment ps, Notification ns){
        this.uname=name;
        this.cart=cart;
        this.rm=rm;
        this.paymentStrategy=ps;
        this.notificationStrategy=ns;
    }

    public void searchRestaurant(String rname){
        Restaurant r=rm.getRestaurant(rname);
        if(r==null){
            System.out.println("no Restaurant present with "+ rname +" name");
        }else{
            System.out.println("Thank you for choosing "+ rname);
        }
    }

    public void addItemToCart(String rname, String iname){
        Item item=rm.getItemFromRes(rname,iname);
        cart.addItem(item);
    }

    public void pay(){
        int total=cart.getTotal();
        if(cart.items.size()==0){
            System.out.println("no item in cart");
            return;
        }
        paymentStrategy.pay(uname,total);
        notificationStrategy.sendNotification(uname);
    }

}


class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        RestaurantManager rm=new RestaurantManager();

        Restaurant r1= new Restaurant("r1");
        Restaurant r2= new Restaurant("r2");

        rm.addRestaurant(r1);
        rm.addRestaurant(r2);

        Item i1=new Item("samosa", 5);
        Item i2= new Item("jalebi", 10);
        Item i3= new Item("dosa", 15);
        rm.addItemToRes("r1",i1);
        rm.addItemToRes("r2",i2);
        rm.addItemToRes("r1",i2);
        rm.addItemToRes("r1",i3);

        Payment p=new Cash();

        Notification n=new Notification();

        Cart c=new Cart();

        User abhishek = new User("Abhi", c,rm,p,n);

        abhishek.searchRestaurant("r1");
        abhishek.searchRestaurant("r5");

        abhishek.pay();

        abhishek.addItemToCart("r1","samosa");
        abhishek.addItemToCart("r2","jalebi");

        abhishek.pay();


    }
}
