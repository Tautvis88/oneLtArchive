package lt.one.service;

import lombok.RequiredArgsConstructor;
import lt.one.dto.PostResponseDTO;
import lt.one.model.Post;
import lt.one.model.User;
import lt.one.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class PostMappingService {

	private final UserRepository userRepository;

	public List<PostResponseDTO> mapToResponseDTO(final List<Post> allPosts) {
		List<PostResponseDTO> mappedPosts = new ArrayList<>();

		for (Post post : allPosts) {
			PostResponseDTO dto = new PostResponseDTO();
			dto.setUserId(post.getUser().getId());
			dto.setUserName(post.getUser().getName());
			dto.setPostId(post.getId());
			dto.setPostMessage(post.getPostMessage());
			mappedPosts.add(dto);
		}
		return mappedPosts;
	}

}
