package kurs.sii.linkshortener.link;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import kurs.sii.linkshortener.controller.LinkDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class LinkEntity {
    @Id
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;
    int visit;

    static LinkEntity fromDto(LinkDto linkDto){
        return LinkEntity
                .builder()
                .id(linkDto.id())
                .email(linkDto.email())
                .targetUrl(linkDto.targetUrl())
                .expirationDate(linkDto.expirationDate())
                .visit(linkDto.visit())
                .build();
    }

    LinkDto toDto(){
        return new LinkDto(id,email,targetUrl,expirationDate,visit);
    }
}
