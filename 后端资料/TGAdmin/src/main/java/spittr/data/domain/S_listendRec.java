package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by tanjian on 2016/12/30.
 * 用户听歌排行（记录）关系实体
 */
@Entity
public class S_listendRec {
    @Column(name = "s_userid")
    private String s_userid;

    @Column(name = "s_songid")
    private String s_songid;

    @Column(name = "s_listendRecNum")
    private int s_listendRecNum;

    @Column(name = "s_userLisetenenDate")
    private Date s_userLisetenenDate;

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

    public int getS_listendRecNum() {
        return s_listendRecNum;
    }

    public void setS_listendRecNum(int s_listendRecNum) {
        this.s_listendRecNum = s_listendRecNum;
    }

    public Date getS_userLisetenenDate() {
        return s_userLisetenenDate;
    }

    public void setS_userLisetenenDate(Date s_userLisetenenDate) {
        this.s_userLisetenenDate = s_userLisetenenDate;
    }

    public S_listendRec(String s_userid, String s_songid,
                        int s_listendRecNum, Date s_userLisetenenDate) {
        this.s_userid = s_userid;
        this.s_songid = s_songid;
        this.s_listendRecNum = s_listendRecNum;
        this.s_userLisetenenDate = s_userLisetenenDate;
    }

    @Override
    public String toString() {
        return "S_listendRec{" +
                "s_userid:" + s_userid + ',' +
                "s_songid:" + s_songid + ',' +
                "s_listendRecNum:" + s_listendRecNum +','+
                "s_userLisetenenDate:" + s_userLisetenenDate +
                '}';
    }
}
