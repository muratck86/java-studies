package CSE102Assignment2;


import java.util.ArrayList;

/**
 * @author Murat Can Kurt 20195156018
 * @since 12.04.2020
 */


public class Assignment02_20195156018 {
    public static void main(String[] args) {
        //For testing...
        /// DO NOT FORGET TO DELETE MAIN BEFORE SUBMIT

        Store s = new Store("Migros","www.migros.com.tr");

        Customer c = new Customer("CSE 102");

        ClubCustomer cc = new ClubCustomer("Club CSE 102","05551234567");
        //s.addCustomer(c); //compiler error because c is Customer not ClubCustomer
        s.addCustomer(cc);

        Product p = new Product("Computer", 1000.00,20);
        FoodProduct fp = new FoodProduct("Snickers",2,100,250,false,true,false);
        ClothingProduct cp = new ClothingProduct("Shoes",89,28,"44");

        s.addProduct(p);
        s.addProduct(fp);
        s.addProduct(cp);

        System.out.println(s.getCount());
        System.out.println(s.getProduct("shoes"));

        System.out.println(cp.purchase(2));
        s.getProduct("Computer").addToInventory(3);
        //System.out.println(fp.purchase(200)); //results in Exception

        c.addToCart(p,2);
        c.addToCart(s.getProduct("Snickers"), -2); //NOTE: This does not stop the program because the exception is caught
        c.addToCart(s.getProduct("Snickers"),1);
        System.out.println("Total due: "+c.getTotalDue());
        System.out.println("\n\nTotal Receipt:\n"+c.receipt());

        //System.out.println("After Paying: "+c.pay(2000)); //result in Exception

        System.out.println("After Paying: "+c.pay(2020));

        System.out.println("Total due: "+c.getTotalDue());
        System.out.println("\n\nTotal Receipt:\n"+c.receipt());
        //Product pt01 = new Product("ExampleProduct1",-50,2);
        //Product pt02 = new Product("ExampleProduct2",50,-12);
        //Product pt03 = new Product("ExampleProduct3",-50,-22);
        Product pt04 = new Product("ExampleProduct4",55,33);
        System.out.println(pt04.toString());
        Customer c2 = s.getCustomer("05551234567");
        cc.addToCart(s.getProduct("snickers"),2);
        cc.addToCart(s.getProduct("Snickers"),1);
        System.out.println(cc.receipt());

        s.getCustomer("05551234567").addToCart(s.getProduct("snickers"),10);
        System.out.println(cc.receipt());







    }

}
class Product {
    private String name;
    private double price;
    private int count;
    public Product (String name, double price, int count){
        this.name = name;
        /** I wanted to set initial price and count attributes by setPrice() and addToInventory()
         * methods, Because I considered what id a negative value of price or count passed to constructor
         * when creating a new Product object.
         */
        setPrice(price);
        addToInventory(count);
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
    public int getCount() {
        return count;
    }
    public void addToInventory(int amount) throws InvalidAmountException {
        if (amount >= 0)
            this.count += amount;
        else throw new InvalidAmountException(amount);
    }
    public double purchase(int amount) throws  InvalidPurchaseException {
        if (amount > 0 && amount <= this.count) {
            this.count -= amount;
            return amount * this.price;
        } else throw new InvalidPurchaseException(amount,count);
    }
    @Override
    public String toString() {
        return "Product '" +this.name+"' has '"+this.count+"' remaining.";
    }

}
class FoodProduct extends Product {
    private int calories;
    private boolean gluten;
    private boolean dairy;
    private boolean meat;
    public FoodProduct(String name, double price, int count,
                       int calories, boolean gluten, boolean dairy, boolean meat){
        super(name, price, count);
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
    public ClothingProduct(String name, double price,int count, String size){
        super(name, price,count);
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
    private ArrayList<Product> productsInCart = new ArrayList<>();
    private ArrayList<Integer> amountsInCart = new ArrayList<>();
    public Customer(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addToCart(Product product, int count){
        try{
            product.purchase(count);
            productsInCart.add(product); amountsInCart.add(count);
        } catch (InvalidPurchaseException ex){
            System.out.println("ERROR: "+ex);
        }
    }
    public String receipt(){
        String message = "";
        String productName = "";
        double productPrice = 0;
        int cartAmount = 0;
        for(int i = 0; i < productsInCart.size();i++ ){
            productName = productsInCart.get(i).getName();
            productPrice = productsInCart.get(i).getPrice();
            cartAmount = amountsInCart.get(i);

            message = message.concat("\n"+productName+" - "+
                    productPrice+" x "+cartAmount + " = " +
                    productPrice * cartAmount +" TL");
        }
        if (getTotalDue() == 0)
            return "There is nothing in your cart...";
        else
            return message + "\n----------------------------------------------\n"+
                "Total Due: " + this.getTotalDue() + "TL";
    }
    public double getTotalDue(){
        double totalDue = 0;
        for (int i = 0; i < productsInCart.size(); i++){
            totalDue += productsInCart.get(i).getPrice()*amountsInCart.get(i);
        }
        return totalDue;
    }
    public double pay(double amount){
        double totalDue = getTotalDue();
        if (amount >= totalDue && totalDue > 0){
            System.out.println("Thank you for shopping with us...");
            productsInCart.clear();
            amountsInCart.clear();
            return amount - totalDue;
        } else if (totalDue == 0)
            return 0;
        else throw new NotEnoughPaymentException(amount,totalDue);
    }
}
class ClubCustomer extends Customer {
    private String phone;
    public ClubCustomer(String name, String phone){
        super(name);
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
class Store{
    private String name;
    private String webSite;
    private ArrayList<Product> inventory = new ArrayList<>();
    private ArrayList<ClubCustomer> clubCustomers = new ArrayList<>();
    public Store(String newName, String newWebSite){
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

    public void addProduct(Product product){
            inventory.add(product);
    }
    public void addCustomer(ClubCustomer customer){
        clubCustomers.add(customer);
    }

    public Product getProduct(String name){
        for (Product p:inventory){
            if (p.getName().equalsIgnoreCase(name))
                return p;
        }
        throw new ProductNotFoundException(name);
    }
    public Customer getCustomer(String phone){
        for (ClubCustomer c:clubCustomers){
            if (c.getPhone().equals(phone))
                return c;
        }
        throw new CustomerNotFoundException(phone);
    }
    public void removeProduct(String name){
        inventory.remove(getProduct(name));
    }
    public void removeCustomer(String phone){
        clubCustomers.remove(getCustomer(phone));
    }
}
class InvalidPriceException extends RuntimeException {
    private double price;
    public InvalidPriceException(double price){
    this.price = price;
    }
    public double getPrice(){return price;}

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