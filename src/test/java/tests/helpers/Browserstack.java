package tests.helpers;

import org.aeonbits.owner.ConfigFactory;
import tests.config.UserConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {
    static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());

    public static String getVideoUrl(String sessionId) {

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .auth().basic(userConfig.getUserName(), userConfig.getAccessKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}