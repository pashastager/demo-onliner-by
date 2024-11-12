package api;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class Booking {

    @Test
    public void test1() {
        Faker faker = new Faker();

        //ГЕНЕРАТОР ДАТЫ
        // Генерируем базовую случайную дату (от сегодняшнего дня до конца года)
        LocalDate datecheckin = LocalDate.now().plusDays(faker.number().numberBetween(0, 365));
// Генерируем первую дату, добавляя случайное количество дней к базовой дате
        LocalDate datecheckout = datecheckin.plusDays(faker.number().numberBetween(1, 30));
        // Форматируем дату в формате yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String checkin = datecheckin.format(formatter);
        String checkout = datecheckout.format(formatter);

        //ГЕНЕРАТОР ИМЕНИ/ФАМИЛИИ
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();


        String body = "{\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"" + checkin + "\",\n" +
                "        \"checkout\": \"" + checkout + "\"\n" +
                "    },\n" +
                "    \"depositpaid\": false,\n" +
                "    \"firstname\": \"" + firstName + "\",\n" +
                "    \"lastname\": \"" + lastName + "\",\n" +
                "    \"roomid\": 32,\n" +
                "    \"email\": \"test@gmail.com\",\n" +
                "    \"phone\": \"+375291234567\"\n" +
                "}";
        String url = "https://automationintesting.online/booking/";
        given()
                .body(body)
                .header("Content-Type", "application/json")
                .when()
                .post(url)
                .then()
                .log().all()
                .statusCode(201)
                .body("booking.firstname", equalTo(firstName))
                .body("booking.lastname", equalTo(lastName))
                .body("booking.bookingdates.checkin", equalTo(checkin))
                .body("booking.bookingdates.checkout", equalTo(checkout))
                .body("booking.roomid", notNullValue()); //значение не равно null
    }
}