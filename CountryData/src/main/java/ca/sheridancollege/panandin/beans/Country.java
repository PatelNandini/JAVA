package ca.sheridancollege.panandin.beans;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable{
	
	private Long id;
	private String name;
	private String continent;
	private String region;
	private Float surface_area;
	private int population;
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", continent=" + continent + ", region=" + region
				+ ", surface_area=" + surface_area + ", population=" + population + "]";
	}
	
}

