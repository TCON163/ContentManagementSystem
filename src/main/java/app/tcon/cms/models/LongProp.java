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
public class LongProp {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long longProp;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    @JsonIgnore
    private Content longPropContent;

    @Column
    private String name;
}
