package kr.co.wook.prac.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloTest {
    //junit 5에서는 접근자를 넣지 않으면 기존 접근자를 셋팅하기 됨

    @Autowired
    private Hello hello;

    private MockMvc mockMvc;
    @Test
    void helloWorld(){
//        System.out.println("test");
        System.out.println(hello.Hello());

        assertThat(hello.Hello()).isEqualTo("Hello World!");
    }

    //Control + shift + r : run
    //option + enter : 추가 method 구현
    @Test
    void mockMvc() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(hello).build();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/hello")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
    }
}