package com.goketech.smartcommunity.bean;

import java.util.List;

public class My_bean {

    /**
     * status : 0
     * msg : success
     * data : {"house_list":[{"house_id":2,"current":1,"community_id":1,"community":"京西社区","bulid":"10","unit":"2","floor":"15","room":"1502","is_owner":1,"is_approve":1,"type":1,"is_call":1,"created_at":"2019-09-25 14:03:27","principal":"","phone":"123456789","users":[{"id":1,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"}]}],"activity_list":[{"id":1,"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909191048322846.jpg","title":"123","address":"12323","end_time":"2019-09-28 00:00:00","total_apply":1,"users":[{"id":1,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"}]}]}
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
        private List<HouseListBean> house_list;
        private List<ActivityListBean> activity_list;

        public List<HouseListBean> getHouse_list() {
            return house_list;
        }

        public void setHouse_list(List<HouseListBean> house_list) {
            this.house_list = house_list;
        }

        public List<ActivityListBean> getActivity_list() {
            return activity_list;
        }

        public void setActivity_list(List<ActivityListBean> activity_list) {
            this.activity_list = activity_list;
        }

        public static class HouseListBean {
            /**
             * house_id : 2
             * current : 1
             * community_id : 1
             * community : 京西社区
             * bulid : 10
             * unit : 2
             * floor : 15
             * room : 1502
             * is_owner : 1
             * is_approve : 1
             * type : 1
             * is_call : 1
             * created_at : 2019-09-25 14:03:27
             * principal :
             * phone : 123456789
             * users : [{"id":1,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"}]
             */

            private int house_id;
            private int current;
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
                 * id : 1
                 * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png
                 */

                private int id;
                private String avatar;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }

        public static class ActivityListBean {
            /**
             * id : 1
             * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909191048322846.jpg
             * title : 123
             * address : 12323
             * end_time : 2019-09-28 00:00:00
             * total_apply : 1
             * users : [{"id":1,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"}]
             */

            private int id;
            private String image;
            private String title;
            private String address;
            private String end_time;
            private int total_apply;
            private List<UsersBeanX> users;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getTotal_apply() {
                return total_apply;
            }

            public void setTotal_apply(int total_apply) {
                this.total_apply = total_apply;
            }

            public List<UsersBeanX> getUsers() {
                return users;
            }

            public void setUsers(List<UsersBeanX> users) {
                this.users = users;
            }

            public static class UsersBeanX {
                /**
                 * id : 1
                 * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png
                 */

                private int id;
                private String avatar;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }
            }
        }
    }
}
