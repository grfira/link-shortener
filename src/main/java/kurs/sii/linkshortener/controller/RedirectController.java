package kurs.sii.linkshortener.controller;

import jakarta.servlet.http.HttpServletResponse;
import kurs.sii.linkshortener.link.LinkNotFounException;
import kurs.sii.linkshortener.link.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping
class RedirectController {

    private final LinkService linkService;

    RedirectController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/s/{id}")
    // @ResponseBody
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity redirectLink(
            @PathVariable("id") String id, HttpServletResponse httpServletResponse) throws IOException {
        LinkDto linkAndIncrementVisits = null;
        try {
            linkAndIncrementVisits = linkService.getLinkAndIncrementVisits(id);
            //httpServletResponse.sendRedirect("https://github.com/greencashew/warsztaty-podstawy-springa");
            httpServletResponse.sendRedirect(linkAndIncrementVisits.targetUrl());
            return ResponseEntity.ok().build();
        } catch (LinkNotFounException e) {
            return ResponseEntity.notFound().build();
        }


    }


}
