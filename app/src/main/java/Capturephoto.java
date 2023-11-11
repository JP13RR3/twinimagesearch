import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.twinimagesearch.R;

import java.io.IOException;

public class Capturephoto extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_GALLERY_IMAGE = 2;
    private static final int REQUEST_IMAGES = 3;
    private static final int REQUEST_ALBUMS = 4;
    private static final int PICK_IMAGE = 5;

    private ImageButton btn_take_photo;
    private ImageButton btn_upload_photo;
    private Button btn_albums;
    private Button btn_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capturephoto);

        btn_take_photo = findViewById(R.id.btn_take_photo);
        btn_upload_photo = findViewById(R.id.btn_upload_photo);
        btn_albums = findViewById(R.id.btn_albums);
        btn_images = findViewById(R.id.btn_images);

        btn_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        btn_upload_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        btn_albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlbums();
            }
        });

        btn_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImages();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_GALLERY_IMAGE);
    }

    private void openAlbums() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("vnd.android.cursor.dir/album");
        startActivityForResult(intent, REQUEST_ALBUMS);
    }

    private void openImages() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                Intent intent = new Intent(this, PreviewActivity.class);
                intent.putExtra("bitmap", bitmap);
                startActivity(intent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }