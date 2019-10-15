package com.goketech.smartcommunity.bean;

import java.util.List;

public class Acivity_Web_bean {

    /**
     * status : 0
     * msg : success
     * data : {"id":1,"fk_company_id":1,"fk_community_id":1,"resident_id":3,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png","title":"123","remark":"aa","content":"12312\nsfgdf大飞哥\n\n分隔","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031447388696.png","begin_time":"2019-09-03 00:00:00","end_time":"2019-09-28 00:00:00","apply_time":"2019-09-19 00:00:00","address":"APP","apply_num":null,"price":null,"contact":null,"contact_phone":null,"status":1,"refuse_reason":null,"enable":1,"created_at":"2019-09-03 11:59:21","total_apply":2,"users":[{"id":1,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"},{"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png"}]}
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
         * fk_company_id : 1
         * fk_community_id : 1
         * resident_id : 3
         * nick : null
         * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png
         * title : 123
         * remark : aa
         * content : 12312
         sfgdf大飞哥

         分隔
         * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031447388696.png
         * begin_time : 2019-09-03 00:00:00
         * end_time : 2019-09-28 00:00:00
         * apply_time : 2019-09-19 00:00:00
         * address : APP
         * apply_num : null
         * price : null
         * contact : null
         * contact_phone : null
         * status : 1
         * refuse_reason : null
         * enable : 1
         * created_at : 2019-09-03 11:59:21
         * total_apply : 2
         * users : [{"id":1,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png"},{"id":2,"nick":null,"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png"}]
         */

        private int id;
        private int fk_company_id;
        private int fk_community_id;
        private int resident_id;
        private Object nick;
        private String avatar;
        private String title;
        private String remark;
        private String content;
        private String image;
        private String begin_time;
        private String end_time;
        private String apply_time;
        private String address;
        private Object apply_num;
        private Object price;
        private Object contact;
        private Object contact_phone;
        private int status;
        private Object refuse_reason;
        private int enable;
        private String created_at;
        private int total_apply;
        private List<UsersBean> users;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFk_company_id() {
            return fk_company_id;
        }

        public void setFk_company_id(int fk_company_id) {
            this.fk_company_id = fk_company_id;
        }

        public int getFk_community_id() {
            return fk_community_id;
        }

        public void setFk_community_id(int fk_community_id) {
            this.fk_community_id = fk_community_id;
        }

        public int getResident_id() {
            return resident_id;
        }

        public void setResident_id(int resident_id) {
            this.resident_id = resident_id;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getRefuse_reason() {
            return refuse_reason;
        }

        public void setRefuse_reason(Object refuse_reason) {
            this.refuse_reason = refuse_reason;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
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
             * id : 1
             * nick : null
             * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png
             */

            private int id;
            private Object nick;
            private String avatar;

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
