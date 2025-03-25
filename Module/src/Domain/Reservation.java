package Domain;

public class Reservation extends Entity<Tuple<Integer, Integer>>{

    private int idClient;
    private int idTrip;
    private int nrSeats;

    public Reservation(int idClient, int idTrip, int nrSeats) {
        super(new Tuple<>(idClient, idTrip));
        this.idClient = idClient;
        this.idTrip = idTrip;
        this.nrSeats = nrSeats;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public int getNrSeats() {
        return nrSeats;
    }

    public void setNrSeats(int nrSeats) {
        this.nrSeats = nrSeats;
    }
}
