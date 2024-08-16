package com.example.javademo.service;

import com.example.javademo.model.equipment.Chainsaw;
import com.example.javademo.model.equipment.Jackhammer;
import com.example.javademo.model.equipment.Ladder;
import com.example.javademo.repository.ChainsawRepository;
import com.example.javademo.repository.JackhammerRepository;
import com.example.javademo.repository.LadderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JavaDemoServiceImpl implements JavaDemoService{
    ChainsawRepository chainsawRepository;
    LadderRepository ladderRepository;
    JackhammerRepository jackhammerRepository;
    @Autowired
    public JavaDemoServiceImpl(ChainsawRepository chainsawRepository, LadderRepository ladderRepository, JackhammerRepository jackhammerRepository) {
        this.chainsawRepository = chainsawRepository;
        this.ladderRepository = ladderRepository;
        this.jackhammerRepository = jackhammerRepository;
    }

    @Override
    public Chainsaw saveChainsaw(Chainsaw chainsaw) {
        return chainsawRepository.save(chainsaw);
    }

    @Override
    public List<Chainsaw> getChainsaw() {
        return chainsawRepository.findAll();
    }

    @Override
    public Chainsaw updateChainsaw(Chainsaw chainsaw) {
        return chainsawRepository.save(chainsaw);
    }

    @Override
    public void deleteChainsaw(Long id) {
        chainsawRepository.deleteById(id);
    }

    @Override
    public Ladder saveLadder(Ladder ladder) {
        return ladderRepository.save(ladder);
    }

    @Override
    public List<Ladder> getLadder() {
        return ladderRepository.findAll();
    }

    @Override
    public Ladder updateLadder(Ladder ladder) {
        return ladderRepository.save(ladder);
    }

    @Override
    public void deleteLadder(Long id) {
        ladderRepository.deleteById(id);
    }

    @Override
    public Jackhammer saveJackhammer(Jackhammer jackhammer) {
        return jackhammerRepository.save(jackhammer);
    }

    @Override
    public List<Jackhammer> getJackhammer() {
        return jackhammerRepository.findAll();
    }

    @Override
    public Jackhammer updateJackhammer(Jackhammer jackhammer) {
        return jackhammerRepository.save(jackhammer);
    }

    @Override
    public void deleteJackhammer(Long id) {
        jackhammerRepository.deleteById(id);
    }

    @Override
    public void run(String... args) throws Exception {
        if(chainsawRepository.findByCode("CHNS") == null) {
            Chainsaw chainsaw = new Chainsaw("Stihl", "CHNS");
            chainsawRepository.save(chainsaw);
        }
        if(ladderRepository.findByCode("LADW") == null) {
            Ladder ladder = new Ladder("Werner", "LADW");
            ladderRepository.save(ladder);
        }
        List<Jackhammer> jackhammers = new ArrayList<>();

        Jackhammer jackhammerD = jackhammerRepository.findByCode("JAKD");
        if (jackhammerD == null) {
            jackhammerD = new Jackhammer("Dewalt", "JAKD");
            jackhammers.add(jackhammerD);
        }

        Jackhammer jackhammerR = jackhammerRepository.findByCode("JAKR");
        if (jackhammerR == null) {
            jackhammerR = new Jackhammer("Rigid", "JAKR");
            jackhammers.add(jackhammerR);
        }

        if (!jackhammers.isEmpty()) {
            jackhammerRepository.saveAll(jackhammers);
        }
    }
}
