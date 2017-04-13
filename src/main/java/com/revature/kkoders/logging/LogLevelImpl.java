package com.revature.kkoders.logging;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="LOG_LEVEL")
public class LogLevelImpl implements LogLevel, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6666283699789091795L;

	@Id
	@Column(name="LEVEL_ID")
	@SequenceGenerator(name="LOGLEVELID_SEQ", sequenceName="LOGLEVELID_SEQ")
	@GeneratedValue(generator="LOGLEVELID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer levelID;
	
	@Column(name="LOG_LEVEL")
	private String level;
	
	//@OneToMany(mappedBy="level")
	//private List<LogImpl> logs;
	
	public LogLevelImpl() {
		super();
	}
	
	public LogLevelImpl(Integer levelID, String level) {
		super();
		this.levelID = levelID;
		this.level = level;
	}

	public Integer getLevelID() {
		return levelID;
	}

	public void setLevelID(Integer levelID) {
		this.levelID = levelID;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		//return "LogLevelImpl [levelID=" + levelID + ", level=" + level + ", logs=" + logs + "]";
		return "LogLevelImpl [levelID=" + levelID + ", level=" + level + "]";
	}

}
