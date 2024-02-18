package lt.one.service;

import lombok.Data;
import lt.one.dto.PostResponseDTO;
import lt.one.model.User;
import lt.one.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class PostService {

	private final UserRepository userRepository;
	private final PostMappingService postMappingService;

	public List<PostResponseDTO> getAllUserPosts(final Long id) {
		Optional<User> user = userRepository.findById(id);
		return postMappingService.mapToResponseDTO(user.get().getPosts());
	}
}
