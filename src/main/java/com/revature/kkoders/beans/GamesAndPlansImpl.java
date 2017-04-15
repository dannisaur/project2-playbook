package com.revature.kkoders.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="GAME_AND_PLANS")
public class GamesAndPlansImpl implements Serializable 
{
	
	
	
	
	@Id
	private long id;
	
	@JoinTable
	(
		name = "GAME_AND_PLANS",
		joinColumns = @JoinColumn(name="plan_id"),
		inverseJoinColumns = @JoinColumn(name="game_id")
	)
	private List<GameImpl> games;

	public final long getId()
	{
		return id;
	}

	public final void setId(long id)
	{
		this.id = id;
	}

	public final List<GameImpl> getGames()
	{
		return games;
	}

	public final void setGames(List<GameImpl> games)
	{
		this.games = games;
	}
}
