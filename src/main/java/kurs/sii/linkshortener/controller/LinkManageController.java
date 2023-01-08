package kurs.sii.linkshortener.controller;


import kurs.sii.linkshortener.link.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/links")
class LinkManageController {
    private final LinkService linkService;
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
       return  linkService.createLink(link.toDto());
        //return link.toDto();
            }
}
