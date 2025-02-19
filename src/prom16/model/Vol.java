import java.time.LocalDateTime;

public class Vol {
    private int id;
    private int avionId;
    private int villeDepartId;
    private int villeArriveeId;
    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private int siegesDisponiblesBusiness;
    private int siegesDisponiblesEco;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvionId() {
        return this.avionId;
    }

    public void setAvionId(int avionId) {
        this.avionId = avionId;
    }

    public int getVilleDepartId() {
        return this.villeDepartId;
    }

    public void setVilleDepartId(int villeDepartId) {
        this.villeDepartId = villeDepartId;
    }

    public int getVilleArriveeId() {
        return this.villeArriveeId;
    }

    public void setVilleArriveeId(int villeArriveeId) {
        this.villeArriveeId = villeArriveeId;
    }

    public LocalDateTime getDateDepart() {
        return this.dateDepart;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDateTime getDateArrivee() {
        return this.dateArrivee;
    }

    public void setDateArrivee(LocalDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public int getSiegesDisponiblesBusiness() {
        return this.siegesDisponiblesBusiness;
    }

    public void setSiegesDisponiblesBusiness(int siegesDisponiblesBusiness) {
        this.siegesDisponiblesBusiness = siegesDisponiblesBusiness;
    }

    public int getSiegesDisponiblesEco() {
        return this.siegesDisponiblesEco;
    }

    public void setSiegesDisponiblesEco(int siegesDisponiblesEco) {
        this.siegesDisponiblesEco = siegesDisponiblesEco;
    }


    // Getters et Setters
}
