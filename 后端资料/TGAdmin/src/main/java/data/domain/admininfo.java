package data.domain;

/**
 * Created by a on 2017/2/23.
 * author:wuguoping
 */
public class admininfo {
    private String adminId;
    private String adminAccount;
    private String adminPwd;
    private String adminRegDate;
    private String adminLastLoginDate;

    public admininfo() {
    }

    public admininfo(String adminId, String adminAccount, String adminPwd, String adminRegDate, String adminLastLoginDate) {
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

    public String getAdminRegDate() {
        return adminRegDate;
    }

    public void setAdminRegDate(String adminRegDate) {
        this.adminRegDate = adminRegDate;
    }

    public String getAdminLastLoginDate() {
        return adminLastLoginDate;
    }

    public void setAdminLastLoginDate(String adminLastLoginDate) {
        this.adminLastLoginDate = adminLastLoginDate;
    }
}
