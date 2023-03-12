package kg.china.crmprojectback.entity.user;

import jakarta.persistence.*;
import kg.china.crmprojectback.entity.BaseEntity;
import kg.china.crmprojectback.entity.dictionary.JobTitle;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "t_employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseEntity {
    @Column(name = "full_name", nullable = false)
    String fullName;
    @OneToOne
    @JoinColumn(name = "job_title_id", nullable = false)
    JobTitle jobTitle;
    @Column(name = "salary", nullable = false)
    BigDecimal salary;
    @Column(name = "address", nullable = false)
    String address;
    @Column(name = "phone_number", nullable = false)
    String phoneNumber;
}
