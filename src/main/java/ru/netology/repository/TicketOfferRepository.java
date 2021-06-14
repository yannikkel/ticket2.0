package domain.repository;

import domain.TicketOffer;
import exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketOfferRepository {
    private TicketOffer[] ticketOffers = new TicketOffer[0];

    public TicketOffer[] getAll() {
        return ticketOffers;
    }

    public void save(TicketOffer ticketOffer) {
        int length = ticketOffers.length + 1;
        TicketOffer[] tmp = new TicketOffer[length];
        System.arraycopy(ticketOffers, 0, tmp, 0, ticketOffers.length);
        tmp[tmp.length - 1] = ticketOffer;
        ticketOffers = tmp;
    }

    public TicketOffer findById(int id) {
        int i = 0;
        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getId() == id) {
                return ticketOffers[i];
            }
            i++;
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = ticketOffers.length - 1;
        TicketOffer[] tmp = new TicketOffer[length];
        int i = 0;
        for (TicketOffer ticketOffer : ticketOffers) {
            if (ticketOffer.getId() != id) {
                tmp[i] = ticketOffer;
                i++;
            }
        }
        ticketOffers = tmp;
    }
}
