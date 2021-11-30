package fetchingEL;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Alien {

	@Id
	private int aid;
	private String Aname;
	@OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
	private Collection<Laptop> laps = new ArrayList<Laptop>();

	public int getId() {
		return aid;
	}

	public void setId(int id) {
		this.aid = id;
	}

	public String getAname() {
		return Aname;
	}

	public void setAname(String aname) {
		Aname = aname;
	}

	public Collection<Laptop> getLaps() {
		return laps;
	}

	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + "]";
	}

}
