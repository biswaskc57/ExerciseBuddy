package ExerciseBuddy;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ExerciseBuddy.Services.UserDetailServiceImpl;
import ExerciseBuddy.Web.exerciseBuddyController;

@SpringBootTest
class ExerciseAppApplicationTests {

	@Autowired
	private exerciseBuddyController webController;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	@Test
	public void contextLoads() throws Exception {
		assertThat(webController).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}
	
}
