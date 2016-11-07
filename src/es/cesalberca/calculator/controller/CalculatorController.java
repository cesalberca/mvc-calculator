package es.cesalberca.calculator.controller;

import es.cesalberca.calculator.model.CalculatorModel;
import es.cesalberca.calculator.observer.Observer;
import es.cesalberca.calculator.view.CalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Created by Cesar
 */
public class CalculatorController implements Observer {
    private final CalculatorView view;
    private final CalculatorModel model;

    public CalculatorController (CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.addCalculationListener(new CalculateListener());
        this.view.addOperationListener(new OperationListener());
        this.model.registerObserver(this);
    }

    private class CalculateListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            int numberUserPressed = Integer.parseInt(((JButton)e.getSource()).getText());
            model.addDigit(numberUserPressed);
        }
    }

    private class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operationPressed = ((JButton)e.getSource()).getText();

            if (Objects.equals(operationPressed, "=")) {
                model.setNumber(model.makeOperation());
            } else {
                model.setCurrentTypeOfOperation(operationPressed);
                model.setPreviousNumber(model.getNumber());
                model.setNumber(0);
            }
        }
    }

    @Override
    public void update() {
        view.setNumber(model.getNumber());
        view.setPreviousNumber(model.getPreviousNumber(), model.getCurrentTypeOfOperation());
    }
}
