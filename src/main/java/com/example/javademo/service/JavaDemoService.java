package com.example.javademo.service;

import com.example.javademo.model.equipment.Chainsaw;
import com.example.javademo.model.equipment.Jackhammer;
import com.example.javademo.model.equipment.Ladder;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

public interface JavaDemoService extends CommandLineRunner {
    Chainsaw saveChainsaw(Chainsaw chainsaw);
    List<Chainsaw> getChainsaw();
    Chainsaw updateChainsaw(Chainsaw chainsaw);
    void deleteChainsaw(Long id);
    Ladder saveLadder(Ladder ladder);
    List<Ladder> getLadder();
    Ladder updateLadder(Ladder ladder);
    void deleteLadder(Long id);
    Jackhammer saveJackhammer(Jackhammer jackhammer);
    List<Jackhammer> getJackhammer();
    Jackhammer updateJackhammer(Jackhammer jackhammer);
    void deleteJackhammer(Long id);
}
