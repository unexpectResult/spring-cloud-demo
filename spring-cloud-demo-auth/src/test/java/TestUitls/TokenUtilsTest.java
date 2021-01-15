package TestUitls;

import com.demo.auth.AuthRunner;
import com.demo.auth.domain.system.Token;
import com.demo.auth.domain.system.User;
import com.demo.auth.util.TokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: DxlinY
 * @apiNote:
 * @date: 2021/1/14
 * @time: 10:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthRunner.class)
public class TokenUtilsTest {


    @Autowired
    private TokenUtils tokenUtils;

    @Test
    public void createToken() {
        Token token = tokenUtils.createToken(new User(1, "admin", "admin", "admin", "admin"));
        System.out.println(token);
    }
}
