package com.example.antivirus;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

	private SwipeRefreshLayout swipeLayout;
	private WebView myWeb;
	private LottieAnimationView eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main);
		/*
		ImageView bCookie = findViewById(R.id.rodillo);
		Glide.with(this)
				.load("https://images.unsplash.com/photo-1519682214708-973477a2529a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
				.transition(DrawableTransitionOptions
						.withCrossFade(2000))
				.centerCrop()
				.placeholder(new ColorDrawable(this.getResources().getColor(R.color.Purple)))
				.into(bCookie);
		*/
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

		swipeLayout = findViewById(R.id.mySwipe);
		swipeLayout.setOnRefreshListener(mOnRefreshListener);
		myWeb = (WebView) findViewById(R.id.myWebView);
		WebSettings webSettings= myWeb.getSettings();
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		myWeb.loadUrl("https://thispersondoesnotexist.com/");
	}
	    
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
	  getMenuInflater().inflate(R.menu.menu_actionbar,menu);
	  return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item){
		ConstraintLayout mLayout = findViewById(R.id.main);
		int id = item.getItemId();
		if(id == R.id.item1) {
			Snackbar snackbar = Snackbar
					.make(mLayout, "Opciones", Snackbar.LENGTH_SHORT)
					.setAction("Aceptar", new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							Snackbar snackbar1 = Snackbar.make(mLayout, "Ok", Snackbar.LENGTH_SHORT);
							snackbar1.show();
						}
					});
			snackbar.show();
			return true;
		}
		if(id == R.id.item2){
			Toast toast2 = Toast.makeText(this, "Profile",
					Toast.LENGTH_LONG);
			toast2.show();
			Intent intent = new Intent(this,Profile.class);
			startActivity(intent);
			return true;
		}
		if(id == R.id.item3) {
			Snackbar snackbar = Snackbar
					.make(mLayout, "Not Available", Snackbar.LENGTH_SHORT)
					.setAction("jaja", new View.OnClickListener() {
						@Override
						public void onClick(View view) {
							Snackbar snackbar1 = Snackbar.make(mLayout, "ok", Snackbar.LENGTH_SHORT);
							snackbar1.show();
						}
					});
			snackbar.show();
			return true;
		}
		if(id == R.id.item4){

			Toast toast2 = Toast.makeText(this, "Sing Out",
					Toast.LENGTH_LONG);
			toast2.show();
			Intent intent = new Intent(this,LogIn.class);
			startActivity(intent);
			return true;
		}
		if(id == R.id.item5){
			showAlertDialogueButtonClicked(this);
		}
		return false;
	}



	protected SwipeRefreshLayout.OnRefreshListener
		mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
		@Override
		public void onRefresh() {
			Toast toast = Toast.makeText(MainActivity.this, "Refreshing...", Toast.LENGTH_LONG);
			toast.show();
			myWeb.reload();
			swipeLayout.setRefreshing(false);
		}
	};
	public void showAlertDialogueButtonClicked(MainActivity mainAlert){

		LayoutInflater inflater = LayoutInflater.from(this);
		LinearLayout dialogView = (LinearLayout) inflater.inflate(R.layout.lottie_animation_eyeseeyou, null);
		LottieAnimationView lottieAnimationView = dialogView.findViewById(R.id.eye);


		lottieAnimationView.playAnimation();

		MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(MainActivity.this);
		builder.setView(dialogView);
		builder.setTitle("Eye see you");
		builder.setMessage("Don't go!!!");
		builder.setCancelable(false);

		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				System.exit(1);
			}
		});

		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				dialogInterface.dismiss();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
	}


}
