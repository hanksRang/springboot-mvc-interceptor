package com.hanksrang.springboot.mvcinterceptor.controller;

import com.alibaba.fastjson.JSON;
import com.hanksrang.springboot.mvcinterceptor.pojo.QueryParams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void testGetStu() throws Exception {
        QueryParams queryParams = new QueryParams();
        queryParams.setAge(120);
        queryParams.setGender("男2133");
        queryParams.setName("小王1231313");
        // queryParams.setCreditCardNumber("21312313312321321");
        String reqJson = JSON.toJSONString(queryParams);
        MvcResult result = mockMvc.perform(post("/my/query")
                .contentType(MediaType.APPLICATION_JSON)
                .content(reqJson)
                .accept(MediaType.APPLICATION_JSON))
                // .andExpect(status().isOk()) // 模拟发送get请求
                .andReturn();
        System.out.println("返回值：" + result.getResponse().getContentAsString());
    }

}
