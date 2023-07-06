package Ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;

public class HospitalPatientController {

    static String URL = "https://ponhrithmidterm-default-rtdb.asia-southeast1.firebasedatabase.app/";

    static Map<String, Patient> patientDatabase = new HashMap<>();

    public static void main(String[] args) {
        PatientService patientService = createPatientService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Hospital Patient Controller =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Get Patient Information");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Patient newPatient = createNewPatient(scanner);
                    savePatientData(patientService, newPatient);
                    break;
                case 2:
                    System.out.print("Enter patient ID: ");
                    String patientId = scanner.nextLine();
                    getPatientInformation(patientId);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Patient createNewPatient(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient symptom: ");
        String symptom = scanner.nextLine();
        System.out.print("Enter patient room number: ");
        String roomNumber = scanner.nextLine();
        System.out.print("Enter patient health record: ");
        String healthRecord = scanner.nextLine();
        System.out.print("Enter patient check-up schedule: ");
        String checkupSchedule = scanner.nextLine();

        return new Patient(id, name, symptom, roomNumber, healthRecord, checkupSchedule);
    }

    public static void savePatientData(PatientService patientService, Patient patient) {
        Call<PatientResponse> call = patientService.createPatient(patient);
        call.enqueue(new Callback<PatientResponse>() {
            @Override
            public void onResponse(Call<PatientResponse> call, Response<PatientResponse> response) {
                if (response.isSuccessful()) {
                    PatientResponse result = response.body();
                    if (result != null) {
                        patientDatabase.put(patient.getId(), patient);
                        System.out.println("Patient data saved successfully.");
                        System.out.println("Patient ID: " + patient.getId());
                    }
                } else {
                    System.out.println("Failed to save patient data. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<PatientResponse> call, Throwable throwable) {
                System.out.println("Failed to save patient data: " + throwable.getMessage());
            }
        });
    }

    public static void getPatientInformation(String patientId) {
        Patient patient = patientDatabase.get(patientId);
        if (patient != null) {
            System.out.println("Patient data retrieved successfully:");
            System.out.println("ID: " + patient.getId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Symptom: " + patient.getSymptom());
            System.out.println("Room Number: " + patient.getRoomNumber());
            System.out.println("Health Record: " + patient.getHealthRecord());
            System.out.println("Check-up Schedule: " + patient.getCheckupSchedule());
        } else {
            System.out.println("Patient not found.");
        }
    }

    public static PatientService createPatientService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PatientService.class);
    }

    public interface PatientService {
        @POST("patients.json")
        Call<PatientResponse> createPatient(@Body Patient patient);
    }

    public static class Patient {
        private String id;
        private String name;
        private String symptom;
        private String roomNumber;
        private String healthRecord;
        private String checkupSchedule;

        public Patient() {

        }

        public Patient(String id, String name, String symptom, String roomNumber, String healthRecord, String checkupSchedule) {
            this.id = id;
            this.name = name;
            this.symptom = symptom;
            this.roomNumber = roomNumber;
            this.healthRecord = healthRecord;
            this.checkupSchedule = checkupSchedule;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSymptom() {
            return symptom;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public String getHealthRecord() {
            return healthRecord;
        }

        public String getCheckupSchedule() {
            return checkupSchedule;
        }
    }

    public static class PatientResponse {
        private String id;

        public String getId() {
            return id;
        }
    }
}