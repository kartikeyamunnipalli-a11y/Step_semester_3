import java.util.Arrays;

// ==========================================
// Base Class: GymMember
// ==========================================
class GymMember {
    private static int counter = 2000; // Counter starting for GYM-2001 format
    protected final String membershipNumber;
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended = 0;
    protected int feesPaid = 0;
    
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;

    // Problem 1 Constructor
    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        counter++;
        this.membershipNumber = "GYM-" + counter;
    }

    // Problem 5 Overloaded Constructor (auto-assigns membershipNumber)
    public GymMember(int monthlyFee) {
        counter++;
        this.membershipNumber = "GYM-" + counter;
        this.memberId = this.membershipNumber;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public static int getMembersEnrolled() {
        return counter - 2000;
    }

    // Problem 5 Overloaded Payment Methods
    public void payFee(int amount) {
        if (amount > 0) {
            feesPaid += amount;
        }
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    // Problem 3 Late Fee Logic
    protected void chargeLateFee(int amount) {
        if (amount > 0 && lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        int sum = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            sum += lateFeeHistory[i];
        }
        return sum;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    // Problem 1: Batch Sign-up
    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    // Problem 5: Referral Code Validator
    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        return code.charAt(0) == 'G' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    // Problem 5: Weekly Check-In Settlement
    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (members == null) return "0 processed | 0 null skipped | 0 group | 0 individual";

        for (GymMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof GroupClassMember) {
                    groupCount++;
                } else {
                    individualCount++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + 
               groupCount + " group | " + individualCount + " individual";
    }
}

// ==========================================
// Subclass: PremiumMember
// ==========================================
class PremiumMember extends GymMember {
    protected String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public PremiumMember(int monthlyFee, String trainerName) {
        super(monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    // Problem 3: Override Late Fee charging with half-discount
    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}

// ==========================================
// Problem 2 Subclasses
// ==========================================

// Multilevel Inheritance: GymMember -> PremiumMember -> EliteMember
class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + sessionsAttended;
    }
}

// Hierarchical Inheritance: GymMember -> GroupClassMember
class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + sessionsAttended;
    }
}

// ==========================================
// Public Driver / Utility Class
// ==========================================
public class assignment_gymmember {

    // Problem 2: Classification using instanceof alone
    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Direct descendant (2 generations deep)";
        } else {
            return "Base class generation";
        }
    }

    // Problem 2: Polymorphic Attendance Summation
    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (GymMember member : members) {
            if (member != null) {
                total += member.getSessionsAttended();
            }
        }
        return total;
    }

    // Problem 4: StringBuilder Announcement & Downcasting
    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (GymMember m : members) {
            if (m != null) {
                if (m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    sb.append("Premium | Trainer: ").append(pm.getTrainerName())
                      .append(" | Sessions: ").append(pm.getSessionsAttended())
                      .append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("] | ");
                } else {
                    sb.append("Standard | Sessions: ").append(m.getSessionsAttended()).append(" | ");
                }
            }
        }
        return sb.toString();
    }
}