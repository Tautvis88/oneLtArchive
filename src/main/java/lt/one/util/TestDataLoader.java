package lt.one.util;

import lombok.RequiredArgsConstructor;
import lt.one.model.Post;
import lt.one.model.User;
import lt.one.repository.PostRepository;
import lt.one.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PostRepository postRepository;

	/**
	 * <a href="http://localhost:1112/h2-console">http://localhost:1111/h2-console</a>
	 * <br><br>
	 * SELECT * FROM USER_NAME;<br>
	 * SELECT * FROM POST;
	 */
	@Override
	public void run(String... args) throws Exception {

		// Create Users
		var user1 = User.builder()
				.name("John Doe")
				.build();
		var user2 = User.builder()
				.name("Jane Smith")
				.build();
		var user3 = User.builder()
				.name("Alex Johnson")
				.build();

		// Create Posts
		var post1 = Post.builder()
				.postMessage("Hello, I'm John, I have joined one.lt portal.")
				.user(user1)
				.build();
		var post2 = Post.builder()
				.postMessage("There are so many beautiful people here.")
				.user(user1)
				.build();
		var post3 = Post.builder()
				.postMessage("Who would like to meet me?")
				.user(user1)
				.build();
		var post4 = Post.builder()
				.postMessage("Hello, I'm Jane, it's great to join this one.lt portal.")
				.user(user2)
				.build();
		var post5 = Post.builder()
				.postMessage("This portal is my first dating website!")
				.user(user2)
				.build();
		var post6 = Post.builder()
				.postMessage("Hello, I'm Alex, it's nice to join the one.lt community.")
				.user(user3)
				.build();

		user1.setPosts(Arrays.asList(post1, post2, post3));
		user2.setPosts(Arrays.asList(post4, post5));
		user3.setPosts(Arrays.asList(post6));

		userRepository.saveAll(Arrays.asList(user1, user2, user3));

		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4, post5, post6));

	}
}
