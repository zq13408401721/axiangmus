package com.goketech.smartcommunity.bean;

import java.util.List;

public class Landing_bean {
    /**
     * status : 0
     * msg : success
     * data : {"id":1,"name":"张三","nick":"","phone":"186****4055","avatar":"","token":"$2y$10$PVqHe30UL10.Ruh5n.XSDuP76as2TD2JkTRGYV1XUx/XsVQiX0xfm","is_open":1,"sex":1,"identity":"","remark":"","is_smart":0,"is_app":0,"is_bind_wx":0,"houses":[{"company_id":1,"community_id":1,"house_id":1,"current":1,"community":"京西社区","bulid":"A001","unit":"2","floor":"15","room":"1502","is_owner":1,"is_approve":0,"principal":"gaox","phone":"123"},{"company_id":1,"current":1,"community_id":1,"house_id":1,"community":"京西社区","bulid":"A001","unit":"2","floor":"17","room":"1701","is_owner":1,"principal":"gaox","phone":"123"}]}
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
         * id : 1
         * name : 张三
         * nick :
         * phone : 186****4055
         * avatar :
         * token : $2y$10$PVqHe30UL10.Ruh5n.XSDuP76as2TD2JkTRGYV1XUx/XsVQiX0xfm
         * is_open : 1
         * sex : 1
         * identity :
         * remark :
         * is_smart : 0
         * is_app : 0
         * is_bind_wx : 0
         * houses : [{"company_id":1,"community_id":1,"house_id":1,"current":1,"community":"京西社区","bulid":"A001","unit":"2","floor":"15","room":"1502","is_owner":1,"is_approve":0,"principal":"gaox","phone":"123"},{"company_id":1,"current":1,"community_id":1,"house_id":1,"community":"京西社区","bulid":"A001","unit":"2","floor":"17","room":"1701","is_owner":1,"principal":"gaox","phone":"123"}]
         */

        private int id;
        private String name;
        private String nick;
        private String phone;
        private String avatar;
        private String token;
        private int is_open;
        private int sex;
        private String identity;
        private String remark;
        private int is_smart;
        private int is_app;
        private int is_bind_wx;
        private List<HousesBean> houses;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getIs_open() {
            return is_open;
        }

        public void setIs_open(int is_open) {
            this.is_open = is_open;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getIdentity() {
            return identity;
        }

        public void setIdentity(String identity) {
            this.identity = identity;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getIs_smart() {
            return is_smart;
        }

        public void setIs_smart(int is_smart) {
            this.is_smart = is_smart;
        }

        public int getIs_app() {
            return is_app;
        }

        public void setIs_app(int is_app) {
            this.is_app = is_app;
        }

        public int getIs_bind_wx() {
            return is_bind_wx;
        }

        public void setIs_bind_wx(int is_bind_wx) {
            this.is_bind_wx = is_bind_wx;
        }

        public List<HousesBean> getHouses() {
            return houses;
        }

        public void setHouses(List<HousesBean> houses) {
            this.houses = houses;
        }

        public static class HousesBean {
            /**
             * company_id : 1
             * community_id : 1
             * house_id : 1
             * current : 1
             * community : 京西社区
             * bulid : A001
             * unit : 2
             * floor : 15
             * room : 1502
             * is_owner : 1
             * is_approve : 0
             * principal : gaox
             * phone : 123
             */

            private int company_id;
            private int community_id;
            private int house_id;
            private int current;
            private String community;
            private String bulid;
            private String unit;
            private String floor;
            private String room;
            private int is_owner;
            private int is_approve;
            private String principal;
            private String phone;

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public int getCommunity_id() {
                return community_id;
            }

            public void setCommunity_id(int community_id) {
                this.community_id = community_id;
            }

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
        }
    }
}
