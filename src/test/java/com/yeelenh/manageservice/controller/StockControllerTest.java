package com.yeelenh.manageservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/616:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring/*.xml","classpath:mybatis/*.xml"})
public class StockControllerTest {
    private MockHttpSession session;

    @Autowired
    private WebApplicationContext wac;

    //mock模拟request
    private MockHttpServletRequest request;
    private MockMvc mockMvc;
    @Autowired
    private StockController stockController;

    @org.junit.Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
        // mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void getHotProductStockAlarm() throws Exception {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/getHotProductStockAlarm.do")).andReturn();
        MockHttpServletResponse object= mvcResult.getResponse();
        System.out.println(object.getContentAsString());
    }

}