# Week 4 Homework

These five standalone Java programs demonstrate constructors, overloaded constructors, inheritance, static initialization, `final` methods, and runtime type checks.

The examples use standard Java 8 language features and can be compiled with a Java 8 or newer JDK.

## Structure

| File | Exercise |
| --- | --- |
| `A1_Hackathon.java` | Participant registration and default teams |
| `A2_Canteen.java` | Item stock and restocking |
| `A3_Parking.java` | Parking fine calculation |
| `A4_Library.java` | Membership cards and static library information |
| `A5_Payment.java` | Cash/card payments and processing fees |

Each file contains one public class whose name matches the filename. The supporting model class remains package-private so the examples can be compiled independently without a package setup.

## Compile and run

From this directory:

```bash
javac A1_Hackathon.java A2_Canteen.java A3_Parking.java A4_Library.java A5_Payment.java
java A1_Hackathon
java A2_Canteen
java A3_Parking
java A4_Library
java A5_Payment
```

Generated `.class` files are build output and should not be committed.
