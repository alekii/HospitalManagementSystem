package com.hms.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hms.admin.entity.Admin;
import com.hms.doctor.entity.Doctor;
import com.hms.patient.entity.Medication;
import com.hms.pharmacy.entity.Pharmacist;
import com.hms.reception.entity.Receptionist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

   @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor

    @Entity
    @Table(name="users",
    uniqueConstraints = {
            @UniqueConstraint(columnNames="username")
    })
    public class UserData {
    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="id")
        private int id;

        @Column(name="username")
        @NotBlank
        @Size(max=20)
        private String username;

        @JsonIgnore
        @NotBlank
        @Size(max=120)
        @Column(name="password")
        private String password;

        @ManyToMany(
                cascade = { CascadeType.PERSIST, CascadeType.MERGE },
                fetch=FetchType.LAZY
        )

        @JoinTable(
                name ="user_roles",
                joinColumns=@JoinColumn(name="user_id"),
                inverseJoinColumns=@JoinColumn(name="role_id")
                )

        @Column(name="roles")
        private Set<Role> role = new HashSet<>();

        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = false)
        private Set<Admin> admin = new LinkedHashSet<>();
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = false)
        private Set<Doctor> doctor = new LinkedHashSet<>();
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = false)
        private Set<Receptionist> receptionist = new LinkedHashSet<>();
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = false)
         private Set<Pharmacist> pharmacist = new LinkedHashSet<>();

        //mandatory when using @ManyToMany bidirectional associations
        public void addAdmin(Admin adminUser){
            admin.add(adminUser);
            adminUser.setUser(this);
        }

        public void addDoctor(Doctor doctorUser){
        doctor.add(doctorUser);
        doctorUser.setUser(this);
    }

    public void addPharmacist(Pharmacist pharmacistUser){
        pharmacist.add(pharmacistUser);
        pharmacistUser.setUser(this);
    }

    public void addReceptionist(Receptionist receptionistUser){
        receptionist.add(receptionistUser);
        receptionistUser.setUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}