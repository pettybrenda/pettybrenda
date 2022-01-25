package com.access.control;

import com.access.control.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccessControlSystemApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	private String getRootUrl(){
		return "http://localhost:"+port;
	}

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetAllUsers(){
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<String>entity=new HttpEntity<String >(null,headers);

		ResponseEntity<String>response =restTemplate.exchange(getRootUrl()+"/users", HttpMethod.GET,entity,String.class);

		assertNotNull(response.getBody());
	}

	@Test
	public  void testUSerById(){
		User user=restTemplate.getForObject(getRootUrl()+"/users/1",User.class);
		System.out.println(user.getFirstName());
		assertNotNull(user);
	}
	@Test
	public  void testCreateUser(){
		User user=new User();
		user.setEmail("example@gmail.com");
		user.setFirstName("Admin");
		user.setLastName("admin");
//		user.setUpdatedAt();
		user.setCreatedBy("admin");

		ResponseEntity<User>postResponse=restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public  void  testUpdatedPost(){
		int id =1;


	User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
    user.setFirstName("admin1");
    user.setLastName("admin2");

    restTemplate.put(getRootUrl() + "/users/" + id, user);

	User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
    assertNotNull(updatedUser);
}

	@Test
	public void testDeletePost() {
		int id = 2;
		User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		assertNotNull(user);

		restTemplate.delete(getRootUrl() + "/users/" + id);

		try {
			user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
