package com.rating.Foodoutletsratingsystem4.service.impl;

import com.rating.Foodoutletsratingsystem4.entity.Bistro;
import com.rating.Foodoutletsratingsystem4.entity.Restaurant;
import com.rating.Foodoutletsratingsystem4.repository.BistroRepository;
import com.rating.Foodoutletsratingsystem4.service.BistroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BistroServiceImp implements BistroService {

    private BistroRepository bistroRepository;

    public BistroServiceImp(BistroRepository bistroRepository) {
        this.bistroRepository = bistroRepository;
    }

    @Override
    public List<Bistro> getAllBistros() {
        return bistroRepository.findAll();
    }

    @Override
    public Bistro saveBistro(Bistro bistro) {
        return bistroRepository.save(bistro);
    }

    @Override
    public Bistro getBistroById(Long id) {
        return bistroRepository.findById(id).get();
    }

    @Override
    public Bistro updateBistro(Bistro bistro) {
        return bistroRepository.save(bistro);
    }

    @Override
    public void deleteBistroByid(Long id) {
         bistroRepository.deleteById(id);
    }


}
