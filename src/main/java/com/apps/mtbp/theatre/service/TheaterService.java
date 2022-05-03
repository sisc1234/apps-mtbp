package com.apps.mtbp.theatre.service;

import java.util.Date;
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

	public List<ResponseEntity<Show>> getTheatersByMovieAndLocation(String location, String movieName,
			String showDate) {
		Map<String, String> qMap = new HashMap<>();
		qMap.put("location", location) ;
		qMap.put("movieName", movieName) ;
		qMap.put("showDate", showDate) ;
		
		thtrMapper.getTheatersByMovieAndLocation(qMap);
		
		

		return null;
	}

	/**
	 * Method creates the respective movie show in particular theater
	 * 
	 * @param show - ShowDto
	 * @return ResponseEntity<String>
	 */
	public ResponseEntity<String> createOrUpdateShowForMovieByLocation(ShowDto show) {

		// Fetch Theator from Request Object
		String thtrId = thtrMapper.getTheaterId(show.getTheaterName());
		if (thtrId == null) {
			throw new UserHandleException("No Theater found !");
		}

		Show newShow = new Show();
		newShow.setTheaterId(Integer.parseInt(thtrId));
		newShow.setMovieId(show.getMovieId());
		newShow.setShowTime(show.getShowTime());
		newShow.setShowDate(new Date(Long.parseLong(show.getShowDate())));

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
	public ResponseEntity<String> deleteShow(String showId) {
		thtrMapper.deleteShow(showId);
		 
		return new ResponseEntity<String>("Show deleted successfully !", HttpStatus.ACCEPTED);
	}

}
