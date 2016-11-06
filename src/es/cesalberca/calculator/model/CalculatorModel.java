package es.cesalberca.calculator.model;

import es.cesalberca.calculator.observer.Observer;
import es.cesalberca.calculator.observer.Subject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Cesar
 */
public class CalculatorModel implements Subject {
    private ArrayList<Observer> observers;

    private ArrayList<Integer> numbers;
    private double number;
    private double calculationValue;

    public CalculatorModel () {
        observers = new ArrayList<>();
        numbers = new ArrayList<>();
    }

    public void addTwoNumbers (int firstNumber, int secondNumber) {
        this.setCalculationValue(firstNumber + secondNumber);
    }

    public void addToNumbers (int number) {
        this.numbers.add(number);
        this.makeNumber();
    }

    public void makeNumber () {
        double result = 0;
        Double ten = 10.0;
        Double dI;
        ArrayList<Integer> reversedNumbers = new ArrayList<>(this.numbers);
        Collections.reverse(reversedNumbers);

        for (int i = 0; i < reversedNumbers.size(); i++) {
            dI = i + 0.0;
            result += reversedNumbers.get(i) * (Math.pow(ten, dI));
        }

        this.setNumber(result);
    }

    public double getCalculationValue() {
        return calculationValue;
    }

    public void setCalculationValue(int calculationValue) {
        this.calculationValue = calculationValue;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
