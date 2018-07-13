package com.yeelenh.manageservice.utils.Interface;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/614:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring/*.xml","classpath:mybatis/*.xml"})
public class AbstractHandleImportFileTest {
    @Test
    public void preExcelHandle() throws Exception {

    }

    @Test
    public void handleImportFile() throws Exception {
    }



}
