package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    RecyclerView rStudents;
    private RecyclerView.LayoutManager layoutManager;
    private StudentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rStudents = findViewById(R.id.rStudent);
        layoutManager = new LinearLayoutManager(this);
        rStudents.setLayoutManager(layoutManager);

        mAdapter = new StudentAdapter(getApplicationContext());
        rStudents.setAdapter(mAdapter);

        final StudentRepository repository=StudentRepository.getInstance();

        final EditText editName,editID,editPW;
        Button btAdd= findViewById(R.id.btAdd);
        editName=findViewById(R.id.editName);
        editID=findViewById(R.id.editID);
        editPW=findViewById(R.id.editPw);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                int id = Integer.parseInt(editID.getText().toString());
                String pw = editPW.getText().toString();


                Student student = new Student();
                student.name = name;
                student.id = id;
                student.password = pw;

                repository.addStudent(student);

                mAdapter.update();

                // clear the fields
                editID.getText().clear();
                editName.getText().clear();
                editPW.getText().clear();

            }
        });




    }
}
