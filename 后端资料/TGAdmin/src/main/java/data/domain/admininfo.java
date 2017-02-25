package data.domain;

import java.util.Date;

/**
 * Created by a on 2017/2/23.
 * author:wuguoping
 */
public class admininfo {
    private String adminId;
    private String adminAccount;
    private String adminPwd;
    private Date adminRegDate;
    private Date adminLastLoginDate;

    public admininfo() {
    }

    public admininfo(String adminId, String adminAccount, String adminPwd, Date adminRegDate, Date adminLastLoginDate) {
        this.adminId = adminId;
        this.adminAccount = adminAccount;
        this.adminPwd = adminPwd;
        this.adminRegDate = adminRegDate;
        this.adminLastLoginDate = adminLastLoginDate;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Date getAdminRegDate() {
        return adminRegDate;
    }

    public void setAdminRegDate(Date adminRegDate) {
        this.adminRegDate = adminRegDate;
    }

    public Date getAdminLastLoginDate() {
        return adminLastLoginDate;
    }

    public void setAdminLastLoginDate(Date adminLastLoginDate) {
        this.adminLastLoginDate = adminLastLoginDate;
    }

    @Override
    public String toString() {
        return "admininfo{" +
                "adminId='" + adminId + '\'' +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminRegDate=" + adminRegDate +
                ", adminLastLoginDate=" + adminLastLoginDate +
                '}';
    }
}
