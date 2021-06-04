package sg.edu.rp.c346.id20037834.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnDelete;
    Button btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.etTextColour);
        etIndexElement = findViewById(R.id.etPosition);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.btnDeleteColour);
        btnUpdate = findViewById(R.id.btnUpdateColour);
        lvColour = findViewById(R.id.listViewColour);


        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
//                alColours.add(colour)
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos,colour);
                aaColours.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (!alColours.isEmpty()) {
                    alColours.remove(pos);
                    aaColours.notifyDataSetChanged();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                String newItem = etElement.getText().toString();
                if(!alColours.isEmpty()){
                    alColours.set(pos,newItem);
                    aaColours.notifyDataSetChanged();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colors = alColours.get(position);
                Toast.makeText(MainActivity.this,"You have selected " + colors, Toast.LENGTH_SHORT).show();
            }
        });
    }
}