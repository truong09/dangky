package com.example.dangky;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-z]{2,}";
    public static final String passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%,.]).{6,20})";
    private Button btTieptuc;
    private EditText txtMail;
    private EditText txtPass;
    private TextView txtValidate;
    private TextView txtKT;
    //Validation
    private Boolean isValidMail = false;
    private Boolean isValidpPass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKT = (TextView) findViewById(R.id.txtKT);
        txtMail = (EditText) findViewById(R.id.txtMail);
        txtPass = (EditText) findViewById(R.id.txtPass);
        txtValidate = (TextView) findViewById(R.id.txtValidate);
        btTieptuc = (Button) findViewById(R.id.btTieptuc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtMail.getText().toString().trim();
                Toast.makeText(getApplicationContext(), "Bạn đang sử dụng email: "+email,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });
        txtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtKT.setText("");
                String pass = txtPass.getText().toString().trim();
                isValidpPass = (pass.matches(passPattern) && s.length()>0);
                if (!isValidpPass){
                    txtKT.setTextColor(Color.rgb(255, 0, 0));
                    txtKT.setText("0-9 && a-z && A-Z && @#$%.,");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //validation
        txtMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtValidate.setText("");
                String email = txtMail.getText().toString().trim();
                isValidMail = (email.matches(emailPattern) && s.length()>0);
                if (!isValidMail){
                    txtValidate.setTextColor(Color.rgb(255, 0,0));
                    txtValidate.setText("Email không hợp lệ");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
