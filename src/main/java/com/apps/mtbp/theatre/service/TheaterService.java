package com.apps.mtbp.theatre.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apps.mtbp.theatre.dto.ShowDto;
import com.apps.mtbp.theatre.entity.Show;
import com.apps.mtbp.theatre.entity.Theater;
import com.apps.mtbp.theatre.exception.UserHandleException;
import com.apps.mtbp.theatre.mapper.TheatreMapper;

@Service
public class TheaterService {

	@Autowired
	private TheatreMapper thtrMapper;

	public ResponseEntity<Theater> getTheatersByLocation(String location) {

		return null;
	}

	public List<ShowDto> getTheatersByMovieAndLocation(String location, String movieName, String showDate) {
		Map<String, String> qMap = new HashMap<>();
		qMap.put("location", location);
		qMap.put("movieName", movieName);
		qMap.put("showDate", showDate);

		List<ShowDto> shows = thtrMapper.getTheatersByMovieAndLocation(qMap);
		if (shows.isEmpty()) {
			throw new UserHandleException("No Shows found for movie : " + movieName );
		}
		return shows;
	}

	/**
	 * Method creates the respective movie show in particular theater
	 * 
	 * @param show - ShowDto
	 * @return ResponseEntity<String>
	 * @throws ParseException 
	 */
	public ResponseEntity<String> createOrUpdateShowForMovieByLocation(ShowDto show) throws ParseException {

		// Fetch Theator from Request Object
		int thtrId = thtrMapper.getTheaterId(show.getTheaterName());
		if (thtrId == 0) {
			throw new UserHandleException("No Theater found !");
		}

		Show newShow = new Show();
		newShow.setTheaterId(thtrId);
		newShow.setMovieId(show.getMovieId());
		newShow.setShowTime(show.getShowTime());		
		newShow.setShowDate(new SimpleDateFormat("yyyy-mm-dd").parse(show.getShowDate()));

		if (newShow.getShowId() == 0) {
			// create new show
			thtrMapper.createShow(newShow);
		} else {
			thtrMapper.updateShow(newShow);
		}

		return new ResponseEntity<String>("Show created successfully !", HttpStatus.CREATED);
	}

	/**
	 * Method deletes the existing movie show in particular theater
	 * 
	 * @param showId - String
	 * @return ResponseEntity<String>
	 */
	public ResponseEntity<String> deleteShow(int showId) {
		thtrMapper.deleteShow(showId);
		return new ResponseEntity<>("Show deleted successfully !", HttpStatus.ACCEPTED);
	}

}
