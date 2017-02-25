import org.junit.Test;
import spittr.utils.sha256;

import java.security.NoSuchAlgorithmException;

/**
 * Created by tanjian on 2017/1/20.
 */
public class sha256Test {
    @Test
    public void encrytedTest() throws NoSuchAlgorithmException {
        System.out.println(sha256.encrypted("a050fddd1e158d7b67052299ddd8c2987e5b484b886d226b9fe70e5ddecba8d8tanjian1002tanjian1002").length());
    }
}
