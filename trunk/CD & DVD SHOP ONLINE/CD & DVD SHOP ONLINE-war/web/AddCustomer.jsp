<%-- 
    Document   : index
    Created on : Jan 6, 2011, 2:45:51 PM
    Author     : TuanAnh-Computer
--%>


<%@page import="BOL.CustomerBOL" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form method="post" action="">

            <table align="center" border="1">
                <tr>
                    <td>Email :</td>
                    <td><input type="text" name="txtEmail"/></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="text" name="txtPassword"/></td>
                </tr>
                <tr>
                    <td>Name :</td>
                    <td><input type="text" name="txtName"/></td>
                </tr>
                <tr>
                    <td>Address :</td>
                    <td><input type="text" name="txtAddress"/></td>
                </tr>
                <tr>
                    <td>Birthday :</td>
                    <td><input type="text" name="txtBirthday"/></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><input type="text" name="txtPhone"/></td>
                </tr>
                <tr>
                    <td rowspan="2"><input size="2" align="center" type="submit" name="btnSubmit" value="Submid"/>

                    </td>
                    
                </tr>
            </table>

        </form>

        
    </body>
</html>
