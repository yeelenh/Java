package com.yeelenh.manageservice.utils.Interface;

import jxl.Sheet;
import jxl.Workbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/3/516:14
 */
@Component
public abstract class AbstractHandleImportFile {

    protected Map<String,String> xlsData;
    public List<Sheet> preExcelHandle(InputStream inputStream){
        List<Sheet> sheetList=new ArrayList<Sheet>();
        try {
            Workbook book = Workbook.getWorkbook(inputStream);
            int num=book.getNumberOfSheets();
            for(int i=0;i<num;i++){
                Sheet sheet=book.getSheet(i);
                sheetList.add(sheet);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sheetList;
    }
    public abstract String handleImportFile(List<Sheet> sheets);
}
