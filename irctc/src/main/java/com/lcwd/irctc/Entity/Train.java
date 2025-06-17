package com.lcwd.irctc.Entity;

public class Train {

    private String tainNo;

    private String name;

//
//    @Email(message = "Invalid email")
//    private  String email;

    private int coches;


    public Train(String tainNo, String name, int coches) {
        this.tainNo = tainNo;
        this.name = name;
        this.coches = coches;
    }

    public Train() {
    }

    public String getTainNo() {
        return tainNo;
    }

    public void setTainNo(String tainNo) {
        this.tainNo = tainNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoches() {
        return coches;
    }

    public void setCoches(int coches) {
        this.coches = coches;
    }
}
