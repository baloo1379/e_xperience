package pl.baloo.e_xperience;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EXperienceApplicationTests {

	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {
	}

	@Test
	public void commonTest() {
		given()
			.port(port)
				.when()
			.get("http://localhost/api")
				.then()
				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.log().body();
	}

}
