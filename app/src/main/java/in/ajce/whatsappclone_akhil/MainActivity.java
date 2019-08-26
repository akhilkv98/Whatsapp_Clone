package in.ajce.whatsappclone_akhil;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

    }

    public void login(View view) {

        String u,p;
        u=username.getText().toString();
        p=password.getText().toString();
        if(u.equals("")||p.equals("")) {
            Toast.makeText(MainActivity.this, "Enter details", Toast.LENGTH_SHORT).show();
        }
        else{
            if(u.equals("akhil")&&p.equals("akhil@123")) {
                Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
            }
        }
        }
}
