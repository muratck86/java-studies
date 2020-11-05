package CSE102Assignment3;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Murat Can Kurt
 * @since 22.04.2020
 */

public class Assignment03Tests_20195156018 {
    /**Instantiation of Product Class and its subclasses...*/
    String fpName1 = "Çokomel";
    String fpName2 = "Çokoprens";
    String cpName1 = "Ray-Ban Sun Glasses";
    String cpName2 = "Nike Air";
    double doubleNormal = 122.55;
    double doubleNormal2 = 178.45;
    double doubleNeg = -145.12;
    int intNormal = 150;
    int intNormal2 = 220;
    int intNeg = -16;
    String size1 = "Large";
    String size2 = "XLarge";

    Product sampleP1 = new Product(fpName1,doubleNormal,intNormal);
    FoodProduct foodP1 = new FoodProduct(fpName2,doubleNormal,intNormal,intNormal,true,false,false);
    ClothingProduct clothingP1 = new ClothingProduct(cpName1,doubleNormal,intNormal,size1);

    /**Instantiation of Customer and ClubCustomer Classes...*/
    String customerName1 = "Example Ali";
    String customerName2 = "Example Veli";
    String customerPhone1 = "001";
    String customerPhone2 = "05321234569";

    Customer cust1 = new Customer(customerName1);
    ClubCustomer clubCust1 = new ClubCustomer(customerName2,customerPhone1);


    /**Instantiation of Store Class...*/
    String storeName = "SimpleBuy";
    String storeName2 = "EasyPeasyBuy";
    String storeWeb = "www.simplebuy.com";
    String storeWeb2 = "easypeasy.com";
    private Store store01 = new Store(storeName,storeWeb);


    //TEST CASES

    @Before
    public void setUp() throws Exception {
    }


    /** Testings of methods of Product and its Subclasses... */

    @Test
    /** to test if an object of testProduct1 is created */
    public void TestProduct01(){
        Product testProduct1 = new Product("Example Product",doubleNormal,intNormal);
        assertTrue(testProduct1 instanceof Product);
    }
    @Test
    public void TestProductGetName01(){
        assertEquals(fpName1, sampleP1.getName());
    }
    @Test
    public void TestProductSetName01(){
        sampleP1.setName(fpName2);
        assertEquals(fpName2,sampleP1.getName());
    }
    @Test
    public void TestGetPrice01(){
        assert(doubleNormal == sampleP1.getPrice());
    }
    @Test
    public void TestSetPrice01(){
        sampleP1.setPrice(doubleNormal2);
        assert(doubleNormal2 == sampleP1.getPrice());
    }
    @Test
    public void TestSetPrice02() {
        double price = sampleP1.getPrice();
        try {
            sampleP1.setPrice(doubleNeg);
            throw new RuntimeException();
        } catch (Exception ex){
            assert(ex instanceof InvalidPriceException);
            assert(price == sampleP1.getPrice());
        }
    }
    @Test
    public void TestSetPrice03(){
        sampleP1.setPrice(0.0);
        assert(0.0 == sampleP1.getPrice());
    }
    @Test
    public void TestGetCount01(){
        assert (intNormal == sampleP1.getCount());
    }
    @Test
    public void TestAddToInventory01(){
        double amount = sampleP1.getCount();
        try {
            sampleP1.addToInventory(intNeg);
            throw new RuntimeException();
        } catch (Exception ex){
            assert (ex instanceof InvalidAmountException);
            assert (amount == sampleP1.getCount());
        }
    }
    @Test
    public void TestAddToInventory02(){
        int amount = sampleP1.getCount();
        sampleP1.addToInventory(intNormal2);
        assert (intNormal2+amount == sampleP1.getCount());
    }
    @Test
    public void TestAddToInventory03(){
        int amount = sampleP1.getCount();
        sampleP1.addToInventory(0);
        assert (amount == sampleP1.getCount());
    }
    @Test
    public void TestPurchase01(){
        sampleP1.purchase(1);
    }
    @Test
    public void TestPurchase02(){
        try {
            sampleP1.purchase(sampleP1.getCount() + 5);
            throw new RuntimeException();
        }catch (Exception ex){
            assert (ex instanceof InvalidPurchaseException);
        }
    }
    @Test
    public void TestPurchase03(){
        try{
            sampleP1.purchase(intNeg);
            throw new RuntimeException();
        }catch (Exception ex){
            assert (ex instanceof InvalidPurchaseException);
        }
    }
    @Test
    public void TestPurchase04(){
        assertTrue (sampleP1.purchase(2) == (2*sampleP1.getPrice()));
    }


