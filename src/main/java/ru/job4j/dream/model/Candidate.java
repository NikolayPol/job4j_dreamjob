package ru.job4j.dream.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс Candidate описывает модель данных Кандидата
 *
 * @author Nikolay Polegaev
 * @version 2.3 02.10.2021
 */
public class Candidate {
    private int id;
    private String name;
    private int cityId;
    private String city;
    private LocalDateTime created;

    public Candidate(int id, String name, int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.created = LocalDateTime.now();
    }

    public Candidate(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.created = LocalDateTime.now();
    }

    public Candidate(int id, String name, int cityId, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
        this.created = created;
    }

    public Candidate(int id, String name, String city, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id
                && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
