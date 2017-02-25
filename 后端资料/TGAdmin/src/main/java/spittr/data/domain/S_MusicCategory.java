package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by tanjian on 2016/12/30.
 * 歌曲分类实体
 */
@Entity
public class S_MusicCategory {
    public S_MusicCategory() {
    }

    @Column(name = "s_songid")
    private String s_songid;

    @Column(name = "s_stid")
    private String s_stid;

    public S_MusicCategory(String s_songid, String s_stid) {
        this.s_songid = s_songid;
        this.s_stid = s_stid;
    }

    public String getS_songid() {
        return s_songid;
    }

    public void setS_songid(String s_songid) {
        this.s_songid = s_songid;
    }

    public String getS_stid() {
        return s_stid;
    }

    public void setS_stid(String s_stid) {
        this.s_stid = s_stid;
    }

    @Override
    public String toString() {
        return "S_MusicCategory{" +
                "s_songid:" + s_songid + ',' +
                "s_stid:" + s_stid +
                '}';
    }
}
