package com.JavaWebMall.Bean;

public class ProductSelectCondition {
    private String prodNameCon;

    private Integer typeIdCon;

    private Integer lowPriceCon;

    private Integer highPriceCon;

    public String getProdNameCon() {
        return prodNameCon;
    }

    public void setProdNameCon(String prodNameCon) {
        this.prodNameCon = prodNameCon;
    }

    public Integer getTypeIdCon() {
        return typeIdCon;
    }

    public void setTypeIdCon(Integer typeIdCon) {
        this.typeIdCon = typeIdCon;
    }

    public Integer getLowPriceCon() {
        return lowPriceCon;
    }

    public void setLowPriceCon(Integer lowPriceCon) {
        this.lowPriceCon = lowPriceCon;
    }

    public Integer getHighPriceCon() {
        return highPriceCon;
    }

    public void setHighPriceCon(Integer highPriceCon) {
        this.highPriceCon = highPriceCon;
    }

    @Override
    public String toString() {
        return "ProductSelectCondition{" +
                "prodNameCon='" + prodNameCon + '\'' +
                ", typeIdCon=" + typeIdCon +
                ", lowPriceCon=" + lowPriceCon +
                ", highPriceCon=" + highPriceCon +
                '}';
    }
}
