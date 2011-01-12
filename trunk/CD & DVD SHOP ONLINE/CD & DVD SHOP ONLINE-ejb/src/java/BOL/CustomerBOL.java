/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BOL;

import DAO.ConnectionDB;
import Entities.Customer;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiepdd_a03888
 */
public class CustomerBOL {

    public ConnectionDB conn;

    public CustomerBOL() {
        conn = new ConnectionDB();
    }

    public boolean CreateCustomer(String cusEmail, String cusPass, String cusName, String cusAddress, String cusBirthday, String cusPhone) {
        try {
            CallableStatement cst = conn.getConnection().prepareCall("{call pc_InsertCustomer(?,?,?,?,?,?)}");

            cst.setString(1, cusEmail);
            cst.registerOutParameter(1, java.sql.Types.NVARCHAR);
            cst.setString(2, cusPass);
            cst.registerOutParameter(2, java.sql.Types.NVARCHAR);
            cst.setString(3, cusName);
            cst.registerOutParameter(3, java.sql.Types.NVARCHAR);
            cst.setString(4, cusAddress);
            cst.registerOutParameter(4, java.sql.Types.NVARCHAR);
            cst.setString(5, cusBirthday);
            cst.registerOutParameter(5, java.sql.Types.NVARCHAR);
            cst.setString(6, cusPhone);
            cst.registerOutParameter(6, java.sql.Types.NVARCHAR);

            if (cst.execute()) {
                Customer cus = new Customer();
                cus.setCusEmail(cst.getString(1));
                cus.setCusEmail(cst.getString(2));
                cus.setCusEmail(cst.getString(3));
                cus.setCusEmail(cst.getString(4));
                cus.setCusEmail(cst.getString(5));
                cus.setCusEmail(cst.getString(6));

                return true;
            }


            return false;


        } catch (Exception ex) {
            Logger.getLogger(CustomerBOL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }
}
