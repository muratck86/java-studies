package CSE102Assignment1;

/**
 * @author Murat Can Kurt 20195156018
 * @since 09.03.2020
 */


public class Assignment01_20195156018 {
    public static void main(String[] args) {
        //For testing...
        /// DO NOT FORGET TO DELETE MAIN BEFORE SUBMIT

        CSE102Assignment1.Store s = new CSE102Assignment1.Store("Migros","www.migros.com.tr", 3);

        CSE102Assignment1.Customer c = new CSE102Assignment1.Customer("CSE 102");
        System.out.println(c.getName());

        CSE102Assignment1.ClubCustomer cc = new CSE102Assignment1.ClubCustomer("Club CSE 102","05443034910");
        System.out.println(cc.getPhone());

        CSE102Assignment1.Product p = new CSE102Assignment1.Product("Computer", 1000.00,20);
        CSE102Assignment1.FoodProduct fp = new CSE102Assignment1.FoodProduct("Snickers",2,100,
                250,false,true,false);
        CSE102Assignment1.ClothingProduct cp = new CSE102Assignment1.ClothingProduct("Shoes",89,28,"44");

        for (int i = 0; i < s.getInventorySize();i++)
            System.out.println(s.getProduct(i));
        s.addProduct(p);
        s.addProduct(fp);

        for (int i = 0; i < s.getCount(); i++)
            System.out.println(s.getProduct(i));
        s.addProduct(cp);

        System.out.println(cp.purchase(2));
        if(fp.containsGluten())
            System.out.println("My wife can NOT eat or drink "+fp.getName());
        else System.out.println("My wife CAN eat or drink "+fp.getName());
        s.getProduct(0).addToInventory(3);
        for (int i = 0; i < s.getCount(); i++)
            System.out.println(s.getProduct(i));


    }

}
class Product {
    private String name;
    private double price;
    private int count;
    public Product (String name, double price, int count){
        this.name = name;
        this.price = price;
        this.count = count;
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
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void addToInventory(int amount){
        if (amount > 0)
            this.count +=amount;
    }
    public double purchase(int amount){
        if (amount < 0 || amount > this.count)
            return 0;
        else {
            this.count -= amount;
            return amount * this.price;
        }
    }
    @Override
    public String toString() {
        return "Product '" +this.name+"' has '"+this.count+"' remaining.";
    }
}
class FoodProduct extends CSE102Assignment1.Product {
    private int calories;
    private boolean gluten;
    private boolean dairy;
    private boolean meat;
    public FoodProduct(String name, double price, int count,
                       int calories, boolean gluten, boolean dairy, boolean meat){
        super(name, price, count);
        this.calories = calories;
        this.gluten = gluten;
        this.dairy = dairy;
        this.meat = meat;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
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
class ClothingProduct extends CSE102Assignment1.Product {
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
    public Customer(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class ClubCustomer extends CSE102Assignment1.Customer {
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
    private int count;
    private CSE102Assignment1.Product[] inventory;
    public Store(String newName, String newWebSite, int newCount){
        name = newName;
        webSite = newWebSite;
        count = newCount;
        inventory = new CSE102Assignment1.Product[count];
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
    public int getInventorySize(){
        return inventory.length;
    }
    public int getCount(){
        int s = 0;
        for (CSE102Assignment1.Product p:inventory){
            if (p != null)
                s ++;
        }
        return s;
    }
    public void addProduct(CSE102Assignment1.Product product){
        int index = getCount();
        if (index < inventory.length)
            inventory[getCount()] = product;
    }
    public CSE102Assignment1.Product getProduct(int index){
        if (index < 0 || index >=getCount())
            return null;
        else return inventory[index];
    }
}


