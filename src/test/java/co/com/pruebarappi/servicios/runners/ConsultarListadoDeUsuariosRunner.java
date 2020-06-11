package co.com.pruebarappi.servicios.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consultar_listado_de_usuarios.feature",
        glue = "co.com.pruebarappi.servicios.stepdefinitions",
        snippets = CAMELCASE
)
public class ConsultarListadoDeUsuariosRunner {
}
