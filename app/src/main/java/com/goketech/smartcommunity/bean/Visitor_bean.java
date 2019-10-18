package com.goketech.smartcommunity.bean;

public class Visitor_bean {

    /**
     * status : 0
     * msg : success
     * data : {"code_str":"ZbgD4vQLntiZ0xLqizJJEfMdEwcBpO-xehydtS6ZoWPQTtNKvFSGQ11BAVrKAdbK6MzSq8RPMnc="}
     */

    private int status;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code_str : ZbgD4vQLntiZ0xLqizJJEfMdEwcBpO-xehydtS6ZoWPQTtNKvFSGQ11BAVrKAdbK6MzSq8RPMnc=
         */

        private String code_str;

        public String getCode_str() {
            return code_str;
        }

        public void setCode_str(String code_str) {
            this.code_str = code_str;
        }
    }
}
