package sg.edu.rp.c346.id20037834.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etUserInputAdd;
    EditText etUserInputDelete;
    Button btnAdd;
    Button btnDelete;
    Button btnUpdate;
    Spinner spnAddDelete;
    ListView lvThingsToDo;

    ArrayList<String> alThingsToDo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserInputAdd = findViewById(R.id.etUserInput);
        etUserInputDelete = findViewById(R.id.etUserInput);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.btnDeleteColour);
        btnUpdate = findViewById(R.id.btnUpdateColour);
        spnAddDelete = findViewById(R.id.spnAddDelete);
        lvThingsToDo = findViewById(R.id.listViewColour);


        alThingsToDo = new ArrayList<String>();

        ArrayAdapter aaThingsToDo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alThingsToDo);
        lvThingsToDo.setAdapter(aaThingsToDo);

        if(alThingsToDo.isEmpty()){
            btnDelete.setActivated(false);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTasks = etUserInputAdd.getText().toString();
                alThingsToDo.add(newTasks);
                aaThingsToDo.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!alThingsToDo.isEmpty()) {
                    alThingsToDo.clear();
                    aaThingsToDo.notifyDataSetChanged();
                }
            }
        });

        spnAddDelete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        etUserInputAdd.setHint("Type in a new task here");
                        break;
                    case 1:
                        etUserInputDelete.setHint("Type in the index of the task to be removed");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"Nothing has been picked",Toast.LENGTH_SHORT).show();
            }
        });


//
//        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String colors = alColours.get(position);
//                Toast.makeText(MainActivity.this,"You have selected " + colors, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}