package x.y;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import x.y.model.User;
import x.y.service.IMemcachedTestService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:spring-base.xml")
public class BaseApplication {
	
	@Resource
	private IMemcachedTestService service;
	
	@Test
	public void test() throws Exception {
		service.getByPersonId("4");
		
	}
	
//	@Test
	public void doQuery() {
		for (int i = 0; i < 1000; i++) {
			service.getByPersonId("4");
		}
		
	}
	
//	@Test
	public void updateQuery() {
		User param = new User();
		param.setId("4");
		param.setUsername("evict");
		for (int i = 0; i < 1000; i++) {
			if(i%10 == 0) {
				service.updatePerson(param);
			} else {
				service.getByPersonId("4");
			}
		}
		
	}
	
}
