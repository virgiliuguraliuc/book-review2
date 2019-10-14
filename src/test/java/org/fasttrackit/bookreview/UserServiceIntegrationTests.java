package org.fasttrackit.bookreview;

import org.fasttrackit.bookreview.domain.User;
import org.fasttrackit.bookreview.service.UserService;
import org.fasttrackit.bookreview.steps.UserSteps;
import org.fasttrackit.bookreview.transfer.book.user.SaveUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTests {

    @Autowired
    private UserSteps userSteps;

    @Test
    public void testCreateUser_whenValidRequest_thenReturnCreatedUser() {
      userSteps.createUser();


    }



}

