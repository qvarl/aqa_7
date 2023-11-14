package tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.InputStreamReader;

import models.JsonModel;
import org.junit.jupiter.api.Test;

public class JsonParseTest {

    ClassLoader cl = JsonParseTest.class.getClassLoader();

    @Test
    void jsonParse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try (
                InputStream resource = cl.getResourceAsStream("Json.json");
                InputStreamReader reader = new InputStreamReader(resource);
        ) {
            JsonModel jsonModel = mapper.readValue(reader, JsonModel.class);
            assertThat(jsonModel.image.height).isEqualTo(600);
            assertThat(jsonModel.image.visible).isTrue();
            assertThat(jsonModel.image.ids).contains(116);
        }
    }
}