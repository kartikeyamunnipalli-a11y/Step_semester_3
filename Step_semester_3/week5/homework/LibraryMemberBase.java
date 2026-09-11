import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

// ==========================================
// PROBLEM 1 & 2: Access Checker & Library Member
// ==========================================

class LibraryMemberBase {
    private String membershipPin;    // Only accessible inside LibraryMember
    String branchCode;              // Default access: accessible within same package
    protected double finesOwed;     // Accessible in same package and cross-package subclasses
    public String displayName;      // Accessible from anywhere
}

class AccessChecker {

    // Problem 1 & 2: Classify single attempt
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier) {
            case "public":
                return "ALLOWED";

            case "protected":
                if ("SAME_CLASS".equals(accessorContext) || 
                    "SAME_PACKAGE".equals(accessorContext) || 
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "default":
                if ("SAME_CLASS".equals(accessorContext) || 
                    "SAME_PACKAGE".equals(accessorContext)) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "private":
                if ("SAME_CLASS".equals(accessorContext)) {
                    return "ALLOWED";
                }
                return "DENIED";

            default:
                return "DENIED";
        }
    }

    // Problem 1: Grouped batch summary per modifier
    public static String summarizeByModifier(String[][] attempts) {
        // Build base map to preserve fixed order and ensure all 4 modifiers are present
        Map<String, int[]> map = new LinkedHashMap<>();
        map.put("private", new int[]{0, 0});   // index 0: allowed, index 1: denied
        map.put("default", new int[]{0, 0});
        map.put("protected", new int[]{0, 0});
        map.put("public", new int[]{0, 0});

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) continue;
                String mod = attempt[0];
                String ctx = attempt[1];

                if (map.containsKey(mod)) {
                    String res = classifyAccess(mod, ctx);
                    if ("ALLOWED".equals(res)) {
                        map.get(mod)[0]++;
                    } else {
                        map.get(mod)[1]++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            if (i > 0) sb.append(" ");
            int allowed = entry.getValue()[0];
            int denied = entry.getValue()[1];
            sb.append(entry.getKey()).append(": ").append(allowed).append(" allowed / ").append(denied).append(" denied");
            i++;
        }
        return sb.toString();
    }

    // Problem 2: Early-exit scan to find the first denied attempt
    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) return "None Denied";

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i] == null || attempts[i].length < 2) continue;
            String mod = attempts[i][0];
            String ctx = attempts[i][1];

            if ("DENIED".equals(classifyAccess(mod, ctx))) {
                return mod + " via " + ctx + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}

// ==========================================
// PROBLEM 3: BookInventory (Circulation Guard)
// ==========================================

class BookInventory {
    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = Math.max(0, copiesTotal);
        this.copiesAvailable = this.copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public int getCopiesTotal() {
        return copiesTotal;
    }
}

// ==========================================
// PROBLEM 4: LibraryMember (JavaBean Spec)
// ==========================================

class LibraryMember {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    // Public no-argument constructor required by JavaBeans
    public LibraryMember() {}

    // Write-Once Property for membershipId
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    // Standard Property for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Standard Property for boolean premium status
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    // Write-Only Property for securityAnswer (No getter exists)
    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            // One-way deterministic transformation (Simple Hash)
            this.securityAnswerHash = String.valueOf(answer.hashCode());
        }
    }
}

// ==========================================
// PROBLEM 5: Immutable Loan Receipt & Ledger
// ==========================================

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        // Defensive copy on constructor input
        if (bookIds != null) {
            this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
        } else {
            this.bookIds = new String[0];
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        // Defensive copy on getter output
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    // Wither method: returns a new updated immutable object
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) {
            return this;
        }
        String[] newBookIds = Arrays.copyOf(this.bookIds, this.bookIds.length);
        newBookIds[index] = newId;
        return new LoanReceipt(this.memberId, newBookIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {
    private static final String BRANCH_CODE;

    // One-time static initialization block
    static {
        BRANCH_CODE = "MAIN-BRANCH-01";
    }

    public static String getBranchCode() {
        return BRANCH_CODE;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processedCount = 0;
        int nullCount = 0;
        int referenceCount = 0;
        int regularCount = 0;

        if (receipts != null) {
            for (LoanReceipt receipt : receipts) {
                if (receipt == null) {
                    nullCount++;
                    continue;
                }
                processedCount++;
                if (receipt instanceof ReferenceOnlyLoanReceipt) {
                    referenceCount++;
                } else {
                    regularCount++;
                }
            }
        }

        return String.format("%d processed | %d null skipped | %d reference-only | %d regular",
                processedCount, nullCount, referenceCount, regularCount);
    }
}