package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by tanjian on 2017/2/28.
 * 生成订单编号工具类
 */
public class OutOrderNum{
    private String PREFIX="TG";

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String OrderNum(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateNowStr = sdf.format(new Date(System.currentTimeMillis()));
        return PREFIX+dateNowStr+new Random().nextInt(1000);
    }
}
