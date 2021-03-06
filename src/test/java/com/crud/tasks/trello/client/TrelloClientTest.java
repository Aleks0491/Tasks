package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private UrlBuilder urlBuilder;

    @Autowired
    private TrelloBoardDto trelloBoardDto;

    @Test
    public void testShouldFetchTrelloBoard() throws URISyntaxException {
        //Given
        when(urlBuilder.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(urlBuilder.getTrelloAppKey()).thenReturn("test");
        when(urlBuilder.getTrelloAppToken()).thenReturn("test");

        TrelloBoardDto[] trelloBoardDto = new TrelloBoardDto[1];
        trelloBoardDto[0] =  new TrelloBoardDto("test_board", "test_id", new ArrayList<>());

        URI uri = new URI("http://test.com/members/aleksandersotor/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(uri, TrelloBoardDto.class)).thenReturn(this.trelloBoardDto);

        //When
        List<TrelloBoardDto> fetchedTrelloBoards = trelloClient.getTrelloBoards();

        //Then
        assertEquals(1, fetchedTrelloBoards.size());
        assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
        assertEquals("test_board", fetchedTrelloBoards.get(0).getName());
        assertEquals(new ArrayList<>(), fetchedTrelloBoards.get(0).getLists());

    }

}