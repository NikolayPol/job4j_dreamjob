package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

/**
 * Интерфейс Store описывает методы хранилища
 *
 * @author Nikolay Polegaev
 * @version 1.4 02.10.2021
 */

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate candidate);

    Post findPostById(int id);

    Collection<Post> findTodayPosts();

    Candidate findCandById(int id);

    void deleteCandidate(int id);

    Collection<Candidate> findTodayCandidates();

    Collection<User> findAllUsers();

    void save(User user);

    User findUserByEmail(String email);

    Collection<City> findAllCities();
}