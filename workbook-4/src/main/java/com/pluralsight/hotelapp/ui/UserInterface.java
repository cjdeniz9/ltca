package com.pluralsight.hotelapp.ui;

import com.pluralsight.hotelapp.model.*;
import com.pluralsight.hotelapp.service.EmployeeService;
import com.pluralsight.hotelapp.service.HotelManager;
import com.pluralsight.hotelapp.service.ReservationService;
import com.pluralsight.hotelapp.service.RoomService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInterface {

    private HotelManager manager = new HotelManager();

    private RoomService roomService = new RoomService();
    private ReservationService reservationService = new ReservationService();
    private EmployeeService employeeService = new EmployeeService();

    private Guest guest;
    private Room room;
    private Reservation reservation;
    private Employee employee;

    public UserInterface() {
        guest = new Guest("Ringo Deniz", "562-718-2010", "ringo.deniz@gmail.com");
        room = new Room(101, RoomType.KING, 1, 200.00, false, true);
        employee = new Employee(false, 1, "Christian Deniz", "Hotel Manager", "Management", 20.75, 40, null);
        reservation = new Reservation(
                guest,
                room,
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 13),
                false
        );
    }

    public void start() {
        String currentScreen = "home";

        while (!currentScreen.equals("exit")) {
            switch (currentScreen) {
                case "home" -> currentScreen = homeScreen();
                case "room" -> currentScreen = roomScreen();
                case "reservation" -> currentScreen = reservationScreen();
                case "employee" -> currentScreen = employeeScreen();
                default -> currentScreen = "home";
            }
        }

        System.out.println();

        System.out.println("Exiting...");

        manager.delay(1000);

        System.out.println("Thank you for using the Hotel Application!");
    }

    // ==================================================
    // DISPLAY METHODS
    // ==================================================

    private void displayHeader(String title) {
        System.out.println();

        System.out.println("===================================");
        System.out.println("        " + title);
        System.out.println("===================================");
    }

    private void updateGuestContactInfo() {
        System.out.print("Enter new phone number: ");
//        String phoneNumber = scanner.nextLine();

        System.out.print("Enter new email address: ");
//        String email = scanner.nextLine();

//        guest.updateContactInfo(phoneNumber, email);

        System.out.println("Guest contact information updated.");
    }

    private void updateEmployeeRole() {
        System.out.print("Enter new employee role: ");
//        String role = scanner.nextLine();

//        employeeService.assignRole(employee, role);
    }

    private void pause() {
        System.out.println();
        System.out.print("Press Enter to return to the menu...");
//        scanner.nextLine();
    }

    // ==================================================
    // INPUT METHODS
    // ==================================================

    private void bookRoom() {
        System.out.print("Would like to book a room/rooms today?: ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            handleReservation();
        } else {
            System.out.println();
            System.out.println("Returning to the home screen...");
            manager.delay(1000);
        }
    }

    private void handleReservation() {
        System.out.print("How many rooms would you like to book: ");

        int option = manager.getIntInput();


    }

    private void handleCheckIn() {
        System.out.println();

        System.out.println("-----------------------------------");
        System.out.print("Would you like to check into this room and reserve it for your stay? (yes/no): ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            room.checkIn();

            System.out.println();
            System.out.println("Processing check-in...");
            manager.delay(1000);

            System.out.println("Check-in completed successfully.");
            System.out.println("Enjoy your stay!");

        } else {
            System.out.println();
            System.out.println("Returning to the home screen...");
            manager.delay(1000);
        }
    }

    public void handleCheckOut() {
        System.out.println();

        System.out.println("-----------------------------------");
        System.out.print("Would you like to check out and make this room available again? (yes/no): ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            room.checkOut();

            System.out.println();
            System.out.println("Processing check-out...");
            manager.delay(1000);

            System.out.println("Check-out completed successfully.");
            System.out.println("Thank you for staying with us. We hope to see you again soon!");
        } else {
            System.out.println();
            System.out.println("Returning to the home screen...");
            manager.delay(1000);
        }
    }

    // ==================================================
    // UPDATE METHODS
    // ==================================================

    public void addTimeCardManually() {
        boolean running = true;

        while (running) {

            System.out.print("Enter clock-in time (24-hour format, whole hour): ");
            int clockInTime = manager.getIntInput();

            System.out.print("Enter clock-out time (24-hour format, whole hour): ");
            int clockOutTime = manager.getIntInput();

            double hoursWorked = employee.punchTimeCard(clockInTime, clockOutTime);
            employee.setHoursWorked(hoursWorked);

            System.out.println();
            System.out.println("Updated total hours worked: " + employee.getHoursWorked());

            System.out.println();
            System.out.print("Add another time card? (yes/no): ");

            String option = manager.getStringInput("yes", "no");

            if (option.equalsIgnoreCase("no")) {
                running = false;
            }

            System.out.println();
        }
    }

    public void addClockInAutomatically() {
        System.out.print("Would you like to clock in? (yes/no): ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            System.out.println("Clocking in...");

            employee.setWorking(true);
            employee.setClockedIn(employee.punchTimeCard());

            manager.delay(1000);

            System.out.println("Clocked in at: " +
                    employee.getClockedIn().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    public void addClockOutAutomatically() {
        System.out.print("Would you like to clock out? (yes/no): ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            System.out.println("Clocking out...");

            System.out.println("Clocked in at: " +
                    employee.getClockedIn().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

            employee.setWorking(false);

            LocalDateTime clockIn = employee.getClockedIn();
            LocalDateTime clockOut = employee.punchTimeCard();

            Duration duration = Duration.between(clockIn, clockOut);

            long hoursWorkedToday = duration.toHours();

            employee.setHoursWorked(employee.getHoursWorked() + hoursWorkedToday);

            employee.setClockedIn(null);

            System.out.println("Clocked out at: " +
                    clockOut.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

            System.out.println("Hours worked today: " + hoursWorkedToday);
            System.out.println("Total hours worked: " + employee.getHoursWorked());

            manager.delay(1000);
        }
    }

    public void addPunchTimeCard(Employee employee) {
        System.out.print("Select time card mode (manual/automatic): ");

        String option = manager.getStringInput("manual", "automatic");

        if (option.equalsIgnoreCase("manual")) {
            addTimeCardManually();
        } else {
            if (employee.getClockedIn() == null) {
                addClockInAutomatically();
            } else {
                addClockOutAutomatically();
            }
        }
    }

    // ==================================================
    // MENU METHODS
    // ==================================================

    private String homeMenu() {
        System.out.println("1. Room information");
        System.out.println("2. Reservation summary");
        System.out.println("3. Employee information");
        System.out.println("4. Exit");

        System.out.println();

        System.out.println("-----------------------------------");
        System.out.print("Choose an option: ");

        int option = manager.getIntInput(1, 2, 3, 4);

        return switch (option) {
            case 1 -> "room";
            case 2 -> "reservation";
            case 3 -> "employee";
            case 4 -> "exit";
            default -> "home";
        };
    }

    private String roomMenu() {
        if (room.isAvailable()) {
            handleCheckIn();
        } else {
            handleCheckOut();
        }

        return "home";
    }

    private String reservationMenu() {
        System.out.print("Would you like to return home? (yes/no): ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            return "home";
        } else {
            return "reservation";
        }

    }

    private String employeeMenu() {
        System.out.println("-----------------------------------");
        System.out.print("Would you like to add a time card entry? (yes/no): ");

        String option = manager.getStringInput("yes", "no");

        if (option.equalsIgnoreCase("yes")) {
            addPunchTimeCard(employee);
            return "employee";
        }

        System.out.println();

        System.out.println("Returning to home screen...");

        return "home";
    }

    // ==================================================
    // SCREEN METHODS
    // ==================================================

    private String homeScreen() {
        displayHeader("HOTEL APPLICATION");

        System.out.println();

        return homeMenu();
    }

    private String roomScreen() {
        displayHeader("ROOM INFORMATION");

        System.out.println();

        roomService.displayRoomInfo(room);
        return roomMenu();
    }

    private String reservationScreen() {
        displayHeader("RESERVATION SUMMARY");

        System.out.println();

        reservationService.displayReservationSummary(room, reservation);
        return reservationMenu();
    }

    private String employeeScreen() {
        displayHeader("EMPLOYEE INFORMATION");

        System.out.println();

        employeeService.displayEmployeeInfo(employee);
        return employeeMenu();
    }

}
