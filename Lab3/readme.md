Overview

This project demonstrates the Observer Design Pattern in Java. The pattern allows multiple observer objects to watch for changes in a subject object and react accordingly.

How It Works

The Subject class maintains a list of observers and notifies them of state changes.

The Observer class is an abstract class that is extended by concrete observer implementations:

BinaryObserver

OctalObserver

HexaObserver

Observers attach themselves to the subject and update when the subject's state changes.

Observers can be detached so they no longer receive updates.

How to Run

Compile all .java files in the project.

Run ObserverPatternDemo.java.

The console output will display state changes in binary, octal, and hexadecimal formats.

Key Features

Implements the Observer Pattern for real-time updates.

Demonstrates dynamic observer attachment/detachment.

Shows different number representations using Java's built-in methods.

Author

M. Talha Imran