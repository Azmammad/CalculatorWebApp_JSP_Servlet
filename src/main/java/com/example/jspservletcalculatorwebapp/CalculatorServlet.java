package com.example.jspservletcalculatorwebapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        String operation = request.getParameter("operation");

        double result =0;
        String operationSymbol = "";

        switch (operation){
            case "add":
                result = a+b;
                operationSymbol = "+";
                break;
            case "subtract":
                result = a-b;
                operationSymbol = "-";
                break;
            case  "multiply":
                result = a*b;
                operationSymbol = "*";
                break;
            case "divide":
                if (b!=0){
                    result = (double) a/b;
                    operationSymbol = "/";
                }else {
                    request.setAttribute("error","Division by zero is not allowed");
                    request.getRequestDispatcher("result.jsp").forward(request,response);
                    return;
                }
                break;
            case "modulus":
                result = a % b;
                operationSymbol = "%";
                break;
            case "power":
                result = Math.pow(a, b);
                operationSymbol = "^";
                break;
            case "sqrtA":
                result = Math.sqrt(a);
                operationSymbol = "√A";
                break;
            case "sqrtB":
                result = Math.sqrt(b);
                operationSymbol = "√B";
                break;
        }

        HttpSession session = request.getSession();
        List<String> history = (List<String>) session.getAttribute("history");
        if (history == null){
            history = new ArrayList<>();
        }

        String calculation = a + " " + operationSymbol + " " + b + " = " + result;
        history.add(calculation);
        session.setAttribute("history",history);

        request.setAttribute("a",a);
        request.setAttribute("b",b);
        request.setAttribute("operationSymbol",operationSymbol);
        request.setAttribute("result",result);

        request.getRequestDispatcher("result.jsp").forward(request,response);


    }
}
