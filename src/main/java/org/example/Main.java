package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> employees = new ArrayList<>();

    public static void main(String[] args) {
        function Function = new function();
        int choice;
        do {


            System.out.println("Добро пожаловать на кладбище 'У Антошки'");
            System.out.println("Меню:");
            System.out.println("1. Добавить нового сотрудника");
            System.out.println("2. Вывести сотрудников");
            System.out.println("3. Добавить усопшего");
            System.out.println("4. Вывести места");
            System.out.println("5. Вывести усопших");
            System.out.println("6. Список инвентаря");
            System.out.println("7. Добавить инвентарь");
            System.out.println("8. Ритуальные услуги");
            System.out.println("9. Вывести заказы");
            System.out.println("10. Выйти");
            System.out.print("Выберите действие: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    newEmployee();
                    break;
                case 2:
                    Function.Employee();
                    break;
                case 3:
                    Function.Users(Function.cemeteryPlaces);
                    break;

                case 4:
                    Function.Mesta();
                    break;

                case 5:
                    Function.Umershie();
                    break;
                case 6:
                    Invent();
                    break;
                case 7:
                    ShowInvent();
                    break;
                case 8:
                    RitualUslugi();
                    break;
                case 9:
                    ShowRitualUslugi();
                    break;
                case 10:
                    RIP();
            }
        }while (choice !=10);
    }

    public static void RIP(){
        System.out.println("Вы успешно вышли");

    }
    public static void newEmployee() {
        String[] positions = {"Менеджер", "Смотритель", "Кассир", "Землекоп", "SMM"};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.print("Введите отчество: ");
        String middleName = scanner.nextLine();

        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();

        System.out.println("Выберите должность:");
        for (int i = 0; i < positions.length; i++) {
            System.out.println((i + 1) + ". " + positions[i]);
        }
        System.out.println("Введите номер должности:");
        int positionIndex = scanner.nextInt();
        scanner.nextLine();

        if (positionIndex >= 1 && positionIndex <= positions.length) {
            employees.add("ФИО: " + firstName + lastName + middleName + " Должность: " + positions[positionIndex - 1]);
            System.out.println("Сотрудник успешно добавлен!");
        } else {
            System.out.println("Неверный номер должности!");
        }
    }

    static ArrayList<String> invent = new ArrayList<>();
    public static void Invent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название инвентаря: ");
        String nazvanie = scanner.nextLine();

        System.out.print("Введите количество: ");
        int kolvo = scanner.nextInt();

        System.out.print("Введите цену: ");
        BigDecimal cost = scanner.nextBigDecimal();

        invent.add(nazvanie);
        invent.add(String.valueOf(kolvo));
        invent.add(String.valueOf(cost));
        System.out.print("Инвентарь добавлен");


    }
    public static void ShowInvent(){
        if (invent.isEmpty()) {
            System.out.println("Список инвентаря пуст.");
        } else {
            System.out.println("Список инвентаря:");
            invent.forEach(System.out::println);
        }
    }
    public static ArrayList<String> zakaz = new ArrayList<>();
    public static void RitualUslugi(){
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;


        System.out.println("Доступные ритуальные услуги:");
        System.out.println("1. Деревянные гроб");
        System.out.println("2. Резной деревянный гроб");
        System.out.println("3. Певчая");
        System.out.println("4. Хор Турецкого");
        System.out.println("5. Отпевание с батюшкой");
        System.out.println("6. Металлический гроб");
        System.out.println("7. Венок 'От студентов МПТ'");
        System.out.println("8. Концерт Анны Асти");
        System.out.println("0. Завершить заказ");

        int choice;
        do {
            System.out.print("Выберите услугу (введите номер или 0 для завершения заказа): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    zakaz.add("Деревянные гроб");
                    totalCost += 1000.0;
                    break;
                case 2:
                    zakaz.add("Резной деревянный гроб");
                    totalCost += 500.0;
                    break;
                case 3:
                    zakaz.add("Певчая");
                    totalCost += 200.0;
                    break;
                case 4:
                    zakaz.add("Хор Турецкого");
                    totalCost += 15000.0;
                    break;
                case 5:
                    zakaz.add("Отпевание с батюшкой");
                    totalCost += 700.0;
                    break;
                case 6:
                    zakaz.add("Металлический гроб");
                    totalCost += 1900.0;
                    break;
                case 7:
                    zakaz.add("Венок 'От студентов МПТ'");
                    totalCost += 3000.0;
                    break;
                case 8:
                    zakaz.add("Концерт Анны Асти");
                    totalCost += 1500000.0;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 0);

        System.out.println("Ваш заказ:");
        for (String usluga : zakaz) {
            System.out.println("- " + usluga);
        }
        System.out.println("Сумма вашего заказа: " + totalCost + " руб.");
        System.out.println("Спасибо за заказ!");
        zakaz.add(String.valueOf(totalCost));
    }

    public static void ShowRitualUslugi(){
        if (zakaz.isEmpty()) {
            System.out.println("Список заказов.");
        } else {
            System.out.println("Список заказов:");
            zakaz.forEach(System.out::println);
        }
    }

    public static class function {
        ArrayList<ArrayList<String>> deceasedData = new ArrayList<>();
        ArrayList<Boolean> cemeteryPlaces = new ArrayList<>();

        ArrayList<String> user = new ArrayList<>();
        public static final int TOTAL_PLACES = 20;



        public void Employee() {
            if (employees.isEmpty()) {
                System.out.println("Список сотрудников пуст.");
            } else {
                System.out.println("Список сотрудников:");
                employees.forEach(System.out::println);
            }
        }

        public void Users(ArrayList<Boolean> cemeteryPlaces) { // Принимаем cemeteryPlaces как параметр
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите фамилию:");
            String surname = scanner.nextLine();

            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();

            System.out.println("Введите отчество:");
            String patronymic = scanner.nextLine();

            System.out.println("Введите дату рождения:");
            String dateOfBirth = scanner.nextLine();

            System.out.println("Введите дату смерти:");
            String dateOfDeath = scanner.nextLine();

            System.out.println("Введите номер свидетельства о смерти:");
            String deathCertificateNumber = scanner.nextLine();

            System.out.println("Введите причину смерти:");
            String causeOfDeath = scanner.nextLine();
            int place;
            System.out.println("Выберите место на кладбище (от 1 до " + TOTAL_PLACES + "):");
                for (int i = 0; i < cemeteryPlaces.size(); i++) {
                    if (!cemeteryPlaces.get(i)) {
                        System.out.println("Место " + (i + 1) + " свободно");
                    } else {
                        System.out.println("Место " + (i + 1) + " занято");
                    }
                }
                System.out.println("Введите номер места");
                place = scanner.nextInt();


            user.add(surname);
            user.add(firstName);
            user.add(patronymic);
            user.add(dateOfBirth);
            user.add(dateOfDeath);
            user.add(deathCertificateNumber);
            user.add(causeOfDeath);
            deceasedData.add(user);

            cemeteryPlaces.set(place - 1, true);

        }
        public void Mesta(){
            for (int i = 0; i < cemeteryPlaces.size(); i++) {
                if (!cemeteryPlaces.get(i)) {
                    System.out.println("Место " + (i + 1) + " свободно");
                } else {
                    System.out.println("Место " + (i + 1) + " занято");
                }
            }
        }
        public void Umershie(){
            if (user.isEmpty()) {
                System.out.println("Список усопших пуст.");
            } else {
                System.out.println("Список усопших:");
                user.forEach(System.out::println);
            }
        }
    }}

