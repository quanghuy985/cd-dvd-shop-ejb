/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tuyendt_a04298
 */
public class ConnectionDB {
    private Connection cnn;
    private String driver;
    private String urlDriver;
    private String hostName;
    private String port;
    private String databaseName;
    private String userName;
    private String password;

    public ConnectionDB() {
        this.driver = "net.sourceforge.jtds.jdbc.Driver";
        this.urlDriver = "jdbc:jtds:sqlserver://";
        this.hostName = "127.0.0.1";
        this.port = "1433";
        this.databaseName = "CD_Shop_EJB";
        this.userName = "sa";
        this.password = "sasa";
        this.openConnection();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        if (cnn == null) {
            openConnection();
        }
        ResultSet rs = null;
        Statement stm = cnn.createStatement();
        rs = stm.executeQuery(sql);
        return rs;
    }

    public int executeUpdateQuery(String sql) {
        if (cnn == null) {
            openConnection();
        }
        int resultCount = 0;
        try {
            Statement stm = cnn.createStatement();
            resultCount = stm.executeUpdate(sql);
        } catch (SQLException ex) {
        } finally {
            closeConnection();
        }
        return resultCount;
    }

    public void openConnection() {
        try {
            Class.forName(this.driver);
            cnn = DriverManager.getConnection(this.urlDriver + this.hostName + ":" + this.port + "/" + this.databaseName, this.userName, this.password);
        } catch (Exception ex) {
        }
    }

    public Connection getConnection() {
        return cnn;
    }

    public void closeConnection() {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException ex) {
            }
        }
    }
}
