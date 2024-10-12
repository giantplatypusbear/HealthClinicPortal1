public class BillingStatement {
    private Profile patientProfile;
    private double totalAmount;

    public BillingStatement(Profile patientProfile, double initialAmount) {
        this.patientProfile = patientProfile;
        this.totalAmount = initialAmount;
    }

    public Profile getPatientProfile() {
        return patientProfile;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addAmount(double amount) {
        this.totalAmount += amount;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f", patientProfile, totalAmount);
    }
}