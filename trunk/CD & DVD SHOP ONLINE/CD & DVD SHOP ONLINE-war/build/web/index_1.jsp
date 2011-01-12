<%-- 
    Document   : index
    Created on : Sep 21, 2010, 8:19:51 PM
    Author     : TuyenCk
--%>



<%@page import="Entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BOL.ProductBOL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apple Page</title>
        <link type="text/css" href="Css/Style_Home.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="container">
            <div id="logo">
                <img src="Images/logoip4.jpg" alt="Apple"/>
                <form action="" method="post">
                    <input type="text" name="search"/>
                    <input type="submit" value="Search" class="button"/>
                </form>
            </div><!--End Logo-->

            <div id="main_nav">
                <ul>
                    <li><a href="index.jsp">Apple</a></li>
                    <li><a href="#">iPhone</a></li>
                    <li><a href="#">iPod</a></li>
                    <li><a href="#">Mac</a></li>
                    <%if (session.getAttribute("Customer") == null) {
                    %>
                    <li><a href="Login.jsp">Login</a></li>
                    <%} else {%>
                    <li><a href="Logout.jsp">Logout</a></li>
                    <%}%>
                    <li><a href="ViewCart.jsp">ViewCart</a></li>
                </ul>
            </div><!--End Main_nav-->

            <div id="main_content">

                <div id="primary">
                    <table cellspacing="0" cellpadding="4" border="0" rules="all" style="background-color: White; width: 100%;">

                        <jsp:useBean id="abc" class="BOL.ProductBOL" scope="request"/>
                        <%
                                    ArrayList<Product> list = new ArrayList<Product>();
                                    list = abc.GetAllProduct();
                                    if (list.size() > 0) {
                                        for (int i = 0; i < list.size(); i++) {
                        %>

                        <form method="post" action="AddToCart">
                            <tr>
                                <td >
                                    <table width="100%" cellspacing="0" cellpadding="0" border="0">
                                        <tbody><tr>
                                                <td width="150" valign="top" align="left" rowspan="5">
                                                    <img style="height: 100px; width: 100px; border-width: 0px;"
                                                         src=<%= list.get(i).getImage()%>></img>
                                                </td>
                                                <td valign="top" align="left">
                                                    <span style="color: blue; font-weight: bold;" id="Label" class="title"><%= list.get(i).getName()%></span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td valign="top" align="left">Price:
                                                    <span style="color: Red; font-weight: bold;" id="Label2"><%= list.get(i).getPrice()%></span>
                                                    &nbsp;<span class="style1">USD</span></td>
                                            </tr>
                                            <tr>
                                                <td valign="top" align="left">
                                                    <input type="hidden" value=<%= list.get(i).getProductID()%> name="ProductID"></input>
                                                    <input type="hidden" value=<%= list.get(i).getName()%> name="ProductName"></input>
                                                    <input type="hidden" value=<%= list.get(i).getPrice()%> name="Price"></input>
                                                    <input type="submit" id="btnSubmit" class="button" value="Add to cart"></input>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </td>
                            </tr>
                        </form>
                    </table>
                    <% }
                                  }%>
                </div><!--End Primary-->

                <div id="menu_left">
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
                    <div id="login">
                        <%if (session.getAttribute("Customer") != null) {%>
                        <h2>
                            <%Customer user = (Customer) session.getAttribute("Customer");
                             out.println("Welcome, " + user.getUsename() + " !");%></h2>
                            <%}%>
                    </div><!--End Login-->
                </div><!--End menu_left-->
            </div>
            <div id="footer">
                <div id="copyright">
                    <p>&copy; 2010-09 Apple.com - All rights reserved.</p>
                </div><!--End Copyright-->
            </div><!--End Footer-->
        </div><!--End Container-->
    </body>
</html>
