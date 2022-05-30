package phoenixit.education.models;

import javax.persistence.*;

@Entity
public class Education {


    private @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    private @Column(nullable = false,unique=true) String name;

    public Education() {

    }

    public Education(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
