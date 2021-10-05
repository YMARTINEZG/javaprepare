package com.sigom.model;


import java.math.BigDecimal;
import java.util.List;

public class Insurance {
    private String company;
    private String type;
    private BigDecimal coverage;
    private List<Provider> providers;

    public Insurance(String company, String type, BigDecimal coverage, List<Provider> providers) {
        this.company = company;
        this.type = type;
        this.coverage = coverage;
        this.providers= providers;
    }

    public String getCompany() {
        return company;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getCoverage() {
        return coverage;
    }

    public List<Provider> getProviders() {
        return providers;
    }
}
