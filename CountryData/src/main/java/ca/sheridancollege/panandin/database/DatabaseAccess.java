package ca.sheridancollege.panandin.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.panandin.beans.Country;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public List<Country> getCountry(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT id, name, continent FROM country";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Country>(Country.class));
	}
	
	public List<Country> getCountryById(Long id){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM country WHERE id = :id";
		namedParameters.getValue(query);
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Country>(Country.class));
	}
}
