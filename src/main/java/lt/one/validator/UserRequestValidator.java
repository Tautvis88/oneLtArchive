package lt.one.validator;

import lombok.RequiredArgsConstructor;
import lt.one.exception.WrongIdException;
import lt.one.repository.UserRepository;
import lt.one.util.console_colors.CustomLogger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRequestValidator {

	private final UserRepository userRepository;
	private final CustomLogger log;

	public void validateUserIdExists(final Long id) throws WrongIdException {
		if (!userRepository.existsById(id)) {
			log.error("User ID does not exist in the DB");
			throw new WrongIdException("ID does not exist in the database!");
		}
	}



}
