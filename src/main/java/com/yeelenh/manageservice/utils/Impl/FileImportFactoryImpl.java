package com.yeelenh.manageservice.utils.Impl;

import com.yeelenh.manageservice.utils.Interface.IFileImportFactory;
import com.yeelenh.manageservice.utils.Interface.AbstractHandleImportFile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/516:16
 */
public class FileImportFactoryImpl implements IFileImportFactory{
    @Resource
    AbstractHandleImportFile iHandleImportFile;
    public AbstractHandleImportFile createFileImport(String key){
        if(key.equals("product")){
            iHandleImportFile=new StockInfoImport();
        }
        return iHandleImportFile;
    }
}
