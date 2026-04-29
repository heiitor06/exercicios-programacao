package entities.Enum;

public enum WorkoutType {

    CARDIO(8),
    WEIGHT_TRAINING(6),
    YOGA(4),
    CROSSFIT(10);

    private int metFactor;

    WorkoutType(int metFactor) {
        this.metFactor = metFactor;
    }

    public int getMetFactor() {
        return metFactor;
    }
}
