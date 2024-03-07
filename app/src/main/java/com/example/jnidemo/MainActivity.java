package com.example.jnidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jnidemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'jnidemo' library on application startup.
    static {
        System.loadLibrary("jnidemo");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.jnidemo.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.textViewAnswer;
//        tv.setText(stringFromJNI());

        EditText editText1 = binding.editTextNumber1;
        EditText editText2 = binding.editTextNumber2;
        Button buttonAdd = binding.buttonSubmitAdd;
        Button buttonSub = binding.buttonSubmitSub;
        Button buttonSumOfArray = binding.buttonSumOfArray;

        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    String str1 = editText1.getText().toString();
                    String str2 = editText2.getText().toString();
                    if (str1.length() > 0 && str2.length() > 0) {
                        int num1 = Integer.parseInt(editText1.getText().toString());
                        int num2 = Integer.parseInt(editText2.getText().toString());
                        int ans = additionFromJNI(num1, num2);
                        tv.setText("Addition is: " + ans);
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter number1 and number2", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                try {
                    String str1 = editText1.getText().toString();
                    String str2 = editText2.getText().toString();
                    if (str1.length() > 0 && str2.length() > 0) {
                        int num1 = Integer.parseInt(editText1.getText().toString());
                        int num2 = Integer.parseInt(editText2.getText().toString());
                        int ans = subtractionFromJNI(num1, num2);
                        tv.setText("Subtraction is: " + ans);
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter number1 and number2", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonSumOfArray.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int ans = sumOfArrayFromJNI(new int[]{10, 20, 30, 40, 50});
                tv.setText("Sum Of Array is:" + ans);
            }
        });

    }

    /**
     * A native method that is implemented by the 'jnidemo' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();
    public native int additionFromJNI(int num1, int num2);

    public native int subtractionFromJNI(int num1, int num2);

    public native int sumOfArrayFromJNI(int[] intArray);
}