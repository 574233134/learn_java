package com.lmk.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private Long userId;
    private String orderNumber;
    private Date created;
    private Date updated;
    private User user;
    private List<OrderDetail> detailList;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getDetailList() {
        return detailList;
    }
}
