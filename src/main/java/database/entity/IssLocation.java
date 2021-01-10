package database.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "ISS_LOCATION")
public class IssLocation  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private double longitude;
    private double latitude;
    private LocalDateTime date;


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}