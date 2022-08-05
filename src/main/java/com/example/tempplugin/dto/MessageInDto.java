package com.example.tempplugin.dto;

import java.util.List;

/**
 * 用于获取网络传入的值
 * <p>
 * {
 * "status": 1,
 * "msg": "毒汤数据获取成功！",
 * "data": [
 * {
 * "id": 122,
 * "content": "别人都说我烂泥扶不上墙，可是我为什么要上墙，躺地上不舒服吗？"
 * }
 * ],
 * "timestamp": 1659591890131
 * }
 *
 * @author Mr.YinHaijun
 */
public class MessageInDto {
    private int status;
    private String msg;
    private long timestamp;
    private List<DataInDto> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataInDto> getData() {
        return data;
    }

    public void setData(List<DataInDto> data) {
        this.data = data;
    }
}
