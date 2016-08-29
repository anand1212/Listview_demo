package com.example.qtm_android.listview_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class MainActivity extends Activity {
    // Array of strings...
    EditText editText;
    Button button;
    Button del;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edt_txt);
        // Get reference of widgets from XML layout
        final ListView lv = (ListView) findViewById(R.id.list_data);
        final Button btn = (Button) findViewById(R.id.btn_add);


        // Initializing a new String Array
        String[] fruits = new String[]{
                "Cape Gooseberry",
                "Capuli cherry"
        };

        // Create a List from String Array elements
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        // Create an ArrayAdapter from List
         final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, R.layout.row,R.id.ttt,fruits_list);

        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add new Items to List
               if(editText.getText().toString().equals(""))
               {
                   Toast.makeText(MainActivity.this,"PLease enter Text",Toast.LENGTH_LONG).show();
               }
                else
               {
                   String newitem = editText.getText().toString();
                   fruits_list.add(newitem);

                /*
                    notifyDataSetChanged ()
                        Notifies the attached observers that the underlying
                        data has been changed and any View reflecting the
                        data set should refresh itself.
                 */
                   arrayAdapter.notifyDataSetChanged();
                   editText.setText(null);
               }


            }
        });


    }
}