package app;

public class Bus {
    private int capacity;
    private int newPassengerIndex;
    private Passenger[] passengers;
    private Destination destination;

    public Bus(int capacity, Destination destination) {
        this.capacity = capacity;
        this.destination = destination;
        this.newPassengerIndex = 0;
        this.passengers = new Passenger[capacity];
    }

    public Destination getDestination() {
        return destination;
    }

    public void insertPassenger(Passenger passenger) {
        if (passenger.getDestination() != this.destination) {
            System.out.println("The bus goes different destination");
        } else if (this.capacity == 0) {
            System.out.println("Bus is full. " + passenger.getName() + " can't get in");
        } else {
            this.passengers[this.newPassengerIndex] = passenger;
            this.capacity--;
            this.newPassengerIndex++;
            System.out.println(passenger.getName() + " gets in the bus");
        }
    }

    public static void main(String[] args) {
        Bus bus = new Bus(3, Destination.ISTANBUL);
        bus.insertPassenger(new Passenger("Furkan", Destination.ISTANBUL));
        bus.insertPassenger(new Passenger("Aslı", Destination.ADANA));
        bus.insertPassenger(new Passenger("Esma", Destination.ISTANBUL));
        bus.insertPassenger(new Passenger("Mehmet", Destination.BURSA));
        bus.insertPassenger(new Passenger("Gaye", Destination.ANKARA));
        bus.insertPassenger(new Passenger("Kemal", Destination.ISTANBUL));
    }

}
