package data.domain;

import java.text.DecimalFormat;

/**
 * Created by a on 2017/2/23.
 * author:wuguoping
 */
public class orderinfo {
    private String OrderID;
    private String pro_cateId;
    private String sellerId;
    private String cateId;
    private String ProductID;
    private String userID;
    private String OrderDate;
    private int OrderNum;
    private double OrderStatus;
    private double OrderVolume;

    public orderinfo() {
    }

    public orderinfo(String orderID, String pro_cateId, String sellerId, String cateId, String productID,
                     String userID, String orderDate, int orderNum, double orderStatus, double orderVolume) {
        OrderID = orderID;
        this.pro_cateId = pro_cateId;
        this.sellerId = sellerId;
        this.cateId = cateId;
        ProductID = productID;
        this.userID = userID;
        OrderDate = orderDate;
        OrderNum = orderNum;
        OrderStatus = orderStatus;
        OrderVolume = orderVolume;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getPro_cateId() {
        return pro_cateId;
    }

    public void setPro_cateId(String pro_cateId) {
        this.pro_cateId = pro_cateId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int orderNum) {
        OrderNum = orderNum;
    }

    public double getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(double orderStatus) {
        OrderStatus = orderStatus;
    }

    public double getOrderVolume() {
        return OrderVolume;
    }

    public void setOrderVolume(double orderVolume) {
        OrderVolume = orderVolume;
    }
}
