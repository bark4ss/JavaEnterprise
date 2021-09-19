package by.teachmeskills.JavaEE.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serial;

    @OneToOne(mappedBy = "passport")
    //http://internetka.in.ua/hibernate-one-to-one/
    private User user;

    public Passport() {
    }

    public Passport(String serial, User user) {
        this.serial = serial;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return id == passport.id && Objects.equals(serial, passport.serial) && Objects.equals(user, passport.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serial, user);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
