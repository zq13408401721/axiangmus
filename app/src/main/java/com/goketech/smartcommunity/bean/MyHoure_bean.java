package com.goketech.smartcommunity.bean;

import java.util.List;

public class MyHoure_bean {


    /**
     * status : 0
     * msg : success
     * data : [{"house_id":6,"current":1,"gateway":"","community_id":1,"community":"京西社区","bulid":"A001","unit":"2","floor":"1","room":"1001","is_owner":1,"is_approve":1,"type":1,"is_call":0,"created_at":"2019-09-09 14:18:40","principal":"gaox","phone":"123","users":[{"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png","phone":"186****4051","house_id":6,"type":1,"is_owner":0,"is_approve":0,"is_call":0,"created_at":"2019-09-09 14:18:40"},{"id":3,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png","phone":"186****4051","house_id":6}]},{"house_id":3,"current":1,"community_id":1,"community":"京西社区","bulid":"A001","unit":"3","floor":"10","room":"1001","is_owner":0,"is_approve":0,"principal":"gaox","phone":"123","users":[]},{"house_id":4,"current":1,"community_id":1,"community":"京西社区","bulid":"A001","unit":"2","floor":"17","room":"1701","is_owner":0,"is_approve":0,"principal":"gaox","phone":"123","users":[]}]
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
         * house_id : 6
         * current : 1
         * gateway :
         * community_id : 1
         * community : 京西社区
         * bulid : A001
         * unit : 2
         * floor : 1
         * room : 1001
         * is_owner : 1
         * is_approve : 1
         * type : 1
         * is_call : 0
         * created_at : 2019-09-09 14:18:40
         * principal : gaox
         * phone : 123
         * users : [{"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png","phone":"186****4051","house_id":6,"type":1,"is_owner":0,"is_approve":0,"is_call":0,"created_at":"2019-09-09 14:18:40"},{"id":3,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png","phone":"186****4051","house_id":6}]
         */

        private int house_id;
        private int current;
        private String gateway;
        private int community_id;
        private String community;
        private String bulid;
        private String unit;
        private String floor;
        private String room;
        private int is_owner;
        private int is_approve;
        private int type;
        private int is_call;
        private String created_at;
        private String principal;
        private String phone;
        private List<UsersBean> users;

        public int getHouse_id() {
            return house_id;
        }

        public void setHouse_id(int house_id) {
            this.house_id = house_id;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public String getGateway() {
            return gateway;
        }

        public void setGateway(String gateway) {
            this.gateway = gateway;
        }

        public int getCommunity_id() {
            return community_id;
        }

        public void setCommunity_id(int community_id) {
            this.community_id = community_id;
        }

        public String getCommunity() {
            return community;
        }

        public void setCommunity(String community) {
            this.community = community;
        }

        public String getBulid() {
            return bulid;
        }

        public void setBulid(String bulid) {
            this.bulid = bulid;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getPrincipal() {
            return principal;
        }

        public void setPrincipal(String principal) {
            this.principal = principal;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<UsersBean> getUsers() {
            return users;
        }

        public void setUsers(List<UsersBean> users) {
            this.users = users;
        }

        public static class UsersBean {
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
}
