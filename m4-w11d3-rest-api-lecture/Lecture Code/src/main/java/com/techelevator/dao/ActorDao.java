package com.techelevator.dao;

import com.techelevator.dao.model.Actor;
import java.util.List;

public interface ActorDao {
    public List<Actor> getMatchingActors(String search);
    public void addActor(Actor actor);
    public void deleteActor(Integer id);
    public void updateActor(Actor actor);
}