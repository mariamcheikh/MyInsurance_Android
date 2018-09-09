package esprit.tn.assuranceapp.Activities;

import android.Manifest;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;

import esprit.tn.assuranceapp.Activities.Constat.DisplayConstatUserActivity;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.Fragments.Constat.CirconstanceAFragment;
import esprit.tn.assuranceapp.R;

public class CameraActivity extends AppCompatActivity {
    boolean IMAGE_STATUS = false;
    static RequestQueue mRequestQueue = null;
    Button btncamera,addcamera;
    ImageView camera;

    String CONSTAT_ID;

String filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 19) {
            int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(CameraActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btncamera = (Button) findViewById(R.id.btncamera);
        camera = (ImageView) findViewById(R.id.camera);
        addcamera = (Button) findViewById(R.id.addcamera);


        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);

            }
        });
        addcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateImage()==true) {

                    AddImage(filePath, getApplicationContext());

                    //  startActivity(new Intent(getApplicationContext(),DisplayConstatAdminActivity.class));
                    //   finish();
                    startActivity(new Intent(CameraActivity.this, DisplayConstatUserActivity.class));
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            camera.setImageBitmap(bitmap);
            IMAGE_STATUS = true;
            Uri tempUri = getImageUri(getApplicationContext(), bitmap);
            filePath = getPath(tempUri, getApplicationContext());
        }
    }


    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        //inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }



    public static String getPath(Uri contentUri,Context ctx) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(ctx, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }


    public static void AddImage(final String imagePath, final Context ctx) {
        //Toast.makeText(ctx, "ahla", Toast.LENGTH_LONG).show();
        //Log.e("multpart",error.getMessage());
        SimpleMultiPartRequest smr = new SimpleMultiPartRequest(Request.Method.POST, Constants.URL_IMAGE_CAMERA,
                response -> {
                    Log.d("Response", response);

                    // JSONObject jObj = new JSONObject(response);
                    //   String message = jObj.getString("message");
                   // Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();

                }, error -> Toast.makeText(ctx, error.getMessage(), Toast.LENGTH_LONG).show());
        smr.setRetryPolicy(new DefaultRetryPolicy(10000,5,5));
        smr.addFile("img", imagePath);
        Log.i("file","hello"+imagePath);
        smr.addStringParam("constat_id", CirconstanceAFragment.CONSTAT_ID);
        Log.e("smr","smr");
        //MyApplication.getInstance().addToRequestQueue(smr);
        mRequestQueue = Volley.newRequestQueue(ctx);
        mRequestQueue.add(smr);

    }

    private boolean validateImage() {
        if (!IMAGE_STATUS)
            Toast.makeText(this, "Image cannot be empty", Toast.LENGTH_SHORT).show();
        return IMAGE_STATUS;
    }

}
