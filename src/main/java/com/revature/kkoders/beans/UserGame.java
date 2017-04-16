package com.revature.kkoders.beans;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value="prototype")
@Table(name="GAME_LIBRARY")
@AssociationOverrides({
	@AssociationOverride(name="pk.user",
		joinColumns = @JoinColumn(name="USER_ID")),
	@AssociationOverride(name="pk.game",
		joinColumns = @JoinColumn(name="GAME_ID"))
})
public class UserGame implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1166381154271774938L;
	
	@EmbeddedId
	private UserGameId pk= new UserGameId();
	
	
	@Column(name="INITIAL_HOURS_PERDAY")
	private long hours;
	
	public UserGame()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public final UserGameId getPk()
	{
		return pk;
	}

	public final void setPk(UserGameId pk)
	{
		this.pk = pk;
	}
	
	@Transient
	public UserImpl getUser()
	{
		return getPk().getUser();
	}
	
	public final void setUser(UserImpl user)
	{
		getPk().setUser(user);
	}

	
	@Transient
	public final GameImpl getGame()
	{
		return getPk().getGame();
	}

	public final void setGame(GameImpl game)
	{
		getPk().setGame(game);
	}


	public final long getHours()
	{
		return hours;
	}

	public final void setHours(long hours)
	{
		this.hours = hours;
	}

	@Override
	public String toString()
	{
		return "UserGame [pk=" + pk + ", hours=" + hours + "]";
	}
	
	
}
