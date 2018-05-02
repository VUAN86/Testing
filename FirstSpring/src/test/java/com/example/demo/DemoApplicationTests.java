package com.example.demo;

import com.example.demo.obj.Auto;
import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.ClientRepository;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    
    @Autowired
    AutoRepository autorepository;

    @Autowired
    ClientRepository clientrepository;

    @Before
	public void beforeTest() {
            System.out.println("Starting the test...");
        }

    @After
	public void afterTest() {
            System.out.println("After the test.");
        }
        
	@Test
	public void testGetCars() {
            List <Auto> list = (List <Auto>) autorepository.findAll();
            System.out.println(list);
            assertEquals("fail - carslist not correct", 3, list.size());
	}

}
