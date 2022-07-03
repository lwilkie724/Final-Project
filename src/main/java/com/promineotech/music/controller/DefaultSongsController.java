package com.promineotech.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.music.entity.Songs;
import com.promineotech.music.service.SongsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultSongsController implements SongsController {

  @Autowired
  private SongsService songsService;

  public Songs createSongs(Songs song) {
    log.debug("song={}", song);
    return songsService.createSongs(song);
  }
}
