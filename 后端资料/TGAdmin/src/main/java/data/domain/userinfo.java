package data.domain;

/**
 * Created by a on 2017/2/23.
 *  author:wuguoping
 */
public class userinfo {
    private String userID;
    private String userAccount;
    private String userNickName;
    private String userPwd;
    private double userPhoneNum;
    private String userAdress;
    private String userRegDate;

    public userinfo() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public double getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(double userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getUserRegDate() {
        return userRegDate;
    }

    public void setUserRegDate(String userRegDate) {
        this.userRegDate = userRegDate;
    }
}
