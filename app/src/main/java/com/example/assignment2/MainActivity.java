package com.example.assignment2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btLogin=findViewById(R.id.btLogin);
        final EditText editID=findViewById(R.id.editID);
        final EditText editPW=findViewById(R.id.editPw);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 EditText editID=findViewById(R.id.editID);
                 EditText editPW=findViewById(R.id.editPw);
                if (editID.getText().toString().equals("1")&&editPW.getText().toString().equals("1")) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }

            }
        });


    }
}
