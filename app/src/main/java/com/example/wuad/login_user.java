package com.example.wuad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class login_user extends AppCompatActivity {
    EditText name,alias,password,confirm_password,email;
    ImageView imageUser;
    Button register;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        name=findViewById(R.id.newName);
        alias=findViewById(R.id.newAlias);
        email=findViewById(R.id.newEmail);
        password=findViewById(R.id.newPassword);
        confirm_password=findViewById(R.id.ConfirmPassword);
        register=findViewById(R.id.buttonregister);
        imageUser=findViewById(R.id.image_user);
        message=findViewById(R.id.message);
        String Password=password.getText().toString();
        String confirmPassword=confirm_password.getText().toString();
        validatePassword(Password);
        comparePassword(Password,confirmPassword);


    }
    public void validatePassword(String Password){
        String resultado;
        int length = 0;
        int numCount=0;
        int capCount = 0;
        for (int x =0; x < Password.length(); x++) {
            if ((Password.charAt(x) >= 47 && Password.charAt(x) <= 58) || (Password.charAt(x) >= 64 && Password.charAt(x) <= 91) ||
                    (Password.charAt(x) >= 97 && Password.charAt(x) <= 122)) {
                //pass
            }

            if ((Password.charAt(x) > 47 && Password.charAt(x) < 58)) { //Cuenta la cantidad de números
                numCount=numCount+1;
            }

            if ((Password.charAt(x) > 64 && Password.charAt(x) < 91)) { // Cuenta la cantidad de mayuscula
                capCount=capCount+1;
            }
            length = (x + 1); // Cuenta la longitud del password

        }

        if (numCount < 1 && capCount < 1){ // Revisa que el password contenga como minimo 1 numero y una Mayuscula
            resultado = "La contraseña no tiene al menos una letra mayúscula y/o un número ";
            message.setText(resultado);
            password.setText("");
        }
        else{
            //pass
        }

        if (length < 8){  // Revisa la longitud minima de 8 caracteres del password
            resultado = "La contraseña no tiene el un un mínimo de 8 carácteres";
            message.setText(resultado);
            password.setText("");

        }
        else{
            //pass
        }
    }
    public void comparePassword(String Password,String confirmPassword){
        if(Password.equals(confirmPassword)){

        }
        else{

        }
    }
}
