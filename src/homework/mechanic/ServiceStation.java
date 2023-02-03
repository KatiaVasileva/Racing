package homework.mechanic;

import homework.transport.Transport;
import homework.transport.TransportTypeException;

import java.util.Queue;

public class ServiceStation {
    private final Queue<Transport<?>> queue;

    public ServiceStation(Queue<Transport<?>> queue) {
        this.queue = queue;
    }

    public Queue<Transport<?>> getQueue() {
        return queue;
    }

    // Метод, который добавляет автомобили в очередь на техосмотр
    public void addInQueue(Transport<?> transport) {
        queue.offer(transport);
    }

    // Метод, который вывод информацию о проведении техосмотра автомобилей из очереди и по окончании техосмотра удаляет их из очереди
    public void performInspection() throws TransportTypeException {
        Transport<?> transport;
        while ((transport = queue.poll()) != null) {
            transport.checkInspection();
        }
    }
}
