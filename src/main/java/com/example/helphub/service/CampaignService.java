package com.example.helphub.service;



import com.example.helphub.model.Campaign;
import com.example.helphub.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    // Create or update a campaign
    public Campaign createCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    // Get all campaigns
    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    // Get a campaign by ID
    public Optional<Campaign> getCampaignById(String id) {
        return campaignRepository.findById(id);
    }
}
