package homework.transport;

public enum BusCapacity {
    VERY_SMALL(null, 10),
    SMALL(null, 25),
    AVERAGE(40, 50),
    LARGE(60, 80),
    VERY_LARGE(100, 120);

    private final Integer minValue;
    private final Integer maxValue;

    BusCapacity(Integer minValue, Integer maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        if (minValue == null) {
            return "Вместимость: до " + maxValue + " мест.\n   ";
        } else {
            return "Вместимость: " + minValue + "-" + maxValue + " мест.\n   ";
        }
    }
}
