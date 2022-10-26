package com.rest.api.controller.v1;

import com.rest.api.entity.User;
import com.rest.api.repo.UserJpaRepo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SignControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserJpaRepo userJpaRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setUp() throws Exception {
        userJpaRepo.save(User.builder().uid("happydaddy@naver.com").name("happydaddy").password(passwordEncoder.encode("1234")).roles(Collections.singletonList("ROLE_USER")).build());
    }

    @Test
    public void signin() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "happydaddy@naver.com");
        params.add("password", "1234");
        mockMvc.perform(post("/v1/signin").params(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.msg").exists())
                .andExpect(jsonPath("$.data").exists());
    }

    @Test
    public void signup() throws Exception {
        long epochTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id", "happydaddy_" + epochTime + "@naver.com");
        params.add("password", "12345");
        params.add("name", "happydaddy_" + epochTime);
        mockMvc.perform(post("/v1/signup").params(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.msg").exists());
    }
}

//package com.rest.api.controller.v1;
//
//import com.rest.api.repo.UserJpaRepoTest;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////// MockMvc를 이용하여 SignController의 로그인, 가입을 테스트하는 예제
//
//@RunWith(SpringRunner.class)
////@ExtendWith(MockitoExtension.class)
////@SpringBootTest
//@AutoConfigureMockMvc
//@Transactional
//public class SignControllerTest {
//
//
//    @Autowired
////    @InjectMocks
////    @Mock
//    private MockMvc mockMvc;
//
//    @Test
//    public void signin() throws Exception {
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("id", "happydaddy@naver.com");
//        params.add("password", "1234");
//        mockMvc.perform(post("/v1/signin").params(params))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success").value(true))
//                .andExpect(jsonPath("$.code").value(0))
//                .andExpect(jsonPath("$.msg").exists())
//                .andExpect(jsonPath("$.data").exists());
//    }
//
////    @Test
////    public void signinFail() throws Exception {
////        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
////        params.add("id", "happydaddy@naver.com");
////        params.add("password", "12345");
////        mockMvc.perform(post("/v1/signin").params(params))
////                .andDo(print())
////                .andExpect(status().is5xxServerError())
////                .andExpect(jsonPath("$.success").value(false))
////                .andExpect(jsonPath("$.code").value(-1001))
////                .andExpect(jsonPath("$.msg").exists());
////    }
//
//    @Test
//    public void signup() throws Exception {
//        long epochTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("id", "happydaddy_" + epochTime + "@naver.com");
//        params.add("password", "12345");
//        params.add("name", "happydaddy_" + epochTime);
//        mockMvc.perform(post("/v1/signup").params(params))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success").value(true))
//                .andExpect(jsonPath("$.code").value(0))
//                .andExpect(jsonPath("$.msg").exists());
//    }
//
////    @Test
////    public void signupFail() throws Exception {
////        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
////        params.add("id", "happydaddy@naver.com");
////        params.add("password", "12345");
////        params.add("name", "happydaddy");
////        mockMvc.perform(post("/v1/signup").params(params))
////                .andDo(print())
////                .andExpect(status().is5xxServerError())
////                .andExpect(jsonPath("$.success").value(false))
////                .andExpect(jsonPath("$.code").value(-9999));
////    }
//}