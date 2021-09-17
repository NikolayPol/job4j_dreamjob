package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс Store описывает модель данных Хранилище.
 * Класс реализован через синглтон.
 *
 * @author Nikolay Polegaev
 * @version 5.0 17.09.2021
 */
public class Store {
    private static final AtomicInteger POST_ID = new AtomicInteger(4);
    private static final AtomicInteger CAND_ID = new AtomicInteger(4);
    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
            posts.put(post.getId(), post);
        }
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(POST_ID.incrementAndGet());
            candidates.put(candidate.getId(), candidate);
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Post findByIdPost(int id) {
        return posts.get(id);
    }

    public Candidate findByIdCand(int id) {
        return candidates.get(id);
    }

    public void deleteCandidate(int id) {
        candidates.remove(id);
    }
}