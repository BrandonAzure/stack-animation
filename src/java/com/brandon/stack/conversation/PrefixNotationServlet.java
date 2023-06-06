/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.brandon.stack.conversation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.catalina.connector.Response;

/**
 *
 * @author brand
 */
@WebServlet(name = "PrefixNotationServlet",
        urlPatterns = {"/PrefixNotation"})
public class PrefixNotationServlet extends HttpServlet {

    static HttpServletRequest request;
    static HttpServletResponse response;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        request = req;
        response = resp;

        String arithmeticExpression = req.getParameter("infix-notation");
        StringBuilder prefixNotation[]
                = Conversation.prefixConversion(
                        arithmeticExpression);
        
        List<String> fullStack = new ArrayList<>();
        for (int i = 0; i < prefixNotation[0].length(); i++) {
            if (prefixNotation[0].charAt(i) != ' ') {
                fullStack.add(String.valueOf(prefixNotation[0].charAt(i)));
            }
        }
        
        req.setAttribute("prefix", fullStack);
        RequestDispatcher requestDispatcher 
                = req.getRequestDispatcher(
                        "expression_tree.jsp");
        requestDispatcher.forward(req, resp);
    }

}