    @Test
    public void TestFoodProduct01(){
        FoodProduct pr1 = new FoodProduct(fpName1,doubleNormal,intNormal,intNormal2,false,true,false);
        assertTrue(fpName1.equals(pr1.getName()));
//
    }
    @Test
    public void TestGetCalories01(){
        assert (intNormal == foodP1.getCalories());
    }
    @Test
    public void TestSetCalories01(){
        foodP1.setCalories(intNormal2);
        assert (intNormal2 == foodP1.getCalories());
    }
    @Test
    public void TestSetCalories02(){
        try{
            foodP1.setCalories(intNeg);
            throw new RuntimeException();
        }catch (Exception ex){
            assert (ex instanceof InvalidAmountException);
            assert (intNormal == foodP1.getCalories());
        }
    }
    @Test
    public void TestContainsGluten01(){
        assert(foodP1.containsGluten());
    }
    @Test
    public void TestContainsDairy01(){
        assert (!foodP1.containsDairy());
    }
    @Test
    public void TestContainsMeat01(){
        assert (!foodP1.containsMeat());
    }

    @Test
    public void TestClothingProduct01(){
        ClothingProduct cl1 = new ClothingProduct("T-Shirt",330.0,65,"S");
        assertEquals("T-Shirt",cl1.getName());
    }
    @Test
    public void TestGetSize01(){
        assertEquals(size1,clothingP1.getSize());
    }
    @Test
    public void TestSetSize01(){
        clothingP1.setSize(size2);
        assertEquals(size2,clothingP1.getSize());
    }
    @Test
    public void TestSetSize02(){
        clothingP1.setSize("Very Large");
        /**size attribute could be described more specific...*/
        ArrayList<String> sizeList =new ArrayList<>(Arrays.asList("Small","XSmall","Medium","Large","Xlarge"));
        assertTrue(sizeList.contains(clothingP1.getSize()));
    }

    @Test
    public void TestCustomer01(){
        Customer c = new Customer("Ali Veli");
        assertEquals("Ali Veli",c.getName());
    }
    @Test
    public void TestCustomerGetName01(){
        assertSame(customerName1, cust1.getName());
    }
    @Test
    public void TestCustomerSetName01(){
        cust1.setName(customerName2);
        assertSame(customerName2, cust1.getName());
    }
    @Test
    public void TestCustomerSetName02(){
        /** Customer name attribute could be defined more specific...*/
        /** is customer name consists of letters and spaces? */
        cust1.setName("54_Murat");
        assertTrue(cust1.getName().matches("[a-z A-Z]+"));
    }
    @Test
    public void TestCustomerSetName03(){
        /** is customer name contains at least one space between name and last name? */
        cust1.setName("MuratCanKurt");
        assertTrue(cust1.getName().contains(" "));
    }
    @Test
    public void TestAddToCart01(){
        cust1.addToCart(sampleP1,2);
        assertEquals(sampleP1.getPrice()*2,cust1.getTotalDue(),0.0001);
        cust1.addToCart(foodP1,5);
        double totalPrice = sampleP1.getPrice()*2+
                foodP1.getPrice()*5;
        assertEquals(totalPrice, cust1.getTotalDue(),0.0001);
        cust1.addToCart(clothingP1,1);
        totalPrice += clothingP1.getPrice()*1;
        assertEquals(totalPrice, cust1.getTotalDue(),0.0001);
    }
    @Test
    public void TestReceipt01(){
        cust1.addToCart(sampleP1,2);
        cust1.addToCart(foodP1,5);
        cust1.addToCart(clothingP1,1);
        String receipt01 = cust1.receipt();
        assertTrue(receipt01.contains(sampleP1.getName()) &&
                receipt01.contains("2") &&
                receipt01.contains(foodP1.getName()) &&
                receipt01.contains("5") &&
                receipt01.contains(clothingP1.getName()) &&
                receipt01.contains("1") &&
                receipt01.contains(String.valueOf(cust1.getTotalDue()))
        );
    }
    @Test
    public void TestReceipt02(){
        assert (cust1.getTotalDue() == 0);
        assertTrue(cust1.receipt().contains("There is nothing in your cart..."));
    }
    @Test
    public void TestGetTotalDue01(){
        cust1.addToCart(sampleP1,3);
        cust1.addToCart(sampleP1,1);
        cust1.addToCart(foodP1,5);
        cust1.addToCart(clothingP1,0);
        double total = sampleP1.getPrice() * 4 + foodP1.getPrice() * 5;
        assertTrue(total == cust1.getTotalDue());
    }
    @Test
    public void TestPay01(){
        assertTrue("No shopping, all payment must be returned..",75.50 == clubCust1.pay(75.50));
    /** return value of the pay method must be equal to paid amount, if totalDue is 0 */
    }
    @Test
    public void TestPay02(){
        clubCust1.addToCart(sampleP1, 3);
        clubCust1.addToCart(foodP1,3);
        clubCust1.addToCart(clothingP1,1);
        assertEquals(2500 - clubCust1.getTotalDue(),clubCust1.pay(2500),0.0001);
    }

