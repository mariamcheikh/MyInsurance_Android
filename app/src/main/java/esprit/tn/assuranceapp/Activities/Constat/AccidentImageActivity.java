package esprit.tn.assuranceapp.Activities.Constat;

/*import android.Manifest;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import esprit.tn.assuranceapp.Fragments.Constat.CirconstanceAFragment;
import esprit.tn.assuranceapp.R;
import java.io.ByteArrayOutputStream;
import esprit.tn.assuranceapp.Constants;

*/import android.Manifest;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.toolbox.Volley;
import java.io.ByteArrayOutputStream;
import com.android.volley.request.SimpleMultiPartRequest;
import esprit.tn.assuranceapp.Constants;
import esprit.tn.assuranceapp.Fragments.Constat.CirconstanceAFragment;
import esprit.tn.assuranceapp.R;




public class AccidentImageActivity extends AppCompatActivity {
     boolean IMAGE_STATUS = false;

    Button b1,submitcroquit;
    ImageView signImage;
    String filePath;
    String CONSTAT_ID;

    static RequestQueue mRequestQueue = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 19) {
            int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(AccidentImageActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_image);
        b1 = (Button) findViewById(R.id.getSign);
        submitcroquit = (Button) findViewById(R.id.submitcroquit);
        signImage = (ImageView) findViewById(R.id.imageView1);
        b1.setOnClickListener(onButtonClick);
        submitcroquit.setOnClickListener(onButtonClicktosigni);
    }

    Button.OnClickListener onButtonClick = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(AccidentImageActivity.this, CaptureSignature.class);
            startActivityForResult(i, 0);
        }
    };


    Button.OnClickListener onButtonClicktosigni = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            if (validateImage()==true){


            AddImage(filePath,CONSTAT_ID,getApplicationContext());

            // TODO Auto-generated method stub
            Intent i = new Intent(AccidentImageActivity.this, SignActivity.class);
            startActivityForResult(i, 0);
            }
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (resultCode == 1) {
            Bitmap b = BitmapFactory.decodeByteArray(
                    data.getByteArrayExtra("byteArray"), 0,
                    data.getByteArrayExtra("byteArray").length);
            signImage.setImageBitmap(b);
            IMAGE_STATUS = true;

            Uri tempUri = getImageUri(getApplicationContext(), b);
            filePath = getPath(tempUri,getApplicationContext());
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



    public static void AddImage(final String imagePath,String constat_id, final Context ctx) {
       // Toast.makeText(ctx, "ahla", Toast.LENGTH_LONG).show();
        //Log.e("multpart",error.getMessage());
        SimpleMultiPartRequest smr = new SimpleMultiPartRequest(Request.Method.POST, Constants.URL_IMAGE_ACCIDENT,
                response -> {
                    Log.d("Response", response);

                    // JSONObject jObj = new JSONObject(response);
                    //   String message = jObj.getString("message");
                    //Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();

                }, error -> {
            Toast.makeText(ctx, error.getMessage(), Toast.LENGTH_LONG).show();
            //                Log.e("multpart",error.getMessage());
        });
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







