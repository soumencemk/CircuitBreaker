package com.soumen.circuitbreakerpoc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Soumen Karmakar
 * @Date 29/07/2021
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class ApplicationRunner {
    private final AlbumService albumService;

    @GetMapping("/albums")
    public Flux<AlbumPojo> albums() {
        Flux<AlbumPojo> albumList = albumService.getAlbumList();
        albumList.count().subscribe(c -> log.info("Retrieved albums : " + c));
        return albumList;
    }
}
