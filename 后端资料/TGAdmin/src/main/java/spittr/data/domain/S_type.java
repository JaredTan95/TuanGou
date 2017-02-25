package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tanjian on 2016/12/30.
 * 歌曲类型实体
 */
@Entity
public class S_type {
    public S_type() {
    }

    @Id
    @Column(name = "s_stid")
    private String s_stid;

    @Column(name = "s_sttitle")
    private String s_sttitle;

    public String getS_stid() {
        return s_stid;
    }

    public void setS_stid(String s_stid) {
        this.s_stid = s_stid;
    }

    public String getS_sttitle() {
        return s_sttitle;
    }

    public void setS_sttitle(String s_sttitle) {
        this.s_sttitle = s_sttitle;
    }

    public S_type(String s_stid, String s_sttitle) {
        this.s_stid = s_stid;
        this.s_sttitle = s_sttitle;
    }

    @Override
    public String toString() {
        return "S_type{" +
                "s_sid:" + s_stid + ',' +
                "s_sttitle:" + s_sttitle +'}';
    }
}
