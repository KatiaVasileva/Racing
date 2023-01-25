package homework.transport;

public enum TruckCapacity {
    N1(null, 3.5f),
    N2(3.5f, 12.0f),
    N3(12.0f, null);

    private final Float minValue;
    private final Float maxValue;

    TruckCapacity(Float minValue, Float maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        if (minValue == null) {
            return "Грузоподъемность: до " + maxValue + " тонн.\n  ";
        } else if (maxValue == null) {
            return "Грузоподъемность: свыше " + minValue + " тонн.\n  ";
        } else {
            return "Грузоподъемность: от " + minValue + " до " + maxValue + " тонн.\n  ";
        }
    }
}
