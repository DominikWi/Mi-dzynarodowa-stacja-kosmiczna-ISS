package database.entity;


import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PEOPLE_IN_SPACE")
public class PeopleInSpace {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String name;
        private LocalDateTime date;

        public PeopleInSpace() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

