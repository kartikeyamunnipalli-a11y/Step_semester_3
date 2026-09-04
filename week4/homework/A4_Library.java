class MembershipCard {
    private static final String LIBRARY_NAME = "SRM Central Library";
    private static final String VALID_UNTIL = "May 2027";
    private final String studentName;

    static {
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public void printCard() {
        System.out.println("Membership card issued: " + studentName
                + " | " + LIBRARY_NAME + " | Valid until: " + VALID_UNTIL);
    }
}

public class A4_Library {
    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (String name : names) {
            new MembershipCard(name).printCard();
        }
    }
}