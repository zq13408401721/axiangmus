package com.goketech.smartcommunity.bean;

import java.util.List;

public class All_bean {

    /**
     * status : 0
     * msg : success
     * data : [{"id":26,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1,"assigned_phone":"123"},{"id":27,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1},{"id":28,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1,"assigned_phone":"18612456789"},{"id":29,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1},{"id":30,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1,"assigned_phone":"18612456789"},{"id":31,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1},{"id":32,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1},{"id":33,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1},{"id":34,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1},{"id":35,"dict_id":16,"address":"1号楼203室","remark":"下水管崩了","date":"2019-09-12","order_type":1}]
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
         * id : 26
         * dict_id : 16
         * address : 1号楼203室
         * remark : 下水管崩了
         * date : 2019-09-12
         * order_type : 1
         * assigned_phone : 123
         */

        private int id;
        private int dict_id;
        private String address;
        private String remark;
        private String date;
        private int order_type;
        private String assigned_phone;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDict_id() {
            return dict_id;
        }

        public void setDict_id(int dict_id) {
            this.dict_id = dict_id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getOrder_type() {
            return order_type;
        }

        public void setOrder_type(int order_type) {
            this.order_type = order_type;
        }

        public String getAssigned_phone() {
            return assigned_phone;
        }

        public void setAssigned_phone(String assigned_phone) {
            this.assigned_phone = assigned_phone;
        }
    }
}
