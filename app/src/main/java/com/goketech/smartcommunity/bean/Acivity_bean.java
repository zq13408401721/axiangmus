package com.goketech.smartcommunity.bean;

import java.util.List;

public class Acivity_bean {

    /**
     * data : [{"address":"线下","apply_time":"2019-09-11 00:00:00","begin_time":"2019-09-03 00:00:00","content":"123123123","end_time":"2019-09-19 00:00:00","id":2,"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031200387900.png","remark":"asdfasdfasdf","resident_id":0,"title":"sss","total_apply":3,"users":[{"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png","fk_activity_id":1,"id":1},{"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png","fk_activity_id":1,"id":2},{"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png","fk_activity_id":1,"id":3}]},{"address":"APP","apply_time":"2019-09-19 00:00:00","begin_time":"2019-09-03 00:00:00","content":"12312 sfgdf大飞哥  分隔","end_time":"2019-09-28 00:00:00","id":1,"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031447388696.png","remark":"12333333333333333333333333333333333333333333333333","resident_id":0,"title":"123"}]
     * msg : success
     * status : 0
     */

    private String msg;
    private int status;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * address : 线下
         * apply_time : 2019-09-11 00:00:00
         * begin_time : 2019-09-03 00:00:00
         * content : 123123123
         * end_time : 2019-09-19 00:00:00
         * id : 2
         * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031200387900.png
         * remark : asdfasdfasdf
         * resident_id : 0
         * title : sss
         * total_apply : 3
         * users : [{"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png","fk_activity_id":1,"id":1},{"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444358260.png","fk_activity_id":1,"id":2},{"avatar":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444598215.png","fk_activity_id":1,"id":3}]
         */

        private String address;
        private String apply_time;
        private String begin_time;
        private String content;
        private String end_time;
        private int id;
        private String image;
        private String remark;
        private int resident_id;
        private String title;
        private int total_apply;
        private List<UsersBean> users;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getApply_time() {
            return apply_time;
        }

        public void setApply_time(String apply_time) {
            this.apply_time = apply_time;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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
             * avatar : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909041444024792.png
             * fk_activity_id : 1
             * id : 1
             */

            private String avatar;
            private int fk_activity_id;
            private int id;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

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
        }
    }
}
