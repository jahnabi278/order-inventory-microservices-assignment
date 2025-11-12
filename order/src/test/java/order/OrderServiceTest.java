package order;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.test.client.TestRestTemplate;

@SpringBootTest
public class OrderServiceTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void placeOrder() {
		assertTrue(true);
	}
}
