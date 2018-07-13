package com.yeelenh.manageservice.utils.Impl;

import com.yeelenh.manageservice.utils.Interface.AbstractHandleImportFile;
import com.yeelenh.manageservice.utils.Interface.IFileImportFactory;
import jxl.Sheet;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/614:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring/*.xml","classpath:mybatis/*.xml"})
public class StockInfoImportTest {
    @org.junit.Test
    public void HandleImportFile() throws Exception {
        System.out.println("Im here");
        IFileImportFactory factory=new FileImportFactoryImpl();
        AbstractHandleImportFile importFile=factory.createFileImport("product");
        File file=new File("C:\\app\\Yeelenh\\cupcake goods manager system.xls");
        InputStream inputStream=new FileInputStream(file);
        List<Sheet> sheetList=importFile.preExcelHandle(inputStream);
        importFile.handleImportFile(sheetList);
    }

}