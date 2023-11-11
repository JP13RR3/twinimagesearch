
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.twinimagesearch.R;

import java.io.File;

public class PreviewActivity extends AppCompatActivity {

    private ImageView previewImageView;
    private Button retakeButton;
    private Button findSimilarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Intent intent = getIntent();
        String imagePath = intent.getStringExtra("imagePath");

        previewImageView = findViewById(R.id.previewImageView);
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        previewImageView.setImageBitmap(bitmap);

        retakeButton = findViewById(R.id.retakeButton);
        retakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementa aquí la lógica para volver a tomar la foto
            }
        });

        findSimilarButton = findViewById(R.id.findSimilarButton);
        findSimilarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementa aquí la lógica para buscar imágenes similares
            }
        });
    }
}