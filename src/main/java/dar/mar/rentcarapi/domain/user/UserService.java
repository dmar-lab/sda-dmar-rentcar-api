package dar.mar.rentcarapi.domain.user;
// korzysta z metod getByUsername() i create(user)
// zapisanych w external.user.DatabaseUserRepository
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        if (userRepository.getByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User with given login already exists");
        }
        user.encodePassword(passwordEncoder, user.getPassword());
        userRepository.create(user);
    }
}
