package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by tanjian on 2016/12/30.
 * 用户评论歌曲关系实体
 */
@Entity
public class S_userComment {
    @Column(name = "s_userid")
    private String s_userid;

    @Column(name = "s_songid")
    private String s_songid;

    @Column(name = "s_userCommContent")
    private String s_userCommContent;

    @Column(name = "s_userCommDate")
    private Date s_userCommDate;

    public String getS_userid() {
        return s_userid;
    }

    public void setS_userid(String s_userid) {
        this.s_userid = s_userid;
    }

    public String getS_songid() {
        return s_songid;
    }

    public void setS_songid(String s_songid) {
        this.s_songid = s_songid;
    }

    public String getS_userCommContent() {
        return s_userCommContent;
    }

    public void setS_userCommContent(String s_userCommContent) {
        this.s_userCommContent = s_userCommContent;
    }

    public Date getS_userCommDate() {
        return s_userCommDate;
    }

    public void setS_userCommDate(Date s_userCommDate) {
        this.s_userCommDate = s_userCommDate;
    }

    public S_userComment(String s_userid, String s_songid,
                         String s_userCommContent, Date s_userCommDate) {
        this.s_userid = s_userid;
        this.s_songid = s_songid;
        this.s_userCommContent = s_userCommContent;
        this.s_userCommDate = s_userCommDate;
    }

    @Override
    public String toString() {
        return "S_userComment{" +
                "s_userid:" + s_userid + ',' +
                "s_songid:" + s_songid + ',' +
                "s_userCommContent:" + s_userCommContent + ',' +
                "s_userCommDate:" + s_userCommDate +
                '}';
    }
}
