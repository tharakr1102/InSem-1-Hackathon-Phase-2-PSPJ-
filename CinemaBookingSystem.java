import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;

    // Parameterized constructor
    public MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    public double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    public double calculateDiscount() {
        double total = calculateTotal();
        if (numberOfTickets >= 5) {
            return total * 0.10;
        } else {
            return 0.0;
        }
    }

    public double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    public void displayBill() {
        double total = calculateTotal();
        double discount = calculateDiscount();
        double finalAmount = calculateFinalAmount();

        System.out.println("\n--- Booking Bill ---");
        System.out.println("Movie Name: " + movieName);
        System.out.printf("Ticket Price: $%.2f\n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.printf("Total Amount: $%.2f\n", total);
        System.out.printf("Discount: $%.2f\n", discount);
        System.out.printf("Final Amount: $%.2f\n", finalAmount);
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Movie Name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter Ticket Price: ");
        double ticketPrice = scanner.nextDouble();

        System.out.print("Enter Number of Tickets: ");
        int numberOfTickets = scanner.nextInt();

        MovieTicket ticketBooking = new MovieTicket(movieName, ticketPrice, numberOfTickets);

        ticketBooking.displayBill();

        scanner.close();
    }
}