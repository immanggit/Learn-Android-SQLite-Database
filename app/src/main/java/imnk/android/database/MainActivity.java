package imnk.android.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import imnk.android.database.Adapter.RecyclerAdapter;
import imnk.android.database.Adapter.RecyclerData;
import imnk.android.database.helper.DBHelper;

import static android.support.v7.widget.RecyclerView.VERTICAL;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private List<RecyclerData> dataList = new ArrayList<>();
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateData.class);
            startActivity(intent);
        });

        dataList = db.dataList();

        recyclerView = findViewById(R.id.rv_main_activity);
        adapter = new RecyclerAdapter(dataList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);
    }
}
