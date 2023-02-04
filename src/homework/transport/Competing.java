package homework.transport;

interface Competing {
    // Метод "пит-стоп"
    void pitStop();

    // Метод "лучшее время круга"
    void bestLapTime();

    // Метод "максимальная скорость"
    void maximumSpeed();
}
