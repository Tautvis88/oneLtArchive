package lt.one.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lt.one.exception.WrongIdException;
import lt.one.service.PostService;
import lt.one.validator.UserRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	private final UserRequestValidator userRequestValidator;

	@Operation(summary = "Get all user posts.")
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllPostsByUserId(@PathVariable final Long userId) {
		try {
			userRequestValidator.validateUserIdExists(userId);
			final var userPosts = postService.getAllUserPosts(userId);
			return ResponseEntity.ok().body(userPosts);
		} catch (WrongIdException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
