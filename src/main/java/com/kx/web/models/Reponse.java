package com.kx.web.models;

/**
 * Created by  KX-iMac on 12/01/2016.
 */
public class Reponse {

    private int status;
    private Object data;


    public Reponse(int status,Object data ) {
        this.data = data;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void incrStatusBy(int increment){
        status +=increment;
    }
}
