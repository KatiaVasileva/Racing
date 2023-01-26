package homework.transport;

public enum CarBodyType {
    SEDAN("седан"),
    HATCHBACK("хэтчбек"),
    COUPE("купе"),
    UNIVERSAL("универсал"),
    SUV("внедорожник"),
    CROSSOVER("кроссовер"),
    PICKUP("пикап"),
    WAGON("фургон"),
    MINIVAN("минивэн");

    private final String bodyType;

    CarBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String toString() {
        return "Тип кузова: " + bodyType;
    }
}
