package br.impacta.go.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        for(int i=0; i< 10; i++) {
            HashMap<String, String> item = new HashMap<String, String>();
            item.put("Gustavo", "Oliveira "+ i);
            item.put("988887777", "922223333"+ i);
            list.add(item);
        }

        String[] from = new String[] {"Name", "Phone"};
        int[] to = new int[] {android.R.id.text1, android.R.id.text2};
        int layout = android.R.layout.two_line_list_item;
        
//        this.setListAdapter(new SimpleAdapter(this, list, layout, from, to));
        //setListAdapter(new SimpleAdapter(this, list, layout, from, to));
       // listV.setAdapter(new SimpleAdapter(this, list, layout, from, to));
    }
}
