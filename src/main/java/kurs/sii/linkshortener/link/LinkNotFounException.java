package kurs.sii.linkshortener.link;

public class LinkNotFounException extends Exception {
    public LinkNotFounException(final String id) {
       super("Link with id: " +id+" not found");
    }
}
