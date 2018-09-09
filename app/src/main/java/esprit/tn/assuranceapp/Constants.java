package esprit.tn.assuranceapp;


public class Constants {


   //private static final String ROOT_URL = "http://41.226.11.243:10080/assuranceapp/Android/v1/";
    private static final String ROOT_URL = "http://172.16.30.21/Android/v1/";
    public static final String URL_REGISTER = ROOT_URL+"register.php";
    public static final String URL_REGISTER_Subscriber = ROOT_URL+"registerSubscriber.php";
    public static final String URL_LOGIN = ROOT_URL+"login.php";
    public static final String URL_CONSTAT_INSERT = ROOT_URL+"InsertConstat.php";
    public static final String URL_CONTRAT_INSERT_INFO_PERSO = ROOT_URL+"updateInfosPersonnelles.php?ncin=";
    public static final String URL_CONTRAT_INSERT_PERMIS = ROOT_URL+"AddPermis.php?ncin=";
    public static final String URL_CONTRAT_INSERT_VEHICULE = ROOT_URL+"insererVoiture.php";
    public static final String URL_CONTRAT_INSERT_GARANTIES = ROOT_URL+"warranty.php";
    public static final String URL_CONTRAT_REFUSER_CONDITIONS = ROOT_URL+"refuserTerme.php";
    public static final String URL_IMAGE_CAMERA = ROOT_URL+"imagecamera.php";
    public static final String URL_IMAGE_ACCIDENT = ROOT_URL+"imageaccident.php";
    public static final String URL_IMAGE_SIGNIATURE = ROOT_URL+"imagessignature.php";
    public static final String URL_DISPLAY_CONSTAT_ADMIN = ROOT_URL+"displayConstatAdmin.php";
    public static final String URL_DISPLAY_CONSTAT_USER = ROOT_URL+"displayConstatUser.php?user_id=";
    public static final String URL_DISPLAY_CONTRAT_USER = ROOT_URL+"displayContratUser.php?ncin_owner=";
    public static final String URL_DISPLAY_CONTRAT_ADMIN = ROOT_URL+"displayContratAdmin.php";
  //  public static final String URL = "http://41.226.11.243:10080/assuranceapp/Android/assuranceapp/";
   public static final String URL = "http://172.16.30.21/Android/assuranceapp/";
    public static final String URL_LISTDRIVERS = ROOT_URL+"getalldrivers.php";
    public static final String URL_CREATE_TOKEN = URL+"createtoken.php";
    public static String URL_ADMIN_TOKEN = URL+"majAdminToken1.php";
    public static final String URL_GET_ADMIN_TOKEN = URL+"getAdminToken.php";
}
