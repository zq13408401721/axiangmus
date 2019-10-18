package com.goketech.smartcommunity.bean;

import java.util.List;

public class Home_bean {
    /**
     * status : 0
     * msg : success
     * data : {"weather":"27.9","banner":[{"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021114121007.png","url":"http://www.baidu.com","type":"1"},{"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021114544608.gif","url":"http://www.baidu.com","type":"1"}],"notice_list":[{"id":2,"type":"3","scope":"1","title":"星期五停水通知"}],"activity":[{"id":2,"title":"享受新时代","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031242397699.png","remark":"请大家踊跃参加，晒出您的拿手菜！","begin_time":"2019-09-03 00:00:00","end_time":"2019-10-06 00:00:00","apply_time":"2019-09-13 00:00:00"},{"id":1,"title":"智能家居体验馆一日游","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031241364768.png","remark":"请大家踊跃参加，体验智能生活！","begin_time":"2019-09-03 00:00:00","end_time":"2019-09-12 00:00:00","apply_time":"2019-09-12 00:00:00"}]}
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
         * weather : 27.9
         * banner : [{"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021114121007.png","url":"http://www.baidu.com","type":"1"},{"image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021114544608.gif","url":"http://www.baidu.com","type":"1"}]
         * notice_list : [{"id":2,"type":"3","scope":"1","title":"星期五停水通知"}]
         * activity : [{"id":2,"title":"享受新时代","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031242397699.png","remark":"请大家踊跃参加，晒出您的拿手菜！","begin_time":"2019-09-03 00:00:00","end_time":"2019-10-06 00:00:00","apply_time":"2019-09-13 00:00:00"},{"id":1,"title":"智能家居体验馆一日游","image":"http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031241364768.png","remark":"请大家踊跃参加，体验智能生活！","begin_time":"2019-09-03 00:00:00","end_time":"2019-09-12 00:00:00","apply_time":"2019-09-12 00:00:00"}]
         */

        private String weather;
        private List<BannerBean> banner;
        private List<NoticeListBean> notice_list;
        private List<ActivityBean> activity;

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<NoticeListBean> getNotice_list() {
            return notice_list;
        }

        public void setNotice_list(List<NoticeListBean> notice_list) {
            this.notice_list = notice_list;
        }

        public List<ActivityBean> getActivity() {
            return activity;
        }

        public void setActivity(List<ActivityBean> activity) {
            this.activity = activity;
        }

        public static class BannerBean {
            /**
             * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909021114121007.png
             * url : http://www.baidu.com
             * type : 1
             */

            private String image;
            private String url;
            private String type;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class NoticeListBean {
            /**
             * id : 2
             * type : 3
             * scope : 1
             * title : 星期五停水通知
             */

            private int id;
            private String type;
            private String scope;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getScope() {
                return scope;
            }

            public void setScope(String scope) {
                this.scope = scope;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class ActivityBean {
            /**
             * id : 2
             * title : 享受新时代
             * image : http://smart-community-goke.oss-cn-beijing.aliyuncs.com/201909031242397699.png
             * remark : 请大家踊跃参加，晒出您的拿手菜！
             * begin_time : 2019-09-03 00:00:00
             * end_time : 2019-10-06 00:00:00
             * apply_time : 2019-09-13 00:00:00
             */

            private int id;
            private String title;
            private String image;
            private String remark;
            private String begin_time;
            private String end_time;
            private String apply_time;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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
        }
    }

}
