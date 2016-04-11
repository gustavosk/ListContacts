package br.impacta.go.contactlist;

import android.database.Cursor;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListAdapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Cursor c = getContentResolver().query(Contacts.People.CONTENT_URI, null, null, null, null);
        startManagingCursor(c);

        String[] columns = new String[] {Contacts.People.NAME, Contacts.People.NUMBER};
        int[] campos = new int[]{R.id.name};

        adpter = new SimpleCursorAdapter(this, R.layout.layout_contatos, c, columns, campos);

        setListAdapter(adpter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Cursor c = (Cursor) adpter.getItem(position);
        String nome = c.getString(c.getColumnIndexOrThrow(Contacts.People.NAME));
        String fone = c.getString(c.getColumnIndexOrThrow(Contacts.People.NUMBER));
        Toast.makeText(this, "Contato: " + nome + fone, Toast.LENGTH_SHORT).show();
    }
}
