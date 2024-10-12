

public enum Specialty {
    FAMILY(250),
    PEDIATRICIAN(300),
    ALLERGIST(350);

    private final int charge;

    // Constructor
    Specialty(int charge) {
        this.charge = charge;
    }

    // Getter
    public int getCharge() {
        return charge;
    }

    @Override
    public String toString() {
        return String.format("%s", name());
    }
}
