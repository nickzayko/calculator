package models;

public class Calculator {
    public double firstNumber;
    public double secondNumber;

    public Calculator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Calculator (){}

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double plus (){
        return firstNumber+secondNumber;
    }

    public double minus (){
        return firstNumber-secondNumber;
    }

    public double multiply (){
        return firstNumber*secondNumber;
    }

    public double divide (){
        return firstNumber/secondNumber;
    }

}
