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

    public Optional<Campaign> updateCampaign(String id, Campaign updatedCampaign) {
        Optional<Campaign> existingCampaign = campaignRepository.findById(id);

        if (existingCampaign.isPresent()) {
            Campaign campaign = existingCampaign.get();
            campaign.setName(updatedCampaign.getName());
            campaign.setDescription(updatedCampaign.getDescription());
            campaign.setStartDate(updatedCampaign.getStartDate());
            campaign.setEndDate(updatedCampaign.getEndDate());
            // Update other fields if required

            return Optional.of(campaignRepository.save(campaign));
        } else {
            return Optional.empty();
        }
    }
}
