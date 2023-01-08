package kurs.sii.linkshortener.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping
class RedirectController {
    @GetMapping("/s/{id}")
   // @ResponseBody
    //@ResponseStatus(HttpStatus.OK)
public void redirectLink(
        @PathVariable("id") String id, HttpServletResponse httpServletResponse) throws IOException{
       httpServletResponse.sendRedirect("https://github.com/greencashew/warsztaty-podstawy-springa");

    }



}
