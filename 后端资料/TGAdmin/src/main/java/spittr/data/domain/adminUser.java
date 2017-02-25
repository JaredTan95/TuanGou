package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by tanjian on 2016/12/29.
 *
 */
@Entity
public class adminUser {
    public adminUser(){

    }
    @Id
    @Column(name="s_adminid")
    private String s_adminid;

    @Column(name="s_authid")
    private int s_authid;

    @Column(name = "s_adminaccount")
    private String s_adminaccount;

    @Column(name = "s_adminPwd")
    private String s_adminPwd;

    @Column(name = "s_adminLogininDate")
    private Date s_adminLogininDate;//允许为空

    public adminUser(String s_adminid, int s_authid, String s_adminaccount, String s_adminPwd, Date s_adminLogininDate) {
        this.s_adminid = s_adminid;
        this.s_authid = s_authid;
        this.s_adminaccount = s_adminaccount;
        this.s_adminPwd = s_adminPwd;
        this.s_adminLogininDate = s_adminLogininDate;
    }

    public String getS_adminid() {
        return s_adminid;
    }

    public void setS_adminid(String s_adminid) {
        this.s_adminid = s_adminid;
    }

    public int getS_authid() {
        return s_authid;
    }

    public void setS_authid(int s_authid) {
        this.s_authid = s_authid;
    }

    public String getS_adminaccount() {
        return s_adminaccount;
    }

    public void setS_adminaccount(String s_adminaccount) {
        this.s_adminaccount = s_adminaccount;
    }

    public String getS_adminPwd() {
        return s_adminPwd;
    }

    public void setS_adminPwd(String s_adminPwd) {
        this.s_adminPwd = s_adminPwd;
    }



    public Date getS_adminLogininDate() {
        return s_adminLogininDate;
    }

    public void setS_adminLogininDate(Date s_adminLogininDate) {
        this.s_adminLogininDate = s_adminLogininDate;
    }

    @Override
    public String toString() {
        return "adminUser{" +
                "s_adminid:" + s_adminid + ',' +
                " s_authid:" + s_authid +
                "s_adminaccount:" + s_adminaccount + ',' +
                "s_adminPwd:" + s_adminPwd + ',' +
                "s_adminLogininDate:" + s_adminLogininDate +
                '}';
    }
}
