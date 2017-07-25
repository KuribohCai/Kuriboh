package com.studio.cai.mysuperdemo.rxjava_retrofit;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public class LowPriceFlight implements Serializable {

        /**
         * Status : 0
         * Message :
         * FlightList : [{"DepartCity":"PEK","ArriveCity":"SHA","FlightDate":"2016-12-24","FlightNo":"MU5126","Cabin":"Z","FlightPrice":350},{"DepartCity":"SHA","ArriveCity":"PEK","FlightDate":"2016-12-24","FlightNo":"MU5157","Cabin":"T","FlightPrice":330},{"DepartCity":"SHA","ArriveCity":"SZX","FlightDate":"2016-12-22","FlightNo":"MU5357","Cabin":"Z","FlightPrice":380},{"DepartCity":"CAN","ArriveCity":"PEK","FlightDate":"2016-12-07","FlightNo":"HU7810","Cabin":"N","FlightPrice":562},{"DepartCity":"SZX","ArriveCity":"PEK","FlightDate":"2017-01-01","FlightNo":"HU7702","Cabin":"N","FlightPrice":517},{"DepartCity":"SZX","ArriveCity":"SHA","FlightDate":"2016-12-13","FlightNo":"CZ3575","Cabin":"R","FlightPrice":332},{"DepartCity":"PEK","ArriveCity":"SZX","FlightDate":"2016-12-23","FlightNo":"ZH9110","Cabin":"K","FlightPrice":506},{"DepartCity":"PEK","ArriveCity":"CAN","FlightDate":"2016-12-27","FlightNo":"CZ3114","Cabin":"T","FlightPrice":562},{"DepartCity":"SHA","ArriveCity":"CAN","FlightDate":"2017-01-01","FlightNo":"HO1287","Cabin":"P","FlightPrice":400},{"DepartCity":"CAN","ArriveCity":"SHA","FlightDate":"2016-12-31","FlightNo":"FM9318","Cabin":"Z","FlightPrice":431},{"DepartCity":"PEK","ArriveCity":"HGH","FlightDate":"2016-12-05","FlightNo":"CA1708","Cabin":"K","FlightPrice":294},{"DepartCity":"CAN","ArriveCity":"HAK","FlightDate":"2016-12-18","FlightNo":"HU7124","Cabin":"T","FlightPrice":412},{"DepartCity":"NKG","ArriveCity":"CAN","FlightDate":"2016-12-06","FlightNo":"HU7114","Cabin":"T","FlightPrice":452}]
         */

        private String Status;
        private String Message;
        private List<FlightListBean> FlightList;

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String Message) {
            this.Message = Message;
        }

        public List<FlightListBean> getFlightList() {
            return FlightList;
        }

        public void setFlightList(List<FlightListBean> FlightList) {
            this.FlightList = FlightList;
        }

        public static class FlightListBean implements Serializable{
            /**
             * DepartCity : PEK
             * ArriveCity : SHA
             * FlightDate : 2016-12-24
             * FlightNo : MU5126
             *     "DepartTime":"07:30",
             "ArriveTime":"09:40",
             * Cabin : Z
             * FlightPrice : 350
             */

            private String DepartCity;
            private String ArriveCity;
            private String DepartTime;
            private String ArriveTime;
            private String FlightDate;
            private String FlightNo;
            private String Cabin;
            private int FlightPrice;

            public FlightListBean(int i) {
                FlightPrice = i;
            }

            public FlightListBean() {
            }

            public FlightListBean(String pek, String sha, String s) {
                DepartCity = pek;
                ArriveCity = sha;
                FlightDate = s;
            }

            public String getDepartTime() {
                return DepartTime;
            }

            public void setDepartTime(String departTime) {
                DepartTime = departTime;
            }

            public String getArriveTime() {
                return ArriveTime;
            }

            public void setArriveTime(String arriveTime) {
                ArriveTime = arriveTime;
            }

            public String getDepartCity() {
                return DepartCity;
            }

            public void setDepartCity(String DepartCity) {
                this.DepartCity = DepartCity;
            }

            public String getArriveCity() {
                return ArriveCity;
            }

            public void setArriveCity(String ArriveCity) {
                this.ArriveCity = ArriveCity;
            }

            public String getFlightDate() {
                return FlightDate;
            }

            public void setFlightDate(String FlightDate) {
                this.FlightDate = FlightDate;
            }

            public String getFlightNo() {
                return FlightNo;
            }

            public void setFlightNo(String FlightNo) {
                this.FlightNo = FlightNo;
            }

            public String getCabin() {
                return Cabin;
            }

            public void setCabin(String Cabin) {
                this.Cabin = Cabin;
            }

            public int getFlightPrice() {
                return FlightPrice;
            }

            public void setFlightPrice(int FlightPrice) {
                this.FlightPrice = FlightPrice;
            }
        }
}
