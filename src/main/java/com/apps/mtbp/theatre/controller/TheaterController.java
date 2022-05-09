package com.apps.mtbp.theatre.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.mtbp.theatre.dto.ShowDto;
import com.apps.mtbp.theatre.service.TheaterService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * Request handler for Theater-microservice calls
 * 
 * @author Sunil
 *
 */
@RequestMapping("/mtbp/theater/")
@RestController
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@PostMapping("/show")
	@Operation(summary = "Create or update movie shows in selected theaters by location")
	public ResponseEntity<String> createOrUpdateShowForMovieByLocation(@RequestBody ShowDto show) throws ParseException {
		return theaterService.createOrUpdateShowForMovieByLocation(show);
	}

	@DeleteMapping("/show/{showId}")
	@Operation(summary = "Delete movie shows in selected theators")
	public ResponseEntity<String> deleteShow(@PathVariable String showId) {
		return theaterService.deleteShow(Integer.parseInt(showId));
	}

	@GetMapping("/theaters/{location}/{movieName}/{showDate}")
	@Operation(summary = "Get the theators list running particular movie by location")
	public List<ShowDto> theatersByMovieAndLocation(@PathVariable String location, @PathVariable String movieName,
			@PathVariable String showDate) {
		return theaterService.getTheatersByMovieAndLocation(location, movieName, showDate);
	}

}
