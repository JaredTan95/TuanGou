package spittr.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tanjian on 2016/12/30.
 * 单曲实体
 */
@Entity
public class S_song {
    public S_song() {
    }

    public S_song(String s_songid, String s_singerid,
                  String s_title, String s_surl,
                  int s_visited, int s_visitedTotal,
                  int s_dloaded, String s_scover,
                  String s_smvurl, String s_songdescp) {
        this.s_songid = s_songid;
        this.s_singerid = s_singerid;
        this.s_title = s_title;
        this.s_surl = s_surl;
        this.s_visited = s_visited;
        this.s_visitedTotal = s_visitedTotal;
        this.s_dloaded = s_dloaded;
        this.s_scover = s_scover;
        this.s_smvurl = s_smvurl;
        this.s_songdescp = s_songdescp;
    }

    @Id
    @Column(name = "s_songid")
    private String s_songid;

    @Column(name = "s_singerid")
    private String s_singerid;

    @Column(name = "s_title")
    private String s_title;

    @Column(name = "s_surl")
    private String s_surl;

    @Column(name = "s_visited")
    private int s_visited;

    @Column(name = "s_visitedTotal")
    private int s_visitedTotal;

    @Column(name = "s_dloaded")
    private int s_dloaded;//总下载量

    @Column(name = "s_scover")
    private String s_scover;

    @Column(name = "s_smvurl")
    private String s_smvurl;

    @Column(name = "s_songdescp")
    private String s_songdescp;

    public String getS_songid() {
        return s_songid;
    }

    public void setS_songid(String s_songid) {
        this.s_songid = s_songid;
    }

    public String getS_singerid() {
        return s_singerid;
    }

    public void setS_singerid(String s_singerid) {
        this.s_singerid = s_singerid;
    }

    public String getS_title() {
        return s_title;
    }

    public void setS_title(String s_title) {
        this.s_title = s_title;
    }

    public String getS_surl() {
        return s_surl;
    }

    public void setS_surl(String s_surl) {
        this.s_surl = s_surl;
    }

    public int getS_visited() {
        return s_visited;
    }

    public void setS_visited(int s_visited) {
        this.s_visited = s_visited;
    }


    public int getS_visitedTotal() {
        return s_visitedTotal;
    }

    public void setS_visitedTotal(int s_visitedTotal) {
        this.s_visitedTotal = s_visitedTotal;
    }

    public int getS_dloaded() {
        return s_dloaded;
    }

    public void setS_dloaded(int s_dloaded) {
        this.s_dloaded = s_dloaded;
    }

    public String getS_scover() {
        return s_scover;
    }

    public void setS_scover(String s_scover) {
        this.s_scover = s_scover;
    }

    public String getS_smvurl() {
        return s_smvurl;
    }

    public void setS_smvurl(String s_smvurl) {
        this.s_smvurl = s_smvurl;
    }

    public String getS_songdescp() {
        return s_songdescp;
    }

    public void setS_songdescp(String s_songdescp) {
        this.s_songdescp = s_songdescp;
    }

    @Override
    public String toString() {
        return "{" +
                "s_songid:" + s_songid + ',' +
                "s_singerid:" + s_singerid + ',' +
                "s_title:" + s_title + ',' +
                "s_surl:" + s_surl + ',' +
                "s_visited:" + s_visited +
                "s_visitedTotal:" + s_visitedTotal +
                "s_dloaded:" + s_dloaded +','+
                "s_scover:" + s_scover + ',' +
                "s_smvurl:" + s_smvurl + ',' +
                "s_songdescp:" + s_songdescp +
                '}';
    }
}
