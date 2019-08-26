package in.ajce.whatsappclone_akhil;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ChatAdapter chatAdapter;

    TextView tv;
    TabLayout tab_layout;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView=findViewById(R.id.rv);
        getData();
        layoutManager = new LinearLayoutManager(Main2Activity.this);
        recyclerView.setLayoutManager(layoutManager);


        tv=findViewById(R.id.tv);
        tab_layout=findViewById(R.id.tabLayout);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "chats is selscted", Toast.LENGTH_SHORT).show();
            }
        });
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                    if(tab.getText().equals("Chats")){
                        tv.setText("CHAT SELECTED");
                    }
                    else if(tab.getText().equals("Status")){
                        tv.setText("STATUS SELECTED");
                    }
                    else if(tab.getText().equals("Calls")){
                        tv.setText("CALLS SELECTED");

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void getData(){
        String BASE_URL = "https://api.myjson.com/bins/";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<List<ChatModel>> call = api.getAllChats();

        call.enqueue(new Callback<List<ChatModel>>() {
            @Override
            public void onResponse(Call<List<ChatModel>> call, Response<List<ChatModel>> response) {
                loadData(response.body());
            }

            @Override
            public void onFailure(Call<List<ChatModel>> call, Throwable t) {

            }
        });
    }
    public void loadData(List<ChatModel> chatModelList){
Log.i("jis",chatModelList.size()+"");
        chatAdapter=new ChatAdapter(Main2Activity.this,chatModelList);
        recyclerView.setAdapter(chatAdapter);

    }
}
