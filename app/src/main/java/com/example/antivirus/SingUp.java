package com.example.antivirus;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SingUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sing_up);
        ImageView bCookie=findViewById(R.id.galleta);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1612388307727-afe00578ca21?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .transition(DrawableTransitionOptions
                        .withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.Purple)))
                .into(bCookie);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openLogIn(View v){
        Intent intent = new Intent(SingUp.this,LogIn.class);
        startActivity(intent);
    }

    public void openMain(View v){
        Intent intent = new Intent(SingUp.this,MainActivity.class);
        startActivity(intent);
    }

    public void openSingUp(View v){
        Intent intent = new Intent(SingUp.this,SingUp.class);
        startActivity(intent);
    }
}













