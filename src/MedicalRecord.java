
public class MedicalRecord {
    private Patient[] patients; // Array of patient objects
    private int size;           // Number of patients in the array

    private static final int INITIAL_CAPACITY = 4;

    // Constructor
    public MedicalRecord() {
        patients = new Patient[INITIAL_CAPACITY];
        size = 0;
    }

    // Helper method to grow the array when it is full
   private void grow() {
    Patient[] newPatients = new Patient[patients.length + INITIAL_CAPACITY];
    for (int i = 0; i < patients.length; i++) {
        newPatients[i] = patients[i];
    }
    patients = newPatients;
}

    // Add a new patient to the record
    public void add(Patient newPatient) {
        if (size == patients.length) {
            grow();
        }
        patients[size++] = newPatient;
    }

    // Find a patient by profile
    public Patient findPatient(Profile profile) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getProfile().equals(profile)) {
                return patients[i];  // Found the patient
            }
        }
        return null;  // Patient not found
    }

    // Get all patients
    public Patient[] getPatients() {
        return patients;
    }
}
