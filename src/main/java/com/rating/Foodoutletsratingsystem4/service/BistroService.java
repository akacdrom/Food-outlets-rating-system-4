package com.rating.Foodoutletsratingsystem4.service;

import com.rating.Foodoutletsratingsystem4.entity.Bistro;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BistroService {

    List<Bistro> getAllBistros();

    Bistro saveBistro(Bistro bistro);

    Bistro getBistroById(Long id);

    Bistro updateBistro(Bistro bistro);

    void deleteBistroByid(Long id);
}
