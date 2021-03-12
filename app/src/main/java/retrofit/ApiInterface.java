package retrofit;

import java.util.List;

import Model.FoodData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

@GET("fooddata.json")
    Call<List<FoodData>> getAllData();

}
