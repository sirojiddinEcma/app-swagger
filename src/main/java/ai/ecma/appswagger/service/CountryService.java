package ai.ecma.appswagger.service;

import ai.ecma.appswagger.entity.Country;
import ai.ecma.appswagger.payload.ApiResponse;
import ai.ecma.appswagger.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BY SIROJIDDIN on 23.12.2020
 */


@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }

    public ApiResponse saveCountry(Country country) {
        countryRepository.save(country);
        return new ApiResponse("Salqlandi", true);
    }
}
