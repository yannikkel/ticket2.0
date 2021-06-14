package manager;

import domain.TicketOffer;
import domain.repository.TicketOfferRepository;
import exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketOfferManager {

    private TicketOfferRepository repository;

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticketOffer : repository.getAll()) {
            if (ticketOffer.getAirportDeparture().equalsIgnoreCase(from) && ticketOffer.getAirportArrival().equalsIgnoreCase(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticketOffer;
                result = tmp;
            }
        }
        if (result.length == 0) {
            throw new NotFoundException("Ticket offers with the airport of departure " + from + " and the airport of arrival " + to + " not found.");
        }
        Arrays.sort(result);
        return result;
    }

}
