package com.coderains.firsthib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alien_table")
public class alien {
	@Id
	private int aid;
	// @Transient
	private alienName aname;
	@Column(name = "alien_color")
	private String color;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public alienName getAname() {
		return aname;
	}

	public void setAname(alienName aname) {
		this.aname = aname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}

}
