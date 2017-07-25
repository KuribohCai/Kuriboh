package com.studio.cai.mysuperdemo.rxjava_retrofit;

import java.io.Serializable;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public class LowPriceFlightListInfo implements Serializable {

    /**
     * LoginInfo : {"Sign":"6de7b5dbb2c293f9d3962726983134d6","UserName":"tester001","Source":"商旅APP"}
     * BusinessInfo : {"Version":"4.3.1","DepartCity":"SHA","ArriveCity":"PEK","FlightDate":"2016-11-14"}
     */

    private LoginInfoBean LoginInfo;
    private BusinessInfoBean BusinessInfo;

    public LoginInfoBean getLoginInfo() {
        return LoginInfo;
    }

    public void setLoginInfo(LoginInfoBean LoginInfo) {
        this.LoginInfo = LoginInfo;
    }

    public BusinessInfoBean getBusinessInfo() {
        return BusinessInfo;
    }

    public void setBusinessInfo(BusinessInfoBean BusinessInfo) {
        this.BusinessInfo = BusinessInfo;
    }

    public static class LoginInfoBean implements Serializable{
        /**
         * Sign : 6de7b5dbb2c293f9d3962726983134d6
         * UserName : tester001
         * Source : 商旅APP
         */

        private String Sign;
        private String UserName;
        private String Source;

        public LoginInfoBean(String sign, String userName, String source) {
            Sign = sign;
            UserName = userName;
            Source = source;
        }

        public String getSign() {
            return Sign;
        }

        public void setSign(String Sign) {
            this.Sign = Sign;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getSource() {
            return Source;
        }

        public void setSource(String Source) {
            this.Source = Source;
        }
    }

    public static class BusinessInfoBean implements Serializable{
        /**
         * Version : 4.3.1
         * DepartCity : SHA
         * ArriveCity : PEK
         * FlightDate : 2016-11-14
         */

        private String Version;
        private String DepartCity;
        private String ArriveCity;
        private String FlightDate;

        public BusinessInfoBean(String version, String departCity, String arriveCity, String flightDate) {
            Version = version;
            DepartCity = departCity;
            ArriveCity = arriveCity;
            FlightDate = flightDate;
        }

        public BusinessInfoBean(String version) {
            Version = version;
        }

        public String getVersion() {
            return Version;
        }

        public void setVersion(String Version) {
            this.Version = Version;
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
    }
}