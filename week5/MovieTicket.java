import java.util.Arrays;

// ==========================================
// PROBLEM 1 & 2: MovieTicket & AccessChecker
// ==========================================
class MovieTicket {
    private String seatNumber;
    int screenId; // package-private (default)[cite: 1]
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket(String seatNumber, int screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public static void main(String[] args) {
        CineHubSystem.main(args);
    }
}

class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                return (accessorContext.equals("SAME_CLASS") || 
                        accessorContext.equals("SAME_PACKAGE") || 
                        accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) ? "ALLOWED" : "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowedCount = 0;
        int deniedCount = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String result = classifyAccess(attempt[0], attempt[1]);
                    if ("ALLOWED".equals(result)) {
                        allowedCount++;
                    } else {
                        deniedCount++;
                    }
                }
            }
        }
        return "Allowed: " + allowedCount + "\nDenied: " + deniedCount;
    }
}

// ==========================================
// PROBLEM 3: CineScreen Encapsulation Guard
// ==========================================
class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}

// ==========================================
// PROBLEM 4: MovieBookingProfile JavaBean
// ==========================================
class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() { // JavaBean compliance for boolean[cite: 1]
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) { // Write-only property (no getter)[cite: 1]
        this.otp = otp;
    }
}

// ==========================================
// PROBLEM 5: Immutable Receipt & Settlement
// ==========================================
class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        // Defensive copy in constructor[cite: 1]
        this.seatNumbers = seatNumbers != null ? Arrays.copyOf(seatNumbers, seatNumbers.length) : new String[0];
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        // Defensive copy in getter[cite: 1]
        return Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) { // Wither pattern[cite: 1]
        String[] newSeats = Arrays.copyOf(seatNumbers, seatNumbers.length);
        if (index >= 0 && index < newSeats.length) {
            newSeats[index] = newSeat;
        }
        return new BookingReceipt(this.bookingId, newSeats);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

class NightlySettlementProcessor {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processedCount = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (receipts != null) {
            for (BookingReceipt receipt : receipts) {
                if (receipt == null) {
                    nullSkipped++;
                } else {
                    processedCount++;
                    if (receipt instanceof GroupBookingReceipt) { // instanceof dispatch[cite: 1]
                        groupCount++;
                    } else {
                        individualCount++;
                    }
                }
            }
        }

        return processedCount + " processed | " + nullSkipped + " null skipped\n" +
               groupCount + " group | " + individualCount + " individual";
    }
}

// ==========================================
// MAIN TEST DRIVER
// ==========================================
class CineHubSystem {
    public static void main(String[] args) {
        System.out.println("--- Testing Problem 1 & 2 ---");
        System.out.println("Private + SAME_CLASS: " + AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println("Protected + DIFFERENT_PACKAGE: " + AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println("Protected + OWN_TYPE: " + AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println("Protected + PARENT_TYPE: " + AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        
        String[][] batch = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(AccessChecker.summarizeBatch(batch));

        System.out.println("\n--- Testing Problem 3 ---");
        CineScreen screen = new CineScreen(2);
        screen.bookSeat();
        screen.bookSeat();
        screen.bookSeat(); // Exceeds limit, silently ignored
        System.out.println("Seats Available (expected 0): " + screen.getSeatsAvailable());

        System.out.println("\n--- Testing Problem 4 ---");
        MovieBookingProfile profile = new MovieBookingProfile("Rahul Dev");
        System.out.println("Profile Name: " + profile.getName());
        profile.setConfirmed(true);
        System.out.println("Is Confirmed: " + profile.isConfirmed());
        profile.setOtp("4471"); // Successfully sets write-only property without leakage

        System.out.println("\n--- Testing Problem 5 ---");
        BookingReceipt receipt = new BookingReceipt("CH-1001", new String[] {"A1", "A2"});
        BookingReceipt updatedReceipt = receipt.withUpdatedSeat(1, "A3");
        System.out.println("Updated Seat 1: " + updatedReceipt.getSeatNumbers()[1]);

        BookingReceipt[] nightBatch = {
            new GroupBookingReceipt("CH-2002", new String[] {"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[] {"C1"})
        };
        System.out.println(NightlySettlementProcessor.processNightlySettlement(nightBatch));
    }
}