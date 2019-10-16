package com.goketech.smartcommunity.bean;

import java.io.Serializable;
import java.util.List;

public class Commonality_bean implements Serializable {

    /**
     * data : {"common_phone":[{"phone":"18645611234","title":"水电费"},{"phone":"13844795531","title":"sdfasd adfg sfhdh dfhsdfgsdfgs"},{"phone":"4001004444","title":"123123"}],"feedback":[{"id":14,"name":"日常反馈"},{"id":15,"name":"意见反馈"}],"repair":[{"id":11,"name":"水电"},{"id":12,"name":"燃气"},{"id":13,"name":"防汛设施"}],"repair_time":["09:00-12:00","12:00-15:00","15:00-18:00","18:00-21:00"]}
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
        private List<CommonPhoneBean> common_phone;
        private List<FeedbackBean> feedback;
        private List<RepairBean> repair;
        private List<String> repair_time;

        public List<CommonPhoneBean> getCommon_phone() {
            return common_phone;
        }

        public void setCommon_phone(List<CommonPhoneBean> common_phone) {
            this.common_phone = common_phone;
        }

        public List<FeedbackBean> getFeedback() {
            return feedback;
        }

        public void setFeedback(List<FeedbackBean> feedback) {
            this.feedback = feedback;
        }

        public List<RepairBean> getRepair() {
            return repair;
        }

        public void setRepair(List<RepairBean> repair) {
            this.repair = repair;
        }

        public List<String> getRepair_time() {
            return repair_time;
        }

        public void setRepair_time(List<String> repair_time) {
            this.repair_time = repair_time;
        }

        public static class CommonPhoneBean {
            /**
             * phone : 18645611234
             * title : 水电费
             */

            private String phone;
            private String title;

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class FeedbackBean {
            /**
             * id : 14
             * name : 日常反馈
             */

            private int id;
            private String name;

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
        }

        public static class RepairBean {
            /**
             * id : 11
             * name : 水电
             */

            private int id;
            private String name;

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
        }
    }
}
