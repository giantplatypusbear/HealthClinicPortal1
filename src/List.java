

public class List {
    private Appointment[] appointments;  // Array of Appointment objects
    private int size;                    // Number of appointments currently in the list

    private static final int INITIAL_CAPACITY = 4; // Initial capacity of the list
    private static final int NOT_FOUND = -1;       // Constant for not found index

    // Constructor
    public List() {
        appointments = new Appointment[INITIAL_CAPACITY];  // Start with a small initial capacity
        size = 0;  // Initially, there are no appointments
    }
    // Helper method to find an appointment in the list by reference


    public Appointment[] getAppointments() {
        return appointments;
    }

    private int find(Appointment appointment) {
        for (int i = 0; i < size; i++) {
            if (appointments[i].equals(appointment)) {
                return i;  // Return the index if the appointment is found
            }
        }
        return NOT_FOUND;  // Return -1 if not found
    }

    // Add an appointment to the list
    public void add(Appointment appointment) {
        // Grow the array if it's full
        if (size == appointments.length) {
            grow();  // Dynamically increase capacity
        }
        appointments[size++] = appointment;  // Add the new appointment and increment size
    }

    // Remove an appointment from the list
    public void remove(Appointment appointment) {
        int index = find(appointment);
        if (index != NOT_FOUND) {
            // Shift elements to the left to remove the appointment
            for (int i = index; i < size - 1; i++) {
                appointments[i] = appointments[i + 1];
            }
            appointments[--size] = null;  // Null out the last element and decrement size
        }
    }



    // Dynamically grow the array when it's full
    private void grow() {
    Appointment[] newAppointments = new Appointment[appointments.length + INITIAL_CAPACITY];
    for (int i = 0; i < appointments.length; i++) {
        newAppointments[i] = appointments[i];
    }
    appointments = newAppointments;
}

    // Print appointments sorted by patient profile, then by date/timeslot
    public void printByPatient() {
        sortByPatient();
        System.out.println("\n** Appointments ordered by patient/date/time **");
        for (int i = 0; i < size; i++) {
            System.out.println(appointments[i]);
        }
        System.out.println("** end of list **");
    }

    // Print appointments sorted by location, then by date/timeslot
    public void printByLocation() {
        sortByLocation();
        System.out.println("\n** Appointments ordered by county/date/time **");
        for (int i = 0; i < size; i++) {
            System.out.println(appointments[i]);
        }
        System.out.println("** end of list **");
    }

    // Print appointments sorted by date/timeslot, then by provider
    public void printByAppointment() {
        sortByDateAndTimeslot();
        System.out.println("\n** Appointments ordered by date/time/provider **");
        for (int i = 0; i < size; i++) {
            System.out.println(appointments[i]);
        }
        System.out.println("** end of list **");
    }

    // Sort appointments by patient profile, date, and timeslot
    public void sortByPatient() {
        // Implement a basic in-place sorting algorithm (e.g., bubble sort)
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (appointments[j].getPatient().compareTo(appointments[j + 1].getPatient()) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    // Sort appointments by location, then date/timeslot
    private void sortByLocation() {
    // Implement an in-place sorting algorithm by county, date, and timeslot
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            int countyComparison = appointments[j].getProvider().getLocation().getCounty().compareTo(appointments[j + 1].getProvider().getLocation().getCounty());
            if (countyComparison > 0) {
                swap(j, j + 1);
            } else if (countyComparison == 0) {
                int dateComparison = appointments[j].getDate().compareTo(appointments[j + 1].getDate());
                if (dateComparison > 0) {
                    swap(j, j + 1);
                } else if (dateComparison == 0) {
                    int timeComparison = appointments[j].getTimeslot().compareTo(appointments[j + 1].getTimeslot());
                    if (timeComparison > 0) {
                        swap(j, j + 1);
                    }
                }
            }
        }
    }
}

    // Sort appointments by date/timeslot, then provider
    private void sortByDateAndTimeslot() {
        // Implement an in-place sorting algorithm by date, timeslot, and provider
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                int dateComparison = appointments[j].getDate().compareTo(appointments[j + 1].getDate());
                if (dateComparison > 0) {
                    swap(j, j + 1);
                } else if (dateComparison == 0) {
                    int timeComparison = appointments[j].getTimeslot().compareTo(appointments[j + 1].getTimeslot());
                    if (timeComparison > 0) {
                        swap(j, j + 1);
                    } else if (timeComparison == 0) {
                        if (appointments[j].getProvider().getName().compareTo(appointments[j + 1].getProvider().getName()) > 0) {
                            swap(j, j + 1);
                        }
                    }
                }
            }
        }
    }

    // Helper method to swap two appointments in the array
    private void swap(int i, int j) {
        Appointment temp = appointments[i];
        appointments[i] = appointments[j];
        appointments[j] = temp;
    }

    public boolean contains(Appointment newAppointment) {
        return find(newAppointment) != NOT_FOUND;

    }
    public int size() {
        return size;
    }

    public Appointment get(int i) {

        return appointments[i];
    }

    public void empty() {
        appointments = new Appointment[INITIAL_CAPACITY];
        size = 0;
    }


}
