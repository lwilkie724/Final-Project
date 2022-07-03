package com.promineotech.music.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.music.entity.Albums;

@Component
public class DefaultAlbumsDao implements AlbumsDao {


  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
public Albums saveAlbums(String albumName, int artist) {
    SqlParams params = generateInsertSql(albumName, artist);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    int id = keyHolder.getKey().intValue();
    
    //@formatter:off
    return Albums.builder()
        .id(id)
        .albumName(albumName)
        .artist(artist)
        .build();
    //@formatter:on
  }


  private SqlParams generateInsertSql(String albumName,  int artist) {
  //@formatter:off
    String sql = ""
        + "INSERT INTO albums ("
        + "album_name, artist"
        + ") VALUES("
        + ":album_name, :artist"
        + ")";
    //@formatter:off
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("album_name", albumName);
    params.source.addValue("artist", artist);
  
    
    
    return params;
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  @Override
  public Optional<String> fetchAlbumName(String albumName ) {
    return Optional.of(albumName);
  }

  @Override
  public Optional<Integer> fetchArtist(int artist) {
    return Optional.of(artist);
  }

  


}
