package ru.churikov.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.repoitory.FeedRepository;

import java.util.List;

@Service
public class FeedService {

    @Autowired
    private FeedRepository feedRepository;

    public List<Feed> getAllFeed() {
        return feedRepository.findAll();
    }

    public Feed getOntById(Long id) {
        return feedRepository.findOneById(id).orElseThrow(() -> new NullPointerException("Object is by id " + id + " not found!"));
    }

    public Feed save(Feed feed) {
        return feedRepository.save(feed);
    }

    public void delete(Long id) {
        feedRepository.deleteById(id);
    }
}
