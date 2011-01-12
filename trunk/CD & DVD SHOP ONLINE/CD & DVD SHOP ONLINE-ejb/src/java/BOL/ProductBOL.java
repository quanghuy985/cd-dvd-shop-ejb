/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BOL;

import DAO.ConnectionDB;
import Entities.Product;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TuyenCk
 */
public class ProductBOL {
    private ConnectionDB dao;
    private Product pr;
    private ArrayList<Product> list;

    public ProductBOL(){
        dao = new ConnectionDB();
        list = new ArrayList<Product>();
    }
    public ArrayList<Product> getallProduct(){
        try{
        CallableStatement cst = dao.getConnection().prepareCall("{call pc_selectAllProduct()}");
        cst.execute();
        ResultSet rs = (ResultSet)cst.executeQuery();
            while (rs.next()) {
                Product pr = new Product();
                pr.setProID(rs.getString("proID"));
                pr.setCateCollection(rs.getString("cateCollection"));
                pr.setProName(rs.getString("proName"));
                pr.setProDetail(rs.getString("proImage"));
                pr.setProDetail(rs.getString("proPublish"));
                pr.setProDetail(rs.getString("proAmountAvailable"));
                pr.setProDetail(rs.getString("proPrice"));
                pr.setProDetail(rs.getString("proPriceRent"));
                pr.setProDetail(rs.getString("proStatus"));
                list.add(pr);
            }
        }catch(Exception ex){
        }
        return list;
    }
}
