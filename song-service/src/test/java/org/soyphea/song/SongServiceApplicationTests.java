package org.soyphea.song;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SongServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testGetListSongShouldBeReturn200() {
		webTestClient.get().uri("/song").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk();
	}

	@Test
	public void testGetSongWithGivenIdShouldReturn404() {
		webTestClient.get().uri("/song/9999999").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk();
	}

}
