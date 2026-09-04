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

#### Week 4 Homework (`feature/session-4`)

- [`A1_Hackathon.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/A1_Hackathon.java): Participant registration and default teams.
- [`A2_Canteen.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/A2_Canteen.java): Item stock and restocking.
- [`A3_Parking.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/A3_Parking.java): Parking fine calculation and validation.
- [`A4_Library.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/A4_Library.java): Membership cards and static library information.
- [`A5_Payment.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/A5_Payment.java): Cash/card payments and processing fees.
- [`CardPayment.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/CardPayment.java), [`Item.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/Item.java), [`MembershipCard.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/MembershipCard.java), [`ParkingTicket.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/ParkingTicket.java), and [`Participant.java`](https://github.com/kartikeyamunnipalli-a11y/Step_semester_3/blob/feature/session-4/week4/homework/Participant.java): Supporting homework model classes.

## Compile and Run

The programs are standalone examples and do not require a build tool or external dependencies. Use Java 8 or newer.

From the repository root, compile one file and run its public class:

```bash
javac week1/ExamHallSeatDuplicationChecker.java
java -cp week1 ExamHallSeatDuplicationChecker
```

For the Week 4 homework examples, first check out `feature/session-4`:

```bash
cd week4/homework
javac A1_Hackathon.java A2_Canteen.java A3_Parking.java A4_Library.java A5_Payment.java
java A1_Hackathon
java A2_Canteen
java A3_Parking
java A4_Library
java A5_Payment
```

Generated `.class` files are build output and should not be committed.

## Branches

- `main`: Consolidated repository contents and the single source of repository documentation.
- `feature/session-1`: Week 1 work.
- `feature/session-2`: Week 2 work.
- `feature/session-3`: Week 3 work.
- `feature/session-4`: Week 4 work and homework additions.

The root README on `main` is the authoritative overview. Individual exercise folders contain source files only.