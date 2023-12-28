/* (C)2023 */
package br.com.edu.recipe.app.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String note;

    public Notes() {}

    public Notes(String note) {
        this.note = note;
    }
}
