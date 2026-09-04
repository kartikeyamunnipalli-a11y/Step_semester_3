class ParkingTicket {
    private final String vehicleNo;
    private final double ratePerMinute;

    public ParkingTicket(String vehicleNo, double ratePerMinute) {
        if (ratePerMinute < 0) {
            throw new IllegalArgumentException("Rate cannot be negative");
        }
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    public final double calculateFine(int overstayMinutes) {
        if (overstayMinutes < 0) {
            throw new IllegalArgumentException("Overstay minutes cannot be negative");
        }
        return overstayMinutes * ratePerMinute;
    }

    public final void printReceipt(int overstayMinutes) {
        System.out.println(vehicleNo + " - Fine: Rs " + calculateFine(overstayMinutes));
    }
}

public class A3_Parking {
    public static void main(String[] args) {
        String[] vehicleNos = {"TN09AB1234", "TN22CD5678", "TN09EF9012", "TN10GH3456"};
        double[] rates = {2, 2, 3, 2};
        int[] overstayMinutes = {15, 0, -5, 8};

        for (int i = 0; i < vehicleNos.length; i++) {
            if (overstayMinutes[i] < 0) {
                System.out.println(vehicleNos[i] + " - Invalid overstay duration");
            } else if (overstayMinutes[i] > 0) {
                ParkingTicket ticket = new ParkingTicket(vehicleNos[i], rates[i]);
                ticket.printReceipt(overstayMinutes[i]);
            } else {
                System.out.println(vehicleNos[i] + " - No fine, within allotted time");
            }
        }
    }
}