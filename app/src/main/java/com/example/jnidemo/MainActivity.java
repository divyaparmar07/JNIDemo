package com.example.jnidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jnidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'jnidemo' library on application startup.
    static {
        System.loadLibrary("jnidemo");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.textViewAnswer;
//        tv.setText(stringFromJNI());

        EditText editText1 = binding.editTextNumber1;
        EditText editText2 = binding.editTextNumber2;

        Button button = binding.buttonSubmitAdd;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    String str1 = editText1.getText().toString();
                    String str2 = editText2.getText().toString();
                    if (str1 != null && str1.length() >0 && str2 != null && str2.length() >0 ) {
                        int num1 = Integer.parseInt(editText1.getText().toString());
                        int num2 = Integer.parseInt(editText2.getText().toString());
//                Log.d("ans", "" + additionFromJNI(10, 20));
                        int ans = additionFromJNI(num1, num2);
//                int ans = num1+num2;
                        tv.setText("Addition is: " + ans);
                    } else {
                        // LOG
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * A native method that is implemented by the 'jnidemo' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int additionFromJNI(int num1, int num2);
}