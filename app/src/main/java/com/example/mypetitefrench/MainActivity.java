package com.example.mypetitefrench;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static String[] diseases = {"Hip Dysplasia", "Brachycephalic Syndrome", "Allergies", "Hemivertebrae", "Patellar Luxation", "Intervertebral Disc Disease"};
    public static String[] diseasesTxt = {"Hip dyplasia is a heritable condition in which the" +
            "femur doesn't fit snugly into the pelvic socket of the hip joint. Hip dysplasia can exist with or without" +
            " clinical signs. Some dogs exhibit pain and lameness on one or both rear legs. As the dog ages, arthritis " +
            "can develop. X-ray screening for hip dysplasia is done by the Orthopedic Foundation for Animals or the University of" +
            " Pennsylvania Hip Improvement Program. Dogs with hip dysplasia should not be bred. Ask the breeder for proof that the parents have been tested for hip dysplasia and found to" +
            " be free of problems.", "Brachycephalic Syndrome: This disorder is found in dogs with short heads, narrowed nostrils, or elongated or soft palates. Their airways are obstructed to varying degrees and can cause" +
            " anything from noisy or labored breathing to total collapse of the airway. Dogs with brachycephalic syndrome commonly snuffle and snort. Treatment varies depending on the severity of the condition but " +
            "includes oxygen therapy as well as surgery to widen nostrils or shorten palates.", "Allergies are a common problem in dogs. There are three main types of allergies: food-based allergies, which are treated " +
            "by an elimination process of certain foods from the dog's diet; contact allergies, caused by a reaction to a topical substance such as bedding, flea powders, dog shampoos, and other chemicals, and treated by " +
            "removing the cause of the allergy; and inhalant allergies, caused by airborne allergens such as pollen, dust, and mildew. The medication for inhalant allergies depends on the severity of the allergy. It is important" +
            " to note that ear infections often accompany inhalant allergies.", "Hemivertebrae: This is a malformation of one or more vertebrae that causes it to be shaped like a wedge or triangle. This malformation can occur on its own " +
            "or with other vertebrae malformations. Hemivertebra can cause no problems, or it can put pressure on the spinal cord. This can lead to pain, weakness, and or paralysis. There is no treatment for the condition unless there is spinal cord " +
            "pressure.", "Patellar Luxation: Also known as \"slipped stifles,\" this is a common problem in small dogs. It is caused when the patella, which has three parts — the femur (thigh bone), patella (knee cap), and tibia (calf) — is not properly " +
            "lined up and slips in and out of place (luxates). This causes lameness or an abnormal gait (the way the dog moves). It is a congenital disease, meaning it's present at birth, although the actual misalignment or luxation does not always occur until much later. " +
            "The rubbing caused by patellar luxation can lead to arthritis, a degenerative joint disease. There are four grades of patellar luxation ranging from grade I, an occasional luxation causing temporary lameness in the joint, to grade IV, in which the turning of the " +
            "tibia is severe and the patella cannot be realigned manually. This gives the dog a bowlegged appearance. Severe grades of patellar luxation may require surgical repair.", "Intervertebral Disc Disease (IVDD): IDD occurs when a disc in the spine ruptures or herniates and pushes" +
            " upward into the spinal cord. When the disc pushes into the spinal cord, nerve transmissions are inhibited from traveling along the spinal cord. Intervertebral Disc Disease can be caused by trauma, age, or simply from the physical jolt that occurs when a dog jumps off a sofa. When " +
            "the disc ruptures, the dog usually feels pain and the ruptured disc can lead to weakness and temporary or permanent paralysis. Treatment usually involves nonsteroidal anti-inflammatory drugs (NSAIDS) made specially for dogs. Never give your dog Tylenol or other NSAIDs made for people" +
            " as they can be toxic. In some cases surgery can help, but it must be done within a day or so of the injury. You may also want to ask your veterinarian about physical rehabilitation. Treatments such as massage, water treadmills and electrical stimulation are available for dogs and can " +
            "have excellent success."};
    public static int[] diseasesIMG = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6};


    private FirebaseAuth mAuth;
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view_drawer);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.logout,R.id.login,R.id.nav_share)
                .setDrawerLayout(drawerLayout)
                .build();
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_Frenchie_Breed,
                R.id.navigation_nutrition, R.id.navigation_healthcare)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            TextView usersss = navigationView.getHeaderView(0).findViewById(R.id.header_user);
            usersss.setText(user.getEmail());
            navigationView.getMenu().findItem(R.id.login).setVisible(false);
        } else {
            navigationView.getMenu().findItem(R.id.login).setVisible(true);
            navigationView.getMenu().findItem(R.id.logout).setVisible(false);
        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void clicked(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Toast.makeText(this, "Logged in already as" + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    public void signOut(MenuItem item) {
        FirebaseApp.initializeApp(this);
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_share:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT,"My dog's jurnal");
                        intent.putExtra(Intent.EXTRA_TEXT,"I have downloaded this new app, i would like to share my dog's Jurnal with you.");
                        startActivity(Intent.createChooser(intent,"Share Using"));
                        break;
                    case R.id.nav_location:
                        Uri gmmIntentUri = Uri.parse("geo:55.856937,9.852151?q=vetenarians");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                        break;
            }
        return false;
    }
}
