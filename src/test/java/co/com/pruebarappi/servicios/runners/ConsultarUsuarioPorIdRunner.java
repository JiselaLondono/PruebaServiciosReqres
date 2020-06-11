package co.com.pruebarappi.servicios.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consultar_usuario_por_id.feature",
        glue = "co.com.pruebarappi.servicios.stepdefinitions",
        snippets = CAMELCASE
)
public class ConsultarUsuarioPorIdRunner {
}
