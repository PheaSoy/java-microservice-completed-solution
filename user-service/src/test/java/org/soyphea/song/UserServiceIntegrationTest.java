package org.soyphea.song;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceIntegrationTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    User song;

    @BeforeEach
    void setup(){
        song =new User();
        song.setName("Shap Of You");
        song.setSingerName("Ed Sheeran");
    }

    @Test
    @DisplayName("Test create song should be return ok. ")
    public void testCreate(){
        ResponseEntity<User> response = testRestTemplate.postForEntity(uriBuilder(),song, User.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo(song.getName());
    }


    String uriBuilder(){
        return String.format("http://localhost:%d/song",port);
    }


}
