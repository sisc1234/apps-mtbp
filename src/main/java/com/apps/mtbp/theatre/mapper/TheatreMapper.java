package com.apps.mtbp.theatre.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.apps.mtbp.theatre.dto.ShowDto;
import com.apps.mtbp.theatre.entity.Show;

@Mapper
public interface TheatreMapper {

	public void createShow(Show newShow);

	public void updateShow(Show newShow);

	public void deleteShow(int showId);

	public int getTheaterId(String theaterName);

	public List<ShowDto> getTheatersByMovieAndLocation(Map<String, String> qMap);

}
