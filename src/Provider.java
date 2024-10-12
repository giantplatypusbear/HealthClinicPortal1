

public enum Provider {
    PATEL(Location.BRIDGEWATER, Specialty.FAMILY),
    LIM(Location.BRIDGEWATER, Specialty.PEDIATRICIAN),
    ZIMNES(Location.CLARK, Specialty.FAMILY),
    HARPER(Location.CLARK, Specialty.FAMILY),
    KAUR(Location.PRINCETON, Specialty.ALLERGIST),
    TAYLOR(Location.PISCATAWAY, Specialty.PEDIATRICIAN),
    RAMESH(Location.MORRISTOWN, Specialty.ALLERGIST),
    CERAVOLO(Location.EDISON, Specialty.PEDIATRICIAN);

    private final Location location;
    private final Specialty specialty;

    // Constructor
    Provider(Location location, Specialty specialty) {
        this.location = location;
        this.specialty = specialty;
    }

    // Getters
    public Location getLocation() {
        return location;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public String getName() {
        return name();  // Returns the enum constant name (e.g., "PATEL")
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %s]", getName(), location, specialty);
    }
}
