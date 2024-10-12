

public class Appointment implements Comparable<Appointment> {
    // Fields
    private Date date;
    private Timeslot timeslot;
    private Profile patient;
    private Provider provider;

    // Constructor
    public Appointment(Date date, Timeslot timeslot, Profile patient, Provider provider) {
        this.date = date;
        this.timeslot = timeslot;
        this.patient = patient;
        this.provider = provider;
    }

    // Getters
    public Date getDate() {
        return date;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public Profile getPatient() {
        return patient;
    }

    public Provider getProvider() {
        return provider;
    }

    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Appointment other = (Appointment) obj;
        return date.equals(other.date) &&
                timeslot.equals(other.timeslot) &&
                patient.equals(other.patient);
    }

    // Override compareTo() method for sorting
    @Override
    public int compareTo(Appointment other) {
        // First, compare by date
        int dateComparison = this.date.compareTo(other.date);
        if (dateComparison != 0) return dateComparison;

        // If dates are the same, compare by timeslot
        int timeslotComparison = this.timeslot.compareTo(other.timeslot);
        if (timeslotComparison != 0) return timeslotComparison;

        // If both date and timeslot are the same, compare by patient
        return this.patient.compareTo(other.patient);
    }
    public static String forTimeslot(Timeslot timeslot) {
        int hour = timeslot.getHour();
        int minute = timeslot.getMinute();
        String amPm = (hour >= 12) ? "PM" : "AM";
        if (hour > 12) {
            hour -= 12;  // Convert to 12-hour format
        }
        return String.format("%d:%02d %s", hour, minute, amPm);
    }
    // Override toString() method
    @Override
    public String toString() {
        return String.format("%s %s %s [%s, %s, %s %s, %s]",
                date,
                forTimeslot(timeslot),
                patient,
                provider.getName(),
                provider.getLocation().getCity(),
                provider.getLocation().getCounty(),
                provider.getLocation().getZip(),
                provider.getSpecialty());
    }

}