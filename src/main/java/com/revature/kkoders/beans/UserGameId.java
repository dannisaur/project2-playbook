package com.revature.kkoders.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Embeddable
@Component
public class UserGameId implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6359734580277975605L;

	@ManyToOne
	@Autowired
	UserImpl user;
	
	@ManyToOne
	@Autowired
	GameImpl game;

	public final UserImpl getUser()
	{
		return user;
	}

	public final void setUser(UserImpl user)
	{
		this.user = user;
	}

	public final GameImpl getGame()
	{
		return game;
	}

	public final void setGame(GameImpl game)
	{
		this.game = game;
	}

	@Override
	public String toString()
	{
		return "GameLibraryUserId [user=" + user + ", game=" + game + "]";
	}

	public UserGameId()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public UserGameId(UserImpl user, GameImpl game)
	{
		super();
		this.user = user;
		this.game = game;
	}
	
	
}
