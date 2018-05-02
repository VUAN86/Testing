package com.example.demo.obj;

/**
 *
 * @author VUAN
 */
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Database id value")
    private Long id;
    
    @Column(name = "name")
    @ApiModelProperty(notes = "Name of client")
    private String name;
    
    @Column(name = "yearint")
    @ApiModelProperty(notes = "Birth year of client")
    private int yearint;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "auto_id")
    private Auto auto;

    public Client(String name, int yearint, Auto auto) {
        this.name = name;
        this.yearint = yearint;
        this.auto = auto;
    }

    protected Client() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearint() {
        return yearint;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public void setYear(int yearint) {
        this.yearint = yearint;
    }

    @Override
    public String toString() {
        return String.format("Client[id=%d, name='%s', yearint=%d, auto_id=%d]", id, name, yearint, auto.getId());
    }

}
