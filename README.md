# Step Semester 3

Java practice solutions organized by week. The exercises move from basic
control flow and arrays to strings, file handling, object-oriented programming,
inheritance, and small real-world models.

## Why This Repository Exists

Each program focuses on one practical programming skill. Reading the examples
in order helps connect the syntax to a reason for using it: first make reliable
decisions with data, then organize that logic into reusable objects and models.

## Week 1: Basic Logic and Arrays

This week builds confidence with loops, conditions, arrays, counters, and
simple calculations. These are the building blocks used in every later
program.

- `ExamHallSeatDuplicationChecker.java`: Checks seat assignments and reports duplicate seats. This is useful for learning how to compare values and protect a system from repeated allocations.
- `MovieReviewWordLengthProfiler.java`: Measures word lengths in movie reviews and summarizes them. This practices scanning text, counting values, and finding patterns.
- `TrafficSignalStreakAnalyzer.java`: Analyzes consecutive traffic-signal values to find streaks. This demonstrates state tracking while processing a sequence.
- `TypingSpeedTestAccuracyChecker.java`: Calculates typing performance and checks answer accuracy. This connects string comparison with practical metrics.
- `WarehouseInventoryBalancer.java`: Compares inventory values and helps balance stock. This practices array processing and decision-making with quantities.

## Week 2: Strings, Validation, and Files

This week introduces defensive input handling, string cleanup, maps, and CSV
processing. These skills matter because real programs receive imperfect text
and data from users and files.

- `AtmPinValidator.java`: Validates ATM PIN input against length and formatting rules. This shows how validation prevents invalid data from reaching application logic.
- `FilteredWordFrequencyReport.java`: Counts words after filtering and produces a frequency report. This practices tokenization, filtering, and map-based counting.
- `LibraryIsbnNormalizer.java`: Cleans and normalizes ISBN values. This demonstrates converting inconsistent user input into a consistent format.
- `ProductInventoryCsvParser.java`: Reads product records from CSV-style data and extracts inventory information. This introduces delimiter-based parsing and structured file data.
- `WordReversalEncoder.java`: Reverses words to create a simple encoded form. This practices character and string manipulation.

## Week 3: Object-Oriented Programming

The main goal is to model real entities as classes. Fields represent state,
constructors establish valid objects, and methods keep related behavior close
to the data it uses.

- `Course.java`: Models course information and course behavior. This demonstrates creating objects with meaningful state.
- `MessWallet.java`: Models wallet operations and balance handling. This shows how methods can protect and update an object's state.
- `PlacementRecord.java`: Represents placement information for a student or candidate. This practices grouping related fields into one domain model.
- `SharedIdCard.java`: Demonstrates shared ID-card information using class-level data. This explains when `static` state belongs to the class rather than one object.

### Week 3 Homework

- `BookInventory.java`: Models books and inventory operations. This practices object state and inventory actions.
- `CompanyStaff.java`: Models staff members in a company. This reinforces class design and relationships between objects.
- `Employee.java`: Defines employee data and behavior. This provides a reusable employee model for larger programs.
- `PayrollAccount.java`: Models payroll-account operations. This connects encapsulated account state with business rules.

## Week 4: OOP, Inheritance, and Modifiers

This week extends object-oriented design with inheritance, access modifiers,
overriding, and domain-specific calculations. The purpose is to reuse common
behavior while allowing specialized classes to add their own rules.

- `EmployeePayroll.java`: Calculates employee payroll values. This applies object data to a business calculation.
- `LateFees.java`: Calculates library late fees from borrowing information. This demonstrates turning policy rules into methods.
- `LibraryBook.java`: Models a library book and its state. This practices controlled updates such as borrowing and returning.
- `SrmStudent.java`: Models student information and related behavior. This reinforces encapsulation and class-level design.

### Week 4 Homework

- `CardPayment.java`: Models card-payment behavior. This is an example of representing a payment type with its own rules.
- `Item.java`: Models an inventory item and stock behavior. This practices fields, methods, and stock updates.
- `MembershipCard.java`: Models library membership-card behavior. This applies encapsulation to member information and permissions.
- `ParkingTicket.java`: Models a parking ticket and fine calculation. This turns a real-world penalty rule into object behavior.
- `Participant.java`: Models a hackathon participant. This demonstrates reusable participant data and behavior.

## Repository Structure

```text
week1/                  Basic logic and arrays
week2/                  Strings, validation, and file parsing
week3/                  Core object-oriented programming
week3/homework/         Additional OOP practice
week4/                  Inheritance, modifiers, and calculations
week4/homework/         Additional OOP practice
```

## Running a Program

From the directory containing a Java file:

```bash
javac FileName.java
java FileName
```

Replace `FileName` with the class name that contains the program entry point.