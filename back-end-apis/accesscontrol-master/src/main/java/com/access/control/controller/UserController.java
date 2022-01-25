package com.access.control.controller;

import com.access.control.models.User;
import com.access.control.repository.UserRepository;
import com.access.control.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping ("/api/v1")
public class UserController {
    @Autowired
    private  UserRepository userRepository;
/**
 * Get all users list.
 *
 * @return the list
 */
@GetMapping("/users")
    public  List<User>getAllUsers(){
    return userRepository.findAll();
}
/**
 * Gets users by id.
 *
 * @param userId the user id
 * @return the users by id
 * @throws ResourceNotFoundException the resource not found exception
 */
@GetMapping("/user/{id}")
    public ResponseEntity<User>getUsersById(@PathVariable(value = "id") Long userId)
    throws ResourceNotFoundException{
    User user= userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on ::" +userId));
    return  ResponseEntity.ok().body(user);
}
    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */

@PostMapping("/users")
public User createUser(@Valid @RequestBody User user){
    return  UserRepository.save(user);
}
/**
 * Update user response entity.
 *
 * @param userId the user id
 * @param userDetails the user details
 * @return the response entity
 * @throws ResourceNotFoundException the resource not found exception
 */
@PutMapping("/users/{id}")
    public ResponseEntity<User> updatedUser(
    @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
    throws ResourceNotFoundException{
    User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found on ::" +userId));
    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setUpdatedAt(new Date());
    final User updatedUser= userRepository.save(user);
    return ResponseEntity.ok(updatedUser);

}
/**
 * Delete user map.
 *
 * @param userId the user id
 * @return the map
 * @throws Exception the exception
 */
@DeleteMapping("/user{id")
    public Map<String,Boolean>deleteUser (@PathVariable(value = "id")Long userId) throws  Exception{
    User user= userRepository.findById((userId)).orElseThrow(() ->new ResourceNotFoundException("User not found on ::"+userId));
    userRepository.delete(user);
    Map<String,Boolean> response =new HashMap<>();
    response.put("User deleted",Boolean.TRUE);
    return  response;
}



}


//    final private UserRepository userRepository;//    private HashData hashData = new HashData();
//     public UserController(UserRepository userRepository) {
//        this.userRepository=userRepository;
//}
//    @PostMapping("/user")
//    public Boolean create(@RequestBody Map<String, String> body)
//            throws NoSuchAlgorithmException {
//        String userName = body.get("userName");
//        if (userRepository.existsByuserName(userName)){
//            throw new ValidationException("Username already existed");        }
//        String password = body.get("password");
//        String encodedPassword = new BCryptPasswordEncoder().encode(password);
////        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
//        String firstName = body.get("firstName");
//        userRepository.save(new User(userName, encodedPassword, firstName));
//        return true;
//    }}

//    @Autowired
//    private UserRepository userRepository;
//    @PostMapping("/users/register")
//    public Status registerUser(@Valid @RequestBody User newUser) {
//        List<User> users = userRepository.findAll();
//        System.out.println("New user: " + newUser.toString());
//        for (User user : users) {
//            System.out.println("Registered user: " + newUser.toString());
//            if (user.equals(newUser)) {
//                System.out.println("User Already exists!");
//                return Status.USER_ALREADY_EXISTS;
//            }
//        }
//        userRepository.save(newUser);
//        return Status.SUCCESS;
//    }
//    @PostMapping("/users/login")
//    public Status loginUser(@Valid @RequestBody User user) {
//        List<User> users = userRepository.findAll();
//        for (User other : users) {
//            if (other.equals(user)) {
//                user.setLoggedIn(true);
//                userRepository.save(user);
//                return Status.SUCCESS;
//            }
//        }
//        return Status.FAILURE;
//    }
//    @PostMapping("/users/logout")
//    public Status logUserOut(@Valid @RequestBody User user) {
//        List<User> users = userRepository.findAll();
//        for (User other : users) {
//            if (other.equals(user)) {
//                user.setLoggedIn(false);
//                userRepository.save(user);
//                return Status.SUCCESS;
//            }
//        }
//        return Status.FAILURE;
//    }
//    @DeleteMapping("/users/all")
//    public Status deleteUsers() {
//        userRepository.deleteAll();
//        return Status.SUCCESS;
//    }
//
//}
//

