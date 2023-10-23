package com.luanvan.b1910025.controllers;

import com.luanvan.b1910025.models.User;
import com.luanvan.b1910025.payloads.requests.LoginRequest;
import com.luanvan.b1910025.payloads.requests.SignUpRequest;
import com.luanvan.b1910025.payloads.requests.TokenRequest;
import com.luanvan.b1910025.payloads.responses.ApiResponse;
import com.luanvan.b1910025.payloads.responses.JwtResponse;
import com.luanvan.b1910025.payloads.responses.MsgResponse;
import com.luanvan.b1910025.repository.UserRepo;
import com.luanvan.b1910025.security.jwt.JwtUtils;
import com.luanvan.b1910025.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepository;

    // @Autowired
    // RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signin") // new signin
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

       /* Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = jwtUtils.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
                userDetails.getEmail(), userDetails.getRole().toString()));*/

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            String jwt = jwtUtils.generateToken(authentication);

            return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
                    userDetails.getEmail(), userDetails.getRole().toString()));
        } catch (BadCredentialsException e) {
            // Handle incorrect username or password
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse(false, "Invalid username or password"));
        }
    }

//    @CrossOrigin(origins = "*", maxAge = 3600)
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
//                userDetails.getEmail(), userDetails.getRole().toString()));
//    }


    //New signup
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        // Creating user's account
//        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
//                signUpRequest.getPassword());
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//
//        user.setRole("User");
//
//        User result = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(result.getUsername()).toUri();
//
//        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
//    }


    /**
     * @param signUpRequest
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MsgResponse("Lỗi: Tên đăng nhập đã tồn tại"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MsgResponse("Lỗi: Tên đăng nhập đã được sử dụng"));
        } else {
            // Create new user's account
            User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getPassword()), "user");

            userRepository.save(user);
            return ResponseEntity.ok(new MsgResponse("Đăng ký thành công"));
        }

    }

    /**
     * @param signUpRequest
     * @return
     */
    @PostMapping("/signup-user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MsgResponse("Lỗi: Tên đăng nhập đã tồn tại"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MsgResponse("Lỗi: Tên đăng nhập đã được sử dụng"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), "user");

        userRepository.save(user);
        return ResponseEntity.ok(new MsgResponse("Đăng ký thành công"));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @PostMapping("/checkToken")
    public ResponseEntity<JwtResponse> checkToken(@RequestBody TokenRequest tokenRequest) {
        Long userId = jwtUtils.getUserIdFromJWT(tokenRequest.getToken());

        switch (userId.toString()) {
            case "0": // Token không hợp lệ (ví dụ: userId không hợp lệ)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JwtResponse(false));
            case "-1":
                // Token đã hết hạn
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse(false));
            case "-2":
                // Token không thấy hoặc giá trị khác để biểu thị token không hợp lệ
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JwtResponse(false));
            default:
                // Sử dụng userRepo để tìm người dùng theo userId
                Optional<User> userOptional = userRepository.findById(userId);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    // Điều gì bạn muốn làm với thông tin người dùng có thể thực hiện ở đây
                    // Ví dụ: trả về thông tin người dùng trong đối tượng JwtResponse
                    JwtResponse response = new JwtResponse(true);
                    response.setId(user.getId());
                    response.setUsername(user.getUsername());
                    response.setEmail(user.getEmail());
                    response.setRole(user.getRole());
                    response.setToken(tokenRequest.getToken());
                    // ... (thêm thông tin người dùng khác nếu cần)
                    return ResponseEntity.ok(response);
                } else {
                    // Trả về một đối tượng JwtResponse với thông tin mặc định khi không tìm thấy người dùng
                    JwtResponse response = new JwtResponse(false);
                    response.setId(-10L);
                    response.setUsername("NULL");
                    response.setEmail("NULL");
                    response.setRole("GUEST");
                    response.setToken(tokenRequest.getToken());
                    // ... (thêm thông tin người dùng khác nếu cần)
                    return ResponseEntity.ok(response);
                }
        }

    }

}