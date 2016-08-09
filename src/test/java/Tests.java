import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.andy.start.RunClass;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(RunClass.class)
@WebIntegrationTest({ "server.port=8090" })
public class Tests extends TestCase {
    @Autowired 
	private WebApplicationContext webApplicationContext;
	
    private MockMvc mockMvc;
    
    @Before
    public void setUp(){
    	this.mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void TestCase(){
    	try {
			this.mockMvc.perform(get("/user/single").contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk())
			.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
}
