/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Vargas
 */
public class consultaStock {

    public int getaProductoID() {
        return aProductoID;
    }

    public void setaProductoID(int aProductoID) {
        this.aProductoID = aProductoID;
    }

    public String getbProductoName() {
        return bProductoName;
    }

    public void setbProductoName(String bProductoName) {
        this.bProductoName = bProductoName;
    }

    public int getcStock() {
        return cStock;
    }

    public void setcStock(int cStock) {
        this.cStock = cStock;
    }

    public int getdQuantitySold() {
        return dQuantitySold;
    }

    public void setdQuantitySold(int dQuantitySold) {
        this.dQuantitySold = dQuantitySold;
    }

    public Date getfLastSoldDate() {
        return fLastSoldDate;
    }

    public void setfLastSoldDate(Date fLastSoldDate) {
        this.fLastSoldDate = fLastSoldDate;
    }

    public String getgBestCustomer() {
        return gBestCustomer;
    }

    public void setgBestCustomer(String gBestCustomer) {
        this.gBestCustomer = gBestCustomer;
    }

    private int aProductoID;
    private String bProductoName;
    private int cStock;
    private int dQuantitySold;
    private Date fLastSoldDate;
    private String gBestCustomer;
    
}
