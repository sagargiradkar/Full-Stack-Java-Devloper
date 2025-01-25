package com.ineuron.service;

import com.ineuron.model.Tourist;

import java.util.List;

public interface ITouristMgmtService {
    public String registerTourst(Tourist tourist);
    public List<Tourist> fetchAllTourit();
    public Tourist fetchTouristById(Integer id);
    public String updateTouristByDetails(Tourist tourist);
    public String updateTouristById(Integer id, Double hikePercent);
    public String deleteTouristById(Integer id);
}
