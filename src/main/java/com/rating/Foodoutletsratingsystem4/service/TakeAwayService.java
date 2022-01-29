package com.rating.Foodoutletsratingsystem4.service;

import com.rating.Foodoutletsratingsystem4.entity.TakeAway;

import java.util.List;

public interface TakeAwayService {
    List<TakeAway> getAllTakeAway();

    TakeAway saveTakeAway(TakeAway takeAway);

    TakeAway getTakeAwayById(Long id);

    TakeAway updateTakeAway(TakeAway takeAway);

    void deleteTakeAwayByid(Long id);
}
