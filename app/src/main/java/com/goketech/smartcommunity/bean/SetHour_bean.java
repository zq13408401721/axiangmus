package com.goketech.smartcommunity.bean;

import java.util.List;

public class SetHour_bean {

    /**
     * data : [{"bulid_id":1,"bulid_name":"10号楼","unit_list":[{"name":"2单元","room_list":[{"fk_bulid_id":1,"floor":"15","house_id":2,"room_number":"1502","unit":"2"},{"fk_bulid_id":1,"floor":"17","house_id":4,"room_number":"1701","unit":"2"}]}]},{"bulid_id":2,"bulid_name":"2号楼","unit_list":[{"name":"2单元","room_list":[{"fk_bulid_id":2,"floor":"1","house_id":6,"room_number":"1001","unit":"2"}]}]},{"bulid_id":3,"bulid_name":"3号楼","unit_list":[{"name":"1单元","room_list":[{"fk_bulid_id":3,"floor":"2","house_id":1,"room_number":"13","unit":"1"},{"fk_bulid_id":3,"floor":"1","house_id":5,"room_number":"1","unit":"1"}]},{"name":"3单元","room_list":[{"fk_bulid_id":3,"floor":"10","house_id":3,"room_number":"1001","unit":"3"}]}]}]
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
         * bulid_id : 1
         * bulid_name : 10号楼
         * unit_list : [{"name":"2单元","room_list":[{"fk_bulid_id":1,"floor":"15","house_id":2,"room_number":"1502","unit":"2"},{"fk_bulid_id":1,"floor":"17","house_id":4,"room_number":"1701","unit":"2"}]}]
         */

        private int bulid_id;
        private String bulid_name;
        private List<UnitListBean> unit_list;

        public int getBulid_id() {
            return bulid_id;
        }

        public void setBulid_id(int bulid_id) {
            this.bulid_id = bulid_id;
        }

        public String getBulid_name() {
            return bulid_name;
        }

        public void setBulid_name(String bulid_name) {
            this.bulid_name = bulid_name;
        }

        public List<UnitListBean> getUnit_list() {
            return unit_list;
        }

        public void setUnit_list(List<UnitListBean> unit_list) {
            this.unit_list = unit_list;
        }

        public static class UnitListBean {
            /**
             * name : 2单元
             * room_list : [{"fk_bulid_id":1,"floor":"15","house_id":2,"room_number":"1502","unit":"2"},{"fk_bulid_id":1,"floor":"17","house_id":4,"room_number":"1701","unit":"2"}]
             */

            private String name;
            private List<RoomListBean> room_list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<RoomListBean> getRoom_list() {
                return room_list;
            }

            public void setRoom_list(List<RoomListBean> room_list) {
                this.room_list = room_list;
            }

            public static class RoomListBean {
                /**
                 * fk_bulid_id : 1
                 * floor : 15
                 * house_id : 2
                 * room_number : 1502
                 * unit : 2
                 */

                private int fk_bulid_id;
                private String floor;
                private int house_id;
                private String room_number;
                private String unit;

                public int getFk_bulid_id() {
                    return fk_bulid_id;
                }

                public void setFk_bulid_id(int fk_bulid_id) {
                    this.fk_bulid_id = fk_bulid_id;
                }

                public String getFloor() {
                    return floor;
                }

                public void setFloor(String floor) {
                    this.floor = floor;
                }

                public int getHouse_id() {
                    return house_id;
                }

                public void setHouse_id(int house_id) {
                    this.house_id = house_id;
                }

                public String getRoom_number() {
                    return room_number;
                }

                public void setRoom_number(String room_number) {
                    this.room_number = room_number;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }
            }
        }
    }
}
