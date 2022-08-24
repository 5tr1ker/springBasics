package noticeboard.entity.DTO;

import noticeboard.entity.freeboard.freeCommit;
import noticeboard.entity.freeboard.freeTag;

public class returnCommitTagDTO {

	private freeTag freetag;
	private freeCommit freecommit;
	
	
	public freeTag getFreetag() {
		return freetag;
	}
	public void setFreetag(freeTag freetag) {
		this.freetag = freetag;
	}
	public freeCommit getFreecommit() {
		return freecommit;
	}
	public void setFreecommit(freeCommit freecommit) {
		this.freecommit = freecommit;
	}
	public returnCommitTagDTO(freeTag freetag, freeCommit freecommit) {
		super();
		this.freetag = freetag;
		this.freecommit = freecommit;
	}
}
