package com.example.antivirus;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImageView bCookie=findViewById(R.id.galleta);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1519682214708-973477a2529a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
	    ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
	    ImageView men = findViewById(R.id.menu);
	    registerForContextMenu(men);

	    
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
	  getMenuInflater().inflate(R.menu.menu_actionbar,menu);
	  return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NotNull MenuItem item){
		int id = item.getItemId();
		if(id == R.id.item1){
			Snackbar snackbar = Snackbar.make(mLayout,"Borrado",Snackbar.LENGTH_SHORT).setAction("jaja",new View.OnClickListener(){
			 @Override
			 public void onClick(View view){
				 Snackbar snackbar1 = Snackbar.make(mLayout,"ok",Snackbar.LENGHT_SHORT);
				 snackbar1.show();
		 });
			snackbar.show(); 
			return true;
		}
		if(id == R.id.item2){
			Intent intent = new Intent(this,Profile.class);
			startActivity(intent);
			return true;
		}
		return false;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
		getMenuInflater().inflate(R.menu.menu_context,menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem menu) {
		
	}
}
