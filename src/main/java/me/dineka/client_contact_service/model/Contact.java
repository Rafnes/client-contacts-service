package me.dineka.client_contact_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "contact")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(phone, contact.phone) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, email);
    }
}
