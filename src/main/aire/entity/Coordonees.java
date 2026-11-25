import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name="coordonees")
public class Coordonees {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name="lattitude")
    private String lattitude;

    @Column (name="longitude")
    private String longitude;

    @Column (name="jeux_id")
    private long jeuxId;

    //constructeurs
    public Coordonees() {
    }

    public Coordonees(String lattitude, String longitude, long jeuxId) {
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.jeuxId = jeuxId;
    }

    // getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public long getJeuxId() {
        return jeuxId;
    }

    public void setJeuxId(long jeuxId) {
        this.jeuxId = jeuxId;
    }
}