    @Test
    public void TestClubCustomer(){
        Customer cl = new ClubCustomer("Ahmet Tamer","9876543210");
        assertTrue("Ahmet Tamer".equals(cl.getName()));
    }
    @Test
    public void TestGetPhone01(){
        assertTrue(customerPhone1.equals(clubCust1.getPhone()));
    }
    @Test
    public void TestSetPhone01(){
        clubCust1.setPhone(customerPhone2);
        assertTrue(customerPhone2.equals(clubCust1.getPhone()));
        clubCust1.setPhone(customerPhone1);
        assertTrue(customerPhone1.equals(clubCust1.getPhone()));
    }
    @Test
    /** Check if the phone number consists of numbers */
    public void TestSetPhone02(){
        clubCust1.setPhone("phone");
        assertTrue(clubCust1.getPhone().matches("[0-9]+"));
    }

    /**Testings of methods of Store */
    @Test
    public void TestStore(){
        Store exStore = new Store("EasyPeasy","www.easypeasy.com");
        assert ("EasyPeasy".equals(exStore.getName()));
    }
    @Test
    public void TestStoreGetName01(){
        assertEquals(storeName, store01.getName());
    }
    @Test
    public void TestGetWebSite01(){
        assertEquals(storeWeb,store01.getWebSite());
    }
    @Test
    public void TestSetName01(){
        store01.setName(storeName2);
        assertEquals(storeName2,store01.getName());
        store01.setName(storeName);
        assertEquals(storeName,store01.getName());
    }
    @Test
    public void TestSetWebSite01(){
        store01.setWebSite(storeWeb2);
        assertEquals(storeWeb2,store01.getWebSite());
        store01.setWebSite(storeWeb);
        assertEquals(storeWeb,store01.getWebSite());
    }
    @Test
    public void TestStoreGetCount01(){
        int countF = store01.getCount();
        store01.addProduct(sampleP1);
        store01.addProduct(foodP1);
        int countL = store01.getCount();
        assertTrue(countF+2 == countL);
        store01.addProduct(sampleP1);
        countL = store01.getCount();
        /** store01 already has sampleP1 so countL must remain unchanged */
        assertTrue(countF+2 == countL);
    }
    @Test
    public void TestAddProduct01(){
        int countF = store01.getCount();
        store01.addProduct(new Product("Smart TV",3250.00,50));
        assertTrue(countF+1 == store01.getCount());
    }
    @Test
    public void TestGetCustomer01(){
        store01.addCustomer(clubCust1);
        assertTrue(store01.getCustomer(customerPhone1).equals(clubCust1));
        clubCust1.setPhone(customerPhone2);
        try {
            store01.getCustomer(customerPhone1);
            throw new RuntimeException();
        } catch (Exception ex){
            assertTrue(ex instanceof CustomerNotFoundException);
        }
    }
    @Test
    public void TestAddCustomer01(){
        store01.addCustomer(clubCust1);
        ClubCustomer example = new ClubCustomer("ahmet","6458");
        store01.addCustomer(example);
        assertEquals(clubCust1,store01.getCustomer(customerPhone1));
        assertEquals(example,store01.getCustomer("6458"));
    }
    @Test
    public void TestRemoveCustomer01(){
        store01.addCustomer(clubCust1);
        store01.removeCustomer(customerPhone1);
        try {
            store01.getCustomer(customerPhone1);
            throw new RuntimeException();
        }catch (Exception ex){
            assertTrue(ex instanceof CustomerNotFoundException);
        }
    }
    @Test
    public void TestRemoveProduct01(){
        store01.addProduct(sampleP1);
        store01.removeProduct(sampleP1.getName());
        try {
            store01.getProduct(sampleP1.getName());
            throw new RuntimeException();
        } catch (Exception ex){
            assertTrue(ex instanceof ProductNotFoundException);
        }
    }


    /** Testing of Exceptions */

    @Test (expected = InvalidAmountException.class)
    public void TestInvalidAmountException01(){
        Product pr1 = new Product("Snickers",250.0,-10);
    }

    @Test (expected = InvalidPriceException.class)
    public void TestInvalidPriceException01(){
        Product pr1 = new Product("Snickers",-250.0,10);
    }

    @Test (expected = InvalidPurchaseException.class)
    public void TestInvalidPurchaseException01(){
        sampleP1.purchase(-15);
    }

    @Test
    public void TestInvalidPurchaseException02(){
        try{
            sampleP1.purchase(5000);
            throw new RuntimeException();
        } catch (Exception ex){
            assertTrue(ex instanceof InvalidPurchaseException);
        }
    }

    @Test (expected = NotEnoughPaymentException.class)
    public void TestNotEnoughPaymentException(){
        clubCust1.addToCart(sampleP1,10);
        clubCust1.pay(0.1);
    }

    @Test (expected = ProductNotFoundException.class)
    public void TestProductNotFoundException(){
            store01.getProduct("---");
    }

    @Test
    public void TestCustomerNotFoundException(){
        try{
            store01.getCustomer("6465");
            throw new RuntimeException();
        } catch (Exception ex){
            assertTrue(ex instanceof CustomerNotFoundException);
        }
    }
}
