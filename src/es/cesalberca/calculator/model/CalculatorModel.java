package es.cesalberca.calculator.model;

import es.cesalberca.calculator.observer.Observer;
import es.cesalberca.calculator.observer.Subject;

import java.util.ArrayList;

/**
 * Created by Cesar
 */
public class CalculatorModel implements Subject {
    private ArrayList<Observer> observers;

    private double number;
    private double previousNumber;
    private String currentTypeOfOperation;

    public CalculatorModel () {
        observers = new ArrayList<>();
        number = 0;
        previousNumber = 0;
    }

    public void addDigit (float digit) {
        setNumber((getNumber() * 10) + digit);
    }

    public Double makeOperation () {
        switch (this.currentTypeOfOperation) {
            case "+":
                break;
            case "-":
                break;
            case "x":
                break;
            case "/":
                break;
            case "=":
                break;
        }
        }
    }

    public double getNumber () {
        return number;
    }

    public void setNumber (double number) {
        this.number = number;
        notifyObservers();
    }

    public double getPreviousNumber() {
        return previousNumber;
    }

    public void setPreviousNumber(double previousNumber) {
        this.previousNumber = previousNumber;
    }

    @Override
    public void registerObserver (Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver (Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }
}
