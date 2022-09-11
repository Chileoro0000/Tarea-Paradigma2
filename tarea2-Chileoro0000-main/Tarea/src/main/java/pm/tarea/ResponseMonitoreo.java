
package pm.tarea;

import DTO.DatosUsuario;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.codehaus.jackson.map.ObjectMapper;

class ResponseMonitoreo {
    //Funcion para optener los valores que necesitamos para el monitor atraves de GET
    public DatosUsuario GET(String hash) throws IOException, InterruptedException{
        String url = "https://sjlt81ef5i.execute-api.us-east-1.amazonaws.com/sensors?access_code=" + hash;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpClient cliente = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = respuesta.body();
        DatosUsuario info = new ObjectMapper().readValue(jsonResponse, DatosUsuario.class); //Generamos la informacion 
        
        return info; 
    }
    
}
