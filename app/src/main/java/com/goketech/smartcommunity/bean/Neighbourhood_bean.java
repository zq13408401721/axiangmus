package com.goketech.smartcommunity.bean;

import java.util.List;

public class Neighbourhood_bean {


    /**
     * status : 0
     * msg : success
     * data : [{"id":3,"username":"19930728416","nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png","address":"10号楼2单元","is_friend":0},{"id":2,"username":"19930728416","nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png","address":"3号楼3单元","is_friend":0}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 3
         * username : 19930728416
         * nick : null
         * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png
         * address : 10号楼2单元
         * is_friend : 0
         */

        private int id;
        private String username;
        private Object nick;
        private String avatar;
        private String address;
        private int is_friend;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIs_friend() {
            return is_friend;
        }

        public void setIs_friend(int is_friend) {
            this.is_friend = is_friend;
        }
    }
}
