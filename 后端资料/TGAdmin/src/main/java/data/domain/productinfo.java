package data.domain;

/**
 * Created by a on 2017/2/23.
 * author:wuguoping
 */
public class productinfo {
    private String pro_cateId;
    private String sellerId;
    private String cateId;
    private String ProductId;
    private float Startprice;
    private String productionDscp;
    private double SalePrice;
    private double AdCount;
    private String publishDate;
    private int sellCount;
    private String productPic;
    private  double productStatus;

    public productinfo() {
    }

    public productinfo(String pro_cateId, String cateId, String productId, float startprice, String productionDscp, double salePrice, double adCount, String publishDate, int sellCount, String productPic, double productStatus) {
    }

    public productinfo(String pro_cateId, String sellerId, String cateId, String productId, float startprice,
                       String productionDscp, double salePrice, double adCount, String publishDate, int sellCount,
                       String productPic, double productStatus) {
        this.pro_cateId = pro_cateId;
        this.sellerId = sellerId;
        this.cateId = cateId;
        ProductId = productId;
        Startprice = startprice;
        this.productionDscp = productionDscp;
        SalePrice = salePrice;
        AdCount = adCount;
        this.publishDate = publishDate;
        this.sellCount = sellCount;
        this.productPic = productPic;
        this.productStatus = productStatus;
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

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public float getStartprice() {
        return Startprice;
    }

    public void setStartprice(float startprice) {
        Startprice = startprice;
    }

    public String getProductionDscp() {
        return productionDscp;
    }

    public void setProductionDscp(String productionDscp) {
        this.productionDscp = productionDscp;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }

    public double getAdCount() {
        return AdCount;
    }

    public void setAdCount(double adCount) {
        AdCount = adCount;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public double getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(double productStatus) {
        this.productStatus = productStatus;
    }
}
