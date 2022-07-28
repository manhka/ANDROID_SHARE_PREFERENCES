package manhnguyen.listview_practice.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tk, mk;
    Button dangnhap;
    CheckBox nho;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
         // get values from sharePreferences
        tk.setText(sharedPreferences.getString("taikhoan",""));
        mk.setText(sharedPreferences.getString("matkhau",""));
        nho.setChecked(sharedPreferences.getBoolean("checked",false));
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = tk.getText().toString().trim();
                String password = mk.getText().toString().trim();
                if (username.equals("MANHNGUYEN") && password.equals("123456")) {
                    if (nho.isChecked()){
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString("taikhoan",username);
                    editor.putString("matkhau",password);
                    editor.putBoolean("checked",true);
                    editor.commit();
                }else {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        tk = (EditText) findViewById(R.id.editTextTextPersonName);
        mk = (EditText) findViewById(R.id.editTextTextPassword);
        dangnhap = (Button) findViewById(R.id.button);
        nho = (CheckBox) findViewById(R.id.checkBox);
    }
}