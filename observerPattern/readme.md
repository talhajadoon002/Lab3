Overview

This project implements an event-driven file editor with a publisher-subscriber pattern. The editor notifies subscribed listeners when a file is opened or saved. The system includes email notifications, logging, and SMS support.

Features

Event-driven architecture using the Observer pattern.

Supports multiple listeners:

Email Notification Listener: Sends an email notification when a file is saved.

Log Open Listener: Logs when a file is opened.

SMS Support Listener: Sends an SMS notification when a file is saved.

Extended SMS Support Listener: Validates the SMS length before sending.

Technologies Used

Java

File Handling

Observer Pattern


Usage

The Editor class allows opening and saving files.

The Publisher manages event subscriptions.

The EventListener interface is implemented by various listeners.

The SMSSupportListener checks if the SMS length is more than 160 characters. If it is, a warning is displayed; otherwise, the SMS is sent.

Future Enhancements

Integrate actual email and SMS services.

Enhance logging with timestamps.

Improve error handling.