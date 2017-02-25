package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by tanjian on 2016/12/30.
 * 用户收藏专辑实体
 */
@Entity
public class S_userFavAlbum {
    @Column(name = "s_aid")
    private String s_aid;

    @Column(name = "s_userid")
    private String s_userid;

    public Date getS_uFavAlbumDate() {
        return s_uFavAlbumDate;
    }

    public void setS_uFavAlbumDate(Date s_uFavAlbumDate) {
        this.s_uFavAlbumDate = s_uFavAlbumDate;
    }

    @Column(name = "s_uFavAlbumDate")
    private Date s_uFavAlbumDate;

    public String getS_aid() {
        return s_aid;
    }

    public void setS_aid(String s_aid) {
        this.s_aid = s_aid;
    }

    public String getS_userid() {
        return s_userid;
    }

    public void setS_userid(String s_userid) {
        this.s_userid = s_userid;
    }

    public S_userFavAlbum(String s_aid, String s_userid, Date s_uFavAlbumDate) {
        this.s_aid = s_aid;
        this.s_userid = s_userid;
        this.s_uFavAlbumDate = s_uFavAlbumDate;
    }

    @Override
    public String toString() {
        return "S_userFavAlbum{" +
                "s_aid:" + s_aid + ',' +
                "s_userid:" + s_userid + ',' +
                "s_uFavAlbumDate:" + s_uFavAlbumDate +
                '}';
    }
}
