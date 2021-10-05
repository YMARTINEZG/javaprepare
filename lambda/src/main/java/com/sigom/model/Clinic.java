package com.sigom.model;

import java.util.List;

/**
 * Created by CH172585 on 9/8/2016.
 */
public class Clinic {
    private final String name;
    private final Integer minAgeInMonths;
    private final Integer maxAgeInMonths;
    private final List<String> diseases;

    public Clinic(String name, Integer minAgeInMonths, Integer maxAgeInMonths, List<String> diseases) {
        this.name = name;
        this.minAgeInMonths = minAgeInMonths;
        this.maxAgeInMonths = maxAgeInMonths;
        this.diseases = diseases;
    }

    public String getName() {
        return name;
    }

    public Integer getMinAgeInMonths() {
        return minAgeInMonths;
    }

    public Integer getMaxAgeInMonths() {
        return maxAgeInMonths;
    }

    public List<String> getDiseases() {
        return diseases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clinic clinic = (Clinic) o;

        return name != null ? name.equals(clinic.name) : clinic.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name +
                '}';
    }
}
