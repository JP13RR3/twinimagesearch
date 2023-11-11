import static android.content.Intent.getIntent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.twinimagesearch.R;

import java.io.IOException;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        Bitmap bitmap = getIntent().getParcelableExtra("image");
        ImageView imageView = finalize(R.id.imageView);
        imageView.setImageBitmap(bitmap);

        ImageView selectAnotherButton = finalize(R.id.selectAnotherButton);
        selectAnotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowImage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView searchSimilarButton = finalize(R.id.searchSimilarButton);
        searchSimilarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementa aquí la lógica para buscar imágenes similares
            }
        });
    }

    private ImageView finalize(int imageView) {
    }
}