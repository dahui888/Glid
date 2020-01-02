package com.bw.ph.bean;

import java.io.Serializable;
import java.util.List;

public class QueryShops implements Serializable {
    private List<QueryShopsResult> result;
    private String message;
    private String status;

    public List<QueryShopsResult> getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
