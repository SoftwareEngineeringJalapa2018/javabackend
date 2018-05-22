
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConsultaDAO {

    Connection connection = null;

    public ConsultaDAO() {
        String bdName = "AdventureWorks2014";
        String user = "sa";
        String pass = "vargas7706";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionBD = "jdbc:sqlserver://localhost;databaseName=" + bdName + ";user=" + user + ";password=" + pass + ";";
            connection = DriverManager.getConnection(connectionBD);

        } 
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public List<consultaStock> getCosultaStock() {
        List<consultaStock> consultastok = new ArrayList<>();
        String sql = "SELECT top 10 \n"
                + "\n"
                + "P.ProductID, \n"
                + "\n"
                + "P.Name as ProductName, \n"
                + "\n"
                + "SUM(PIV.Quantity) AS Stock, \n"
                + "\n"
                + "SUM(SOD.OrderQty) AS QuantitySold,\n"
                + "\n"
                + "MAX(SOH.OrderDate) AS LastSoldDate,\n"
                + "\n"
                + "(select TOP 1 pe.LastName + ' ' + pe.FirstName\n"
                + "\n"
                + "from Sales.SalesOrderDetail sd\n"
                + "\n"
                + "inner join Sales.SalesOrderHeader soh on sd.SalesOrderID =soh.SalesOrderID\n"
                + "\n"
                + "inner join Sales.Customer c on soh.CustomerID=c.CustomerID\n"
                + "\n"
                + "inner join Person.Person pe on c.PersonID=pe.BusinessEntityID\n"
                + "\n"
                + "where ProductID = P.ProductID\n"
                + "\n"
                + "GROUP BY pe.LastName + ' ' + pe.FirstName\n"
                + "\n"
                + "ORDER BY COUNT(1) DESC) as BestCustomer\n"
                + "\n"
                + "FROM Production.ProductInventory PIV\n"
                + "\n"
                + "INNER JOIN Production.Product P ON PIV.ProductID=P.ProductID\n"
                + "\n"
                + "INNER JOIN Sales.SalesOrderDetail SOD ON P.ProductID = SOD.ProductID\n"
                + "\n"
                + "INNER JOIN Sales.SalesOrderHeader SOH ON SOD.SalesOrderID = SOH.SalesOrderID\n"
                + "\n"
                + "GROUP By  P.ProductID, P.Name\n"
                + "\n"
                + "ORDER By  Stock asc,QuantitySold desc";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                consultaStock c = new consultaStock();
                c.setaProductoID(rs.getInt(1));
                c.setbProductoName(rs.getString(2));
                c.setcStock(rs.getInt(3));
                c.setdQuantitySold(rs.getInt(4));
                c.setfLastSoldDate(rs.getDate(5));
                c.setgBestCustomer(rs.getString(6));
                consultastok.add(c);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return consultastok;

    }

}
