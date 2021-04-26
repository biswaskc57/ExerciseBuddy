package ExerciseBuddy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;




import static org.assertj.core.api.Assertions.assertThat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ExerciseBuddy.Services.UserDetailServiceImpl;
import ExerciseBuddy.Web.exerciseBuddyController;

@ExtendWith(SpringExtension.class)
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
