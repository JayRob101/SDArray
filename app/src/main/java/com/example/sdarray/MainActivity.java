package com.example.sdarray;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {


    //String array of Car Brand names to be used in the Spinner menu
    String[] brands = {"Audi", "Bentley", "BMW", "Fiat", "Ford", "Honda", "Hyundai", "Jaguar", "Mercedes", "Toyota"};

    String brandName ="", imgName="", fileName="", spinnerAnswer="";
    int brandId =0, imageId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Set Spinner and pass brands array to it
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brands);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        //Random car brand
        Random rnd_brand = new Random();
        brandId = rnd_brand.nextInt(10); // random number of 0 to 9
        brandName = brands[brandId];

        //Random car image
        Random rnd_img = new Random();
        imageId = rnd_img.nextInt(10); // random number of 0 to 9

        //Call RandImage Function
        imgName = RandImage(brandName, imageId);

        //Name of file randomly selected __> path, brand and image name
        fileName = "/sdcard/images/" + brandName + "/" + imgName;

        //set the random image from SD Card to image View
        Bitmap bitmap = BitmapFactory.decodeFile(fileName);
        ImageView imageViewSD = (ImageView) findViewById(R.id.imageViewSD);
        imageViewSD.setImageBitmap(bitmap);


        //Submit Button
        Button button_Submit = findViewById(R.id.button_Submit);
        button_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerAnswer = spinner.getSelectedItem().toString();
                //Compare spinner answer to image name
                if (brandName.equalsIgnoreCase(spinnerAnswer)) {
                    TextView textViewSDCorrect = (TextView) findViewById(R.id.textViewSDCorrect);
                    textViewSDCorrect.setText("Correct Answer");
                    textViewSDCorrect.setTextColor(Color.GREEN);
                    textViewSDCorrect.setText("Correct Answer");

                    TextView textViewSDAnswer = (TextView) findViewById(R.id.textViewSDAnswer);
                    textViewSDAnswer.setTextColor(Color.BLUE);
                    textViewSDAnswer.setText(brandName);
                } else {
                    TextView textViewSDWrong = (TextView) findViewById(R.id.textViewSDWrong);
                    textViewSDWrong.setText("Wrong Answer");
                    textViewSDWrong.setTextColor(Color.RED);
                    textViewSDWrong.setText("Wrong Answer");

                    TextView textViewSDAnswer = (TextView) findViewById(R.id.textViewSDAnswer);
                    textViewSDAnswer.setTextColor(Color.BLUE);
                    textViewSDAnswer.setText(brandName);
                }
                //Random car brand
                Random rnd_brand = new Random();
                int brandId = rnd_brand.nextInt(10); // random number of 0 to 9
                brandName = brands[brandId];

                //Random car image
                Random rnd_img = new Random();
                imageId = rnd_img.nextInt(10); // random number of 0 to 9

                //Call RandImage Function
                imgName = RandImage(brandName, imageId);

                //Name of file randomly selected __> path, brand and image name
                fileName = "/sdcard/images/" + brandName + "/" + imgName;

                //set the random image from SD Card to image View
                Bitmap bitmap = BitmapFactory.decodeFile(fileName);
                ImageView imageViewSD = (ImageView) findViewById(R.id.imageViewSD);
                imageViewSD.setImageBitmap(bitmap);

                //get the answer from the Spinner
//                String spinnerAnswer = spinner.getSelectedItem().toString();


                String brandOnly = brandName;
                String imgNameOnly = imgName;

                //Toast fot testing --> Remove
                Toast.makeText(getApplicationContext(), "Brand Name = " + brandOnly
                        , Toast.LENGTH_SHORT).show();

                //Testing output by showing random selection data in text boxes --> Remove
                TextView textViewSD = (TextView) findViewById(R.id.textViewSD);
                textViewSD.setText("File name = " + fileName);

                TextView textViewSD2 = (TextView) findViewById(R.id.textViewSD2);
                textViewSD2.setText("Brand name = " + brandOnly);

                TextView textViewSD3 = (TextView) findViewById(R.id.textViewSD3);
                textViewSD3.setText("Image name = " + imgNameOnly);
                button_Submit.setText("Next");
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    //Function for random image
    public String RandImage(String brandName, int imageId) {
        String imgName = "";
        if (brandName.equals("Audi")) {
            imgName = "audi" + imageId + ".jpg";
        }
        if (brandName.equals("Bentley")) {
            imgName = "bentley" + imageId + ".jpg";
        }
        if (brandName.equals("BMW")) {
            imgName = "bmw" + imageId + ".jpg";
        }
        if (brandName.equals("Fiat")) {
            imgName = "fiat" + imageId + ".jpg";
        }
        if (brandName.equals("Ford")) {
            imgName = "ford" + imageId + ".jpg";
        }
        if (brandName.equals("Honda")) {
            imgName = "honda" + imageId + ".jpg";
        }
        if (brandName.equals("Hyundai")) {
            imgName = "hyundai" + imageId + ".jpg";
        }
        if (brandName.equals("Jaguar")) {
            imgName = "jaguar" + imageId + ".jpg";
        }
        if (brandName.equals("Mercedes")) {
            imgName = "mercedes" + imageId + ".jpg";
        }
        if (brandName.equals("Toyota")) {
            imgName = "toyota" + imageId + ".jpg";
        }

        return imgName;

    }

}
