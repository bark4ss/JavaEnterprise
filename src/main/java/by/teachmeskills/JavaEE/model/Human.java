package by.teachmeskills.JavaEE.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//https://habr.com/ru/post/337488/
//https://coderlessons.com/articles/java/hibernate-nasledovanie-tablitsa-po-ierarkhii-klassov
public class Human {

    private String login;

    public Human() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
