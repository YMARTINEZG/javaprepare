package com.sigom.services;

import com.sigom.model.*;

import java.math.BigDecimal;
import java.security.spec.InvalidParameterSpecException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class SeguroSocialPeru implements TreatmentPlanService{

    // Do not modify the lists below.
    private List<Disease> diseases = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    private List<Clinic> clinics = new ArrayList<>();

    // TODO Optionally Implement any additional data structures here....

    public static final LocalDate TODAYSDATE = LocalDate.of(2016,9,1); // just for follow java doc , it should be LocalDate.now()
    public static final double HUNDRED_PERCENT = 100.00;
    public static final float FULL_PERCENT = 100.0f;
    public static final float LIKELY_PERCENT = 70.0f;
    public static final int TOTAL_MONTHS_YEAR = 12;

    // TODO .... to here.


    @Override
    public void init(List<Disease> diseases, List<Clinic> clinics, List<Medication> medications) {
        this.diseases = diseases;
        this.clinics = clinics;
        this.medications = medications;

        // TODO Optionally implement any additional init items below here ....

        // TODO ... to here.
    }

    @Override
    public Integer ageInYears(Patient patient) {
        return Math.round(ChronoUnit.YEARS.between(patient.getDateOfBirth(),TODAYSDATE));
    }

    @Override
    public Integer ageInMonths(Patient patient) {
        return Math.round(ChronoUnit.MONTHS.between(patient.getDateOfBirth(), TODAYSDATE));
    }

    @Override
    public List<Clinic> clinicsBasedOnAgeAndDiseases(Patient patient) {
        List<Clinic> myClinic = new ArrayList<>();
        Optional<Disease> myDisease = diseases.stream().filter(dis -> {
            Collection<String> similar = new HashSet<>( dis.getSymptoms() );
            similar.retainAll(patient.getSymptoms());
            return (similar.size() * 100.0 / dis.getSymptoms().size())  >= LIKELY_PERCENT;
        }).findFirst();
        if (myDisease.isPresent()){
            Disease localDisease = myDisease.get();
            for(Clinic cli: clinics) {
                if ( (cli.getMaxAgeInMonths() != null &&
                        cli.getMinAgeInMonths() <= ageInMonths(patient)
                        && cli.getMaxAgeInMonths() >= ageInMonths(patient)) || (
                        cli.getMaxAgeInMonths() == null &&  cli.getMinAgeInMonths() <= ageInMonths(patient))
                ) {
                    if (cli.getDiseases().contains(localDisease.getName())) {
                        myClinic.add(cli);
                    }
               }
            }
        }
        return myClinic;
    }

    @Override
    public Map<Disease, BigDecimal> diseaseLikelihoods(Patient patient) {
        return null;
    }

    @Override
    public Map<Medication, BigDecimal> medicationsForDisease(Patient patient, Disease disease) {
        return null;
    }

    @Override
    public TreatmentPlan treatmentPlanForPatient(Patient patient) {
        return null;
    }
}
