/*
 * package com.hcl.DemoApplication;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.times; import static org.mockito.Mockito.verify; import
 * static org.mockito.Mockito.when;
 * 
 * import java.util.Optional; import java.util.stream.Collectors; import
 * java.util.stream.Stream;
 * 
 * import org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test;
 * import org.junit.runner.RunWith; import org.mockito.InjectMocks; import
 * org.mockito.Mock; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.hcl.dto.UserDto; import com.hcl.entity.User; import
 * com.hcl.repository.UserRepository; import
 * com.hcl.serviceImpl.UserServiceImpl;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class UserControllerTest {
 * 
 * 
 * @InjectMocks UserServiceImpl userService;
 * 
 * @Mock UserRepository userRepository;
 * 
 * static UserDto userDto = new UserDto();
 * 
 * @BeforeAll public static void setUp() { userDto.setName("Anil");
 * userDto.setAge(28); userDto.setEmail("anil@gmail.com");
 * System.out.println("setup method"); }
 * 
 * @Test void getUserTest() { when(userRepository.findAll()).thenReturn(
 * Stream.of(new User(1l, "Anil", "a@gmail.com", 29), new User(2l, "Pratap",
 * "p@gmail.com", 28)) .collect(Collectors.toList())); assertEquals(2,
 * userService.getAllUser().size()); }
 * 
 * @Test void getUserByIdTest() { User user = new User(1L, "Rashmi",
 * "r@gmail.com", 25);
 * when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
 * assertEquals(user, userService.getUserById(user.getId())); }
 * 
 * @Test void saveUserTest() { User user = new User();
 * user.setAge(userDto.getAge()); user.setEmail(userDto.getEmail());
 * user.setName(userDto.getName());
 * when(userRepository.save(user)).thenReturn(user); assertNotNull(user); }
 * 
 * @Test void deleteUserTest() { User user = new User(1L, "Rashmi",
 * "r@gmail.com", 25); userService.delete(user.getId()); verify(userRepository,
 * times(1)).deleteById(user.getId()); }
 * 
 * }
 */