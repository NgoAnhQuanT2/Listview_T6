package com.example.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraSua;
    ArrayList<TraSua> arrayTraSua;
    TraSuaAdapter adapter;
    int vitri=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Anhxa();
        adapter = new TraSuaAdapter(this, R.layout.dong_tra_sua, arrayTraSua);
        lvTraSua.setAdapter(adapter);

        lvTraSua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        lvTraSua.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
        lvTraSua.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Ngô Anh Quân");
                b.setMessage("Bạn có đồng ý xóa không ?");
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayTraSua.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = b.create();
                al.show();
                return false;
            }
        });
    }

    private void Anhxa() {
        lvTraSua = (ListView) findViewById(R.id.listview);
         arrayTraSua = new ArrayList<>();

         arrayTraSua.add(new TraSua("Frends", R.drawable.friends));
        arrayTraSua.add(new TraSua("Followers", R.drawable.follow));
        arrayTraSua.add(new TraSua("Following", R.drawable.favorite));
        arrayTraSua.add(new TraSua("Email", R.drawable.email));
        arrayTraSua.add(new TraSua("Skype", R.drawable.skype));
        arrayTraSua.add(new TraSua("Instagram", R.drawable.instagram));
    }
}