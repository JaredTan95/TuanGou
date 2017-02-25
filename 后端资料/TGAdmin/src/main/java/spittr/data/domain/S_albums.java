package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tanjian on 2016/12/30.
 * 专辑实体
 */
@Entity
public class S_albums {
    @Id
    @Column(name = "s_aid")
    private String s_aid;

    @Column(name = "s_singerid")
    private String s_singerid;

    @Column(name = "s_atitle")
    private String s_atitle;

    @Column(name = "s_apubTime")
    private Date s_apubTime;

    @Column(name = "s_adescp")
    private String s_adescp;

    @Column(name = "s_avisRec")
    private int s_avisRec;

    @Column(name = "s_aCoverUrl")
    private String s_aCoverUrl;

    public String getS_aCoverUrl() {
        return s_aCoverUrl;
    }

    public void setS_aCoverUrl(String s_aCoverUrl) {
        this.s_aCoverUrl = s_aCoverUrl;
    }

    public String getS_aid() {
        return s_aid;
    }

    public void setS_aid(String s_aid) {
        this.s_aid = s_aid;
    }

    public String getS_singerid() {
        return s_singerid;
    }

    public void setS_singerid(String s_singerid) {
        this.s_singerid = s_singerid;
    }

    public String getS_atitle() {
        return s_atitle;
    }

    public void setS_atitle(String s_atitle) {
        this.s_atitle = s_atitle;
    }

    public Date getS_apubTime() {
        return s_apubTime;
    }

    public void setS_apubTime(Date s_apubTime) {
        this.s_apubTime = s_apubTime;
    }

    public String getS_adescp() {
        return s_adescp;
    }

    public void setS_adescp(String s_adescp) {
        this.s_adescp = s_adescp;
    }

    public int getS_avisRec() {
        return s_avisRec;
    }

    public void setS_avisRec(int s_avisRec) {
        this.s_avisRec = s_avisRec;
    }

    public S_albums(String s_aid, String s_singerid,
                    String s_atitle, Date s_apubTime,
                    String s_adescp, int s_avisRec, String s_aCoverUrl) {
        this.s_aid = s_aid;
        this.s_singerid = s_singerid;
        this.s_atitle = s_atitle;
        this.s_apubTime = s_apubTime;
        this.s_adescp = s_adescp;
        this.s_avisRec = s_avisRec;
        this.s_aCoverUrl = s_aCoverUrl;
    }

    @Override
    public String toString() {
        return "S_albums{" +
                "s_aid:" + s_aid + ',' +
                "s_singerid:" + s_singerid + ',' +
                "s_atitle:" + s_atitle + ',' +
                "s_apubTime:" + s_apubTime +','+
                "s_adescp:" + s_adescp + ',' +
                "s_avisRec:" + s_avisRec + '}';
    }
}
