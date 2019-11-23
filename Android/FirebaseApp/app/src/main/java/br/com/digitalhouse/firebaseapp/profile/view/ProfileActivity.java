package br.com.digitalhouse.firebaseapp.profile.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import br.com.digitalhouse.firebaseapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import pl.aprilapps.easyphotopicker.MediaFile;
import pl.aprilapps.easyphotopicker.MediaSource;

public class ProfileActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private CircleImageView imageViewProfile;
    private Button btnRegister;
    private ProgressBar progressBar;
    private EasyImage easyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnRegister = findViewById(R.id.btn_register);
        textInputLayoutName = findViewById(R.id.textinput_name);
        textInputLayoutEmail = findViewById(R.id.textinput_email);
        imageViewProfile = findViewById(R.id.imageview_profile);
        progressBar = findViewById(R.id.progressBar);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        textInputLayoutName.getEditText().setText(user.getDisplayName());
        textInputLayoutEmail.getEditText().setText(user.getEmail());

        imageViewProfile.setOnClickListener(view -> {

            int permissionCheckStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int permissionCheckCamera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

            if (permissionCheckStorage == PackageManager.PERMISSION_GRANTED && permissionCheckCamera == PackageManager.PERMISSION_GRANTED) {
                easyImage = new EasyImage.Builder(this).build();
                easyImage.openCameraForImage(this);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        easyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onMediaFilesPicked(MediaFile[] imageFiles, MediaSource source) {


                for (MediaFile imageFile : imageFiles) {
                    try {
                        InputStream stream = new FileInputStream(imageFile.getFile());
                        salvarImagem(stream);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onImagePickerError(@NonNull Throwable error, @NonNull MediaSource source) {
                //Some error handling
                error.printStackTrace();
            }

            @Override
            public void onCanceled(@NonNull MediaSource source) {
                //Not necessary to remove any files manually anymore
            }
        });
    }

    private void salvarImagem(InputStream stream) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        StorageReference storage = FirebaseStorage.getInstance().getReference().child(user.getUid() + "/image/profile");
        UploadTask uploadTask = storage.putStream(stream);

        uploadTask.addOnCompleteListener(task -> {
            storage.getDownloadUrl().addOnSuccessListener(uri -> {
                Picasso.get().load(uri).into(imageViewProfile);
            });
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }
}
