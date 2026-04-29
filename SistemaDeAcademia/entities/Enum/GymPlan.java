package entities.Enum;

public enum GymPlan {

    BASIC(99.90),
    STANDART(149.90),
    PREMIUM(249.90);

    private double monthlyFree;

    GymPlan(double monthlyFree) {
        this.monthlyFree = monthlyFree;
    }

    public double getMonthlyFree() {
        return monthlyFree;
    }
}
