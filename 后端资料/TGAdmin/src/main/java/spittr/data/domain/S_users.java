package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tanjian on 2016/12/30.
 * 用户实体
 */
@Entity
public class S_users {
    @Id
    @Column(name = "s_userid")
    private String s_userid;

    @Column(name = "s_uaccount")
    private String s_uaccount;

    @Column(name = "s_upwdsalt")
    private String s_upwdsalt;

    @Column(name = "s_upwd")
    private String s_upwd;

    @Column(name = "s_unickname")
    private String s_unickname;

    @Column(name = "s_uemail")
    private String s_uemail;

    @Column(name = "s_unone")
    private String s_unone;

    public String getS_userid() {
        return s_userid;
    }

    public void setS_userid(String s_userid) {
        this.s_userid = s_userid;
    }

    public String getS_uaccount() {
        return s_uaccount;
    }

    public void setS_uaccount(String s_uaccount) {
        this.s_uaccount = s_uaccount;
    }

    public String getS_upwdsalt() {
        return s_upwdsalt;
    }

    public void setS_upwdsalt(String s_upwdsalt) {
        this.s_upwdsalt = s_upwdsalt;
    }

    public String getS_upwd() {
        return s_upwd;
    }

    public void setS_upwd(String s_upwd) {
        this.s_upwd = s_upwd;
    }

    public String getS_unickname() {
        return s_unickname;
    }

    public void setS_unickname(String s_unickname) {
        this.s_unickname = s_unickname;
    }

    public String getS_uemail() {
        return s_uemail;
    }

    public void setS_uemail(String s_uemail) {
        this.s_uemail = s_uemail;
    }

    public String getS_unone() {
        return s_unone;
    }

    public void setS_unone(String s_unone) {
        this.s_unone = s_unone;
    }

    public S_users(String s_userid, String s_uaccount,
                   String s_upwdsalt, String s_upwd,
                   String s_unickname, String s_uemail,
                   String s_unone) {
        this.s_userid = s_userid;
        this.s_uaccount = s_uaccount;
        this.s_upwdsalt = s_upwdsalt;
        this.s_upwd = s_upwd;
        this.s_unickname = s_unickname;
        this.s_uemail = s_uemail;
        this.s_unone = s_unone;
    }

    @Override
    public String toString() {
        return "S_users{" +
                "s_userid:" + s_userid + ',' +
                "s_uaccount:" + s_uaccount + ',' +
                "s_upwdsalt:" + s_upwdsalt + ',' +
                "s_upwd:" + s_upwd + ',' +
                "s_unickname:" + s_unickname + ',' +
                "s_uemail:" + s_uemail + ',' +
                "s_unone:" + s_unone +
                '}';
    }
}
