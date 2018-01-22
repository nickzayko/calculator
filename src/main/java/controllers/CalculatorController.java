package controllers;

import models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/in")
public class CalculatorController {

    Calculator calculator = new Calculator();
    public String combinationOfNumbers = "";
    public String operation = "";

    @RequestMapping("/inputNumbers")
    public String inputNumbers (HttpServletRequest request){
        combinationOfNumbers += request.getParameter("number");
        request.setAttribute("monitorValue", combinationOfNumbers);
        return "result";
    }

    @RequestMapping("/inputNumbers/{inputOperation}")
    public String defineOperation (@PathVariable("inputOperation") String inputOperation, HttpServletRequest request) {
        if (inputOperation.equals("plus")) {
            calculator.setFirstNumber(Double.parseDouble(request.getParameter("buttonPlus")));
            saveCurrentOperation(inputOperation);
        } else {
            if (inputOperation.equals("minus")) {
                calculator.setFirstNumber(Double.parseDouble(request.getParameter("buttonMinus")));
                saveCurrentOperation(inputOperation);
            } else {
                if (inputOperation.equals("multiply")) {
                    calculator.setFirstNumber(Double.parseDouble(request.getParameter("buttonMultiply")));
                    saveCurrentOperation(inputOperation);
                } else {
                    if (inputOperation.equals("divide")) {
                        calculator.setFirstNumber(Double.parseDouble(request.getParameter("buttonDivide")));
                        saveCurrentOperation(inputOperation);
                    } else {
                        if (inputOperation.equals("result")) {
                            if (operation.equals("plus")) {
                                calculator.setSecondNumber(Double.parseDouble(request.getParameter("buttonResult")));
                                double resultOfCalculate = calculator.plus();
                                request.setAttribute("monitorValue", String.valueOf(resultOfCalculate));
                            } else {
                                if (operation.equals("minus")) {
                                    calculator.setSecondNumber(Double.parseDouble(request.getParameter("buttonResult")));
                                    double resultOfCalculate = calculator.minus();
                                    request.setAttribute("monitorValue", resultOfCalculate);
                                } else {
                                    if (operation.equals("multiply")) {
                                        calculator.setSecondNumber(Double.parseDouble(request.getParameter("buttonResult")));
                                        double resultOfCalculate = calculator.multiply();
                                        request.setAttribute("monitorValue", resultOfCalculate);
                                    } else {
                                        if (operation.equals("divide")) {
                                            calculator.setSecondNumber(Double.parseDouble(request.getParameter("buttonResult")));
                                            double resultOfCalculate = calculator.divide();
                                            request.setAttribute("monitorValue", resultOfCalculate);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "result";
    }

    private void saveCurrentOperation(String inputOperation) {
        operation = inputOperation;
        combinationOfNumbers = "";
    }

    @RequestMapping("/clean")
    public String clean (HttpServletRequest request){
        combinationOfNumbers = "";
        operation = "";
        request.setAttribute("monitorValue", "");
        return "result";
    }

    @RequestMapping("/convertInputNumberValue")
    public String convertInputNumberValue (HttpServletRequest request){
        if (Double.parseDouble(combinationOfNumbers)>0){
            combinationOfNumbers = "-" + combinationOfNumbers;
            request.setAttribute("monitorValue", combinationOfNumbers);
        } else {
            combinationOfNumbers = combinationOfNumbers.substring(1);
            request.setAttribute("monitorValue", combinationOfNumbers);
        }
    return "result";
    }
}
