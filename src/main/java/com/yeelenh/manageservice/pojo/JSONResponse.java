package com.yeelenh.manageservice.pojo;


import java.io.Serializable;

/**
 * @author Yeelenh
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/2/2817:52
 */
public class JSONResponse  implements Serializable {
    @Override
    public String toString() {
        return "JSONResponse{" +
                "desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    private String desc;
    private String status;
    private Object data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JSONResponse success(Object data){
        JSONResponse jsonResponse=new JSONResponse();
        jsonResponse.setStatus("0");
        jsonResponse.setData(data);

        return jsonResponse;
    }
    public static JSONResponse error(String desc){
        JSONResponse jsonResponse=new JSONResponse();
        jsonResponse.setStatus("1");
        jsonResponse.setDesc(desc);
        return jsonResponse;
    }
}
