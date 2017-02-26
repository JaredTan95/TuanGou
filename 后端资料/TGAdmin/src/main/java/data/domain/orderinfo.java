package data.domain;

import java.sql.Date;

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
    private Date OrderDate;
    private int OrderNum;
    private int OrderStatus;
    private int OrderVolume;

    public orderinfo() {
    }

    public orderinfo(String orderID, String pro_cateId, String sellerId,
                     String cateId, String productID, String userID, Date orderDate,
                     int orderNum, int orderStatus, int orderVolume) {
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

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int orderNum) {
        OrderNum = orderNum;
    }

    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getOrderVolume() {
        return OrderVolume;
    }

    public void setOrderVolume(int orderVolume) {
        OrderVolume = orderVolume;
    }
}
