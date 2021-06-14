package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int price;
    private String airportDeparture;
    private String airportArrival;
    private int flightTimeInMinutes;

    @Override
    public int compareTo(TicketOffer o) {
        return this.price - o.price;
    }
}
