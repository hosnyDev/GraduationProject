package com.academy.motatwera;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

	 private GoogleMap mMap;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  Bar();
		  setContentView(R.layout.activity_maps);
		  // Obtain the SupportMapFragment and get notified when the map is ready to be used.
		  SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				  .findFragmentById(R.id.map);
		  mapFragment.getMapAsync(this);
	 }


	 /**
	  * Manipulates the map once available.
	  * This callback is triggered when the map is ready to be used.
	  * This is where we can add markers or lines, add listeners or move the camera. In this case,
	  * we just add a marker near Sydney, Australia.
	  * If Google Play services is not installed on the device, the user will be prompted to install
	  * it inside the SupportMapFragment. This method will only be triggered once the user has
	  * installed Google Play services and returned to the app.
	  */
	 @Override
	 public void onMapReady(GoogleMap googleMap) {
		  mMap = googleMap;

		  // Add a marker in Sydney and move the camera
		  LatLng sydney = new LatLng(29.994755 , 31.163256);
		  mMap.addMarker(new MarkerOptions().position(sydney).title("المعهد العالى للدراسات المتطورة")).showInfoWindow();
		  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

		  // control in map
		  googleMap.getUiSettings().setZoomControlsEnabled(true);

		  // set zoom in first marker
		  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney , 13));

	 }

	 //  Method To change  status bar color
	 private void Bar() {

		  Window window = getWindow();
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP ) {
			   window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			   SystemBarTintManager tintManager = new SystemBarTintManager(this);
			   tintManager.setStatusBarTintEnabled(true);
			   tintManager.setTintColor(ContextCompat.getColor(this , R.color.colorPrimary));
		  }
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
			   window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
			   window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
		  }

	 }

}
