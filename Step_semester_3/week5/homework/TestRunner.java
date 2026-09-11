public class TestRunner {
    public static void main(String[] args) {
        System.out.println("========== PROBLEM 1 & 2: Access Checker ==========");
        testAccessChecker();
        
        System.out.println("\n========== PROBLEM 3: Book Inventory ==========");
        testBookInventory();
        
        System.out.println("\n========== PROBLEM 4: Library Member ==========");
        testLibraryMember();
        
        System.out.println("\n========== PROBLEM 5: Loan Receipt & Ledger ==========");
        testLoanReceipt();
    }
    
    static void testAccessChecker() {
        // Test Problem 1: Classify Access
        System.out.println("--- Problem 1: Classify Access ---");
        System.out.println("private + SAME_CLASS: " + AccessChecker.classifyAccess("private", "SAME_CLASS"));
        System.out.println("private + SAME_PACKAGE: " + AccessChecker.classifyAccess("private", "SAME_PACKAGE"));
        System.out.println("public + DIFFERENT_PACKAGE: " + AccessChecker.classifyAccess("public", "DIFFERENT_PACKAGE"));
        System.out.println("protected + SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE: " + AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        
        // Test Problem 1: Summarize by Modifier
        System.out.println("\n--- Problem 1: Summarize by Modifier ---");
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"default", "DIFFERENT_PACKAGE"}
        };
        System.out.println("Summary: " + AccessChecker.summarizeByModifier(attempts));
        
        // Test Problem 2: First Denied Attempt
        System.out.println("\n--- Problem 2: First Denied Attempt ---");
        System.out.println("First denied: " + AccessChecker.firstDeniedAttempt(attempts));
    }
    
    static void testBookInventory() {
        BookInventory inventory = new BookInventory(5);
        System.out.println("Initial state - Total: " + inventory.getCopiesTotal() + ", Available: " + inventory.getCopiesAvailable());
        
        inventory.checkOut();
        inventory.checkOut();
        System.out.println("After 2 checkouts - Available: " + inventory.getCopiesAvailable());
        
        inventory.checkIn();
        System.out.println("After 1 checkin - Available: " + inventory.getCopiesAvailable());
    }
    
    static void testLibraryMember() {
        LibraryMember member = new LibraryMember();
        member.setMembershipId("LIB-001");
        member.setName("John Doe");
        member.setPremiumMember(true);
        member.setSecurityAnswer("MySecret123");
        
        System.out.println("Membership ID: " + member.getMembershipId());
        System.out.println("Name: " + member.getName());
        System.out.println("Premium Member: " + member.isPremiumMember());
        System.out.println("(Security answer is write-only, not displayed)");
        
        // Try to set membershipId again - should not change
        member.setMembershipId("LIB-002");
        System.out.println("After attempting to change ID: " + member.getMembershipId() + " (unchanged, write-once property)");
    }
    
    static void testLoanReceipt() {
        String[] bookIds = {"BOOK-001", "BOOK-002", "BOOK-003"};
        LoanReceipt receipt = new LoanReceipt("MEM-456", bookIds);
        
        System.out.println("Member ID: " + receipt.getMemberId());
        System.out.println("Book IDs: " + java.util.Arrays.toString(receipt.getBookIds()));
        
        // Create corrected version using wither
        LoanReceipt correctedReceipt = receipt.withCorrectedBookId(1, "BOOK-999");
        System.out.println("Corrected Book IDs: " + java.util.Arrays.toString(correctedReceipt.getBookIds()));
        System.out.println("Original Book IDs (unchanged): " + java.util.Arrays.toString(receipt.getBookIds()));
        
        // Test ReferenceOnlyLoanReceipt
        System.out.println("\n--- Reference-Only Loan Receipt ---");
        ReferenceOnlyLoanReceipt refReceipt = new ReferenceOnlyLoanReceipt("MEM-789", new String[]{"REF-001", "REF-002"}, "ROOM-101");
        System.out.println("Reference Receipt - Member: " + refReceipt.getMemberId() + ", Room: " + refReceipt.getRoomNumber());
        
        // Test CirculationLedger
        System.out.println("\n--- Circulation Ledger ---");
        System.out.println("Branch Code: " + CirculationLedger.getBranchCode());
        
        LoanReceipt[] receipts = {receipt, refReceipt, null, correctedReceipt};
        String result = CirculationLedger.processNightlyCirculation(receipts);
        System.out.println("Nightly Circulation: " + result);
    }
}
