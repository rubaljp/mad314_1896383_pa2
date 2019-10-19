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


        String name1 ="rahul" ;
        int id1 = 2;
        



         Student student1 = new Student();
        student1.name = name1;
        student1.id = id1;


        // add animal to repo
        repository.addStudent(student1);

        mAdapter.update();
        String name2 ="gres" ;
        int id2 = 3;




        Student student2 = new Student();
        student2.name = name2;
        student2.id = id2;


        // add animal to repo
        repository.addStudent(student2);

        mAdapter.update();

        //4th
        String name3 ="fghfghg" ;
        int id3 = 4;
        Student student3 = new Student();
        student3.name = name3;
        student3.id = id3;

        //5th
        String name4 ="fggjgfhg" ;
        int id4 = 5;
        Student student4 = new Student();
        student4.name = name4;
        student4.id = id4;


        // add animal to repo
        repository.addStudent(student3);

        mAdapter.update();
        //
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
