package com.bw.ph.bean;

import java.io.Serializable;

public class QueryShopsResult implements Serializable {
    private int commodityId;
    private String commodityName;
    private String masterPic;
    private Double price;
    private int saleNum;

    public int getCommodityId() {
        return commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public Double getPrice() {
        return price;
    }

    public int getSaleNum() {
        return saleNum;
    }
}
