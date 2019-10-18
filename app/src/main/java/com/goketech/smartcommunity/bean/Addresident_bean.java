package com.goketech.smartcommunity.bean;

public class Addresident_bean {

    /**
     * status : 0
     * msg : success
     * data : {"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png","phone":"186****4051","house_id":6,"type":1,"is_owner":0,"is_approve":0,"is_call":0,"created_at":"2019-09-09 14:18:40"}
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
         * id : 2
         * nick : null
         * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png
         * phone : 186****4051
         * house_id : 6
         * type : 1
         * is_owner : 0
         * is_approve : 0
         * is_call : 0
         * created_at : 2019-09-09 14:18:40
         */

        private int id;
        private Object nick;
        private String avatar;
        private String phone;
        private int house_id;
        private int type;
        private int is_owner;
        private int is_approve;
        private int is_call;
        private String created_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getNick() {
            return nick;
        }

        public void setNick(Object nick) {
            this.nick = nick;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getHouse_id() {
            return house_id;
        }

        public void setHouse_id(int house_id) {
            this.house_id = house_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIs_owner() {
            return is_owner;
        }

        public void setIs_owner(int is_owner) {
            this.is_owner = is_owner;
        }

        public int getIs_approve() {
            return is_approve;
        }

        public void setIs_approve(int is_approve) {
            this.is_approve = is_approve;
        }

        public int getIs_call() {
            return is_call;
        }

        public void setIs_call(int is_call) {
            this.is_call = is_call;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }
    }
}
