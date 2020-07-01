package cst438;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=1, max=50)
	private String title;
	
	@NotNull
	private int rating;
	
	@NotNull
	@Size(min=1, max=50)
	private String name;
	
	@NotNull
	private String time;
	
	public Movie() {
	}
	
	/**public Movie(String title, int rating, String name, String time) {
		super();
		this.title = title;
		this.rating = rating;
		this.name = name;
		this.time = time;
	}**/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
