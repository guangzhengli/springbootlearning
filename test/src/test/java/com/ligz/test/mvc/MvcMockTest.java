package com.ligz.test.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ligz.test.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

public class MvcMockTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void mockRequest() throws Exception {
        //模拟一个get请求
        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name={name}","lee"));

        //模拟一个post请求
        mockMvc.perform(MockMvcRequestBuilders.post("/user/{id}",1));

        // 模拟发送一个message参数，值为hello
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("message", "hello"));

        //模拟发送 json 参数
        String jsonStr = "{\"username\":\"Dopa\",\"password\":\"ac3af72d9f95161a502fd326865c2f15\",\"status\":\"1\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user/save").content(jsonStr.getBytes()));

        //模拟将对象转成json发送
        User user = new User();
        user.setUsername("Dopa");
        user.setPassword("ac3af72d9f95161a502fd326865c2f15");
        user.setStatus("1");
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user/save")
                .content(userJson.getBytes()));

        //模拟Session和Cookie
        String name = "name";
        String value = "value";
        mockMvc.perform(MockMvcRequestBuilders.get("/index")
                .sessionAttr(name, value));
        mockMvc.perform(MockMvcRequestBuilders.get("/index")
                .cookie(new Cookie(name, value)));

        //设置请求的Content-Type
        mockMvc.perform(MockMvcRequestBuilders.get("/index")
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        //设置返回格式为JSON
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1)
                .accept(MediaType.APPLICATION_JSON));

        //模拟HTTP请求头：
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1)
                .header(name, value));
    }

    @Test
    public void mockRequestStatus() throws Exception {
        //期望成功调用，即HTTP Status为200
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());

        //期望返回内容是application/json
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        //检查返回JSON数据中某个值的内容
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("mrbird"));

        //判断Controller方法是否返回某视图
        mockMvc.perform(MockMvcRequestBuilders.post("/index"))
                .andExpect(MockMvcResultMatchers.view().name("index.html"));


        //比较Model
        mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", 1))
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("password"))
                .andExpect(MockMvcResultMatchers.model().attribute("username", "mrbird"));
    }
}
