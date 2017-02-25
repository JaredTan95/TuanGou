package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by tanjian on 2016/12/30.
 * 用户收藏歌曲关系实体
 */
@Entity
public class S_userFavSong {
    @Column(name = "s_songid")
    private String s_songid;

    @Column(name = "s_userid")
    private String s_userid;

    @Column(name = "s_uFavSongDate")
    private Date s_uFavSongDate;

    public Date getS_uFavSongDate() {
        return s_uFavSongDate;
    }

    public void setS_uFavSongDate(Date s_uFavSongDate) {
        this.s_uFavSongDate = s_uFavSongDate;
    }

    public String getS_songid() {
        return s_songid;
    }

    public void setS_songid(String s_songid) {
        this.s_songid = s_songid;
    }

    public String getS_userid() {
        return s_userid;
    }

    public void setS_userid(String s_userid) {
        this.s_userid = s_userid;
    }

    public S_userFavSong(String s_songid, String s_userid, Date s_uFavSongDate) {
        this.s_songid = s_songid;
        this.s_userid = s_userid;
        this.s_uFavSongDate = s_uFavSongDate;
    }

    @Override
    public String toString() {
        return "S_userFavSong{" +
                "s_songid:" + s_songid + ',' +
                "s_userid:" + s_userid + ',' +
                "s_uFavSongDate:" + s_uFavSongDate +
                '}';
    }
}
