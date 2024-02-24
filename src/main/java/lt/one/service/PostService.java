package lt.one.service;

import lombok.Data;
import lt.one.dto.PostResponseDTO;
import lt.one.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PostService {

	private final UserRepository userRepository;
	private final PostMappingService postMappingService;

	public List<PostResponseDTO> getAllUserPosts(final Long id) {
		var user = userRepository.findById(id).get();
		return postMappingService.mapToResponseDTO(user.getPosts());
	}
}
