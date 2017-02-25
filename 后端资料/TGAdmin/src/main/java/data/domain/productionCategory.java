package data.domain;

/**
 * Created by a on 2017/2/23.
 *  author:wuguoping
 */
public class productionCategory {
    private String cateId;
    private String cateTitle;

    public productionCategory(String cateId, String cateTitle) {
        this.cateId = cateId;
        this.cateTitle = cateTitle;
    }

    public productionCategory() {

    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateTitle() {
        return cateTitle;
    }

    public void setCateTitle(String cateTitle) {
        this.cateTitle = cateTitle;
    }
}
