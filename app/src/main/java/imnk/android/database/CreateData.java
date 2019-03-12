package imnk.android.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import imnk.android.database.helper.DBHelper;

public class CreateData extends AppCompatActivity {

    private EditText summary, description;
    private Button saveButton;
    private int status = 0;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_data);

        db = new DBHelper(this);

        summary = findViewById(R.id.et_summary);
        description = findViewById(R.id.et_description);
        saveButton = findViewById(R.id.btn_save);

        saveButton.setOnClickListener(view -> saveData());
    }

    private void saveData() {
        boolean isUpdate = db.insertData(summary.getText().toString(),
                description.getText().toString(),
                String.valueOf(status));

        if (isUpdate)
            Toast.makeText(this, "Data Update", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Data not Updated", Toast.LENGTH_LONG).show();
    }
}
