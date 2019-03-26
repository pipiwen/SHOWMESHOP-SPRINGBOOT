package com.syw.showmeshopsyw.entity;

import java.util.List;

public class Bill {
    private List<List<Order>> billList;
    private List<UserInfo> userInfoList;

    public List<List<Order>> getBillList() {
        return billList;
    }

    public void setBillList(List<List<Order>> billList) {
        this.billList = billList;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
