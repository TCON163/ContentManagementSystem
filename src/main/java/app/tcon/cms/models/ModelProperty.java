package app.tcon.cms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ModelProperty {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private ModelEntity model;

    @Column
    private int dataType;
    /*
    *   Data type:
    *   ByteArrayProp = 0
    *   DateProp = 1;
    *  .... Alphabetical.
    * */


    @Column
    private String name;

    @Column
    private Boolean isShowing;




}

