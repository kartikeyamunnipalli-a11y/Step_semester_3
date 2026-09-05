# Step Semester 3

Java practice solutions organized by week. Each week contains focused exercises, and nested `homework` folders contain the longer object-oriented programming assignments.

## Repository Structure

### Week 1: Basic Logic and Arrays

- [`ExamHallSeatDuplicationChecker.java`](week1/ExamHallSeatDuplicationChecker.java): Detect duplicate seat assignments.
- [`MovieReviewWordLengthProfiler.java`](week1/MovieReviewWordLengthProfiler.java): Profile word lengths in movie reviews.
- [`TrafficSignalStreakAnalyzer.java`](week1/TrafficSignalStreakAnalyzer.java): Analyze traffic signal streaks.
- [`TypingSpeedTestAccuracyChecker.java`](week1/TypingSpeedTestAccuracyChecker.java): Check typing speed and accuracy.
- [`WarehouseInventoryBalancer.java`](week1/WarehouseInventoryBalancer.java): Balance warehouse inventory values.

### Week 2: Strings, Validation, and Files

- [`AtmPinValidator.java`](week2/AtmPinValidator.java): Validate ATM PIN input.
- [`FilteredWordFrequencyReport.java`](week2/FilteredWordFrequencyReport.java): Produce a filtered word-frequency report.
- [`LibraryIsbnNormalizer.java`](week2/LibraryIsbnNormalizer.java): Normalize library ISBN values.
- [`ProductInventoryCsvParser.java`](week2/ProductInventoryCsvParser.java): Parse product inventory CSV data.
- [`WordReversalEncoder.java`](week2/WordReversalEncoder.java): Encode words by reversing their characters.

### Week 3: Object-Oriented Programming

- [`Course.java`](week3/Course.java): Course information and object behavior.
- [`MessWallet.java`](week3/MessWallet.java): Wallet operations and balance handling.
- [`PlacementRecord.java`](week3/PlacementRecord.java): Placement record modeling.
- [`SharedIdCard.java`](week3/SharedIdCard.java): Shared static ID-card information.

#### Week 3 Homework

- [`BookInventory.java`](week3/homework/BookInventory.java): Book inventory management.
- [`CompanyStaff.java`](week3/homework/CompanyStaff.java): Company staff modeling.
- [`Employee.java`](week3/homework/Employee.java): Employee data and behavior.
- [`PayrollAccount.java`](week3/homework/PayrollAccount.java): Payroll account operations.

### Week 4: OOP Inheritance and Modifiers

- [`EmployeePayroll.java`](week4/EmployeePayroll.java): Employee payroll calculations.
- [`LateFees.java`](week4/LateFees.java): Library late-fee calculations.
- [`LibraryBook.java`](week4/LibraryBook.java): Library book state and behavior.
- [`SrmStudent.java`](week4/SrmStudent.java): Student information modeling.

#### Week 4 Homework

- [`CardPayment.java`](week4/homework/CardPayment.java): Card payment behavior.
- [`Item.java`](week4/homework/Item.java): Inventory item and stock behavior.
- [`MembershipCard.java`](week4/homework/MembershipCard.java): Library membership card behavior.
- [`ParkingTicket.java`](week4/homework/ParkingTicket.java): Parking ticket and fine behavior.
- [`Participant.java`](week4/homework/Participant.java): Hackathon participant modeling.

### Week 5: Encapsulation, Access Control, and Immutability

All five questions are implemented in one file:
[`MovieTicket.java`](week5/MovieTicket.java).

1. **MovieTicket fields:** Demonstrates Java access modifiers using private,
	package-private, protected, and public fields.
2. **AccessChecker:** Classifies whether a field access is allowed in different
	contexts and summarizes batches of access attempts.
3. **CineScreen:** Demonstrates encapsulation by validating screen capacity and
	safely handling seat booking, cancellation, and availability.
4. **MovieBookingProfile:** Implements JavaBean-style properties for a customer
	name and confirmation status, plus a write-only OTP property.
5. **BookingReceipt and settlement:** Demonstrates immutable receipt data with
	defensive array copies, a wither method for updated seats, inheritance through
	group receipts, and polymorphic nightly settlement processing.

Run the Week 5 test driver with:

```bash
cd week5
javac MovieTicket.java
java MovieTicket
```

