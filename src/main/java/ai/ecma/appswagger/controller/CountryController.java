package ai.ecma.appswagger.controller;

import ai.ecma.appswagger.entity.Country;
import ai.ecma.appswagger.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

/**
 * BY SIROJIDDIN on 23.12.2020
 */


@RestController
@RequestMapping("/api/country")
@Api(description = "Davlatlarni CRUD qilish")
public class CountryController {
    @Autowired
    CountryService countryService;
    @Autowired
    JavaMailSender javaMailSender;


    @GetMapping
    @ApiOperation(value = "Returns list of all davlatlar", notes = "Uxlamang")
    public HttpEntity<?> getCountries() {
        return ResponseEntity.ok(countryService.getCountryList());
    }

    @PostMapping
    public HttpEntity<?> addCountry(@ApiParam(value = "Bu yerga davlat haqida json qilib bering", example = "SHunaqa")
                                    @RequestBody Country country) {
        return ResponseEntity.ok(countryService.saveCountry(country));
    }


    @GetMapping("/sendEmail")
    public String sendEMail(@RequestParam String pochta, @RequestParam String title, @RequestParam String xabarMatni) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(pochta);
        message.setSubject(title);
        message.setText(xabarMatni);
        javaMailSender.send(message);
        return "Ok hammasi";
    }
}
