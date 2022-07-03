package com.promineotech.music.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.music.entity.Artists;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/artists")
@OpenAPIDefinition(info = @Info(title = "Artists Service"),
servers = {@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface ArtistsController {

//@formatter:off
  @Operation(
      summary = "Create a new artist",
      description = "Returns created artist",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "The created artist is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Artists.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "A song was not found with the input criteria",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occured",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
         @Parameter(name = "artist",             
             required = false, 
             description = "The artist as JSON")
         }
      )
 
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Artists createArtists(@Valid @RequestBody Artists artist);      
  //@formatter:on
}
