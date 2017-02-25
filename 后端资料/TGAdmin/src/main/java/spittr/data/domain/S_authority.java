package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by tanjian on 2016/12/30.
 * 管理员权限等级表
 */
@Entity
public class S_authority {
    @Column(name = "s_authid")
    private int s_authid;

    @Column(name = "s_auleavel")
    private String s_auleavel;

    @Column(name = "s_whodid")
    private String s_whodid;

    public S_authority(int s_authid, String s_auleavel, String s_whodid) {
        this.s_authid = s_authid;
        this.s_auleavel = s_auleavel;
        this.s_whodid = s_whodid;
    }

    public S_authority() {
    }

    public String getS_whodid() {
        return s_whodid;
    }

    public void setS_whodid(String s_whodid) {
        this.s_whodid = s_whodid;
    }

    public int getS_authid() {
        return s_authid;
    }

    public void setS_authid(int s_authid) {
        this.s_authid = s_authid;
    }

    public String getS_auleavel() {
        return s_auleavel;
    }

    public void setS_auleavel(String s_auleavel) {
        this.s_auleavel = s_auleavel;
    }

    @Override
    public String toString() {
        return "S_authority{" +
                "s_authid:" + s_authid +','+
                "s_auleavel:" + s_auleavel + ',' +
                "s_whodid:" + s_whodid  +
                '}';
    }
}
