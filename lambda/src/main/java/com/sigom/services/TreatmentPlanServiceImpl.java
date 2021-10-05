package com.sigom.services;



import com.sigom.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Your task is to implement the below service to solve the following problem:
 * given a Patient, what is the appropriate TreatmentPlan?
 *
 * A Patient has a name, date of birth, weight, list of symptoms, list of medication allergies,
 * and MRN (Medical Record Number). We have also provided a list of Diseases, Medications, and Clinics
 * for use in this problem in our test suite.
 *
 * A Disease has a name, list of symptoms (which suggest a patient has the disease if a patient has the
 * symptoms in the list), and a list of possible treatments for the disease. Each possible treatment for
 * a disease is a combination of medications with dosage amounts given in mg/kg.
 *
 * A Medication has a name and a cost per mg.
 *
 * A Clinic has a name, a range of ages (in months) that the clinic is open to, and a list of diseases
 * the clinic specializes in treating.
 *
 * Using this information and the provided classes and interface, implement the TreatmentPlanServiceImpl
 * class. Each method in the interface includes exact specifications for what it should return. You can validate
 * that you are returning the correct information using the provided JUnit Test Suite. We will test your answers
 * against additional tests upon your submission of your code.
 *
 * The "Init" method will be called before each test to set up the lists of Disease, Medications, and Clinics. We
 * may test your solution against different lists of Diseases, Medications, and Clinics.
 */
public class TreatmentPlanServiceImpl implements TreatmentPlanService {

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
        if(!patient.getDateOfBirth().isBefore(TODAYSDATE)){
            return 0;
        } else {
            return Period.between(patient.getDateOfBirth(), TODAYSDATE).getYears();
        }
    }

    @Override
    public Integer ageInMonths(Patient patient) {
        if(!patient.getDateOfBirth().isBefore(TODAYSDATE)){
            return 0;
        } else {
            return ageInYears(patient)* TOTAL_MONTHS_YEAR + Period.between(patient.getDateOfBirth(), TODAYSDATE).getMonths();
        }
    }

    @Override
    public List<Clinic> clinicsBasedOnAgeAndDiseases(Patient patient) {
        List<Clinic> patienClinics = new ArrayList<>();
        Integer ageInMonths =  ageInMonths(patient);
        List<String> patientDisease = getListOfDiseasesPatientHasAccordingWithTheSyntoms(patient).stream()
                                      .map(d -> d.getName()).collect(Collectors.toList());
        for(Clinic c : clinics){
            if(checkIfClinicAttendListOfDiseases(c.getDiseases(), patientDisease)){
                if (isAgeAllowedInClinic(c, ageInMonths)){
                    patienClinics.add(c);
                }
            }
        };
        return patienClinics;
    }

    @Override
    public Map<Disease, BigDecimal> diseaseLikelihoods(Patient patient) {
        Map<Disease, BigDecimal> mapDisease = new HashMap<>();
        for (Disease disease: diseases){
            Stream<String> merged = Stream.concat(patient.getSymptoms().stream(), disease.getSymptoms().stream());
            int matchs = merged.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(s -> s.getValue()>=2)
                    .collect(Collectors.toList())
                    .size();
            double val = (matchs * HUNDRED_PERCENT / disease.getSymptoms().size()) / HUNDRED_PERCENT;

            BigDecimal val1 = BigDecimal.valueOf(val);
            BigDecimal likehood = val1.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            mapDisease.merge(disease, likehood,BigDecimal::add);
        }
        return mapDisease;
    }

    @Override
    public Map<Medication, BigDecimal> medicationsForDisease(Patient patient, Disease disease) {

        Optional<Map<String, BigDecimal>> obj = disease.getMedicationCombinations().stream().filter(map -> {
            return !Stream.concat(map.keySet().stream(), patient.medicationAllergies().stream())
                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                       .entrySet()
                       .stream()
                       .filter(s -> s.getValue()>=2)
                       .findAny().isPresent();
        }).sorted((m1,m2) -> m1.values().stream().reduce(BigDecimal::add).get().compareTo(m2.values().stream().reduce(BigDecimal::add).get()))
        .findFirst();

        Map<Medication, BigDecimal> medications = new HashMap<>();
        if (obj.isPresent()){
            for(Map.Entry<String, BigDecimal> entry : obj.get().entrySet()){
                medications.put(new Medication(entry.getKey(), entry.getValue()), entry.getValue().multiply(patient.getWeight()));
            }
        }
        return medications;
    }

    @Override
    public TreatmentPlan treatmentPlanForPatient(Patient patient) {
        TreatmentPlan treatmentPlan = new TreatmentPlan();
        treatmentPlan.setAgeYearPortion(ageInYears(patient));
        treatmentPlan.setAgeMonthPortion(getMonthNumberOfgivingPatientAge(patient));

        List<Disease> diseases = getListOfDiseasesPatientHasAccordingWithTheSyntoms(patient);
        List<Map<Medication, BigDecimal>> groupOfMedicationsForDisease = new ArrayList<>();
        for(Disease disease: diseases){
            groupOfMedicationsForDisease.add(medicationsForDisease(patient, disease));
        }
        Map<Medication, BigDecimal> medicationsForDisease = new HashMap<>();
        groupOfMedicationsForDisease.stream().flatMap(m -> m.entrySet().stream())
                                             .forEach(e -> medicationsForDisease.merge(e.getKey(), e.getValue(), BigDecimal::add));
        treatmentPlan.setClinics(clinicsBasedOnAgeAndDiseases(patient));
        treatmentPlan.setMedications(medicationsForDisease);

        return treatmentPlan;

    }
    private boolean isAgeAllowedInClinic(Clinic clinic , Integer patientAgeInmonths){
        if (clinic.getMinAgeInMonths().compareTo(patientAgeInmonths) < 1) {
            if(clinic.getMaxAgeInMonths() == null ){
                return true;
            } else if (clinic.getMaxAgeInMonths().compareTo(patientAgeInmonths) > 0){
                return true;
            }
        }
        return false;
    }
    private List<Disease> getListOfDiseasesPatientHasAccordingWithTheSyntoms(Patient patient){
        List<Disease> patientDisease = new ArrayList<>();
        for (Disease disease: diseases) {
            Stream<String> merged = Stream.concat(patient.getSymptoms().stream(), disease.getSymptoms().stream());
            int matchs = merged.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(s -> s.getValue() >= 2)
                    .collect(Collectors.toList())
                    .size();

            if (((matchs * FULL_PERCENT) / disease.getSymptoms().size()) > LIKELY_PERCENT){
                patientDisease.add(disease);
            }
        }
        return patientDisease;
    }
    private Integer getMonthNumberOfgivingPatientAge(Patient patient){
        return ageInMonths(patient) - ageInYears(patient) * TOTAL_MONTHS_YEAR;
    }
    private boolean checkIfClinicAttendListOfDiseases(List<String> clinicDisease , List<String> patientDiseases){
        return Stream.concat(clinicDisease.stream() , patientDiseases.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue()>=2)
                .collect(Collectors.toList())
                .size() > 0;
    }
}
