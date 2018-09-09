    package esprit.tn.assuranceapp;

    import android.content.Context;
    import android.content.SharedPreferences;

    /**
     * Created by Mariam on 19/11/2017.
     */

    public class SharedPrefManager {
        private static SharedPrefManager mInstance;
        private static Context mCtx;

        private static final String SHARED_PREF_NAME = "mysharedpref12";
        private static final String KEY_USER_ID = "id";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_USER_EMAIL = "email";
        private static final String KEY_USER_NCIN = "ncin";
        private static final String KEY_USER_LNAME = "lname";
        private static final String KEY_USER_PHONE = "phone";
        private static final String KEY_USER_FNAME = "fname";
        //private static final String KEY_USER_Birthdate = "birthdate";



        private SharedPrefManager(Context context) {
            mCtx = context;

        }

        public static synchronized SharedPrefManager getInstance(Context context) {
           // if (mInstance == null) {
                mInstance = new SharedPrefManager(context);
           // }
            return mInstance;
        }

        /*public boolean userLogin(int id, String email, String username , String  ncin){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putInt(KEY_USER_ID, id);
            editor.putString(KEY_USERNAME, username);
            editor.putString(KEY_USER_EMAIL, email);
            editor.putString(KEY_USER_NCIN, ncin);



            editor.apply();

            return true;
        }*/


        public boolean userLogin(int id, String email, String username ,String phone ,  String fname , String lname,String  ncin){
        //String password, String lname, String phone ,String fname, String birthday
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putInt(KEY_USER_ID, id);
            editor.putString(KEY_USERNAME, username);
            editor.putString(KEY_USER_EMAIL, email);
            editor.putString(KEY_USER_PHONE, phone);
            editor.putString(KEY_USER_FNAME, fname);
            editor.putString(KEY_USER_LNAME, lname);
            editor.putString(KEY_USER_NCIN, ncin);


            //   editor.putString(KEY_USER_Birthdate, birthday);
            editor.apply();

            return true;
        }



        public boolean isLoggedIn(){
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            if(sharedPreferences.getString(KEY_USERNAME, null) != null){
                return true;
            }
            return false;
        }

        public boolean logout(){
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            return true;
        }



        public String getUserName(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USERNAME,null);

        }

        public String getUserEmail(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_EMAIL,null);

        }

        public String getlname(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_LNAME,null);

        }



        public String getphone(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_PHONE,null);

        }


        public String getfname(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_FNAME,null);

        }




        public String getNcin(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_USER_NCIN,null);

        }

        public int getUserID(){

            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
            return sharedPreferences.getInt(KEY_USER_ID,-1);

        }




    }
