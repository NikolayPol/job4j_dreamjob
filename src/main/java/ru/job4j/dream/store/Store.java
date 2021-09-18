package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

/**
 * Интерфейс Store описывает методы хранилища
 *
 * @author Nikolay Polegaev
 * @version 1.1 18.09.2021
 */

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate candidate);

    Post findPostById(int id);

    Candidate findCandById(int id);

    void deleteCandidate(int id);

    Collection<User> findAllUsers();

    void save(User user);

    User findUserById(int id);

    User findUserByEmail(String email);

    void deleteUser(int id);
}