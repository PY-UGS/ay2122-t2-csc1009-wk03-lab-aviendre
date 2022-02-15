import java.util.Date;
import java.util.Scanner;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public static void main(String[] args){
        Loan sample = new Loan();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter annual interest rate, for example, 8.25: ");
        sample.annualInterestRate = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        sample.numberOfYears = input.nextInt();
        System.out.print("Enter loan ammount, for example, 12000.89: ");
        sample.loanAmount = input.nextDouble();
        System.out.println("The loan was created on " + sample.getLoanDate());
        System.out.printf("The monthly payment is %.2f", sample.getMonthlyPayment());
        System.out.println();
        System.out.printf("The total payment is %.2f", sample.getTotalPayment());
    }

    public Loan(){}

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        loanDate = new java.util.Date();  
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public double getMonthlyPayment(){
        double sum, monthlyInterestRate;
        monthlyInterestRate = (annualInterestRate/100)/12;
        sum = loanAmount * monthlyInterestRate;
        sum = sum /(1 - (1/(java.lang.Math.pow((1+monthlyInterestRate),(numberOfYears*12)))));
        return sum;
    }

    public double getTotalPayment(){
        return (getMonthlyPayment()*numberOfYears*12);
    }
}
