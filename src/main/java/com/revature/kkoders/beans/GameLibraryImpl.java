package com.revature.kkoders.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="GAME_LIBRARY")
public class GameLibraryImpl implements GameLibrary
{
	@Id
	private long id;
	
	@JoinTable
	(
		name = "GAME_LIBRARY",
		joinColumns = @JoinColumn(name="user_id"),
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
