package com.promineotech.music.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.music.entity.Artists;
import com.promineotech.music.service.ArtistsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultArtistsController implements ArtistsController {

  @Autowired
  private ArtistsService artistsService;

  public Artists createArtists(Artists artist) {
    log.debug("artists={}", artist);
    return artistsService.createArtists(artist);
  }

  


  
}
