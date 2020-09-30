package com.example.retroo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.text.StringSearch;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.collectapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Main> call = jsonPlaceHolderApi.getPosts("tr","istanbul");

        call.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {

                if(!response.isSuccessful()){
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }

                List<Post> posts = response.body().getResultData();

                for (Post post : posts){
                    String content ="";
                    content += "Date:" + post.getMain() + "\n";
                    content += "Day:" + post.getDay() + "\n";
                    content += "Icon:" + post.getIcon() + "\n";
                    content += "Description:" + post.getDescription() + "\n";
                    content += "Status:" + post.getStatus() + "\n";
                    content += "Degree:" + post.getDegree() + "\n";
                    content += "Min:" + post.getMin() + "\n";
                    content += "Max:" + post.getMax() + "\n";
                    content += "Night:" + post.getNight() + "\n";
                    content += "Humidity:" + post.getHumidity() + "\n\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {

                textViewResult.setText(t.getMessage());
            }
        });
    }
}