package android.alex.edu.moreimplicitentents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by Alex on 17-Apr-17.
 */

public class IntentUtils
{
    public static boolean canOpen(Intent intent, PackageManager packageManager)
    {
        return intent.resolveActivity(packageManager) != null;
    }

    public static boolean isM()
    {
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
       {
           return true;
       }
       else
       {
           return false;
       }
    }

}
