package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

/**
 * Класс PsqlMain для тестирования класса PsqlStore
 *
 * @author Nikolay Polegaev
 * @version 1.3 02.10.2021
 */
public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        Post post = new Post(0, "Java Job!!");
        store.save(post);
        for (Post el : store.findAllPosts()) {
            System.out.println(el.getId() + " " + el.getName());
        }
        post.setId(1);
        store.save(post);

        Candidate c = new Candidate(4, "SuperJunior JavaDev");
        store.save(c);
        for (Candidate el : store.findAllCandidates()) {
            System.out.println(el.getId() + " " + el.getName());
        }

        for (Post p : store.findAllPosts()) {
            System.out.println(p.getId() + " " + p.getName());
        }
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }

        store.deleteCandidate(1);

        User user = new User(0, "Parfiry", "123@ya.ru", "1234");
        store.save(user);
        for (User u : store.findAllUsers()) {
            System.out.println(u.getId() + " " + u.getName() + " "
                   + u.getEmail() + " " + u.getPassword());
        }
    }
}
