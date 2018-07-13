package com.yeelenh.manageservice.controller;

import com.yeelenh.manageservice.pojo.JSONResponse;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/117:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring/*.xml"})
public class ProductControllerTest {
    private MockHttpSession session;

    @Autowired
    private WebApplicationContext wac;

    //mock模拟request
    private MockHttpServletRequest request;
    private MockMvc mockMvc;
    @Autowired
    private ProductController productController;
    @Autowired
    private CustomerController customerController;
    @org.junit.Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
       // mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @org.junit.Test
    public void selectAllProduct() throws Exception {
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/selectAllProduct.do")).andReturn();
        MockHttpServletResponse object= mvcResult.getResponse();
        System.out.println(object.getContentAsString());
    }

    @org.junit.Test
    public void getProductByNameorID() throws Exception {
    }

    @org.junit.Test
    public void addProiduct() throws Exception {
    }

    @org.junit.Test
    public void updateProduct() throws Exception {
    }

    @org.junit.Test
    public void deleteProduct() throws Exception {
    }

    @org.junit.Test
    public void getOneProductById() throws Exception {
    }

    @org.junit.Test
    public void getProductByName() throws Exception {
    }



}
