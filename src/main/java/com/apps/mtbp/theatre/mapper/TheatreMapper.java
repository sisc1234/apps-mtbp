package com.apps.mtbp.theatre.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.apps.mtbp.theatre.entity.Show;

@Mapper
public interface TheatreMapper {

	@Select("SELECT thtr_id FROM mtbp_thtr_l WHERE thtr_nm = #{theaterName}")
	public String getTheaterId(String theaterName);

	@Insert("INSERT INTO mtbp_thtr_show_l(show_id, thtr_id, movie_id, show_date ,show_time ) "
			+ " VALUES (#{showId}, #{theaterId}, #{movieId}, #{showDate} , #{showTime})")
	public void createShow(Show newShow);

	@Update("Update mtbp_thtr_show_l set movie_id=#{movieId}, "
			+ " show_date=#{showDate}, show_time=#{showTime} where show_id=#{showId}")
	public void updateShow(Show newShow);

	@Delete("DELETE FROM mtbp_thtr_show_l WHERE show_id = #{showId}")
	public void deleteShow(String showId);
	
	@Select("SELECT \r\n"
			+ "   SL.show_id ,\r\n"
			+ "   SL.movie_id , \r\n"
			+ "   SL.thtr_id ,\r\n"
			+ "   SL.show_dt ,\r\n"
			+ "   SL.start_time ,\r\n"
			+ "   ML.movie_id ,\r\n"
			+ "   ML.movie_nm ,\r\n"
			+ "   ML.language,\r\n"
			+ "   ML.genre,\r\n"
			+ "   ML.length\r\n"
			+ "from \r\n"
			+ "	mtbp_mvi_movie_l ML,\r\n"
			+ "	(SELECT * from mtbp_thtr_show_l \r\n"
			+ "		where thtr_id in \r\n"
			+ "			(\r\n"
			+ "				SELECT thtr_id from mtbp_thtr_l where location_id in \r\n"
			+ "				(  \r\n"
			+ "					SELECT location_id from mtbp_locn_location where city = #{movieName}  \r\n"
			+ "				) \r\n"
			+ "			) AND \r\n"
			+ "		 show_dt = #{showDate} \r\n"
			+ "	) SL\r\n"
			+ "\r\n"
			+ "WHERE \r\n"
			+ "	ML.movie_id = SL.movie_id")
	public void getTheatersByMovieAndLocation(Map<String, String> qMap);
	
	

}

					
