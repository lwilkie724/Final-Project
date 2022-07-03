package com.promineotech.music.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.music.entity.Albums;
import com.promineotech.music.service.AlbumsService;

@RestController
@RequestMapping("/music/albums")
public class DefaultAlbumsController implements AlbumsController {

  @Autowired
  private AlbumsService albumsService;
  
  public Albums createAlbums(Albums albums) {
   
    return albumsService.createAlbums(albums);
  }

 
  
}
