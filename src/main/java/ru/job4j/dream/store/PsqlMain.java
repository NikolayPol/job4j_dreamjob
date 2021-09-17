package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

/**
 * Класс PsqlMain для тестирования класса PsqlStore
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.09.2021
 */
public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        //тест методов create и update
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

        //тест метода findPostById() и findCandById()
        for (Post p : store.findAllPosts()) {
            System.out.println(p.getId() + " " + p.getName());
        }
        //тест метода findAllCandidates()
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }
        //тест метода delete()
//        store.deleteCandidate(1);
    }

}
