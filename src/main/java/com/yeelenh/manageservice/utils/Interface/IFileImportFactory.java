package com.yeelenh.manageservice.utils.Interface;

import org.springframework.stereotype.Component;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/516:07
 */
@Component
public interface IFileImportFactory {
    public AbstractHandleImportFile createFileImport(String key);
}
