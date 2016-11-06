package es.cesalberca.calculator;

import es.cesalberca.calculator.controller.CalculatorController;
import es.cesalberca.calculator.model.CalculatorModel;
import es.cesalberca.calculator.view.CalculatorView;

/**
 * Created by Cesar
 */
public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);

        controller.update();
    }
}
