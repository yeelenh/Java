
package com.yeelenh.manageservice.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
public class JxlReadUtil {  
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private String filePath = null;  
    private File file = null;  
    private Workbook wk = null;  
    private Map hmSheet = new HashMap();

    private JxlReadUtil(){

    }
    public static JxlReadUtil getInstance(){
        return new JxlReadUtil();
    }

    /**
     * @Description 得到sheet第一行数据，并组装成String数组
     * @param sheet 
     * @param row 
     *            start with 0 
     * @return 
     */  
    public String[] getContentsViaRow(Sheet sheet, int row) {  
    	//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Cell[] rowCells = sheet.getRow(row);  
        int len = rowCells.length;  
        String[] strCells = new String[len];  
        for (int i = 0; i < len; i++) {  
			String type = rowCells[i].getType().toString();
			String value = rowCells[i].getContents();
            strCells[i] = value;  
        }  
        return strCells;  
    }  

    /** 
     * @Description 
     * @param sheet 
     * @param col 
     *            start with 0 
     * @return 
     */  
    public String[] getContentsViaCol(Sheet sheet, int col) {  
        Cell[] cells = sheet.getColumn(col);  
        int len = cells.length;  
        String[] strCols = new String[len];  
        Cell c = null;  
        for (int i = 0; i < len; i++) {  
            c = cells[i];  
            strCols[i] = c.getContents();  
        }  
        return strCols;  
    }  

    public List<String[]> getFirstSheetRowsContents(Sheet sheet) {
        int rows = sheet.getRows();
        List<String[]> ls = new ArrayList<String[]>();  
        for(int i=0;i<rows;i++) {  
            ls.add(getContentsViaRow(sheet,i));  
        }  
        return ls;  
    }  
    
    /**
	 * @Description 从第二行将xls文件行数据组装成map数组,键：sheet表头,值：sheet单元格对应值
	 * @author 唐葵
	 * @param sheet
	 * @param fieldNames
	 * @return map[]
	 * @throws
	 */
	public Map[] assembleMap4xls(Sheet sheet, String[] fieldNames){
		
		int rows = sheet.getRows();// sheet页实际行数
		int dataRows = rows - 1;// sheet页实际数据行,除去第一行
		Map[] map = new HashMap[dataRows];
		
		for (int i = 1; i <= dataRows; i++) {
			Map temp = new HashMap();
			for (int j = 0; j < fieldNames.length; j++) {
				String type = sheet.getCell(j, i).getType().toString();
				String value = sheet.getCell(j, i).getContents();
				
				if(type.equals(CellType.DATE.toString()) || type.contains(CellType.DATE.toString())){// 日期类型转化为YYYYMMDD
					value = sdf.format(new Date(value));
				}else if(type.equals(CellType.NUMBER.toString())){// 数字型转化为#.##
					if(value.contains("%")){
						double d_value = Double.valueOf((value.split("%")[0])) / 100;
						value = String.valueOf(d_value).trim();
					}
				}
				temp.put(fieldNames[j], value);
			}
			map[i-1] = temp;
		}
		
		return map;
	}

    
    /**
     * @Description 将sheet列数据组装成String[],放入list
     * @author 唐葵
     * @param 
     * @return List(String[])
     * @throws
     */
    public List<String[]> getFirstSheetColsContents(Sheet sheet) {
        int cols = sheet.getColumns();
        List<String[]> ls = new ArrayList<String[]>();  
        for(int i=0;i<cols;i++) {  
            ls.add(getContentsViaCol(sheet,i));  
        }  
        return ls;  
    }
    public static void main( String args[]){
        System.out.println("\1");
    }
}  


