# NFC Attendance System

This Java-based NFC attendance system reads NFC tags and logs attendance in an Excel spreadsheet.
This was initially developed for the Pakistani Student Association at Rutgers University by Dayyan Hamid

## Requirements
- Java 8 (or higher)
- Apache POI library for Excel file handling
- USB NFC Reader 
- NFC tags/cards

## Setup
1. Install Java.
2. Install the necessary drivers for your NFC reader.
3. Add the required libraries to your project.
4. Connect the NFC reader to your USB port.

## Usage
1. Run the `NFCReader.java` file to start scanning NFC tags.
2. The `AttendanceSystem.java` file will record the UID of the scanned NFC tag along with the current timestamp into an Excel file (`attendance.xlsx`).

## How It Works
The system waits for an NFC tag to be scanned and reads its UID. The UID, along with the current timestamp, is logged in an Excel sheet for attendance tracking.
Most users were able to use a mobile app to generate and transmit the UID, allowing them to seamlessly check in by simply swiping their phones as they entered the room.



