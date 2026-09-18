import java.util.Arrays;

// ==========================================
// PROBLEM 1 & Base Classes
// ==========================================
class LibraryMember {
    private static int counter = 100; // Counter starting for LIB-101 format
    protected final String memberNumber;
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed = 0;
    protected int[] fineHistory = new int[10];
    protected int fineCount = 0;

    // Problem 1 Constructor
    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        counter++;
        this.memberNumber = "LIB-" + counter;
    }

    // Problem 5 Overloaded Constructor (auto-assigns memberNumber)
    public LibraryMember(int borrowLimit) {
        counter++;
        this.memberNumber = "LIB-" + counter;
        this.memberId = this.memberNumber;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    // Problem 5 Overloaded Method
    public void borrowBook(String genre) {
        // Record genre if needed, then delegate to no-arg borrowBook()
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public static int getMembersEnrolled() {
        return counter - 100;
    }

    // Problem 3 Fine Logic
    protected void chargeFine(int amount) {
        if (amount > 0 && fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        // Returns defensive copy
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int sum = 0;
        for (int i = 0; i < fineCount; i++) {
            sum += fineHistory[i];
        }
        return sum;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    // Problem 1: Batch Enrollment Method
    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    // Problem 5: Renewal Code Validator
    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        return code.charAt(0) == 'R' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    // Problem 5: Nightly Circulation Audit
    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        if (members == null) return "0 processed | 0 null skipped | 0 faculty | 0 regular";

        for (LibraryMember m : members) {
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof FacultyMember) {
                    facultyCount++;
                } else {
                    regularCount++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + 
               facultyCount + " faculty | " + regularCount + " regular";
    }
}

// ==========================================
// Subclass: StudentMember
// ==========================================
class StudentMember extends LibraryMember {
    protected String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public StudentMember(int borrowLimit, String course) {
        super(borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    // Problem 3: Override Fine charging with discount
    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + booksBorrowed;
    }
}

// ==========================================
// PROBLEM 2 Subclasses
// ==========================================

// Multilevel Inheritance: LibraryMember -> StudentMember -> HonorsStudentMember
class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + course + " | Bonus Limit: " + bonusLimit + " | Books Borrowed: " + booksBorrowed;
    }
}

// Hierarchical Inheritance: LibraryMember -> FacultyMember
class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Books Borrowed: " + booksBorrowed;
    }
}

// ==========================================
// Utility Classes for Problem Solutions
// ==========================================

class Problem2Utils {
    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Direct descendant (2 generations deep)";
        } else {
            return "Base class generation";
        }
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember member : members) {
            if (member != null) {
                total += member.getBooksBorrowed(); // Polymorphic call
            }
        }
        return total;
    }
}

class Problem4Utils {
    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (LibraryMember m : members) {
            if (m != null) {
                if (m instanceof StudentMember) {
                    StudentMember sm = (StudentMember) m; // Safe downcast
                    sb.append("Student | Course: ").append(sm.getCourse())
                      .append(" | Books: ").append(sm.getBooksBorrowed())
                      .append(" [Course via downcast: ").append(sm.getCourse()).append("] | ");
                } else {
                    sb.append("General | Books: ").append(m.getBooksBorrowed()).append(" | ");
                }
            }
        }
        return sb.toString();
    }
}