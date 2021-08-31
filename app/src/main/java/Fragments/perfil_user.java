package Fragments;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.wuad.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Random;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class perfil_user extends Fragment {
    GoogleSignInClient mGoogleSignInClient;
    ImageView image_user,image_ok,image_edit;
    TextView name_user,email,alias;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.perfil_user,container,false);
        image_user=view.findViewById(R.id.image_user);
        name_user=view.findViewById(R.id.NameUser);
        email=view.findViewById(R.id.setmail);
        alias=view.findViewById(R.id.setAlias);
        image_ok=view.findViewById(R.id.ok);
        image_edit=view.findViewById(R.id.edit);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());

        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();
            name_user.setText(personName);
            email.setText(personEmail);
            Glide.with(this).load(personPhoto).override(200, 200).into(image_user);
            generateAliasRandom();

        }


        return  view;

    }

    public void generateAliasRandom(){
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        alias.setText(sb);
    }
}
