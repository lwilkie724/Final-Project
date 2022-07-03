package com.promineotech.music.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.music.entity.Albums;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@OpenAPIDefinition(info = @Info(title = "Albums"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.") })

@RequestMapping("/albums")
public interface AlbumsController {

  //@formatter:off
  @Operation(
      summary = "Creates a new album",
      description = "Returns a created album",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A ",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Albums.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No Albums were found with the input criteria",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
              description = "An unplanned error occured",
              content = @Content(
                  mediaType = "application/json"))
          },
      parameters = {
          @Parameter(name = "album name", 
              required = false,
              description = "The album")
          }
      )
     
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
 Albums createAlbums(@Valid @RequestBody Albums albums);
  
  //@formatter:on
}
