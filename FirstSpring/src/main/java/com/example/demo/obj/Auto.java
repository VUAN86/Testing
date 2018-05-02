package com.example.demo.obj;

/**
 *
 * @author VUAN
 */
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Auto")
public class Auto implements Serializable{

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Database id value")
    private Long id;
    
    @Column(name = "model")
    @ApiModelProperty(notes = "Car model name")
    private String model;
    
    @Column(name = "yearint")
    @ApiModelProperty(notes = "Car year of building")
    private int yearint;


    public Auto(String model, int yearint) {
        this.model = model;
        this.yearint = yearint;
    }


    protected Auto() {
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYearint() {
        return yearint;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int yearint) {
        this.yearint = yearint;
    }
  

    @Override
    public String toString() {
        return String.format("Auto[id=%d, model='%s', yearint=%d]",id,model,yearint);
    }

}
 