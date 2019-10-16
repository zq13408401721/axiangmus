package com.goketech.smartcommunity.bean;

import java.util.List;

public class Announcement_bean {

    /**
     * data : [{"address":"6号楼1单元6楼601室","community_id":1,"end_at":"2019-12-31","house_id":2,"id":1,"late_price":0,"months":[{"amount":80,"title":"2月份物业费账单"},{"amount":80,"title":"3月份物业费账单"},{"amount":80,"title":"4月份物业费账单"},{"amount":80,"title":"5月份物业费账单"},{"amount":80,"title":"6月份物业费账单"},{"amount":80,"title":"7月份物业费账单"},{"amount":80,"title":"8月份物业费账单"},{"amount":80,"title":"9月份物业费账单"},{"amount":80,"title":"10月份物业费账单"},{"amount":80,"title":"11月份物业费账单"},{"amount":80,"title":"12月份物业费账单"}],"order_num":"201909261333565681","pay_count":240,"pay_way":0,"payment_way":0,"start_at":"2019-02-26","status":0,"title":"2019年物业费账单"}]
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
         * address : 6号楼1单元6楼601室
         * community_id : 1
         * end_at : 2019-12-31
         * house_id : 2
         * id : 1
         * late_price : 0
         * months : [{"amount":80,"title":"2月份物业费账单"},{"amount":80,"title":"3月份物业费账单"},{"amount":80,"title":"4月份物业费账单"},{"amount":80,"title":"5月份物业费账单"},{"amount":80,"title":"6月份物业费账单"},{"amount":80,"title":"7月份物业费账单"},{"amount":80,"title":"8月份物业费账单"},{"amount":80,"title":"9月份物业费账单"},{"amount":80,"title":"10月份物业费账单"},{"amount":80,"title":"11月份物业费账单"},{"amount":80,"title":"12月份物业费账单"}]
         * order_num : 201909261333565681
         * pay_count : 240
         * pay_way : 0
         * payment_way : 0
         * start_at : 2019-02-26
         * status : 0
         * title : 2019年物业费账单
         */

        private String address;
        private int community_id;
        private String end_at;
        private int house_id;
        private int id;
        private int late_price;
        private String order_num;
        private int pay_count;
        private int pay_way;
        private int payment_way;
        private String start_at;
        private int status;
        private String title;
        private List<MonthsBean> months;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCommunity_id() {
            return community_id;
        }

        public void setCommunity_id(int community_id) {
            this.community_id = community_id;
        }

        public String getEnd_at() {
            return end_at;
        }

        public void setEnd_at(String end_at) {
            this.end_at = end_at;
        }

        public int getHouse_id() {
            return house_id;
        }

        public void setHouse_id(int house_id) {
            this.house_id = house_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLate_price() {
            return late_price;
        }

        public void setLate_price(int late_price) {
            this.late_price = late_price;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public int getPay_count() {
            return pay_count;
        }

        public void setPay_count(int pay_count) {
            this.pay_count = pay_count;
        }

        public int getPay_way() {
            return pay_way;
        }

        public void setPay_way(int pay_way) {
            this.pay_way = pay_way;
        }

        public int getPayment_way() {
            return payment_way;
        }

        public void setPayment_way(int payment_way) {
            this.payment_way = payment_way;
        }

        public String getStart_at() {
            return start_at;
        }

        public void setStart_at(String start_at) {
            this.start_at = start_at;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<MonthsBean> getMonths() {
            return months;
        }

        public void setMonths(List<MonthsBean> months) {
            this.months = months;
        }

        public static class MonthsBean {
            /**
             * amount : 80
             * title : 2月份物业费账单
             */

            private int amount;
            private String title;

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
