/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omsalung.api;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author anonymous
 */
public class JsonResponse implements Serializable{

    @JsonProperty("status_code")
    private int statusCode;
    private Object data;
    @JsonProperty("response_time")
    private long responseTime;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

}
