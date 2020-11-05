package CSE102Assignment4;


import java.util.*;

/**
 * @author Murat Can Kurt 20195156018
 * @since 15.04.2020
 */


public class Assignment04_20195156018 {
    public static void main(String[] args) {
        //For testing...
        /// DO NOT FORGET TO DELETE MAIN BEFORE SUBMIT
        Store s1 = new Store("Migros", "www.migros.com.tr");
        Store s2 = new Store("BIM", "www.bim.com.tr");

        Customer c = new Customer("CSE 102");
        Customer cc= new Customer("Club CSE 102");
        //s1.addCustomer(c); // compile error because no phone number given
        s1.addCustomer(cc,"05551234567");

        Product p = new Product("Computer",1000.00);
        FoodProduct fp = new FoodProduct("Snickers",2,250,false,true,false);
        ClothingProduct cp = new ClothingProduct("Shoes", 89,"44");
        System.out.println(cp);

        s1.addToInventory(p,20);
        s2.addToInventory(p,10);
        s2.addToInventory(fp,100);
        s1.addToInventory(cp,28);

        System.out.println(s1.getName()+" has "+s1.getCount()+" products");
        System.out.println(s1.getProductCount(p));

        System.out.println(s1.purchase(p,2));
        s1.addToInventory(p,3);
        System.out.println(s1.getProductCount(p));
        System.out.println(s2.getProductCount(p));
        //System.out.println(s1.getProductCount(fp)); //results in Exception
        //System.out.println(s2.purchase(fp,200)); //results in Exception

        c.addToCart(s1,p,2);
        c.addToCart(s1,fp,1); //NOTE: This does not stop the program because the Exception is caught
        c.addToCart(s1,cp,1);
        System.out.println("Total due - "+c.getTotalDue(s1));
        System.out.println("\n\nReceipt:\n"+c.receipt(s1));
        //System.out.println("\n\nReceipt:\n"+c.receipt(s2)); //results in Exception

        //System.out.println("After paying: "+c.pay(s1,2000)); //results in Exception

        System.out.println("After paying: "+c.pay(s1,2100));

        //System.out.println("Total due - "+c.getTotalDue(s1)); //results in Exception
        //System.out.println("\n\nReceipt:\n"+c.receipt(s1)); //results in Exception

        cc.addToCart(s2,fp,2);
        cc.addToCart(s2,fp,1);
        System.out.println(cc.receipt(s2));

        cc.addToCart(s2,fp,10);
        System.out.println(cc.receipt(s2));
    }
}
class Product {
    private String name;
    private double price;
    public Product (String name, double price){
        this.name = name;
        /** I wanted to set initial price and count attributes by setPrice() and addToInventory()
         * methods, Because I considered what id a negative value of price or count passed to constructor
         * when creating a new Product object.
         */
        setPrice(price);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) throws  InvalidPriceException {
        if (price >= 0)
            this.price = price;
        else throw new InvalidPriceException(price);
    }

