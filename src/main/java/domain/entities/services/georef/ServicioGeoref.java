package domain.entities.services.georef;

import domain.entities.services.georef.entities.ListadoDeProvincias;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioGeoref {
    private static ServicioGeoref instancia = null;
    private Retrofit retrofit;
    private static final String urlApi = "https://apis.datos.gob.ar/georef/api/";

    private ServicioGeoref(){
        this.retrofit = new Retrofit.Builder().baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ServicioGeoref getInstancia(){
        if(instancia == null){
            instancia = new ServicioGeoref();
        }
        return instancia;
    }

    public ListadoDeProvincias listadoDeProvincias() throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeProvincias> requestListadoProvinciasArg = georefService.provincias();
        Response<ListadoDeProvincias> responseProvinciasArg = requestListadoProvinciasArg.execute();

        return responseProvinciasArg.body();
    }
}
