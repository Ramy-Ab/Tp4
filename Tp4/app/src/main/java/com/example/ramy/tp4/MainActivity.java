package com.example.ramy.tp4;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final List<Vacance> vacances = new ArrayList<Vacance>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListView mListView = (ListView) findViewById(R.id.list);


        vacances.add(new Vacance("Ramy Abadlia", "Ok",R.drawable.test));
        vacances.add(new Vacance("Ramy Abadlia", "Ok ;)",R.drawable.test));


                 final VacanceAdapter adapter = new VacanceAdapter(MainActivity.this, vacances);
                mListView.setAdapter(adapter);

                mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        final  int pos=i;

                        AlertDialog.Builder confirm = new AlertDialog.Builder(MainActivity.this);
                        confirm.setTitle("Suppression");
                        confirm.setIcon(android.R.drawable.ic_dialog_alert);
                        confirm.setMessage("Vous confirmez la suppression ?");

                        confirm.setPositiveButton(android.R.string.yes,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int i) {
                                        vacances.remove(pos);
                                        adapter.notifyDataSetChanged();
                                    }
                                });
                        confirm.setNegativeButton(android.R.string.no, null);
                        confirm.show();

                        return true;
                    }
                });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialogue);
            dialog.setTitle("Création");
            final EditText label = (EditText) dialog.findViewById(R.id.dialog_libelle);
            Button btnValider = (Button) dialog.findViewById(R.id.dialog_btn_valider);
            dialog.show();
            btnValider.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    vacances.add(new Vacance("Ramy Abadlia",label.getText().toString(),R.drawable.test));
                    dialog.dismiss();
                                                      }
                                                  });
        }
        return super.onOptionsItemSelected(item);
    }


        public class VacanceAdapter extends ArrayAdapter<Vacance> {
        List<Vacance> es;
        public VacanceAdapter(Context context, List<Vacance> vacances) {
            super(context, 0, vacances);
             es=vacances;}
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent, false);

            TextView nom = (TextView)convertView.findViewById(R.id.titre);
            TextView des = (TextView) convertView.findViewById(R.id.text);
            ImageView icon = (ImageView) convertView.findViewById(R.id.image);


            des.setText(es.get(position).getDescription());


            return convertView;
        }
    }

}

