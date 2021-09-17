package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;

/**
 * Класс PsqlMain для тестирования класса PsqlMain
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.09.2021
 */
public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        //тест методов create и update
//        Post post = new Post(0, "Java Job!!");
//        store.save(post);
//        for (Post el : store.findAllPosts()) {
//            System.out.println(el.getId() + " " + post.getName());
//        }
//        post.setId(1);
//        store.save(post);
        //тест метода finfById()
        System.out.println(store.findById(2).getId());
        System.out.println(store.findById(1).getName());
        //тест метода findAllCandidates()
        for (Candidate c : store.findAllCandidates()) {
            System.out.println(c.getId() + " " + c.getName());
        }
    }

}
