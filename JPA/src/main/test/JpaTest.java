import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eci.cosw.Application;
import eci.cosw.data.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

   

    @Test
    public void test1() {
//        Users user = new Users();
//        long userId = 1L;
//        user.setId(userId);
//        user.setFirstName("FirstName");
//        user.setLastName("FirstName");
//        user.setEmailId("fisrtname.secondname@gmail.com");
//        user.setPhoneNumber("1234567890");
//
//        assertEquals(user, userRepository.save(user));
    }

   
}