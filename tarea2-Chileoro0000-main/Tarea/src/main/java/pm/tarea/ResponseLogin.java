
package pm.tarea;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;


public class ResponseLogin {
    //Funcion para realizar un post al servidor y obtener el hash 
    public String POST(String usuario, String Contra) throws IOException, InterruptedException{
        URL url = new URL("https://sjlt81ef5i.execute-api.us-east-1.amazonaws.com/login");
        String datos = "{\n\"username\": \"" + usuario + "\",\n\"password\":\"" + Contra + "\"\n}"; 
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setConnectTimeout(5000);
        conexion.setRequestProperty("Content-Type", "application/json");
        conexion.setDoOutput(true);
        conexion.setDoInput(true);
        conexion.setRequestMethod("POST");
        try (OutputStream os = conexion.getOutputStream()) {
            os.write(datos.getBytes());
        }
        if(conexion.getResponseCode() == 500){
            return "500"; //retornamos 500 si no podemos contactarnos con el servidor o API
        }
        InputStream in = new BufferedInputStream(conexion.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        String[] split = result.split("\"");
        if(conexion.getResponseCode() == 200){
            return split[5]; //Retorno el hash
        }
        return "500";
    }
}
