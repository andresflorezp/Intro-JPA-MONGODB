import org.junit.Test;
import eci.cosw.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import eci.cosw.Application;
import eci.cosw.data.TodoRepository;
import eci.cosw.data.UserRepository;
import eci.cosw.data.model.Todo;
import static org.junit.Assert.assertTrue;

import java.util.Date;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

   
    @Autowired
    private TodoRepository todoR;

    @Test
    public void test1() {
    	todoR.deleteAll();
    	Todo t = new Todo("hola", 1,new Date(2019, 10, 25) , "Andres","InProgress");
    	Todo t1 = new Todo("hola2", 1,new Date(2019, 10, 25) , "Andres","InProgress");
    	Todo t2 = new Todo("hola3", 1,new Date(2019, 10, 25) , "AndresG","InProgress");
    	todoR.save(new Todo("hola", 1,new Date(2019, 10, 25) , "Andres","InProgress"));
    	todoR.save(t1);
    	todoR.save(t2);
    	System.out.println(todoR.findByResponsible("Andres"));
    	assertTrue(todoR.findByResponsible("Andres").size() == 2);
    }

   
}