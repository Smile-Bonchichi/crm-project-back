package kg.china.crmprojectback.entity.dictionary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kg.china.crmprojectback.entity.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_job_title")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobTitle extends BaseEntity {
    @Column(name = "name", unique = true, nullable = false)
    String name;
}
