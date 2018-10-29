package prefernces.shared.delsol.com.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_AGE = "PREFS_AGE";
    private static final String PREFS_NAME = "PREFS_NAME";
    private static final String PREFS = "PREFS";
    EditText name, age;
    Button save;
    SharedPreferences sharedPreferences;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        save = findViewById(R.id.saveData);

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);

        if (sharedPreferences.contains(PREFS_AGE) && sharedPreferences.contains(PREFS_NAME)) {

            String age1 = sharedPreferences.getString(PREFS_AGE, null);
            String name1 = sharedPreferences.getString(PREFS_NAME, null);
            Log.d(PREFS, "Age: " + age1 + " name: " + name1);

            name.setText(name1);
            age.setText(age1 + " Years Old");
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences
                        .edit()
                        .putString(PREFS_AGE, age.getText().toString().trim())
                        .putString(PREFS_NAME, name.getText().toString().trim())
                        .apply();
                Toast.makeText(MainActivity.this, "Sauvegardé, relancez l'application pour voir le résultat", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
