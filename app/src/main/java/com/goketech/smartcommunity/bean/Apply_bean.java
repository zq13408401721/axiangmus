package com.goketech.smartcommunity.bean;

import java.util.List;

public class Apply_bean {

    /**
     * data : [{"content":"111","create_at":"2019-09-02 00:00:00","id":4,"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021624583338.jpg","scope":3,"title":"app新版上线","type":1},{"content":"123 sd","id":1,"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021545324020.jpg","scope":1,"title":"星期五停水通知","type":1}]
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
         * content : 111
         * create_at : 2019-09-02 00:00:00
         * id : 4
         * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021624583338.jpg
         * scope : 3
         * title : app新版上线
         * type : 1
         */

        private String content;
        private String create_at;
        private int id;
        private String image;
        private int scope;
        private String title;
        private int type;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
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

        public int getScope() {
            return scope;
        }

        public void setScope(int scope) {
            this.scope = scope;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
