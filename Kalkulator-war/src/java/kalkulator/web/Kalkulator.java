/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kalkulator.ejb.KalkulatorBeanLocal;

/**
 *
 * @author se7en
 */
@WebServlet(name = "Kalkulator", urlPatterns = {"/Kalkulator"})
public class Kalkulator extends HttpServlet {

    KalkulatorBeanLocal kalkulatorBean = lookupKalkulatorBeanLocal();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            double value;
            double _value = 0;
            String op = "";
            if (request.getParameter("Add") != null) {
                if(!request.getParameter("ans").isEmpty()) {
                    op = request.getParameter("op");
                    _value = Double.parseDouble(request.getParameter("ans"));
                    if ("+".equals(op)){
                        value = kalkulatorBean.add(_value);
                        _value = value;
                    }
                    if ("-".equals(op)){
                        value = kalkulatorBean.subtract(_value);
                        _value = value;
                    }
                    if ("/".equals(op)){
                        value = kalkulatorBean.divide(_value);
                        _value = value;
                    }
                    if ("*".equals(op)){
                        value = kalkulatorBean.multiply(_value);
                        _value = value;
                    }
                    else{
                        value = kalkulatorBean.fill(_value);
                    }
                    request.setAttribute("display2", "+");
                    request.setAttribute("display", "");
                }else{
                    op = "+";
                    request.setAttribute("display2", "+");
                }
            }
            if (request.getParameter("Sub") != null) {
                if(!request.getParameter("ans").isEmpty()) {
                    op = request.getParameter("op");
                    _value = Double.parseDouble(request.getParameter("ans"));
                    if ("+".equals(op)){
                        value = kalkulatorBean.add(_value);
                        _value = value;
                    }
                    if ("-".equals(op)){
                        value = kalkulatorBean.subtract(_value);
                        _value = value;
                    }
                    if ("/".equals(op)){
                        value = kalkulatorBean.divide(_value);
                        _value = value;
                    }
                    if ("*".equals(op)){
                        value = kalkulatorBean.multiply(_value);
                        _value = value;
                    }
                    else{
                        value = kalkulatorBean.fill(_value);                        
                    }
                    request.setAttribute("display2", "-");
                    request.setAttribute("display", "");
                }else{
                    op = "-";
                    request.setAttribute("display2", "-");
                }
            }
            if (request.getParameter("Div") != null) {
                if(!request.getParameter("ans").isEmpty()) {
                    op = request.getParameter("op");
                    _value = Double.parseDouble(request.getParameter("ans"));
                    if ("+".equals(op)){
                        value = kalkulatorBean.add(_value);
                        _value = value;
                    }
                    if ("-".equals(op)){
                        value = kalkulatorBean.subtract(_value);
                        _value = value;
                    }
                    if ("/".equals(op)){
                        value = kalkulatorBean.divide(_value);
                        _value = value;
                    }
                    if ("*".equals(op)){
                        value = kalkulatorBean.multiply(_value);
                        _value = value;
                    }
                    else{
                        value = kalkulatorBean.fill(_value);
                        op = "/";                        
                    }
                    request.setAttribute("display2", "/");
                    request.setAttribute("display", "");
                }else{
                    op = "/";
                    request.setAttribute("display2", "/");
                }
            }
            if (request.getParameter("Mul") != null) {
                if(!request.getParameter("ans").isEmpty()) {
                    op = request.getParameter("op");
                    _value = Double.parseDouble(request.getParameter("ans"));
                    if ("+".equals(op)){
                        value = kalkulatorBean.add(_value);
                        _value = value;
                    }
                    if ("-".equals(op)){
                        value = kalkulatorBean.subtract(_value);
                        _value = value;
                    }
                    if ("/".equals(op)){
                        value = kalkulatorBean.divide(_value);
                        _value = value;
                    }
                    if ("*".equals(op)){
                        value = kalkulatorBean.multiply(_value);
                        _value = value;
                    }
                    else{
                        value = kalkulatorBean.fill(_value);                        
                    }
                    request.setAttribute("display2", "*");
                    request.setAttribute("display", "");
                }else{
                    op = "*";
                    request.setAttribute("display2", "*");
                }
            }
            if (request.getParameter("Res") != null) {
                if(!request.getParameter("ans").isEmpty()) {
                    _value = Double.parseDouble(request.getParameter("ans"));
                    op = request.getParameter("op");
                    if ("+".equals(op)){
                        value = kalkulatorBean.add(_value);
                        request.setAttribute("display", value);
                    }
                    if ("-".equals(op)){
                        value = kalkulatorBean.subtract(_value);
                        request.setAttribute("display", value);
                    }
                    if ("/".equals(op)){
                        value = kalkulatorBean.divide(_value);
                        request.setAttribute("display", value);
                    }
                    if ("*".equals(op)){
                        value = kalkulatorBean.multiply(_value);
                        request.setAttribute("display", value);
                    }
                    else{
                        value = kalkulatorBean.getValue();
                        request.setAttribute("display", value);
                    }
                    request.setAttribute("display2", "=");
                }
            }
            if (request.getParameter("reset") != null) {
                kalkulatorBean.reset();
                request.setAttribute("display", "");
            }
            else{
                value = kalkulatorBean.getValue();
            }
//            PrintWriter out = response.getWriter();   
//            out.println("Operand: " + _value + "<br />");
//            out.println("Operator: " + op + "<br />");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        }
        catch(Exception ex){
            PrintWriter out = response.getWriter();
            out.println("Error:"+
            ex.getMessage());
        }
        finally {
            PrintWriter out = response.getWriter();
            out.close();
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private KalkulatorBeanLocal lookupKalkulatorBeanLocal() {
        try {
            Context c = new InitialContext();
            return (KalkulatorBeanLocal) c.lookup("java:global/Kalkulator/Kalkulator-ejb/KalkulatorBean!kalkulator.ejb.KalkulatorBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
