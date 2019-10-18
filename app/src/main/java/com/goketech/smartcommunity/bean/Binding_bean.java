package com.goketech.smartcommunity.bean;

import java.util.List;

public class Binding_bean {

    /**
     * data : {"bulid":"A001","community":"京西社区","community_id":1,"created_at":"2019-09-09 14:18:40","current":1,"floor":"1","house_id":6,"is_approve":1,"is_call":0,"is_owner":1,"phone":"123","principal":"gaox","room":"1001","type":1,"unit":"2","users":[]}
     * msg : success
     * status : 0
     */

    private DataBean data;
    private String msg;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * bulid : A001
         * community : 京西社区
         * community_id : 1
         * created_at : 2019-09-09 14:18:40
         * current : 1
         * floor : 1
         * house_id : 6
         * is_approve : 1
         * is_call : 0
         * is_owner : 1
         * phone : 123
         * principal : gaox
         * room : 1001
         * type : 1
         * unit : 2
         * users : []
         */

        private String bulid;
        private String community;
        private int community_id;
        private String created_at;
        private int current;
        private String floor;
        private int house_id;
        private int is_approve;
        private int is_call;
        private int is_owner;
        private String phone;
        private String principal;
        private String room;
        private int type;
        private String unit;
        private List<?> users;

        public String getBulid() {
            return bulid;
        }

        public void setBulid(String bulid) {
            this.bulid = bulid;
        }

        public String getCommunity() {
            return community;
        }

        public void setCommunity(String community) {
            this.community = community;
        }

        public int getCommunity_id() {
            return community_id;
        }

        public void setCommunity_id(int community_id) {
            this.community_id = community_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public int getHouse_id() {
            return house_id;
        }

        public void setHouse_id(int house_id) {
            this.house_id = house_id;
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

        public int getIs_owner() {
            return is_owner;
        }

        public void setIs_owner(int is_owner) {
            this.is_owner = is_owner;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPrincipal() {
            return principal;
        }

        public void setPrincipal(String principal) {
            this.principal = principal;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public List<?> getUsers() {
            return users;
        }

        public void setUsers(List<?> users) {
            this.users = users;
        }
    }
}
