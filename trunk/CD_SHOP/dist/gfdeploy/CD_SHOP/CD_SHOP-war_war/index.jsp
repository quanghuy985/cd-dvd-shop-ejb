<%-- 
    Document   : index
    Created on : Jan 12, 2011, 11:41:42 PM
    Author     : TuyenCk
--%>
<%@page import="BOL.ShoppingCart"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:useBean id="loadProduct" scope="page" class="Controller.ProductController"></jsp:useBean>
        <c:forEach var="item" items="${loadProduct.productAll}">
            <form action="AddCart" method="post">
            <table width="100%" cellspacing="0" cellpadding="0" border="0">
                <tbody>
                    <tr>
                        <td width="150" valign="middle" align="center" rowspan="5">
                            <span>${item.proID}</span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">Name of product
                            <span style="color: Blue; font-weight: bold;" id="Label">${item.proName}</span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">ProAmountAvailable
                            <span style="color: Red; font-weight: bold;" id="Label2">${item.proAmountAvailable}</span></td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">Price:
                            <span style="color: Red; font-weight: bold;" id="Label2">${item.proPrice}</span> USD</td>
                    </tr>
                    <tr>
                        <td valign="top" align="left">
                            <input type="hidden" value=${item.proID} name="ProductID"></input>
                            <input type="hidden" value=${item.proName} name="ProductName"></input>
                            <input type="hidden" value=${item.proPrice} name="Price"></input>
                            <input type="submit" id="btnSubmit" class="button" value="Add to cart"></input>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr/>
            </form>
        </c:forEach>
      
        <div id="shoppingCart"
             <h4 style="text-align: center">
                <%
                            if (session.getAttribute("Cart") != null) {
                                ShoppingCart Cart = (ShoppingCart) session.getAttribute("Cart");
                %>
                <label id="Label1" style="color: blue">Items: <% out.print(Cart.TotalQuantity());%></label><br/>
                <label id="Label1" style="color: red">Total Price: <% out.print(Cart.TotalPrice());%> USD</label>
                <%
                                                                    } else {%>
                <label id="Label1" style="color: blue">Items: 0</label><br/>
                <label id="Label1" style="color: red">Total Price: 0 USD</label>
                <% }%>
            </h4>
        </div><!--End Shopping cart-->
    </body>
</html>
