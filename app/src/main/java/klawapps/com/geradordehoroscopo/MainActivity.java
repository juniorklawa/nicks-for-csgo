package klawapps.com.geradordehoroscopo;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;


import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {


    public Switch brModeSwitch;
    public Switch prefixModeSwitch;
    public Switch originalModeSwitch;
    private TextView txtGerador;
    private FancyButton btnGerador;
    private boolean isBr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);



        // modes = (Spinner) findViewById(R.id.spinner3);
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.modos,android.R.layout.simple_spinner_item);
       // modes.setAdapter(adapter);
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        txtGerador = (TextView) findViewById(R.id.txtGerador);
        btnGerador = (FancyButton) findViewById(R.id.btnGerador);
        brModeSwitch = (Switch) findViewById(R.id.switch1);
        prefixModeSwitch = (Switch) findViewById(R.id.switch2);
        originalModeSwitch = (Switch) findViewById(R.id.switch3);

        brModeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                originalModeSwitch.setChecked(false);
            }
        });

        originalModeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brModeSwitch.setChecked(false);
                prefixModeSwitch.setChecked(false);
            }
        });



        btnGerador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // audioManager.playSoundEffect(SoundEffectConstants.CLICK);


                if (brModeSwitch.isChecked()) {

                    //originalModeSwitch.setChecked(false);
                    brMode();

                    if(prefixModeSwitch.isChecked()) {

                        brModePrefixo();
                    }
                }
                else if (originalModeSwitch.isChecked()){
                    prefixModeSwitch.setChecked(false);
                    originalMode();
                }
                else {

                    if (prefixModeSwitch.isChecked()) {

                        randonModePrefix();
                    }
                    else {

                        randomMode();

                    }
                }





            }
        });

    }

    public void originalMode(){


        final  String[] txtPalavra1={"Mon","Fay","Shi","Zag","Ble","Blarg","Rash","Izen","Malo","Zip",
                "Zak","Abo","Wonk","Son", "Li","Kor","Kim","Zion","Art","Mui",
                "Obi","Gar","Rem","Nov","Cae","Cer","Jui","Opi","Pir","Far","Fil","Lop","Lae","Yut","Tar","Tir","Kal","Kui","Las","Ae","Ra","Eve","Sil","Reb","Ca","Lu","Rag",
                "Lib","Bil","Vrau", "Fal","Pas","Kon","Fig","Glag","Nar","Ny","Ror"};
        final String[] txtPalavra2 = {"mon","fay","shi","zag","ble","blarg","rash","izen","malo","zip","ae","ror",
                "zak","abo","wonk","son", "li","kor","kim","zion","art","mui",
                "obi","gar","rem","nov","cae","cer","jui","opi","pir","far","fil","lop","lae","yut","tar","tir","kal","kui","las","ra","eve","sil","reb","ca","lu","rag","coi","ny",
                "lib","bil","vrau", "fal","pas","kon","fig","glag","nar"};


        Random rand = new Random();
        String randomNome = (txtPalavra1[rand.nextInt(txtPalavra1.length)]);
        String randomNome2 = (txtPalavra2[rand.nextInt(txtPalavra2.length)]);

        txtGerador.setText(randomNome + randomNome2);


    }
    public void brMode(){


        final  String[] txtPalavra={"Cleytin","Bolt","Capitão","Grilo","Noé","Fallen","Pelé","Chimbinha","Jesus","Pão",
                                    "Neymar","Agente","Fighter","Soldado", "Gamer","Defuser","Sniper","Padre","Josiel","Palhaço",
                                    "Professor","Josley","Carteiro","Cachorro","Cão","Lobo","Boi","Macaco","Carlinhos","Piriquito","Crossfiter",
                                    "Gringo","Jacaré","Bam Bam","Ninja","Noob","General","Camper"
        };
        final String [] txtAdjetivo = {"Carnívoro","Carregador","Bala Tensa","Killer","Salvador","Daltônico","Bêbado","Acelerado","Pitoresco",
                                       "Marotador","Clutch Master","do Global","Safadão","Selvagem","Tóxico","do Agreste","com Lasers","Atômico","Chulapa",
                                       "Serelepe","da Audácia","das Smokes","Troll","com Probleminha","Ward","Pescador","Pinador","Baludo","Pistoleiro","da Quebrada",
                                       "Sinistro","Chavoso","Ousado","da Rocinha","Pistola","Aleluia","Pipoqueiro","Crazy","Expert","Lagado","dos Rush"

        };


        Random rand = new Random();
        String randomNome = (txtPalavra[rand.nextInt(txtPalavra.length)]);
        String randomAdjetivo = (txtAdjetivo[rand.nextInt(txtAdjetivo.length)]);

        txtGerador.setText(randomNome + " " + randomAdjetivo);

        /*int randomInt = rand.nextInt((1 - 0) + 1) + 0;

        if (randomInt == 1){

            txtGerador.setText(randomNome);
        }
       else if (randomInt == 0){

            txtGerador.setText(randomNome + " " + randomAdjetivo);
        }*/





    }
    public  void brModePrefixo(){

     final String[] txtPrefixo= {"MC","El","O","Mr.","Sr.","Doutor","Santo","Presidente","Deputado"};

     final  String[] txtPalavra={"Cleytin","Bolt","Capitão","Grilo","Noé","Fallen","Pelé","Chimbinha","Jesus","Pão",
             "Neymar","Agente","Fighter","Soldado", "Gamer","Defuser","Sniper","Padre","Josiel","Palhaço",
             "Professor","Josley","Carteiro","Cachorro","Cão","Lobo","Boi","Macaco","Carlinhos","Piriquito","Crossfiter",
             "Gringo","Jacaré","Bam Bam"
     };
     final String [] txtAdjetivo = {"Carnívoro","Carregador","Bala Tensa","Killer","Salvador","Daltônico","Bêbado","Acelerado","Pitoresco",
             "Marotador","Clutch Master","do Global","Safadão","Selvagem","Tóxico","do Agreste","com Lasers","Atômico","Chulapa",
             "Serelepe","da Audácia","das Smokes","Troll","com Probleminha","Ward","Pescador","Pinador","Baludo","Pistoleiro","da Quebrada",
             "Sinistro","Chavoso","Ousado","da Rocinha","Pistola","Aleluia","Pipoqueiro"

     };


     Random rand = new Random();
     String randomNome = (txtPalavra[rand.nextInt(txtPalavra.length)]);
     String randomAdjetivo = (txtAdjetivo[rand.nextInt(txtAdjetivo.length)]);
     String randomPrefixo = (txtPrefixo[rand.nextInt(txtPrefixo.length)]);

        txtGerador.setText(randomPrefixo + " " + randomNome + " " + randomAdjetivo);



 }
    public void randomMode(){



        final  String[] txtPalavra={"Ninja","Bolt","Captain","Baiter","Sprayer","Fallen","Agent","Samurai","Knifer","General",
                "Commander","Agent","Fighter","Soldier", "Gamer","Defuser","Sniper","Priest","Sherrif","Clown",
                "Teacher","Major","Detonator","Dog","Lurker","Wolf","Knight","Monkey","King","Bird","Crossfiter",
                "Gringo","Frog","Lord","Shooter","Fragger","Assassin","Monster","Camper"
        };
        final String [] txtAdjetivo = {"Choking","Silver","Crazy","Killer","Savior","Lucky","Drunk","Heavy","Fearless",
                "Expert","Clutch Master","Nasty","Stealthy","Savage","Toxic","Legendary","Atomic","Wild",
                "Flaming","Unbreakable","Crimson","Troll","Lagging","Ward","Hateful","Hidden","Bulletproof","Gunner","Dirty",
                "Jumping","Dark","Flashing","Explosive","Bad","Tactical","Happy","Patient","Sloppy","Wise","Angry","Fat","Neurotic","Agressive","Daring","Armored"

        };


        Random rand = new Random();
        String randomNome = (txtPalavra[rand.nextInt(txtPalavra.length)]);
        String randomAdjetivo = (txtAdjetivo[rand.nextInt(txtAdjetivo.length)]);

        int randomInt = rand.nextInt((1 - 0) + 1) + 0;

        if (randomInt == 1){

            txtGerador.setText(randomNome);
        }
        else if (randomInt == 0){

            txtGerador.setText(randomAdjetivo + " " + randomNome);
        }


    }
    public void randonModePrefix(){

        final String[] txtPrefixo= {"The","El","Mr.","Sr.","Saint","Le","Lt.","President"};

        final  String[] txtPalavra={"Ninja","Bolt","Captain","Baiter","Sprayer","Fallen","Agent","Samurai","Knifer","General",
                "Commander","Agent","Fighter","Soldier", "Gamer","Defuser","Sniper","Priest","Sherrif","Clown",
                "Teacher","Major","Detonator","Dog","Lurker","Wolf","Knight","Monkey","King","Bird","Crossfiter",
                "Gringo","Frog","Lord","Shooter","Fragger","Assassin","Monster","Camper","Prince"
        };
        final String [] txtAdjetivo = {"Choking","Silver","Crazy","Killer","Savior","Lucky","Drunk","Heavy","Fearless",
                "Expert","Clutch Master","Nasty","Stealthy","Savage","Toxic","Legendary","Atomic","Wild",
                "Flaming","Unbreakable","Crimson","Troll","Lagging","Ward","Hateful","Hidden","Bulletproof","Gunner","Dirty",
                "Jumping","Dark","Flashing","Explosive","Bad","Tactical","Happy","Patient","Sloppy","Wise","Angry","Fat","Neurotic","Agressive","Daring","Armored"

        };


        Random rand = new Random();
        String randomNome = (txtPalavra[rand.nextInt(txtPalavra.length)]);
        String randomAdjetivo = (txtAdjetivo[rand.nextInt(txtAdjetivo.length)]);
        String randomPrefixo = (txtPrefixo[rand.nextInt(txtPrefixo.length)]);
        txtGerador.setText(randomPrefixo + " " + randomAdjetivo + " " + randomNome);




    }
}
