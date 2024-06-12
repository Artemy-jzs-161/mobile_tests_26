package test.helpers;

import org.aeonbits.owner.ConfigFactory;
import test.config.BrowserstackConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {
    static final BrowserstackConfig browserstackConfig = ConfigFactory
            .create(BrowserstackConfig.class, System.getProperties());

    public static String getVideoUrl(String sessionId) {

        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .auth().basic(browserstackConfig.getUserName(), browserstackConfig.getAccessKey())
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}