    @Override
    public String toString() {
        return this.name+" @ "+this.price;
    }

}
class FoodProduct extends Product {
    private int calories;
    private boolean gluten;
    private boolean dairy;
    private boolean meat;
    public FoodProduct(String name, double price,
                       int calories, boolean gluten, boolean dairy, boolean meat){
        super(name, price);
        setCalories(calories);
        this.gluten = gluten;
        this.dairy = dairy;
        this.meat = meat;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        if (calories >= 0)
            this.calories = calories;
        else throw new InvalidAmountException(calories);
    }
    public boolean containsGluten(){
        return this.gluten;
    }
    public boolean containsDairy(){
        return this.dairy;
    }
    public boolean containsMeat(){
        return this.meat;
    }
}
class ClothingProduct extends Product {
    private String size;
    public ClothingProduct(String name, double price, String size){
        super(name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
class Customer{
    private String name;
    private HashMap<Store,HashMap<Product,Integer>> cart;
    public Customer(String name){
        this.name = name;
        cart = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addToCart(Store store, Product product, int count){
        HashMap<Product,Integer> tempCart= new HashMap<>();
        int countBefore = 0;
        try{
            store.purchase(product,count);
            if (cart.containsKey(store)){
                tempCart = cart.get(store);
                if (tempCart.containsKey(product))
                    countBefore = tempCart.get(product);
            }
            tempCart.put(product,countBefore + count);
            cart.put(store,tempCart);
        } catch (RuntimeException ex){
            System.out.println("ERROR: "+ex);
        }
    }
    public String receipt(Store store){
        if (!cart.containsKey(store))
            throw new StoreNotFoundException(store);
        String message = "Customer Receipt For "+store.getName();
        String productName = "";
        double productPrice = 0;
        int cartAmount = 0;
        for(Product p: cart.get(store).keySet()){
            productName = p.getName();
            productPrice = p.getPrice();
            cartAmount = cart.get(store).get(p);

            message = message.concat("\n"+productName+" - "+
                    productPrice+" x "+cartAmount + " = " +
                    productPrice * cartAmount +" TL");
        }
        return message + "\n----------------------------------------------\n"+
                "Total Due: " + this.getTotalDue(store) + "TL";
    }
    public double getTotalDue(Store store){
        if (!cart.containsKey(store))
            throw new StoreNotFoundException(store);
        double totalDue = 0;
        for (Product p: cart.get(store).keySet()){
            totalDue += p.getPrice()*cart.get(store).get(p);
        }
        return totalDue;
    }
    public double pay(Store store, double amount){
        double totalDue = getTotalDue(store);
        if (amount >= totalDue){
            System.out.println("Thank you for shopping with us...");
            cart.remove(store);
            return amount - totalDue;
        } else if (totalDue == 0)
            return 0;
        else throw new NotEnoughPaymentException(amount,totalDue);
    }
}
class Store{
    private String name;
    private String webSite;
    private Map<Product,Integer> inventory;
    private Map<String,Customer> clubCustomers;
    public Store(String newName, String newWebSite){
        inventory = new HashMap<>();
        clubCustomers = new HashMap<>();
        name = newName;
        webSite = newWebSite;
    }
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    public String getWebSite() {
        return webSite;
    }
    public void setWebSite(String newWebSite) {
        webSite = newWebSite;
    }
    public int getCount(){
        return inventory.size();
    }
    public void addCustomer(Customer customer, String phone){
        clubCustomers.put(phone,customer);
    }
    public int getProductCount(Product product){
        if (inventory.get(product) == null)
            throw new ProductNotFoundException(product.getName());
        return inventory.get(product);
    }
    public Customer getCustomer(String phone){
        if (!clubCustomers.containsKey(phone))
            throw new CustomerNotFoundException(phone);
        return clubCustomers.get(phone);

    }
    public void removeProduct(Product product){
        if (!inventory.containsKey(product))
            throw new ProductNotFoundException(product.getName());
        inventory.remove(product);
    }
    public void removeCustomer(String phone){
        if (!clubCustomers.containsKey(phone))
            throw new CustomerNotFoundException(phone);
        clubCustomers.remove(phone);
    }
    public void addToInventory(Product product, int amount){
        int amountBefore =0;
        if (amount < 0)
            throw new InvalidAmountException(amount);
        if (inventory.containsKey(product))
            amountBefore = inventory.get(product);
        inventory.put(product,amountBefore+amount);
    }
    public double purchase(Product product, int amount){
        if (amount < 0 || amount > getProductCount(product))
            throw new InvalidPurchaseException(amount,getProductCount(product));
        if (!inventory.containsKey(product))
            throw new ProductNotFoundException(product.getName());
        inventory.put(product,(getProductCount(product)-amount));
        return amount * product.getPrice();
    }
}

class InvalidPriceException extends RuntimeException {
    private double price;
    public InvalidPriceException(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "InvalidPriceException{" +
                "price=" + price +
                '}';
    }
}
class InvalidAmountException extends RuntimeException {
    private int amount;
    public InvalidAmountException(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "InvalidAmountException{" +
                "amount=" + amount +
                '}';
    }
}
class InvalidPurchaseException extends RuntimeException {
    private int amount;
    private int remaining;
    public InvalidPurchaseException(int amount, int remaining){
        this.amount= amount;
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "InvalidPurchaseException{" +
                "Requested amount=" + amount +
                ", Remaining amount=" +remaining+
                '}';
    }
}
class NotEnoughPaymentException extends RuntimeException {
    private double amount;
    private double due;
    public NotEnoughPaymentException(double amount, double due){
        this.amount = amount;
        this.due = due;
    }

    @Override
    public String toString() {
        return "NotEnoughPaymentException{" +
                "due=" + due +
                ", given=" + amount +
                '}';
    }
}
class ProductNotFoundException extends RuntimeException {
    private String name;
    public ProductNotFoundException(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductNotFoundException{" +
                "name='" + name + '\'' +
                '}';
    }
}
class CustomerNotFoundException extends RuntimeException {
    private String phone;
    public CustomerNotFoundException(String phone){
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerNotFoundException{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
class StoreNotFoundException extends RuntimeException{
    private String name;
    public StoreNotFoundException(Store store){
        this.name = store.getName();
    }
    @Override
    public String toString() {
        return "StoreNotFoundException{" +
                "No cart for '" + name + '\'' +
                '}';
    }
}