package javagda21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ChecklistItem implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean completed;
    @ManyToOne
    private Checklist checklist;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String discription;


}
