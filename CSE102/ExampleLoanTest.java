package CSE102;

import org.junit.*;
import static org.junit.Assert.*;

public class ExampleLoanTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void testPaymentMethods(){
        double annualInterestRate = 2.5;
        int numberOfYears = 5;
        double loanAmount = 1000;
        Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);
        assertTrue(loan.getMonthlyPayment() == getMonthlyPayment(annualInterestRate,numberOfYears,loanAmount));
        assertTrue(loan.getTotalPayment() == getTotalPayment(annualInterestRate,numberOfYears,loanAmount));
    }
    /**Manually find monthly payment*/
    public double getMonthlyPayment(double interest, int years, double loan){
        double monthlyIntRate = interest/1200;
        double monthlyPayment = loan * monthlyIntRate /(1-(1/Math.pow(1 + monthlyIntRate, years*12)));
        return monthlyPayment;
    }
    /**Manually find total payment*/
    public double getTotalPayment(double interest, int years, double loan){
        return getMonthlyPayment(interest,years,loan)*years*12;
    }
}
