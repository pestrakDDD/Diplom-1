package ru.churikov.rest.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.churikov.rest.models.Feed;
import ru.churikov.rest.models.FeedDto;
import ru.churikov.rest.repoitory.FeedRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class FeedServiceTest {
    FeedService service;
    Feed feed;
    FeedDto dto;
    FeedRepository repository = Mockito.mock(FeedRepository.class);

    @BeforeEach
    public void setUp() {
        feed  = new Feed("name", "description");
        dto = new FeedDto();
        dto.setName("name");
        dto.setDescription("description");
        service = new FeedService(repository);
       feed = service.save(feed);
    }

    @AfterEach
    public void tearDown() {
        Mockito.clearInvocations(repository);
    }

    @Test
    void testGetById() {
        Mockito.when(repository.findOneById(feed.getId())).thenReturn(Optional.of(feed));
        Mockito.when(service.getOntById(feed.getId())).thenReturn(feed);
        Mockito.verify(repository).findOneById(any());

    }

    @Test
    void testSave() {

        Mockito.when(repository.save(feed)).thenReturn(feed);
        Mockito.when(service.save(feed)).thenReturn(feed);
        Mockito.verify(repository, Mockito.times(1)).save(feed);
    }

    @Test
    void verifyThatGetAllFeedsSuccessiful() {
        List<Feed> result = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(result);

        assertEquals(service.getAllFeed(), result);
    }
}