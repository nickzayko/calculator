package controllers;

import models.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
                            String parameterFromRequest;
                            if (operation.equals("plus")) {
                                parameterFromRequest = request.getParameter("buttonResult");
                                if (checkRequestParameter(parameterFromRequest)) {
                                    calculator.setSecondNumber(Double.parseDouble(parameterFromRequest));
                                    double resultOfCalculate = calculator.plus();
                                    request.setAttribute("monitorValue", String.valueOf(resultOfCalculate));
                                } else {
                                    request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
                                }
                            } else {
                                if (operation.equals("minus")) {
                                    parameterFromRequest = request.getParameter("buttonResult");
                                    if (checkRequestParameter(parameterFromRequest)) {
                                        calculator.setSecondNumber(Double.parseDouble(parameterFromRequest));
                                        double resultOfCalculate = calculator.minus();
                                        request.setAttribute("monitorValue", resultOfCalculate);
                                    } else {
                                        request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
                                    }
                                } else {
                                    if (operation.equals("multiply")) {
                                        parameterFromRequest = request.getParameter("buttonResult");
                                        if (checkRequestParameter(parameterFromRequest)) {
                                            calculator.setSecondNumber(Double.parseDouble(request.getParameter("buttonResult")));
                                            double resultOfCalculate = calculator.multiply();
                                            request.setAttribute("monitorValue", resultOfCalculate);
                                        } else {
                                            request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
                                        }
                                    } else {
                                        if (operation.equals("divide")) {
                                            parameterFromRequest = request.getParameter("buttonResult");
                                            if (checkRequestParameter(parameterFromRequest)) {
                                                calculator.setSecondNumber(Double.parseDouble(request.getParameter("buttonResult")));
                                                double resultOfCalculate = calculator.divide();
                                                request.setAttribute("monitorValue", resultOfCalculate);
                                            } else {
                                                request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
                                            }
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

    private boolean checkRequestParameter(String parameterFromRequest) {
        if (parameterFromRequest.equals("")){
            return false;
        } else {
            return true;
        }
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
    public String convertInputNumberValue (HttpServletRequest request) {
        combinationOfNumbers = request.getParameter("buttonConvert");
        if (checkRequestParameter(combinationOfNumbers)) {
            if (Double.parseDouble(combinationOfNumbers) > 0) {
                combinationOfNumbers = "-" + combinationOfNumbers;
                request.setAttribute("monitorValue", combinationOfNumbers);
            } else {
                combinationOfNumbers = combinationOfNumbers.substring(1);
                request.setAttribute("monitorValue", combinationOfNumbers);
            }
        } else {
            request.setAttribute("informationLabel", "Error of operation! Check input parameters!");
        }
        return "result";
    }
}
