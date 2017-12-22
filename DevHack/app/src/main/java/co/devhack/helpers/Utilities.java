package co.devhack.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by cdcalvo on 16/12/17.
 */

public class Utilities {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String saveImage(Context context, Bitmap imageBitmap) {
        OutputStream os = null;
        try {
            File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    "program",  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
            os = new FileOutputStream(image);
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);

            return image.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static String convertList(String str){
        return str != null ? str.replaceAll("\\|","\n") : "";
    }
}
