package CSE102;

import java.util.Date;

public class LoanApp {
    public static void main(String[] args) {
        Loan kredi1 = new Loan(15,3,20000);
        System.out.println("Monthly Payment: "+kredi1.getMonthlyPayment()+" TL");
        System.out.println("Total Payment: "+kredi1.getTotalPayment()+" TL");
        System.out.println("Date: "+new  Date());

    }

}
class Loan{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date date;
    public Loan(){
        this(2.5,1,10000);
    }
    public Loan(double interestRate, int years, double amount){
        this.annualInterestRate = interestRate;
        this.numberOfYears = years;
        this.loanAmount = amount;
        //this.date = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public double getMonthlyPayment(){
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    public double getTotalPayment(){
        return getMonthlyPayment() * numberOfYears * 12;
    }
}
