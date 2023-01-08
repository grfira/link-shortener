package kurs.sii.linkshortener.link;

import jakarta.transaction.Transactional;
import kurs.sii.linkshortener.controller.LinkDto;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.HashMap;
import java.util.Optional;

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
    public LinkDto createLink(final LinkDto toDto) {
         linkRepository.save(LinkEntity.fromDto(toDto));
    return toDto;
    }

    @Override
    @Transactional
    public LinkDto getLinkAndIncrementVisits (final String id) throws LinkNotFounException {
        final var linkEntity = linkRepository.findById(id).orElseThrow(()-> new LinkNotFounException(" Invalid; " +id));//albo "LinkEntity" insted of "var"
           linkEntity.setVisit(linkEntity.getVisit()+1);
       // LinkEntity linkEntity = linkRepository.findById(id).orElseThrow(()->new LinkNotFoundException ("Invalid client id: "+ id));
         //       //return linkRepository.findById(id).get().toDto();
        //linkEntity.setVisit(linkEntity.getVisit()+1);*/
        return linkEntity.toDto();
    }
}
