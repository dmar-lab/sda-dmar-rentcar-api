package dar.mar.rentcarapi.domain.user;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

import static dar.mar.rentcarapi.domain.user.User.builder;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository, passwordEncoder);
    private final ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);


    @Test
    void shouldRegisterUser() {
        User user1 = builder()
                .username("Rafal")
                .password("12345")
                .role("done")
                .build();
        Mockito.when(userRepository.getByUsername("Rafal")).thenReturn(Optional.empty());
        userService.registerUser(user1);

        User result = userArgumentCaptor.getValue();
        //then
        Mockito.verify(userRepository).getByUsername("Rafal");
        assertEquals("Rafal", result.getUsername());

    }

    @Test
    void testShouldFindUserByUsername() {
        //given
        String username = "username";
        //when
        Mockito.when(userRepository.getByUsername(username)).thenReturn(Optional.of(User.builder()
                .id(1)
                .username("username")
                .password("password")
                .role("user")
                .build()));

        User result = userService.findUserByName(username);
        //then
        Mockito.verify(userRepository).getByUsername(username);
        assertEquals("username", result.getUsername());
        assertEquals(1, result.getId());
        assertEquals("user", result.getRole());
        assertEquals("password", result.getPassword());

    }

    @Test
    void testShouldThrowExceptionForIncorrectUsername() {
        //given
        String username = "user";
        //when
        Mockito.when(userRepository.getByUsername("username")).thenReturn(Optional.empty());
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> userService.findUserByName(username));
        //then
        Mockito.verify(userRepository).getByUsername(username);
        assertEquals("Unknown user", ex.getMessage());
    }

}