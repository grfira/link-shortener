package kurs.sii.linkshortener.link;

import kurs.sii.linkshortener.controller.LinkDto;

public interface LinkService {
    LinkDto createLink(LinkDto toDto);

    LinkDto getLinkAndIncrementVisits(String id) throws LinkNotFounException;
}
