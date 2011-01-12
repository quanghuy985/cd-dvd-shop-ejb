/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import BOL.ShoppingCart;
import Entity.ProductCart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TuyenCk
 */
@WebServlet(name="AddCart", urlPatterns={"/AddCart"})
public class AddCart extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(false);
            int quantity = 1;
            String prodID = request.getParameter("ProductID");
            String prodName = request.getParameter("ProductName");
            float price = Float.parseFloat(request.getParameter("Price"));
            ProductCart products = new ProductCart(prodID, price, quantity, prodName);
            if (session.getAttribute("Cart") == null) {
                ShoppingCart cart = new ShoppingCart();
                cart.AddCart(products);
                session.setAttribute("Cart", cart);
                goPage(request, response, "index.jsp");
            } else {
                ShoppingCart cart = (ShoppingCart) session.getAttribute("Cart");
                cart.AddCart(products);
                goPage(request, response, "index.jsp");
            }
        goPage(request, response, "index.jsp");
    } 

    private void goPage(HttpServletRequest request, HttpServletResponse response, String link)
            throws ServletException, IOException {
        RequestDispatcher reqdis = request.getRequestDispatcher(link);
        reqdis.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
