package app.tcon.cms.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Content {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity model;

    @Column
    private String contentTitle;

    @Column
    private Boolean isShowing;

    @OneToMany(mappedBy = "byteArrayPropContent")
    private List<ByteArrayProp> byteArrayProps = new ArrayList<>();

    @OneToMany(mappedBy = "datePropContent")
    private List<DateProp> dateProps = new ArrayList<>();

    @OneToMany(mappedBy = "doublePropContent")
    private List<DoubleProp> doubleProps = new ArrayList<>();

    @OneToMany(mappedBy = "intPropContent")
    private List<IntegerProp> intProps = new ArrayList<>();

    @OneToMany(mappedBy = "longPropContent")
    private List<LongProp> longProps = new ArrayList<>();

    @OneToMany(mappedBy = "stringPropContent")
    private List<StringProp> stringProps = new ArrayList<>();


}
