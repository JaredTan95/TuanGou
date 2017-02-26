package config;

import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.annotation.WebFilter;

/**
 * Created by tanjian on 2017/2/25.
 */
@WebFilter
public class EncodingFilter extends CharacterEncodingFilter {
    @Override
    public void setForceRequestEncoding(boolean forceRequestEncoding) {
        super.setForceRequestEncoding(forceRequestEncoding);
        setEncoding("UTF-8");
        setForceEncoding(true);
    }

    @Override
    public void setForceResponseEncoding(boolean forceResponseEncoding) {
        super.setForceResponseEncoding(forceResponseEncoding);
        setEncoding("UTF-8");
        setForceEncoding(true);
    }

    public EncodingFilter() {
        setForceRequestEncoding(true);
        setForceResponseEncoding(true);
    }
}
