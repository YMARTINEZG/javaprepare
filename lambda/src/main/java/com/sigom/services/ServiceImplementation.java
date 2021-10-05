package com.sigom.services;

import com.sigom.model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class ServiceImplementation implements TreatmentPlanService{

    private List<Disease> diseases = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    private List<Clinic> clinics = new ArrayList<>();
    public static final LocalDate TODAYSDATE = LocalDate.of(2016,9,1);


    public double calculatePercentage(int obtained, int total) {
        return Double.valueOf(obtained) * 100 / Double.valueOf(total);
    }

    public BigDecimal getPercentOfLikeHood(List<String> diseases, List<String> symptoms ){
        int count = 0;
        for(String i: diseases) {
            if (Collections.binarySearch(symptoms, i) >= 0) {
                count++;
            }
        }
        double val = (count * 100.0 / diseases.size())/100.0;
        return round(val, 2);
    }
    public static BigDecimal round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd;
    }
    private static BigDecimal totalCost(Map<Medication, BigDecimal> map){
        return map.values().stream().reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
    }
    @Override
    public void init(List<Disease> diseases, List<Clinic> clinics, List<Medication> medications) {
        this.diseases = diseases;
        this.clinics=clinics;
        this.medications=medications;
    }

    @Override
    public Integer ageInYears(Patient patient) {
        Long years = ChronoUnit.YEARS.between(patient.getDateOfBirth(), TODAYSDATE);
        Long months = ChronoUnit.MONTHS.between(patient.getDateOfBirth(), TODAYSDATE);
        Long ageInMonth = months%years;
        Integer ageInYear = years.intValue();
        return (ageInMonth <= 6) ? ageInYear : ageInYear + 1;
    }

    @Override
    public Integer ageInMonths(Patient patient) {
        Long months = ChronoUnit.MONTHS.between(patient.getDateOfBirth(), TODAYSDATE);
        return months.intValue();
    }

    @Override
    public List<Clinic> clinicsBasedOnAgeAndDiseases(Patient patient) {
        Integer patientAge = ageInMonths(patient);

        Map<Disease, BigDecimal> ps = diseaseLikelihoods(patient);

        List<Clinic> result = clinics.stream()
                .filter(clinic -> (patientAge >= clinic.getMinAgeInMonths() && clinic.getMaxAgeInMonths() == null) ||
                                  (patientAge >= clinic.getMinAgeInMonths() && (clinic.getMaxAgeInMonths() !=null && patientAge <= clinic.getMaxAgeInMonths() ) ) )
                .filter(clinic -> {
                     for(Disease s : ps.keySet()){
                         if(clinic.getDiseases().contains(s.getName()) ){
                             return true;
                         }
                     }
                     return false;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public Map<Disease, BigDecimal> diseaseLikelihoods(Patient patient) {
        BigDecimal seventhy = BigDecimal.valueOf(0.70);
        List<String> patientSymptoms = new ArrayList<>(patient.getSymptoms());
        Collections.sort(patientSymptoms);
        return diseases.stream()
                .collect(Collectors.toMap( d->d, d-> getPercentOfLikeHood(d.getSymptoms(), patientSymptoms)) )
                .entrySet()
                .stream()
                .filter(map -> map.getValue().compareTo(seventhy) == 1)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
    }

    @Override
    public Map<Medication, BigDecimal> medicationsForDisease(Patient patient, Disease disease) {
            Map<Medication, BigDecimal> available = new HashMap<>();
            BigDecimal weight = patient.getWeight();
            List<String> medicationAllergies = patient.medicationAllergies();
            boolean isAllergic = false;
            for(Map<String, BigDecimal> m: disease.getMedicationCombinations()){
                Map<Medication, BigDecimal> temporal = new HashMap<>();
                isAllergic = false;
                for(Map.Entry<String, BigDecimal> entry : m.entrySet()){

                    if (medicationAllergies.contains(entry.getKey())){
                        isAllergic = true;
                    }
                    Optional<Medication> medication = medications.stream()
                                     .filter(item -> item.getName().equals(entry.getKey()))
                                     .findAny();

                    if (medication.isPresent()){
                        temporal.put(medication.get(), weight.multiply(entry.getValue()));
                    }
                }
                if (!isAllergic){
                    if(totalCost(available).equals(BigDecimal.ZERO) || totalCost(available).compareTo(totalCost(temporal)) == 1){
                      available = temporal;
                    }
                }
            }

        return available;
    }

    @Override
    public TreatmentPlan treatmentPlanForPatient(Patient patient) {
        return null;
    }
}
