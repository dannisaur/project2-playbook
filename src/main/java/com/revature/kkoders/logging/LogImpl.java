package com.revature.kkoders.logging;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * A log that has a message and a level which categorizes it. 
 *
 */
@Component
@Entity
@Table(name="LOGS")
public class LogImpl implements Log, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5949323416613650199L;

	@Id
	@Column(name="LOG_ID")
	@SequenceGenerator(name="LOGID_SEQ", sequenceName="LOGID_SEQ")
	@GeneratedValue(generator="LOGID_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer logID;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false) 
    @JoinColumn(name = "LEVEL_ID", nullable = false, updatable = false)
	private LogLevelImpl level;

	@Column(name="MESSAGE")
	private String message;
	
	public LogImpl() {
		super();
	}
	
	/*
	public LogImpl(Integer logID, LogLevelImpl level, String message) {
		super();
		this.logID = logID;
		this.level = level;
		this.message = message;
	}
	*/
	
	@Column(name="DATETIME_CREATED", insertable=false) //will only be assigned by db.
	private Timestamp datetimeCreated;
	
	public Integer getLogID() {
		return logID;
	}
	public void setLogID(Integer logID) {
		this.logID = logID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getDatetimeCreated() {
		return datetimeCreated;
	}

	public void setDatetimeCreated(Timestamp datetimeCreated) {
		this.datetimeCreated = datetimeCreated;
	}

	
	public void setLevel(LogLevelImpl level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "LogImpl [logID=" + logID + ", level=" + level + ", message=" + message + ", logLevel=" + level
				+ ", datetimeCreated=" + datetimeCreated + "]";
	}

}
