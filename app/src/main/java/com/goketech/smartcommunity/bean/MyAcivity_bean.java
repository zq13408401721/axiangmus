package com.goketech.smartcommunity.bean;

import java.util.List;

public class MyAcivity_bean {

    /**
     * status : 0
     * msg : success
     * data : [{"id":2,"resident_id":0,"title":"sss","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031200387900.png","remark":"asdfasdfasdf","content":"123123123","begin_time":"2019-09-03 00:00:00","end_time":"2019-09-19 00:00:00","apply_time":"2019-09-11 00:00:00","address":"线下","apply_num":null,"price":null,"contact":null,"contact_phone":null,"total_apply":3,"users":[{"fk_activity_id":1,"id":1,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"},{"fk_activity_id":1,"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png"},{"fk_activity_id":1,"id":3,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png"}]},{"id":1,"resident_id":0,"title":"123","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031447388696.png","remark":"12333333333333333333333333333333333333333333333333","content":"12312\nsfgdf大飞哥\n\n分隔","begin_time":"2019-09-03 00:00:00","end_time":"2019-09-28 00:00:00","apply_time":"2019-09-19 00:00:00","address":"APP","apply_num":null,"price":null,"contact":null,"contact_phone":null}]
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
         * id : 2
         * resident_id : 0
         * title : sss
         * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031200387900.png
         * remark : asdfasdfasdf
         * content : 123123123
         * begin_time : 2019-09-03 00:00:00
         * end_time : 2019-09-19 00:00:00
         * apply_time : 2019-09-11 00:00:00
         * address : 线下
         * apply_num : null
         * price : null
         * contact : null
         * contact_phone : null
         * total_apply : 3
         * users : [{"fk_activity_id":1,"id":1,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"},{"fk_activity_id":1,"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png"},{"fk_activity_id":1,"id":3,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png"}]
         */

        private int id;
        private int resident_id;
        private String title;
        private String image;
        private String remark;
        private String content;
        private String begin_time;
        private String end_time;
        private String apply_time;
        private String address;
        private Object apply_num;
        private Object price;
        private Object contact;
        private Object contact_phone;
        private int total_apply;
        private List<UsersBean> users;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getResident_id() {
            return resident_id;
        }

        public void setResident_id(int resident_id) {
            this.resident_id = resident_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getApply_time() {
            return apply_time;
        }

        public void setApply_time(String apply_time) {
            this.apply_time = apply_time;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getApply_num() {
            return apply_num;
        }

        public void setApply_num(Object apply_num) {
            this.apply_num = apply_num;
        }

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public Object getContact() {
            return contact;
        }

        public void setContact(Object contact) {
            this.contact = contact;
        }

        public Object getContact_phone() {
            return contact_phone;
        }

        public void setContact_phone(Object contact_phone) {
            this.contact_phone = contact_phone;
        }

        public int getTotal_apply() {
            return total_apply;
        }

        public void setTotal_apply(int total_apply) {
            this.total_apply = total_apply;
        }

        public List<UsersBean> getUsers() {
            return users;
        }

        public void setUsers(List<UsersBean> users) {
            this.users = users;
        }

        public static class UsersBean {
            /**
             * fk_activity_id : 1
             * id : 1
             * nick : null
             * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png
             */

            private int fk_activity_id;
            private int id;
            private Object nick;
            private String avatar;

            public int getFk_activity_id() {
                return fk_activity_id;
            }

            public void setFk_activity_id(int fk_activity_id) {
                this.fk_activity_id = fk_activity_id;
            }

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
        }
    }
}
