package noticeboard.entity.freeboard;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class freeWhoLike {
	
	@Column(nullable = false , length = 20)
	private String commender;
	
}
