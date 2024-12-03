package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate newDay = today.plusDays(shift);
        return newDay.format(formatter);
    }

    public static String generateCity(String locale) {
        String[] cities = new String[]{
                "Тамбов", "Сыктывкар", "Ставрополь", "Смоленск", "Симферополь", "Севастополь", "Саратов", "Саранск",
                "Ярославль", "Якутск", "Южно-Сахалинск", "Элиста", "Чита", "Челябинск", "Чебоксары",
                "Ханты-Мансийск", "Хабаровск", "Уфа", "Ульяновск", "Улан-Удэ", "Тюмень", "Тула", "Томск", "Тверь",
                "Санкт-Петербург", "Самара", "Рязань", "Ростов-на-Дону", "Псков", "Петропавловск-Камчатский", "Петрозаводск",
                "Пермь", "Пенза", "Мурманск", "Москва", "Махачкала", "Магадан", "Липецк",
                "Курск", "Курган", "Красноярск", "Краснодар", "Кострома", "Киров", "Кемерово", "Калуга",
                "Калининград", "Казань", "Йошкар-Ола", "Иркутск", "Ижевск", "Иваново", "Екатеринбург",
                "Грозный", "Воронеж", "Вологда", "Волгоград", "Владимир", "Владикавказ", "Владивосток", "Великий Новгород",
                "Брянск", "Благовещенск", "Белгород", "Оренбург", "Орёл", "Омск", "Новосибирск", "Нижний Новгород", "Нальчик",
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();

    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)
            );

            return user;
        }
    }

    @Value //аннотоция ламбока - можно посмотреть , открыв refactor - delombook - не дает изменять объекты
    public static class UserInfo {
        String city;
        String name;
        String phone;

        public String getCity() {
        return city; }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}
