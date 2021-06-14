package manager;

import domain.TicketOffer;
import domain.repository.TicketOfferRepository;
import exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketOfferManagerTest {
    private TicketOfferRepository repository = new TicketOfferRepository();
    private TicketOfferManager manager = new TicketOfferManager(repository);
    private TicketOffer ticketOffer1 = new TicketOffer(1, 10_000, "LED", "DME", 90);
    private TicketOffer ticketOffer2 = new TicketOffer(2, 20_000, "LED", "DME", 130);
    private TicketOffer ticketOffer3 = new TicketOffer(3, 50_000, "LED", "VVO", 600);
    private TicketOffer ticketOffer4 = new TicketOffer(4, 15_000, "LED", "DME", 100);
    private TicketOffer ticketOffer5 = new TicketOffer(5, 45_000, "DME", "VVO", 550);
    private TicketOffer ticketOffer6 = new TicketOffer(6, 42_000, "DME", "VVO", 610);


    @BeforeEach
    public void setUp() {
        repository.save(ticketOffer1);
        repository.save(ticketOffer2);
        repository.save(ticketOffer3);
        repository.save(ticketOffer4);
        repository.save(ticketOffer5);
        repository.save(ticketOffer6);
    }

    @Test
    void shouldFindAllLEDtoDME() {
        TicketOffer[] actual = manager.findAll("LED", "DME");
        TicketOffer[] expected = new TicketOffer[] {ticketOffer1, ticketOffer4, ticketOffer2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllDMEtoVVO() {
        TicketOffer[] actual = manager.findAll("DME", "VVO");
        TicketOffer[] expected = new TicketOffer[] {ticketOffer6, ticketOffer5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenFindAll() {
        assertThrows(NotFoundException.class, () -> manager.findAll("VVO", "LED"));
    }
}
