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
    public String defineOperation (@PathVariable("inputOperation") String inputOperation, HttpServletRequest request){
        operation = inputOperation;
        if (operation.equals("plus")) {
            calculator.setFirstNumber(Integer.parseInt(request.getParameter("buttonPlus")));
        }
        if (operation.equals("minus")) {
            calculator.setFirstNumber(Integer.parseInt(request.getParameter("buttonMinus")));
        }
        if (operation.equals("multiply")) {
            calculator.setFirstNumber(Integer.parseInt(request.getParameter("buttonMultiply")));
        }
        if (operation.equals("divide")) {
            calculator.setFirstNumber(Integer.parseInt(request.getParameter("buttonDivide")));
        }
        combinationOfNumbers = "";
        return "result";
    }

    @RequestMapping("/inputNumbers/result")
    public String solution(HttpServletRequest request) {
        if (operation.equals("plus")) {
            calculator.setSecondNumber(Integer.parseInt(request.getParameter("buttonResult")));
            double result = calculator.plus();
            request.setAttribute("monitorValue", String.valueOf(result));
        }

        if (operation.equals("minus")) {
            calculator.setSecondNumber(Integer.parseInt(request.getParameter("buttonResult")));
            double result = calculator.minus();
            request.setAttribute("monitorValue", result);
        }
        if (operation.equals("multiply")) {
            calculator.setSecondNumber(Integer.parseInt(request.getParameter("buttonResult")));
            double result = calculator.multiply();
            request.setAttribute("monitorValue", result);
        }
        if (operation.equals("divide")) {
            calculator.setSecondNumber(Integer.parseInt(request.getParameter("buttonResult")));
            double result = calculator.divide();
            request.setAttribute("monitorValue", result);
        }
        return "result";
    }

    @RequestMapping("/clean")
    public String clean (HttpServletRequest request){
        combinationOfNumbers = "";
        operation = "";
        request.setAttribute("monitorValue", "");
        return "result";
    }


}
