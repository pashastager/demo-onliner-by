package api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    @Test
    public void test1() {
        String bodyRequest="_csrf=cYIlQIl1y3YhmJQhqC7SYOYogEEFO5lRhcR6q8l2ul80sHAKyx6CDnb5-xLlHes5slHmC3R30yS8iy6e-RDOKg%3D%3D&email=test%40test.by&password=123456&rememberMe=on";
        String url="https://tabletka.by/ajax-request/login";
        given()
                .body(bodyRequest)
                .header("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
                .header("Cookie","_ga=GA1.1.653080799.1730789025; regionId=0; PHPSESSID=496a7cdndt3f1opbjjs3591rk6; _csrf=9e817304cb04785c6cd6387c877587a53862a9ddf863555b663c2ab776eed854a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22E2UJBkIxWao3M39YTyfJqLJu9OT50ftu%22%3B%7D; __gads=ID=8889adfcc90e386c:T=1730789025:RT=1730997728:S=ALNI_MYaylsIH6BSwwhWKgtk-I3BdY5KFA; __gpi=UID=00000f2170cf7e88:T=1730789025:RT=1730997728:S=ALNI_MbMfEC3yPRUer4yBIkK8HjyzMgu3w; __eoi=ID=949003534434f772:T=1730789025:RT=1730997728:S=AA-Afjb_H3tYhlauCrfD_KCGS_4U; allow-cookies=; _ga_S6LL4MRH46=GS1.1.1730997727.3.1.1730997812.0.0.0")
                .header("X-Requested-With","XMLHttpRequest")


                .then()
                .log().all()
                .statusCode(200);
        //        .body()
    }

}
