package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tanjian on 2016/12/30.
 * 歌手实体
 */
@Entity
public class S_singer {
    @Id
    @Column(name = "s_singerid")
    private String s_singerid;

    @Column(name = "s_sname")
    private String s_sname;

    @Column(name = "s_sgender")
    private int s_sgender;

    @Column(name = "s_sdescp")
    private String s_sdescp;

    @Column(name = "s_svisi")
    private int s_svisi;

    @Column(name = "s_spic")
    private String s_spic;

    public String getS_singerid() {
        return s_singerid;
    }

    public void setS_singerid(String s_singerid) {
        this.s_singerid = s_singerid;
    }

    public String getS_sname() {
        return s_sname;
    }

    public void setS_sname(String s_sname) {
        this.s_sname = s_sname;
    }

    public int getS_sgender() {
        return s_sgender;
    }

    public void setS_sgender(int s_sgender) {
        this.s_sgender = s_sgender;
    }

    public String getS_sdescp() {
        return s_sdescp;
    }

    public void setS_sdescp(String s_sdescp) {
        this.s_sdescp = s_sdescp;
    }

    public int getS_svisi() {
        return s_svisi;
    }

    public void setS_svisi(int s_svisi) {
        this.s_svisi = s_svisi;
    }

    public String getS_spic() {
        return s_spic;
    }

    public void setS_spic(String s_spic) {
        this.s_spic = s_spic;
    }

    public S_singer(String s_singerid, String s_sname,
                    int s_sgender, String s_sdescp,
                    int s_svisi, String s_spic) {
        this.s_singerid = s_singerid;
        this.s_sname = s_sname;
        this.s_sgender = s_sgender;
        this.s_sdescp = s_sdescp;
        this.s_svisi = s_svisi;
        this.s_spic = s_spic;
    }

    @Override
    public String toString() {
        return "{" +
                "s_singerid:'" + s_singerid + "'," +
                "s_sname:'" + s_sname +  "'," +
                "s_sgender:'" + s_sgender + "',"+
                "s_sdescp:'" + s_sdescp +  "'," +
                "s_svisi:'" + s_svisi + "',"+
                "s_spic:'" + s_spic +"'"+
                '}';
    }
}
