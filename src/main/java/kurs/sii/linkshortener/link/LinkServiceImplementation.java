package kurs.sii.linkshortener.link;

import kurs.sii.linkshortener.controller.LinkDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
class LinkServiceImplementation  implements  LinkService{

    //private final Map<String, LinkDto> linkRepository;
    private final LinkRepository linkRepository;

    LinkServiceImplementation(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    //LinkServiceImplementation(){
   //     this.linkRepository=new HashMap<>();
   // }

    @Override
    public LinkDto createLink(LinkDto toDto) {
         linkRepository.save(LinkEntity.fromDto(toDto));
    return toDto;
    }
}
