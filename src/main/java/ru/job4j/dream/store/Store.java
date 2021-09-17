package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.Collection;

/**
 * Интерфейс Store описывает методы хранилища
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.09.2021
 */

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    Post findById(int id);
}